package com.example.education

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ComparisonActivity : AppCompatActivity() {
    private var test = arrayOf<String>(
        "Биология",
        "География",
        "Всемирная истроия (новое время)",
        "Иностранный язык",
        "История Беларуси",
        "Математика",
        "Обществоведение",
        "Русский / белорусский язык",
        "Русская / белорусская литература",
        "Физика",
        "Физическая подготовка",
        "Химия"
    )

    private lateinit var editResult: TextView
    private var spec: MutableList<Spec> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparison)
        setInitialData()
        var selection = findViewById(R.id.selection) as TextView
        val spinner = findViewById(R.id.spinner) as Spinner
        val spinner2 = findViewById(R.id.spinner2) as Spinner
        val spinner3 = findViewById(R.id.spinner3) as Spinner
        editResult = findViewById(R.id.edit_result)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, test)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(adapter)
        spinner2.setAdapter(adapter)
        spinner3.setAdapter(adapter)
        var test1 = String()
        var test2 = String()
        var test3 = String()

        findViewById<Button>(R.id.comparison).setOnClickListener{
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("test1", test1)
            intent.putExtra("test2", test2)
            intent.putExtra("iptest3", test3)
            intent.putExtra("result", editResult.text.toString())
            startActivity(intent)
        }

        val itemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val item = parent.getItemAtPosition(position) as String
                test1 = item
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
        spinner.setOnItemSelectedListener(itemSelectedListener)
    }

    companion object{
        @JvmStatic
        fun newIntent(context: Context) = Intent(context, ComparisonActivity::class.java)
    }

    private fun setInitialData() {
        spec.add(Spec("Правоведение. Судебно-прокурорско-следственная деятельность", "Академия Министерства внутренних дел Республики Беларусь", R.drawable.logo01))
        spec.add(Spec("Академия управления при Президенте Республики Беларусь", R.drawable.logo02))
        spec.add(Spec("Белорусский государственный аграрный технический университет", R.drawable.logo03))
        spec.add(Spec("Белорусская государственная академия авиации", R.drawable.logo04))
        spec.add(Spec("Белорусская государственная академия искусств",R.drawable.logo05))
        spec.add(Spec("Белорусская государственная академия музыки",R.drawable.logo06))
        spec.add(Spec("Белорусская государственная академия связи",R.drawable.logo07))
        spec.add(Spec("Белорусский государственный медицинский университет", R.drawable.logo08))
        spec.add(Spec("Белорусский государственный педагогический университет имени Максима Танка",R.drawable.logo09))
        spec.add(Spec("Белорусский государственный технологический университет",R.drawable.logo10))
        spec.add(Spec("Белорусский государственный университет",R.drawable.logo11))
        spec.add(Spec("Белорусский государственный университет информатики и радиоэлектроники",R.drawable.logo12))
        spec.add(Spec("Белорусский государственный университет культуры и искусств",R.drawable.logo13))
        spec.add(Spec("Белорусский государственный университет физической культуры",R.drawable.logo14))
        spec.add(Spec("Белорусский государственный экономический университет",R.drawable.logo15))
        spec.add(Spec("Белорусский национальный технический университет",R.drawable.logo16))
        spec.add(Spec("Военная академия Республики Беларусь",R.drawable.logo17))
        spec.add(Spec("Институт пограничной службы Республики Беларусь",R.drawable.logo18))
        spec.add(Spec("Минский государственный высший радиотехнический колледж",R.drawable.logo19))
        spec.add(Spec("Минский государственный лингвистический университет",R.drawable.logo20))
        spec.add(Spec("Минский филиал РЭУ имени Г. В. Плеханова",R.drawable.logo21))
        spec.add(Spec("Университет гражданской защиты МЧС Республики Беларусь",R.drawable.logo22))
    }
}