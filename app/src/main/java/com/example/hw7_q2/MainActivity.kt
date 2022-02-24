package com.example.hw7_q2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw7_q2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val mQuestionBank: Array<Answer> = arrayOf<Answer>(
        Answer(R.string.q1, true),
        Answer(R.string.q2, true),
        Answer(R.string.q3, false),
        Answer(R.string.q4, true)
    )
    var index=0
    var cheat=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        binding.buttonCheat.setOnClickListener {
            getInit()
        }
        binding.buttonNext.setOnClickListener {
            index=(index+1)%mQuestionBank.size
                cheat=false
                updateQuestion()

        }
        binding.buttonprev.setOnClickListener {
            index=(index-1)%mQuestionBank.size
                 cheat=false
                updateQuestion()

        }
        binding.buttonTrue.setOnClickListener {
            checkA(true)
        }

    }

    private fun checkA(b: Boolean) {
        val c=mQuestionBank[index].isTrueQuestion()
        val id=0
        if(b==mQuestionBank[index].isTrueQuestion()) {
            Toast.makeText(this, "true", Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this,"false", Toast.LENGTH_LONG).show()
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