package com.example.myapplication2

import android.Manifest
import android.content.ContentResolver
import android.content.ContentUris
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.telephony.TelephonyManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.myapplication2.R


class SecondActivity:AppCompatActivity() {
    override fun setContentView(layoutResID: Int) {
        super.setContentView(R.layout.layout2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.layout2)
        var add = findViewById<Button>(R.id.button4)
        var edit_numero = findViewById<EditText>(R.id.editTextPhone)
        var edit_nome = findViewById<EditText>(R.id.editTextName)

        add.setOnClickListener(){
            var numero_digitado = edit_numero.text.toString()
            var nome_digitado = edit_nome.text.toString()
            var tamanho = numero_digitado.length
            var nome_lenght = nome_digitado.length
            if(tamanho!=11||nome_lenght<1 ){
                Toast.makeText(applicationContext,"O numero deve ter 11 digitos e o nome pelo menos uma letra",
                    Toast.LENGTH_LONG).show()
            }
            else{
                var  name = nome_digitado
                var  phone = numero_digitado
                var contactIntent =  Intent(ContactsContract.Intents.Insert. ACTION )
                contactIntent.setType(ContactsContract.RawContacts. CONTENT_TYPE )
                contactIntent
                    .putExtra(ContactsContract.Intents.Insert. NAME , name)
                    .putExtra(ContactsContract.Intents.Insert. PHONE , phone)
                startActivity(contactIntent)
            }

        }

        fun onStart() {
            super.onStart()

        }
    }}

