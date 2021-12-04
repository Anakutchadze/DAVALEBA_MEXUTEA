package com.example.heroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

private lateinit var emailChange: EditText
private lateinit var pass1Change: EditText
private lateinit var pass2Change: EditText
private lateinit var gafrenaButton : Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
        gaafrine()


    }

    private fun initialize() {
        emailChange=findViewById(R.id.email)
        pass1Change=findViewById(R.id.paroli1)
        pass2Change=findViewById(R.id.paroli2)
        gafrenaButton=findViewById(R.id.ღილაკუკა)

    }

    private fun gaafrine() {

        gafrenaButton.setOnClickListener {

            val email = emailChange.text.toString()
            val password = pass1Change.text.toString()
            val password1 = pass2Change.text.toString()


            if (email.isEmpty())
            {
                Toast.makeText(this, "შეიყვანეთ E-mail", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (password.isEmpty() || password1.isEmpty()
                || password1 != password ||password.length <9 || !password.contains("[0-9]".toRegex()) || !password.contains("[a-z]".toRegex()))
            {
                Toast.makeText(this, "შეიყვანეთ პაროლი", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "საქმე ბედნიერადაა, შეგიძლიათ იმხიარულოთ", Toast.LENGTH_SHORT).show()

                    }
                    else
                        Toast.makeText(this, "შეამოწმეთ E-mail", Toast.LENGTH_SHORT).show()

                }




        }

    }}
