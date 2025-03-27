package com.shechkov.core.presentation

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

interface OpenBrowser {
    fun open(link: String)

    class Base(private val context: Context) : OpenBrowser {
        override fun open(link: String) {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                setData(link.toUri())
                setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }

    }
}