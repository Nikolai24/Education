package com.example.education

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UniversitiesActivity : AppCompatActivity() {
    private var universities: MutableList<Item> = mutableListOf()
    private lateinit var adapter: DataAdapter
    private lateinit var recyclerView: RecyclerView

    private val listener: DataAdapter.OnItemClickListener = object : DataAdapter.OnItemClickListener {
        override fun onItemClick(university: Item, position: Int) {
            startSpecialitiesProfileActivity(university, position)
        }
    }

    private fun startSpecialitiesProfileActivity(university: Item, position: Int) {
        val intent = Intent(this@UniversitiesActivity, SpecialitiesProfileActivity::class.java)
        intent.putExtra("University", university)
        intent.putExtra("position", position)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universities)
        setInitialData()
        adapter = DataAdapter(universities, listener)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun setInitialData() {
        universities.add(Item("Академия Министерства внутренних дел Республики Беларусь", R.drawable.logo01))
        universities.add(Item("Академия управления при Президенте Республики Беларусь", R.drawable.logo02))
        universities.add(Item("Белорусский государственный аграрный технический университет", R.drawable.logo03))
        universities.add(Item("Белорусская государственная академия авиации", R.drawable.logo04))
        universities.add(Item("Белорусская государственная академия искусств",R.drawable.logo05))
        universities.add(Item("Белорусская государственная академия музыки",R.drawable.logo06))
        universities.add(Item("Белорусская государственная академия связи",R.drawable.logo07))
        universities.add(Item("Белорусский государственный медицинский университет", R.drawable.logo08))
        universities.add(Item("Белорусский государственный педагогический университет имени Максима Танка",R.drawable.logo09))
        universities.add(Item("Белорусский государственный технологический университет",R.drawable.logo10))
        universities.add(Item("Белорусский государственный университет",R.drawable.logo11))
        universities.add(Item("Белорусский государственный университет информатики и радиоэлектроники",R.drawable.logo12))
        universities.add(Item("Белорусский государственный университет культуры и искусств",R.drawable.logo13))
        universities.add(Item("Белорусский государственный университет физической культуры",R.drawable.logo14))
        universities.add(Item("Белорусский государственный экономический университет",R.drawable.logo15))
        universities.add(Item("Белорусский национальный технический университет",R.drawable.logo16))
        universities.add(Item("Военная академия Республики Беларусь",R.drawable.logo17))
        universities.add(Item("Институт пограничной службы Республики Беларусь",R.drawable.logo18))
        universities.add(Item("Минский государственный высший радиотехнический колледж",R.drawable.logo19))
        universities.add(Item("Минский государственный лингвистический университет",R.drawable.logo20))
        universities.add(Item("Минский филиал РЭУ имени Г. В. Плеханова",R.drawable.logo21))
        universities.add(Item("Университет гражданской защиты МЧС Республики Беларусь",R.drawable.logo22))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("items", universities as ArrayList<out Parcelable>)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        universities = savedInstanceState.getParcelableArrayList("items")!!
        adapter = DataAdapter(universities, listener)
        recyclerView.adapter = adapter
    }

    companion object{
        @JvmStatic
        fun newIntent(context: Context) = Intent(context, UniversitiesActivity::class.java)
    }
}