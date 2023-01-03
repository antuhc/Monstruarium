package com.example.monstruarium

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.monstruarium.databinding.ActivityMainBinding
import com.example.monstruarium.model.Monster
import com.example.monstruarium.model.MonsterDbClient
import kotlinx.coroutines.launch


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarApp)


        val monstersAdapter = MonsterAdapter(emptyList()) {
            navigateTo(it)
            //Toast.makeText(this@MainActivity, monster.name, Toast.LENGTH_SHORT).show()
        }
        binding.containerRecycler.adapter = monstersAdapter

        lifecycleScope.launch {
            val listMovies = MonsterDbClient.service.listMonsters()
            // withContext es para elegir el hilo donde se ejecutara la peticion
            //val body = withContext(Dispatchers.IO) {listMovies.execute().body()}
            // if (body != null)
            monstersAdapter.monsters = listMovies.results
            monstersAdapter.notifyDataSetChanged()
        }
        /*

        thread {
            val listMovies = MonsterDbClient.service.listMonsters()
            val body = listMovies.execute().body()

            runOnUiThread {
                if (body != null)
                    monstersAdapter.monsters = body.results
                    monstersAdapter.notifyDataSetChanged()
            }
        }

         */
    }

    private fun navigateTo(monster: Monster) {
        val intent = Intent(this, DetailActivity::class.java)
        //intent.putExtra("MonsterName", monster.name)
        intent.putExtra("Monster", monster)
        startActivity(intent)
    }

}