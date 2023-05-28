package com.bangkit2023.capstone.greenix.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.bangkit2023.capstone.greenix.R

class PasswordEditText: AppCompatEditText, View.OnTouchListener {
    private var showError: Boolean = true

    private lateinit var warning: Drawable
    private lateinit var normal: Drawable

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }

    private fun init() {
        warning =  ContextCompat.getDrawable(context, R.drawable.border_error) as Drawable
        normal =  ContextCompat.getDrawable(context, R.drawable.border_normal) as Drawable

        addTextChangedListener(onTextChanged = { s, _, _, _ ->
            if (s.toString().length < 8) {
                showError = true
                background = warning
                error = context.getString(R.string.password_error)
            } else {
                showError = false
                background = normal
                error = null
            }
        })
    }

    override fun onTouch(v: View?, event: MotionEvent): Boolean {
        return true
    }
}