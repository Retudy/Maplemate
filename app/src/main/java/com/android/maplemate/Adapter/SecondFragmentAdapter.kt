package com.android.maplemate.Adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android.maplemate.Data.Equipment
import com.android.maplemate.databinding.FragmentSecondItemBinding

class SecondFragmentAdapter(val items: MutableList<Equipment.ItemEquipment?>) :
    RecyclerView.Adapter<SecondFragmentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SecondFragmentAdapter.ViewHolder {
        val binding =
            FragmentSecondItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SecondFragmentAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(val binding: FragmentSecondItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(item: Equipment.ItemEquipment?) {
            binding.tvItemIcon.load(item?.itemIcon)
            binding.tvItemPartname.text = item?.itemEquipmentPart
            binding.tvItemName.text = item?.itemName
            binding.tvStarFoce.text = "${item?.starforce}성"
            binding.tvOption1.text = item?.potentialOption1
            binding.tvOption2.text = item?.potentialOption2
            binding.tvOption3.text = item?.potentialOption3
            binding.tvAddTvOption1.text = item?.additionalPotentialOption1
            binding.tvAddTvOption2.text = item?.additionalPotentialOption2
            binding.tvAddTvOption3.text = item?.additionalPotentialOption3






        }
    }
}