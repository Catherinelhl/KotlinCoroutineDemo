package com.by.kotlincoroutinedemo.base

import android.app.Application

/**
 *
 * @author Catherine Liu
 * 2022/2/21 17:09
 * base application
 *
 **/
class BaseApplication : Application() {

    companion object{
        private var context : BaseApplication? = null
        fun instance() = context!!

    }


    override fun onCreate() {
        super.onCreate()
        context = this
    }

}