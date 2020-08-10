package com.example.appa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    final var viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        send_direct_button.setOnClickListener {
            GlobalScope.launch (Dispatchers.Main){
                var wait = GlobalScope.async (Dispatchers.IO){
                    viewModel.sendDirect(message_text.text.toString())

                }
                wait.await()
                Toast.makeText(applicationContext, "Sent!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}