package com.example.android.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.android.quizapp.Constants.USER_NAME
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        button1.setOnClickListener {
            if(editTexy.text.toString().isEmpty()){
                Toast.makeText(this,"Please  enter yur name",Toast.LENGTH_SHORT)
            }
            else{
                val intent1= Intent(this,QuestionActivity::class.java)
                intent1.putExtra(Constants.USER_NAME,editTexy.text.toString())
                startActivity(intent1)
                finish()
            }
        }

    }

}