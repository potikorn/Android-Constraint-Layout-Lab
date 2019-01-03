package com.example.potikorn.constraintlayout

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_circular_positioning.*

class CircularPositioningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_positioning)
        sbCircleAngel.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val constraintLayout = buttonOne.parent as ConstraintLayout
                val constraintSet = ConstraintSet().apply { clone(constraintLayout) }
                progress.toFloat().let {
                    constraintSet.constrainCircle(
                        R.id.buttonTwo,
                        R.id.buttonOne,
                        convertDpToPixel(120F, this@CircularPositioningActivity).toInt(),
                        it
                    )
                }
                constraintSet.applyTo(constraintLayout)
                tvSeekbarValue.text = "$progress Degree"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    fun convertPixelsToDp(px: Float, context: Context): Float {
        return px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun convertDpToPixel(dp: Float, context: Context): Float {
        return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}