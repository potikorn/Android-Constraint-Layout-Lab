package com.example.potikorn.constraintlayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_barriers.*

class BarriersActivity : AppCompatActivity() {

    var isTested = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barriers)
        buttonTest.setOnClickListener {
            when(isTested) {
                true -> {
                    buttonOne.text = "Testing very long text button"
                    isTested = false
                }
                false -> {
                    buttonOne.text = "SHORTER"
                    isTested = true
                }
            }
        }
    }

}