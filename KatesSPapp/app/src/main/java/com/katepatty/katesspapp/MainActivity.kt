package com.katepatty.katesspapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // no need to create data class while using share preference
    companion object {
        private const val data = " "
        private const val money = 0
        private const val  date = " "
        private const val item  = " "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        writeBtn.setOnClickListener { writeIn()
            Toast.makeText(this@MainActivity, "save is completed.", Toast.LENGTH_SHORT).show()
        }
        readBtn.setOnClickListener {
            readOut()
            Toast.makeText(this@MainActivity, "All of them are Back!.", Toast.LENGTH_SHORT).show()
        }

        clearBtn.setOnClickListener {
            toBeEmpty()
            Toast.makeText(this@MainActivity, "Plz then enter CFRM.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun readOut(){

        // param1 is string, param 2 is mode in type of Int
        var model = getSharedPreferences(data, 0)

        // k/v pair
        expendField.setText(model?.getString(money.toString(), "0"))

        dateField.setText(model?.getString(date, "20210205"))

        itemField.setText(model?.getString(item, "Guava & Almond"))

    }

    private fun writeIn(){

        // param1 is string, param 2 is mode in type of Int
        var model = getSharedPreferences(data, 0)

        // k/v pairs
        model.edit()
            .putString(money.toString(), expendField?.text.toString())
            .putString(date, dateField?.text.toString())
            .putString(item, itemField?.text.toString())
            .apply()
    }

    private fun toBeEmpty(){

        expendField.setText("")

        dateField.setText("")

        itemField.setText("")
    }

}