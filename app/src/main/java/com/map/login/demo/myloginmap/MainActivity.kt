

package com.map.login.demo.myloginmap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Process
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.map.login.demo.myloginmap.R.id.etPassword
import com.map.login.demo.myloginmap.R.id.etUser
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etUser = findViewById<EditText>(R.id.etUser)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnCancel = findViewById<Button>(R.id.btnCancel)


        btnLogin.setOnClickListener {

            var status =
            if (etUser.text.toString().equals("admin") &&
                    etPassword.text.toString().equals("Pass")) "Successful Login"
            else "Login Error"
                Toast.makeText(this, status, Toast.LENGTH_LONG).show()
            }
        //else {

                //if (!etUser.text.toString().equals("admin") &&
                 //       etPassword.text.toString().equals("Pass")) {
                 //   Toast.makeText(this, "Login Error", Toast.LENGTH_LONG).show()
                //}
            //}
        //})


        //val intent = Intent(this, RegistrationActivity::class.java)
        //intent.putExtra("Welcome Please Register Now",txtsend.text.toString())
        //startActivity(intent)

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

