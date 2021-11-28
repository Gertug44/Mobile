package com.example.hudway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ResetPassword : AppCompatActivity() {
    fun onClick_Reset(view: View){
        val email = findViewById<View>(R.id.enterResetEmail) as TextView
        val email_text = email.text.toString()
        //reset("http://test.local/web/user/reset?key="+"&login="+email_text)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
    }
}