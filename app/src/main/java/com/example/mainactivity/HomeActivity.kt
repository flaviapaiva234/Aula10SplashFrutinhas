package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.mainactivity.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Configura a minha Toobar de ações
        setSupportActionBar(binding.myToobar) // tem que retornar a myToobar

        //Recupera a minha barra de ações, essa é a ação de aparecer a setinha na barra de menu
        val actionBar = supportActionBar

        //chama a actionBar com *actionBar?*
        actionBar?.setDisplayHomeAsUpEnabled(true)
        // .setDisplayHomeAsUpEnabled(true) ativa a setinha de retorno padrão do android (ex: o whataPP tem essa seta quando entra em uma conversa

        //para definir uma ação
        binding.myToobar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {  // Identifica o Id

                R.id.itemBuscarMorango -> {  // Faz a ação do item: itemBuscar
                    val intent = Intent(this@HomeActivity, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.addPudim -> {    // Faz a ação do item: addPudim
                    val intent = Intent(this@HomeActivity, SplashActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.addTalher -> {  // Faz a ação do item: itemBuscar
                    val intent = Intent(this@HomeActivity,LastActivity::class.java)
                    startActivity(intent)
                    true
                }

                // essa ação exige um boolean então tem que colocar um true

            else -> false
        }

        }

        setViewPager() // está função que está sendo chamada está logo abaixo

    }

    private fun setViewPager(){   // //Essa ViewPager tem que receber o Adapter que é o impurrãozinho
        binding.viewPagerHomeTela.adapter = ViewPagerAdapter(this) //Declara o adapter e o atribui ao view

        //Vou usar mais um objeto pronto que vai receber dois parametros
          // vou usar o tabLayout que está no layout "activity_main* e vai receber a viewPager também
        //TabLayout é o objeto responsável por fazer aparecer as tabs e manipula-las de acordo com o fragmmente que irá aparecer
        TabLayoutMediator(binding.tabLayout2, binding.viewPagerHomeTela){ tab, position ->
            tab.text = "Telinha $position"
        }.attach() // essa linha vai associar os comandos acima da setViewPage
    }

    //Essa Função é chamada quando o item na toolbar é clicado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){   //idebtifica o id do item
            android.R.id.home -> {   // Home é o id da seta de navegação
                onBackPressed()  // Efetua o retorno
                return true // essa função exige um retorno boolean, então tem que colocar o *retorn true*
            }
        }
        return super.onOptionsItemSelected(item)

    }

    // tem que adicionar os itens toobar a essa activity
    //*onCreateOptionsMenu* essa função é sempre responsável por criar itens na toobar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}


//todo // supportActionBar?.hide() // esconde a barra de menu
// ou vai em themes e deixa como NoActionBar que vai tirar a barra de menu do projeto inteiro

// tem como criar a própria barra de menu, tem que ir no layout da activity e chamar uma tag chamada: <AppBarLayout