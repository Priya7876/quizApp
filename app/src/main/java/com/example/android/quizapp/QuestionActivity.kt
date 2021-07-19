package com.example.android.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.android.quizapp.R.drawable.background
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() , View.OnClickListener {
    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
private var mSelesctedPosition:Int=0
    var mCorrectQuestion:Int=0
    var mUsername:String ?=null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        mUsername=intent.getStringExtra(Constants.USER_NAME)
        mQuestionList = Constants.getQuestion()
setquestion()
        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
        submit.setOnClickListener(this)


    }
    private  fun setquestion() {

        val questionGet = mQuestionList!![mCurrentPosition - 1]
        defaultLayout()
        if(mCurrentPosition==mQuestionList!!.size){
            submit.text="FINISH"
        }
        else{
            submit.text="SUBMIT"
        }
        determinateBar.progress = mCurrentPosition
        progressDisplay.text = "$mCurrentPosition" + "/" + determinateBar.max
        qua.text = questionGet!!.question

        option1.text = questionGet!!.opt1
        option2.text = questionGet!!.opt2
        option3.text = questionGet!!.opt3
        option4.text = questionGet!!.opt4
    }
   private fun defaultLayout(){
        var options=ArrayList<TextView>()
        options.add(0,option1)
        options.add(1,option2)
        options.add(2,option3)
        options.add(3,option4)

        for(i in options){
            i.setTextColor(Color.parseColor("#AAB7B8"))
            i.typeface= Typeface.DEFAULT
            i.background=ContextCompat.getDrawable(this,R.drawable.background)
        }
    }
    private fun answerView(answer:Int,Drawable:Int){
        when(answer){
            1 ->{
                option1.background=ContextCompat.getDrawable(this,Drawable)
            }
            2 ->{
                option2.background=ContextCompat.getDrawable(this,Drawable)
            }
            3 ->{
                option3.background=ContextCompat.getDrawable(this,Drawable)
            }
            4 ->{
                option4.background=ContextCompat.getDrawable(this,Drawable)
            }

        }

    }
    private fun selectedLayout(tv:TextView,selectedOption:Int){
        defaultLayout()
        mSelesctedPosition=selectedOption
        tv.setTextColor(Color.parseColor("#8E44AD"))
        tv.typeface= Typeface.DEFAULT
        tv.background=ContextCompat.getDrawable(this,R.drawable.background_selected)
    }

    override fun onClick(v: View?) {
      when(v?.id)  {
          R.id.option1->{
              selectedLayout(option1,1)
          }
          R.id.option2->{
              selectedLayout(option2,2)
          }
          R.id.option3->{
              selectedLayout(option3,3)
          }
          R.id.option4->{
              selectedLayout(option4,4)
          }


          R.id.submit ->{
              if(mSelesctedPosition==0){

                  mCurrentPosition += 1

                  when {
                      mCurrentPosition <= mQuestionList!!.size -> {
                          setquestion()

                      }
                      else -> {
                          val intent1=Intent(this,resultActivity::class.java)
                          intent1.putExtra(Constants.USER_NAME,mUsername)
                          intent1.putExtra(Constants.CORRECT_QUES,mCorrectQuestion.toString())
                          intent1.putExtra(Constants.TOTAL_QUES,mQuestionList!!.size.toString())
                          startActivity(intent1)
                          finish()
                      }

                  }



              }
              else{
                  val question1=mQuestionList?.get(mCurrentPosition-1)
                  if(question1!!.correctOpt !=mSelesctedPosition){
                      answerView(mSelesctedPosition,R.drawable.wrong_questionbg)
                  }
                  else{
                      mCorrectQuestion=mCorrectQuestion+1
                  }
                  answerView(question1!!.correctOpt,R.drawable.background_for_greenbackground)
                  mSelesctedPosition=0
                  if(mCurrentPosition==mQuestionList?.size){
                      submit.text="FINISH"
                  }
                  else{
                      submit.text="GO TO NEXT QUESTION"
                  }
              }



          }
        }
    }



}