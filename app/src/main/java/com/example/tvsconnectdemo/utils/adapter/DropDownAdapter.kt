package com.example.tvsconnectdemo.utils.adapter

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.tvsconnectdemo.R
import com.example.tvsconnectdemo.databinding.ItemSpinnerTextBinding
import com.example.tvsconnectdemo.databinding.SpinnerBikeBackgroundBinding

class DropDownAdapter<T>(context: Context, private val values: List<T>) :
    ArrayAdapter<T>(context, R.layout.spinner_bike_background, values) {

    private var mContext: Context = context
    private var hintText: String? = null

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val sppinerRowTextBinding =
            DataBindingUtil.inflate<ItemSpinnerTextBinding>(
                LayoutInflater.from(mContext),
                R.layout.item_spinner_text,
                null,
                false
            )
        val item = getItem(position)
        setValues(position, sppinerRowTextBinding.tvSpinnerRowTxt)
        return sppinerRowTextBinding.root
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val spinnerBackgroundBinding =
            DataBindingUtil.inflate<SpinnerBikeBackgroundBinding>(
                LayoutInflater.from(mContext),
                R.layout.spinner_bike_background,
                null,
                false
            )
        setValues(position, spinnerBackgroundBinding.tvSpinnerBgTxt)
        return spinnerBackgroundBinding.root
    }

    private fun setValues(position: Int, label: TextView) {
        val item = getItem(position)
        if (item is String) {
            label.text = item
            if (!TextUtils.isEmpty(hintText) && label.text.toString().equals(hintText, ignoreCase = true))
                label.setTextColor(ContextCompat.getColor(mContext, R.color.gray_AFAFAF))
            else {
                if (!TextUtils.isEmpty(hintText) && hintText.equals(context.getString(R.string.hh_mm), ignoreCase = true))
                    label.setTextColor(ContextCompat.getColor(mContext, R.color.black_3A3A3A))
                else label.setTextColor(ContextCompat.getColor(mContext, R.color.gray_4B4B4B))
            }
        }
        /*else if (item is VehicleData)
            label.text =
                if (item.nickName != null && item.nickName!!.isNotEmpty()) item.nickName else item.series
        else if (item is CategoryData)
            label.text =
                if (item.title != null && item.title!!.isNotEmpty()) item.title else item.value*/
    }

    fun setHintText(hintText: String) {
        this.hintText = hintText
    }
}