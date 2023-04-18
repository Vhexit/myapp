package com.example.authreg_vic

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var firstname:EditText
    lateinit var secondname:EditText
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var user:Button
    lateinit var database:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstname = findViewById(R.id.first_name)
        secondname= findViewById(R.id.second_name)
        email = findViewById(R.id.edt_email)
        password = findViewById(R.id.edt_password)
        user = findViewById(R.id.btn_create)


        database = openOrCreateDatabase("victor", Context.MODE_PRIVATE, null)

        database.execSQL("CREATE TABLE IF NOT EXISTS newusers(fname VARCHA, sname Varcha, arafa VARCHA, pass VARCHA)")

        user.setOnClickListener {

            var fname = firstname.text.toString().trim()
            var sname = secondname.text.toString().trim()
            var arafa = email.text.toString().trim()
            var pass = password.text.toString().trim()

            if (fname.isEmpty() || sname.isEmpty() || arafa.isEmpty() || pass.isEmpty()) {

                Toast.makeText(this, "Cannot Create User", Toast.LENGTH_SHORT).show()
            } else {

                database.execSQL("INSERT INTO newusers VALUES( '\"+fname+\"',   '\"+sname+\"' , '\"+arafa+\"', '\"+pass+\"')")

                Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()


            }


        }

    }
}