package com.android.maplemate

import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

object Util {

    fun hideOrShowBottomNavigationView(context: Context, isVisible: Boolean) {
        val activity = context as? AppCompatActivity
        val bottomNavigationView = activity?.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.viewPager2)

        bottomNavigationView?.visibility = if (isVisible) View.VISIBLE else View.GONE
        viewPager2?.isUserInputEnabled = isVisible
    }

}