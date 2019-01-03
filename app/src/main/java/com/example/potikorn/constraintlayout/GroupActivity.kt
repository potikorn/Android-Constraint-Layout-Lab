package com.example.potikorn.constraintlayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_group.*

class GroupActivity : AppCompatActivity() {

    var isToggle = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)
        buttonHide.setOnClickListener {
            when(isToggle) {
                true -> group.visibility = View.VISIBLE
                false -> group.visibility = View.GONE
            }
            isToggle = !isToggle
        }
    }

}