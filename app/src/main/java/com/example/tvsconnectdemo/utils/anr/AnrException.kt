package com.example.tvsconnectdemo.utils.anr

import android.annotation.SuppressLint
import android.util.Log
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.*

class AnrException(thread: Thread) :Exception() {
    init {
        stackTrace = thread.stackTrace
    }
    /**
     * Logs the current process and all its threads
     */
    fun logProcessMap() {
        val bos = ByteArrayOutputStream()
        val ps = PrintStream(bos)
        printProcessMap(ps)
        Log.i(this.javaClass.simpleName, String(bos.toByteArray()))
    }

    /**
     * Prints the current process and all its threads
     *
     * @param ps the [PrintStream] to which the
     * info is written
     */
    fun printProcessMap(ps: PrintStream) {
        // Get all stack traces in the system
        val stackTraces = Thread.getAllStackTraces()
        ps.println("Process map:")
        for (thread in stackTraces.keys) {
            if (stackTraces[thread]?.isNotEmpty() == true) {
                stackTraces[thread]?.let { printThread(ps, Locale.getDefault(), thread, it) }
                ps.println()
            }
        }
    }

    /**
     * Prints the given thread
     * @param ps the [PrintStream] to which the
     * info is written
     * @param l the [Locale] to use
     * @param thread the [Thread] to print
     * @param stack the [Thread]'s stack trace
     */
    private fun printThread(ps: PrintStream, l: Locale, thread: Thread, stack: Array<StackTraceElement>) {
        ps.println(String.format(l, "\t%s (%s)", thread.name, thread.state))
        for (element in stack) {
            ps.println(String.format(l, "\t\t%s.%s(%s:%d)", element.className, element.methodName, element.fileName, element.lineNumber))
        }
    }
}