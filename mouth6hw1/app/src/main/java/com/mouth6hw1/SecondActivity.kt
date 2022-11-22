package com.mouth6hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mouth6hw1.MainActivity
import com.example.mouth6hw1.R
import com.example.mouth6hw1.databinding.ActivitySecondBinding
import com.mouth6hw1.constants.Constants.KEY_MAIN_ACTIVITY
import com.mouth6hw1.constants.Constants.KEY_SECOND_ACTIVITY

class  SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resultData()
    }

    private fun resultData() {
        val extras: Bundle? = intent.extras
        val text = extras?.getString(KEY_MAIN_ACTIVITY)
        binding.etText.setText(text)
        binding.btnBack.setOnClickListener {
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            val sendText = binding.etText.text.toString()
            if (sendText.isEmpty()) {
                Toast.makeText(this, getString(R.string.is_nothing), Toast.LENGTH_LONG).show()
            } else {
                intent.putExtra(KEY_SECOND_ACTIVITY, sendText)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}
