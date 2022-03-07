package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayScore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_score)

        var intent = getIntent()
        var total=intent.getIntExtra("Score",0)

        var setTotalTextView=findViewById<TextView>(R.id.setTotal)
        total*=2
        setTotalTextView.setText("$total/100")
    }
}