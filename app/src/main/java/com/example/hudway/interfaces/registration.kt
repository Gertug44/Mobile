package com.example.hudway.interfaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.hudway.R
import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL

class registration : AppCompatActivity() {
    fun onClick_Registration(view: View){
        val email = findViewById<View>(R.id.editTextTextEmailAddress) as TextView
        val pass = findViewById<View>(R.id.editTextTextPassword) as TextView
        val pass2 = findViewById<View>(R.id.editTextTextPassword2) as TextView
        val email_text = email.text.toString()
        val pass_text = pass.text.toString()
        val pass2_text = pass2.text.toString()
        val json = ("log "+email_text+"pass "+pass_text)
        val gson = Gson()
        val json1=gson.toJson(json)
        if (!pass_text.equals(pass2_text))
            Toast.makeText(applicationContext, "пароли не соответствуют", Toast.LENGTH_LONG)
        val url = "http://test.local/web/user/login/$json1"
        val connection = URL(url).openConnection() as HttpURLConnection
        try {
            connection.connect()
            val text = connection.inputStream.use{it.reader().use{reader-> reader.readText()}}
            if (text.contains("fail")) Toast.makeText(applicationContext, "данный логин занят", Toast.LENGTH_LONG)
        }finally
        {
            connection.disconnect()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }
}