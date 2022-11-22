package com.example.mouth6hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.mouth6hw1.databinding.ActivityMainBinding
import com.mouth6hw1.constants.Constants.KEY_SECOND_ACTIVITY
import com.mouth6hw1.constants.Constants.KEY_MAIN_ACTIVITY

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendData()
    }

    private fun sendData() {
        binding.btnSend.setOnClickListener {
            val send = binding.etInput.text.toString()
            if (send.isEmpty()) {
                Toast.makeText(this, getString(R.string.is_nothing), Toast.LENGTH_LONG).show()
            } else {
                intent.putExtra(KEY_MAIN_ACTIVITY, send)
                resultLauncher.launch(intent)
            }
        }
    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent: Intent? = result.data
            val accessText = intent?.getStringExtra(KEY_SECOND_ACTIVITY)
            binding.etInput.setText(accessText)
        }
    }


}


