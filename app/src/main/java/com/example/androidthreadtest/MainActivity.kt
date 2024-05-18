package com.example.androidthreadtest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidthreadtest.databinding.ActivityMainBinding
import java.lang.ref.WeakReference
import kotlin.concurrent.thread

/**
 * 一、Android 多线程练习
 * 掌握：
 * 1. Kotlin协程的使用
 * 2. Java 线程池
 * 3. Java + Kotlin的锁机制
 * 4. 做一个多线程的功能测试
 * 5. 复习Handler机制，从源码角度了解Handler机制的工作流程。（✅）
 *    - Handler内存泄漏如何解决？ （✅）
 *    - HandleThread的使用，从源码角度了解实现的机制。能够用自己的话概括。
 *
 *
 * 二、Android Service练习
 *
 *
 *
 * @constructor
 */
class MainActivity : AppCompatActivity() {

    companion object {
        const val updateText = 1
    }

    private lateinit var mBinding: ActivityMainBinding

    private class MyHandler(val wrActivity: WeakReference<MainActivity>) :
        Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            wrActivity.get()?.run {
                when (msg.what) {
                    updateText -> mBinding.textView.text = msg.obj as String
                }
            }

        }
    }

    private val mHandler = MyHandler(WeakReference(this))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.changeTextBtn.setOnClickListener {
            thread {
                mHandler.sendMessageDelayed(Message.obtain().apply {
                    what = updateText
                    obj = "你好"
                }, 5000)
            }
        }
    }

}