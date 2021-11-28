package com.example.hudway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL

class ResetPassword : AppCompatActivity() {
    fun onClick_Reset(view: View){
        val email = findViewById<View>(R.id.enterResetEmail) as TextView
        val email_text = email.text.toString()
        val json = ("log $email_text")
        val gson = Gson()
        val json1=gson.toJson(json)
        val url = "http://test.local/web/user/change/$json1"
        val connection = URL(url).openConnection() as HttpURLConnection
        try {
            connection.connect()
            val text = connection.inputStream.use{it.reader().use{reader-> reader.readText()}}
            if (text.contains("error")) Toast.makeText(applicationContext, "данный логин занят", Toast.LENGTH_LONG)
        }finally
        {
            connection.disconnect()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
    }
}