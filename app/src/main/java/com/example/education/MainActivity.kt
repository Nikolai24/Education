package com.example.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button1).setOnClickListener{
            startActivity(SpecialitiesActivity.newIntent(this))
        }
        findViewById<Button>(R.id.button2).setOnClickListener{
            startActivity(UniversitiesActivity.newIntent(this))
        }
        findViewById<Button>(R.id.button3).setOnClickListener{
            startActivity(ComparisonActivity.newIntent(this))
        }
    }
}