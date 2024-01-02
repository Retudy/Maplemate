package com.android.maplemate

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.maplemate.Data.MainTabs
import com.android.maplemate.UI.FirstFragment
import com.android.maplemate.UI.SecondFragment
import com.android.maplemate.UI.ThirdFragment
import com.android.retrofit.R

class ViewPager2Adapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val fragments = ArrayList<MainTabs>().apply {
        add(
            MainTabs(
                fragment = FirstFragment.newInstance(),
                title = R.string.member_first,
                icon = R.drawable.budget,
            )
        )
        add(
            MainTabs(
                fragment = SecondFragment(),
                title = R.string.member_second,
                icon = R.drawable.community,
            )
        )
        add(
            MainTabs(
                fragment = ThirdFragment(),
                title = R.string.member_third,
                icon = R.drawable.home,
            )
        )
    }

    // HomeFragment의 index를 찾아서 반환해줌
    fun findFragmentTabIndex(name: Int): Int {
        return when (name) {
            R.string.member_first -> {
                val element = fragments.find { it.title == name }
                fragments.indexOf(element)
            }

            R.string.member_second -> {
                val element = fragments.find { it.title == name }
                fragments.indexOf(element)
            }

            R.string.member_third -> {
                val element = fragments.find { it.title == name }
                fragments.indexOf(element)
            }

            else -> 0
        }
    }

    fun getTitme(position: Int): Int = fragments[position].title
    fun getIcon(position: Int): Int = fragments[position].icon

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position].fragment
}