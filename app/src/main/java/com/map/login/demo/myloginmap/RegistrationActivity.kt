package com.map.login.demo.myloginmap

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val etEmail = findViewById<EditText>(R.id.etEmail) as EditText
        val etAddress = findViewById<EditText>(R.id.etAddress) as EditText

        //We obtain a reference from an object of the SharedPreferences
        //class through the inherited getSharedPreferences method of the AppCompatActivity class.
        //The first parameter is the name of the preferences file and the second is
        //the way the file is created (MODE_PRIVATE indicates that only this application can query
        // the XML file that is created)

        val preferences = getSharedPreferences ("data", Context.MODE_PRIVATE)

        //To extract the data from the preferences file we must indicate the name to extract and
        // a return value if the name does not exist in the preferences file (in our example
        // the first time that our program is executed logically there is no preferences file
        // Which makes Android believe it, if we try to extract the value of mail will return
        // the second parameter ie the String with an empty string:

        etEmail.setText (preferences.getString ("mail", ""))
        etAddress.setText (preferences.getString ("mail", ""))

        val btnSubmit = findViewById <Button>(R.id.btnSubmit) as Button

        //When you press the “save preferences” button, what we do is to save the contents of
        //the EditText in a variable called “mail” in the preferences file:

        btnSubmit.setOnClickListener (View.OnClickListener {

            val editor = preferences.edit ()

            editor.putString ("mail", etEmail.text.toString ())
            editor.putString ("mail", etAddress.text.toString ())
            editor.apply()
            //editor.commit ()

            //the finish method of the AppCompatActivity class ends the current activity
            finish()

            val intent = Intent(this, MapsActivity::class.java)
            //intent.putExtra("Welcome Please Register Now",txtsend.text.toString())
            startActivity(intent)

        })
    }
}

