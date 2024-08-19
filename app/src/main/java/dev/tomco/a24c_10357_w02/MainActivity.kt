package dev.tomco.a24c_10357_w02

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import dev.tomco.a24c_10357_w02.logic.GameManager
import dev.tomco.a24c_10357_w02.utilities.Constants

class MainActivity : AppCompatActivity() {


    private lateinit var main_LBL_countryName: MaterialTextView

    private lateinit var main_IMG_flag: ShapeableImageView

    private lateinit var main_BTN_yes: MaterialButton

    private lateinit var main_BTN_no: MaterialButton

    private lateinit var main_LBL_score: MaterialTextView

    private lateinit var main_IMG_hearts: Array<ShapeableImageView>

    private lateinit var gameManager: GameManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViews()
        gameManager = GameManager(main_IMG_hearts.size)
        initViews()
    }

    private fun initViews() {
        main_LBL_score.text = gameManager.score.toString()
        main_BTN_yes.setOnClickListener { view: View? -> answerClicked(true) }
        main_BTN_no.setOnClickListener { view: View? -> answerClicked(false) }
        refreshUI()
    }

    private fun answerClicked(expected: Boolean) {
        gameManager.checkAnswer(expected = expected)
        refreshUI()
    }

    private fun findViews() {
        main_LBL_countryName = findViewById(R.id.main_LBL_countryName)
        main_IMG_flag = findViewById(R.id.main_IMG_flag)
        main_BTN_yes = findViewById(R.id.main_BTN_yes)
        main_BTN_no = findViewById(R.id.main_BTN_no)
        main_LBL_score = findViewById(R.id.main_LBL_score)
        main_IMG_hearts = arrayOf(
            findViewById(R.id.main_IMG_heart0),
            findViewById(R.id.main_IMG_heart1),
            findViewById(R.id.main_IMG_heart2)
        )
    }

    private fun refreshUI() {
        if (gameManager.isGameLost) { // Lost:
            Log.d("Game Status", "Game Over! " + gameManager.score)
            changeActivity("😭Game Over! ",gameManager.score)
        } else if (gameManager.isGameEnded) { // Won:
            Log.d("Game Status", "You Won! " + gameManager.score)
            changeActivity("🥳You Won! ",gameManager.score)
        } else { // Ongoing:
            main_LBL_score.text = gameManager.score.toString()
            main_LBL_countryName.text = gameManager.currentCountry.name
            main_IMG_flag.setImageResource(gameManager.currentCountry.flagImage)
            if (gameManager.wrongAnswers != 0) {
                main_IMG_hearts[main_IMG_hearts.size - gameManager.wrongAnswers].visibility =
                    View.INVISIBLE
            }
        }

    }

    private fun changeActivity(message: String, score: Int) {
        val intent = Intent(this, ScoreActivity::class.java);
        var bundle = Bundle()
        bundle.putInt(Constants.SCORE_KEY, score)
        bundle.putString(Constants.STATUS_KEY, message)
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }


    // 2) reduce hearts - game logic
    // 3) change countries - questions.
    // 4) Score Activity

}