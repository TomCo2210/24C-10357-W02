package dev.tomco.a24c_10357_w02

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textview.MaterialTextView
import dev.tomco.a24c_10357_w02.utilities.Constants

class ScoreActivity : AppCompatActivity() {

    private lateinit var score_LBL_result: MaterialTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        findviews()
        initViews()
    }

    private fun findviews() {
        score_LBL_result = findViewById(R.id.score_LBL_result)
    }

    private fun initViews() {
        val bundle: Bundle? = intent.extras

        val score = bundle?.getInt(Constants.SCORE_KEY, 0)
        val message = bundle?.getString(Constants.STATUS_KEY)

        score_LBL_result.text = buildString {
            append(message)
            append("\n")
            append(score)
        }
    }
}