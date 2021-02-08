package app.iida.jessy.countapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // valのほうがいいかも？ わかりました！
        // varだと再代入できるけど、多分findViewByIdして
        // val plusButton = findViewById<Button>(R.id.plusButton)
      //  var plusButton = findViewById<Button>(R.id.plusButton)
      //  var minusButton = findViewById<Button>(R.id.minusButton)
      //  var clearButton = findViewById<Button>(R.id.clearButton)
      //  var textView = findViewById<TextView>(R.id.textView)
          val plusButton = findViewById<Button>(R.id.plusButton)
          val minusButton = findViewById<Button>(R.id.minusButton)
          val clearButton = findViewById<Button>(R.id.clearButton)
          val textView = findViewById<TextView>(R.id.textView)

        var number: Int =0

        textView.text = "0"

        plusButton.setOnClickListener {
            number = number + 1
            textView.text = number.toString()
        }

        minusButton.setOnClickListener {
            number = number - 1
            textView.text = number.toString()
        }

        clearButton.setOnClickListener {
            number = 0
            textView.text = number.toString()
        }

    }
}