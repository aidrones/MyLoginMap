
package com.map.login.demo.myloginmap

import android.content.Intent
import android.os.Bundle
import android.os.Process
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUser = findViewById<EditText>(R.id.etUser)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnRegistration = findViewById<Button>(R.id.btnRegistration)
        val btnCancel = findViewById<Button>(R.id.btnCancel)


        btnLogin.setOnClickListener (View.OnClickListener  {

            var status =
            if (etUser.text.toString().equals("admin") &&
                    etPassword.text.toString().equals("Pass")) "Successful Login"
            else "Login Error"
                Toast.makeText(this, status, 9) .show()//Toast.LENGTH_LONG).show()
            })

        btnRegistration.setOnClickListener (View.OnClickListener {
        val intent = Intent(this, RegistrationActivity::class.java)
        //intent.putExtra("Welcome Please Register Now",txtsend.text.toString())
        startActivity(intent)
        })

        btnReset.setOnClickListener (View.OnClickListener {
            etUser.setText("")
            etPassword.setText("")
            etUser.requestFocus()
        })

        btnCancel.setOnClickListener (View.OnClickListener {
            Process.killProcess(Process.myPid())
            System.exit(1)
        })
    }
}

