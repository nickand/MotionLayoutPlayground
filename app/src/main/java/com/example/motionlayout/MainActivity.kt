package com.example.motionlayout

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout

class MainActivity : AppCompatActivity() {

    private lateinit var bgSpace: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val motionLayout: MotionLayout = findViewById(R.id.motionLayout)
        bgSpace = findViewById(R.id.bgSpace)

        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: MotionLayout, startId: Int, endId: Int) { }

            override fun onTransitionChange(motionLayout: MotionLayout, startId: Int, endId: Int, progress: Float) {
                val paddingInPx = calculatePaddingPx(progress)
                bgSpace.setPadding(0, paddingInPx, 0, bgSpace.paddingBottom)
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) { }

            override fun onTransitionTrigger(motionLayout: MotionLayout, triggerId: Int, positive: Boolean, progress: Float) { }
        })
    }

    private fun calculatePaddingPx(progress: Float): Int {
        val scale = bgSpace.height
        return (progress * scale + 0.5f).toInt()
    }
}