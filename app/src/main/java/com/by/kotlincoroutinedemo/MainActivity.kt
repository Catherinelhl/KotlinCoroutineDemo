package com.by.kotlincoroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

/**
 * practicing how to use the coroutine of the kotlin
 *
 * 协程的特点：
 * 协程是我们在Android 上进行异步编程的推荐解决方案，值得关注的特点：
 *1：轻量；你可以在单个线程中运行多个协程，因为协程支持挂起（何为挂起呢？）
 *
 */
class MainActivity : AppCompatActivity() {
    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        aboutAsync()
//        aboutLaunch()
    }

    /**
     * async 能够并发执行任务
     */
    private fun aboutAsync() {
        println("current time is====${System.currentTimeMillis()}")
        scope.launch(Dispatchers.Main) {
            /**
             * (start = CoroutineStart.LAZY) 设置 start 为懒加载
             */
            val one = async(start = CoroutineStart.LAZY){ getResult(10) }
            println("second time is====${System.currentTimeMillis()}")
            delay(3000)
            val two = async { getResult(20) }
            tvShow.text = "the result is:${one.await() + two.await()}"
            println("third time is====${System.currentTimeMillis()}")

        }
        println("last time is====${System.currentTimeMillis()}")

    }

    private fun aboutLaunch(){
        println("current time is====${System.currentTimeMillis()}")
        scope.launch(Dispatchers.Main) {
            val one = getResult(10)
            println("second time is====${System.currentTimeMillis()}")
            val two = getResult(20)
            tvShow.text = "the result is:${one + two}"
            println("third time is====${System.currentTimeMillis()}")

        }
        println("last time is====${System.currentTimeMillis()}")
    }


    private suspend fun getResult(num: Int): Int {
        println("getResult start time is====${System.currentTimeMillis()}")

        delay(2000)
        println("getResult time is====${System.currentTimeMillis()}")
        return num * num
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}