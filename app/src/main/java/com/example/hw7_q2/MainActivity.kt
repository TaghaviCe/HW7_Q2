package com.example.hw7_q2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw7_q2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var trueAnswer=0
    var falseAnswer=0
    lateinit var binding: ActivityMainBinding
    val mQuestionBank: Array<Answer> = arrayOf<Answer>(
        Answer(R.string.q1, true),
        Answer(R.string.q2, true),
        Answer(R.string.q3, false),
        Answer(R.string.q4, true),
        Answer(R.string.q5,true),
        Answer(R.string.q6,false),
        Answer(R.string.q7,false),
        Answer(R.string.q8,true),
        Answer(R.string.q9,true),
        Answer(R.string.q10,false)
    )
    var index=0
    var cheat=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)
        updateQuestion()
        binding.buttonCheat.setOnClickListener {
            getInit()
        }
        binding.buttonNext.setOnClickListener {
            index=(index+1)%mQuestionBank.size
                cheat=false
                updateQuestion()

        }
        binding.buttonprev.setOnClickListener {
            index = (index - 1) % mQuestionBank.size
            cheat = false
            updateQuestion()
        }
        binding.buttonTrue.setOnClickListener {
            checkA(true)
        }
        binding.buttonFalse.setOnClickListener {
            checkA(false)
        }

    }

    private fun checkA(b: Boolean) {
        val c=mQuestionBank[index].isTrueQuestion()
        val id=0
        if(b==mQuestionBank[index].isTrueQuestion()) {
            Toast.makeText(this, "correct!", Toast.LENGTH_LONG).show()
            trueAnswer++
        } else{
            Toast.makeText(this,"wrong!", Toast.LENGTH_LONG).show()
            falseAnswer++
        }



    }

    private fun updateQuestion() {
        val question=mQuestionBank[index].getQuestion()
        binding.text.setText(question)

    }

    private fun getInit() {
        val intent= Intent(this, MainActivity2::class.java)
        intent.putExtra("id",index)
        startActivity(intent)
    }
}