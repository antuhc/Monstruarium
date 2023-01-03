package com.example.monstruarium

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.example.monstruarium.databinding.ActivityDetailBinding
import com.example.monstruarium.model.Monster

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val monsterName = intent.getStringExtra("MonsterName")
        //binding.monsterName.text = monsterName

        //Parcelable
        val monster = intent.getParcelableExtra<Monster>("Monster")

        if (monster != null) {
            //Nombre en el textView
            //binding.monsterName.text = monster.name

            //Nombre en el toolbar
            title = monster.name

            Glide.with(this).load(monster.cover).into(binding.monsterImage)
            bindDetailInfo(binding.detailMonsterInfo, monster)
        }

    }

    private fun bindDetailInfo(detailMonsterInfo: TextView, monster: Monster) {
        detailMonsterInfo.text = buildSpannedString {
            appendLine(monster.description)

            bold { append("Clase:") }
            appendLine(monster.race)

            bold { append("Genero:") }
            appendLine(monster.genre)

            bold { append("Culto:") }
            appendLine(monster.cult)

            bold { append("Armas:") }
            appendLine(monster.weapons)

            bold { append("Clase:") }
            appendLine(monster.habitat)
        }
    }
}