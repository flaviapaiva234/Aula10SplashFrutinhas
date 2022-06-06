package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //todo // supportActionBar?.hide() // esconde a barra de menu
        // ou vai em thema e deixa como NoActionBar que vai tirar a barra de menu do projeto inteiro

        // tem como criar a própri barra de menu, tem que ir no layout da activity e chamar uma tag chamada: <AppBarLayout

        //para instanciar ou chamar o Handler, tem que colocar o (Looper.getMainLooper())
        //Handler executa a ação depois de um tempo
        //e o intervalo de tempo que essa ação vai ocorrer, essa ação se chama:.postDelayed({Runnable *é uma ação*,
        // delayMillis *essa ação vai aceitar um tempo que é sempre em milisegundos*})

        //Handler usado para manipular tudo(então vamos usar para manipular o tempo(como um temporizador))
        Handler(Looper.getMainLooper()).postDelayed({
            //Intent que navega para a home
            val intent = Intent(this@SplashActivity, MainActivity::class.java) // navegar da @SplashActivity para Home Activity
            startActivity(intent) // o start é para fazer essa função entrar em vigor
           finish() // Termina com a activity, vai tirar da pilha para o usuário não voltar mais nessa tela
            },2000) // após 3 segundos é para navegar para a home

    }
}