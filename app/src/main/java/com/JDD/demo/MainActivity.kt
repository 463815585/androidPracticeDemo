 package com.JDD.demo

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.TransitionManager

 class MainActivity : AppCompatActivity() {
     private lateinit var btn1 : TextView;
     private lateinit var constraintLayout : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn1 = findViewById(R.id.btn_1)
        constraintLayout = findViewById(R.id.main)
        btn1.setOnClickListener {
            animateToKeyframeTwo()
            Toast.makeText(this@MainActivity, "点击了1", Toast.LENGTH_SHORT).show()
        }
    }

    private fun animateToKeyframeTwo() {
        val constraintSet = ConstraintSet()
        constraintSet.load(this, R.layout.activity_main_two)
        TransitionManager.beginDelayedTransition(constraintLayout)
        constraintSet.applyTo(constraintLayout)
    }

}