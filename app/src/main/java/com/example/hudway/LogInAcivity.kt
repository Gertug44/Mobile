
package com.example.hudway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.hudway.fragments.MainHeaderFragment
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.net.HttpURLConnection
import java.net.URL

class LogInAcivity : AppCompatActivity() {
    fun onClick_SignIn(view: View){
        val email = findViewById<View>(R.id.EnterEmail) as TextView
        val pass = findViewById<View>(R.id.EnterPassword) as TextView
        val email_text = email.text.toString()
        val pass_text = pass.text.toString()
        val json = ("log "+email_text+"pass "+pass_text)
        val gson = Gson()
        val json1=gson.toJson(json)
        val url = "http://test.local/web/user/login/$json1"
        val connection = URL(url).openConnection() as HttpURLConnection
        try {
            connection.connect()
            val text = connection.inputStream.use{it.reader().use{reader-> reader.readText()}}
            if (text.contains("fail")) Toast.makeText(applicationContext, "введите правильный логин и пароль", Toast.LENGTH_LONG)
        }finally
        {
            connection.disconnect()
        }

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
