package com.example.potikorn.constraintlayout

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_placeholder.*

class PlaceHolderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placeholder)
        button_3.setOnClickListener {
            TransitionManager.beginDelayedTransition(button_3.parent as ConstraintLayout)
            when (placeHolderSample.content.id) {
                buttonTwo.id -> placeHolderSample.setContentId(buttonOne.id)
                else -> placeHolderSample.setContentId(buttonTwo.id)
            }
        }
    }
}