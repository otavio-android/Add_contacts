package  com.example.myapplication2

import android.Manifest.permission.*
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.myapplication2.R
//import com.example.myapplication2.R
import java.util.*
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         setContentView(R.layout.tela1)
        var paramn = 114
        var param = arrayOf(READ_CONTACTS, READ_PHONE_NUMBERS, READ_PHONE_STATE)



        var button = findViewById<Button>(R.id.button3)
        button.setOnClickListener(){
            if(ActivityCompat.checkSelfPermission(
                    this,
                    READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    READ_PHONE_NUMBERS
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    READ_PHONE_STATE
                ) != PackageManager.PERMISSION_GRANTED){

                Timer("SettingUp", false).schedule(2000) {

                    ActivityCompat.requestPermissions(this@MainActivity,param,paramn)
                }
                Toast.makeText(applicationContext,"Conceda as permissoes para prosseguir",Toast.LENGTH_LONG).show()


            }
            else { var intent = Intent(this@MainActivity,SecondActivity::class.java)
                startActivity(intent)}
        }

    }

    override fun onRestart() {

        super.onRestart()

    }

}


