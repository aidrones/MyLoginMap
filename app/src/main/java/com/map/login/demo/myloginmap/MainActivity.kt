package com.map.login.demo.myloginmap

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View;
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.map.login.demo.myloginmap.R.id.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin);
        val etUser = findViewById<EditText>(R.id.etUser);
        val etPassword = findViewById<EditText>(R.id.etPassword);

        val btnCancel = findViewById<Button>(R.id.btnCancel);
        //val txtView3 = findViewById<TextView>(R.id.txtView3);
        //txtView3.setText("No of Attempts: 3");

        btnLogin.setOnClickListener(View.OnClickListener() {
                var status = if
                    (etUser.text.toString().equals("admin") &&
                            etPassword.text.toString().equals("Password")) "Successful Login Redirecting..." else "Wrong Credentials"
                    Toast.makeText(this,status, Toast.LENGTH_SHORT).show();
                           // "Successful Redirecting...", Toast.LENGTH_SHORT).show();

                    val intent = Intent(this, RegistrationActivity::class.java)
                    //intent.putExtra("Welcome Please Register Now",txtsend.text.toString())
                    startActivity(intent)

                })

        btnCancel.setOnClickListener(View.OnClickListener() {
            android.os.Process.killProcess(android.os.Process.myPid())
            System.exit(1);

                //if(View() == btnCancel){
                //    finish()
                //};
        });
    }
}
