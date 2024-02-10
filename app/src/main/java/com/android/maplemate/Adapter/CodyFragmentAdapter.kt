package com.android.maplemate.Adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android.maplemate.Data.Cash
import com.android.maplemate.Data.Cash2222
import com.android.maplemate.databinding.FragmentCodyDetailItemBinding

class CodyFragmentAdapter(
) : RecyclerView.Adapter<CodyFragmentAdapter.ViewHolder>() {

    private var items: List<Cash2222.CashItemEquipmentBase> = emptyList()

    fun setItems(items: List<Cash2222.CashItemEquipmentBase?>) {
        this.items = items as List<Cash2222.CashItemEquipmentBase>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CodyFragmentAdapter.ViewHolder {
        val binding =
            FragmentCodyDetailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CodyFragmentAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(val binding: FragmentCodyDetailItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(item: Cash2222.CashItemEquipmentBase) = binding.apply {

            imgCodyName.load(item.cashItemIcon)
            tvCodyItem.text = item?.cashItemLabel as CharSequence?
            tvCodyItemChar.text = item?.cashItemEquipmentSlot
            tvCodyItemName.text = item?.cashItemName

        }
    }
}
