package dev.tomco.a24c_10357_w02

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {


    private lateinit var main_LBL_countryName: MaterialTextView

    private lateinit var main_IMG_flag: ShapeableImageView

    private lateinit var main_BTN_yes: MaterialButton

    private lateinit var main_BTN_no: MaterialButton

    private lateinit var main_LBL_score: MaterialTextView

    private lateinit var main_IMG_hearts: Array<ShapeableImageView>

    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViews()
        initViews()
    }

    private fun initViews() {
        main_LBL_score.text = score.toString()
        main_BTN_yes.setOnClickListener { view: View? -> increase() }
        main_BTN_no.setOnClickListener { view: View? -> decrease() }
    }

    private fun decrease() {
        this.score -= 10
        main_LBL_score.text = score.toString()
    }

    private fun increase() {
        this.score += 10
        main_LBL_score.text = score.toString()
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


    //TODO:
    // 1) countries - data
    // 2) reduce hearts - game logic
    // 3) change countries - questions.
    // 4) Score Activity

}