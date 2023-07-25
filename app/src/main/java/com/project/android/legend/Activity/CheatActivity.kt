package com.project.android.legend.Activity

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.geomain.R
import com.project.android.legend.Model.QuizViewModel

const val EXTRA_ANSWER_SHOWN="com.bignerdranch.android.geomain.answer_shown"
private const val EXTRA_ANSWER_IS_TRUE="com.bignerdranch.android.geomain.answer_is_true"

class CheatActivity : AppCompatActivity() {


    private lateinit var answerTextView: TextView
    private lateinit var showAnswerButton: Button
    private lateinit var textView : TextView

    private val quizViewModel: QuizViewModel by lazy {
        ViewModelProvider(this)[QuizViewModel::class.java]
    }

    private var answerIsTrue = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        answerIsTrue=intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false)
        answerTextView=findViewById(R.id.answer_text_view)
        showAnswerButton=findViewById(R.id.show_answer_button)

        val level = Build.VERSION.SDK_INT
        val levelApi = "API Level $level"

        textView = findViewById(R.id.levelText)
        textView.text = levelApi

        if(quizViewModel.showAnswer){
            val answerText = when{
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }
            answerTextView.setText(answerText)
            true.setAnswerShownResult()
            showAnswerButton.isEnabled = false
        }

        showAnswerButton.setOnClickListener{
            val answerText = when{
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }
            answerTextView.setText(answerText)
            true.setAnswerShownResult()
            showAnswerButton.isEnabled = false
            quizViewModel.showAnswer=true
        }
    }

    private fun Boolean.setAnswerShownResult() {
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOWN, this@setAnswerShownResult)
        }
        setResult(RESULT_OK, data)
    }

    companion object {
        fun newIntent(packageContext: Context,answerIsTrue: Boolean): Intent {
            return Intent(packageContext, CheatActivity::class.java).apply{
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }
    }
}