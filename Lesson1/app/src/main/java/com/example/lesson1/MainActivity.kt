package com.example.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onTransition()
    }

    private fun initListener() {
        binding.btnSubmit.setOnClickListener {
            if (binding.etText.text.isNotEmpty()) {

            }
        }




    }



//    Дз: На первой активити добавить EditText + Button, при вводе если значения
//    в editText пустое и вы нажали на button, то отобразить Toast, что EditText
//    не может быть пустым, иначе Перейти на вторую активити и отобразить значение
//    в EditText, также добавить Button, если EditText не пуст, то вернуться на 1
//    активити и отобразить текст из 2 активити.(использовать registerForActivity)

}