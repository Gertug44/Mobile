package com.example.hudway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.hudway.fragments.MainHeaderFragment

class LogInAcivity : AppCompatActivity() {
    fun onClick_SignIn(view: View){
        val email = findViewById<View>(R.id.EnterEmail) as TextView
        val pass = findViewById<View>(R.id.EnterPassword) as TextView
        val email_text = email.text.toString()
        val pass_text = pass.text.toString()
        //login("http://test.local/web/user/login?key="+"&login="+email_text+"&pass="+pass_text)
    }
    fun onClick_SignUp(view: View)
    {
        setContentView(R.layout.activity_registration)
    }
    fun onClick_restorePassword(view: View){
        setContentView(R.layout.activity_reset_password)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_acivity)
    }

}