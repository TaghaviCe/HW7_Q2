package com.example.hw7_q2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hw7_q2.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

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

    lateinit var binding2: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding2= ActivityMain2Binding.inflate(layoutInflater)
        var view=binding2.root
        setContentView(view)
        var extraMessage=getIntent().getIntExtra("id",0)
        binding2.button6.setOnClickListener {
            binding2.textView2.visibility= View.VISIBLE
            val question=mQuestionBank[extraMessage].isTrueQuestion()
            binding2.textView2.setText(question.toString())
        }

    }
}