package com.example.android.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        var userName=intent.getStringExtra(Constants.USER_NAME)
        name.text=userName
        var Vscore = intent.getStringExtra(Constants.CORRECT_QUES)
        var Tscore=intent.getStringExtra(Constants.TOTAL_QUES)
score.text="Your net score is" +"$Vscore" +"/" +"$Tscore"
finishButton.setOnClickListener {
    var intent= Intent(this,MainActivity::class.java)
    startActivity(intent)
    finish()
}
    }
}