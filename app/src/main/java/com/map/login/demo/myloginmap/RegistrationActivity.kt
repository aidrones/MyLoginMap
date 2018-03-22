package com.map.login.demo.myloginmap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        //TextView etUser = (TextView)findViewById(R.id.etUser)
        //etUser.setText()



        val intent = Intent(this, RegistrationActivity::class.java)
        //intent.putExtra("Welcome Please Register Now",txtsend.text.toString())
        startActivity(intent)


    }
}
