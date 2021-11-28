package com.example.hudway.interfaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.hudway.R

class registration : AppCompatActivity() {
    fun onClick_Registration(view: View){
        val email = findViewById<View>(R.id.editTextTextEmailAddress) as TextView
        val pass = findViewById<View>(R.id.editTextTextPassword) as TextView
        val pass2 = findViewById<View>(R.id.editTextTextPassword2) as TextView
        val email_text = email.text.toString()
        val pass_text = pass.text.toString()
        val pass2_text = pass2.text.toString()
        if (!pass_text.equals(pass2_text))
            Toast.makeText(applicationContext, "пароли не соответствуют", Toast.LENGTH_LONG)
    //else
            //registr("http://test.local/web/user/login?key="+"&login="+email_text+"&pass="+pass_text)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }
}