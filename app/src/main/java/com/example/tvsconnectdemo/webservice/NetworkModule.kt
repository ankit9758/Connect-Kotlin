package com.example.tvsconnectdemo.webservice

import android.util.Log
import com.example.tvsconnectdemo.BuildConfig
import com.example.tvsconnectdemo.TVSApplication
import com.example.tvsconnectdemo.authentication.network.APIService
import com.example.tvsconnectdemo.utils.DateUtils
import com.example.tvsconnectdemo.utils.KEYS
import com.example.tvsconnectdemo.utils.PrintLog
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(provideOkHttpClient(interceptor = provideInterceptor()))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val naiveTrustManager = object : X509TrustManager {
            override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
            override fun checkClientTrusted(certs: Array<X509Certificate>, authType: String) = Unit
            override fun checkServerTrusted(certs: Array<X509Certificate>, authType: String) = Unit
        }
        // Install the all-trusting trust manager
        val insecureSocketFactory = SSLContext.getInstance("TLSv1.2").apply {
            val trustAllCerts = arrayOf<TrustManager>(naiveTrustManager)
            init(null, trustAllCerts, SecureRandom())
        }.socketFactory



        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.dispatcher(dispatcher)
        okHttpClientBuilder.sslSocketFactory(insecureSocketFactory,naiveTrustManager)

        okHttpClientBuilder.connectTimeout(45, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(30, TimeUnit.SECONDS)
        okHttpClientBuilder.followRedirects(false)
        okHttpClientBuilder.followSslRedirects(false)
        okHttpClientBuilder.addInterceptor(interceptor)
        if (PrintLog.isDebug()) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        okHttpClientBuilder.addNetworkInterceptor(provideCacheInterceptor())
        okHttpClientBuilder.cache(provideCache())
        return okHttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient().setDateFormat(DateUtils.getUtcTFormat())
            .create()
    }

    @Provides
    fun provideInterceptor(): Interceptor {
        return ApiInterceptor()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

    @Singleton
    @Provides
    fun provideCache(): Cache? {
        var cache: Cache? = null
        try {
            cache =
                Cache(File(TVSApplication.appClass?.cacheDir, "http-cache"), 10 * 1024 * 1024)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return cache
    }

    @Singleton
    @Provides
    fun provideCacheInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            var request = chain.request()
            val cacheControl = CacheControl.Builder()
                .maxStale(0, TimeUnit.DAYS)
                .maxAge(0, TimeUnit.DAYS)
                .build()
            request = request.newBuilder()
                .addHeader("Cache-Control", cacheControl.toString())
                .addHeader("Accept", "*/*") /*.addHeader(*/ /*"x-access-token"*/ /*"token",
                            PreferenceUtils.getInstance(context).getValue(context.getString(R.string.pref_token), ""))*/
                .addHeader("UserId","")
                .addHeader("countryId","48")
                .addHeader("Region",BuildConfig.Region)
                .build()
            request = request.newBuilder()
                .addHeader(
                    KEYS.QUERY_PARAM_LANGUAGE, "en-US") //Tells server about users language preference
                .build()
            Log.d("RestClient", "provideCacheInterceptor: " + request.headers)
            // this condition should be removed once upgradeToken api is deprecated.
            // it is added only for old user and old apps to avoid force login / logout after adding vulnerablity changes.
            val originalResponse = chain
                .proceed(request)
            originalResponse.newBuilder()
                .removeHeader("Cache-Control")
                .build()
        }
    }
}