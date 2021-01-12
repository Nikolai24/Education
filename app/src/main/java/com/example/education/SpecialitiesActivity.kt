package com.example.education

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SpecialitiesActivity : AppCompatActivity() {
    private var specialities: MutableList<Item> = mutableListOf()
    private lateinit var adapter: DataAdapter
    private lateinit var recyclerView: RecyclerView

    private val listener: DataAdapter.OnItemClickListener = object : DataAdapter.OnItemClickListener {
        override fun onItemClick(specialty: Item, position: Int) {
            startSpecialitiesProfileActivity(specialty, position)
        }
    }

    private fun startSpecialitiesProfileActivity(specialty: Item, position: Int) {
        val intent = Intent(this@SpecialitiesActivity, SpecialitiesProfileActivity::class.java)
        intent.putExtra("Specialty", specialty)
        intent.putExtra("position", position)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specialities)
        setInitialData()
        adapter = DataAdapter(specialities, listener)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun setInitialData() {
        specialities.add(Item("ПЕДАГОГИКА", R.drawable.school))
        specialities.add(Item("ИСКУССТВО И ДИЗАЙН",R.drawable.school))
        specialities.add(Item("ГУМАНИТАРНЫЕ НАУКИ",R.drawable.school))
        specialities.add(Item("КОММУНИКАЦИИ. ПРАВО. ЭКОНОМИКА. УПРАВЛЕНИЕ", R.drawable.school))
        specialities.add(Item("ЕСТЕСТВЕННЫЕ НАУКИ",R.drawable.school))
        specialities.add(Item("ЭКОЛОГИЧЕСКИЕ НАУКИ",R.drawable.school))
        specialities.add(Item("ТЕХНИКА И ТЕХНОЛОГИИ",R.drawable.school))
        specialities.add(Item("АРХИТЕКТУРА И СТРОИТЕЛЬСТВО", R.drawable.school))
        specialities.add(Item("СЕЛЬСКОЕ И ЛЕСНОЕ ХОЗЯЙСТВО",R.drawable.school))
        specialities.add(Item("ЗДРАВООХРАНЕНИЕ",R.drawable.school))
        specialities.add(Item("СОЦИАЛЬНАЯ ЗАЩИТА",R.drawable.school))
        specialities.add(Item("ФИЗИЧЕСКАЯ КУЛЬТУРА. ТУРИЗМ И ГОСТЕПРИИМСТВО",R.drawable.school))
        specialities.add(Item("ОБЩЕСТВЕННОЕ ПИТАНИЕ. БЫТОВОЕ ОБСЛУЖИВАНИЕ",R.drawable.school))
        specialities.add(Item("СЛУЖБЫ БЕЗОПАСНОСТИ",R.drawable.school))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("items", specialities as ArrayList<out Parcelable>)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        specialities = savedInstanceState.getParcelableArrayList("items")!!
        adapter = DataAdapter(specialities, listener)
        recyclerView.adapter = adapter
    }

    companion object{
        @JvmStatic
        fun newIntent(context: Context) = Intent(context, SpecialitiesActivity::class.java)
    }
}

