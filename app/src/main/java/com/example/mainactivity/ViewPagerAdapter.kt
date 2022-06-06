package com.example.mainactivity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// criei essa classe que vai dar o empurrãozinho necessario
// para o ViewPager funcionar e começar a contagem das telas
// e de acordo com essa contagem vai definir em qual tela que está.

//Esse adapter foi projetado para receber as activitys

class ViewPagerAdapter(
        //tem que recefer como parametro um fragmento de activity
   fragment: FragmentActivity
): FragmentStateAdapter(fragment) {  //ela já é pronta para receber um construtor fragment

      override fun getItemCount(): Int { //esse método serve para contar quantas páginas tem
                return 10
   }

   override fun createFragment(position: Int): Fragment {  //cria os meus fragments

       return when(position){
           0 -> {
               FirtsPageFragment()
           }
           1 -> {
               SecondFragment()
           }
           2 -> {
               ThirdFragment()
           }
           else -> {
               FourthFragment()
           }

       }
   }


}