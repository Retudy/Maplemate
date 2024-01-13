package com.android.maplemate.Adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
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
            // 스타포스가 0 일때
            when(item?.starforce.toString()){
                "0" -> binding.tvStarFoce.text = "⭐"
                else -> binding.tvStarFoce.text = "⭐${item?.starforce}"
            }
            //옵션1 조건처리

            when(item?.potentialOption1.toString()) {

                 "null" -> binding.framePotential.visibility = View.GONE
                "크리티컬 데미지 : +8%" -> binding.tvOption1.text = "크뎀 8%"
                "<쓸만한 샤프 아이즈> 스킬 사용 가능" -> binding.tvOption1.text ="<쓸샾>"
                "<쓸만한 윈드 부스터> 스킬 사용 가능" -> binding.tvOption1.text ="<쓸윈부>"
                "보스 몬스터 공격 시 데미지 : +40%" -> binding.tvOption1.text = "보공40%"
                "보스 몬스터 공격 시 데미지 : +35%" -> binding.tvOption1.text = "보공35%"
                "보스 몬스터 공격 시 데미지 : +30%" -> binding.tvOption1.text = "보공30%"
                "몬스터 방어율 무시 : +40%" -> binding.tvOption1.text = "방무40%"
                "몬스터 방어율 무시 : +35%" -> binding.tvOption1.text = "방무35%"
                "몬스터 방어율 무시 : +30%" -> binding.tvOption1.text = "방무30%"
                "모든 스킬의 재사용 대기시간 : -2초(10초 이하는 10%감소, 5초 미만으로 감소 불가)" -> binding.tvOption1.text = "쿨감-2초"
                "모든 스킬의 재사용 대기시간 : -1초(10초 이하는 5%감소, 5초 미만으로 감소 불가)" -> binding.tvOption1.text = "쿨감-1초"
                "아이템 드롭률 : +20%" -> binding.tvOption1.text = "드랍 20%"
                "메소 획득량 : +20%" -> binding.tvOption1.text ="메획 20%"
                "캐릭터 기준 9레벨 당 STR : +2" -> binding.tvOption1.text ="렙당STR:+2"
                "캐릭터 기준 9레벨 당 DEX : +2" -> binding.tvOption1.text ="렙당DEX:+2"
                "캐릭터 기준 9레벨 당 INT : +2" -> binding.tvOption1.text ="렙당INT:+2"
                "캐릭터 기준 9레벨 당 LUK : +2" -> binding.tvOption1.text ="렙당LUK:+2"
                "HP 회복 아이템 및 회복 스킬 효율 : +30%" -> binding.tvOption1.text = "기타"
                "4초 당 22의 MP 회복" -> binding.tvOption1.text = "기타"
                else -> binding.tvOption1.text = item?.potentialOption1
            }

            var add = binding.framePotential.visibility

            when (add){
               View.GONE -> binding.frameAddPotential.visibility = View.GONE
            }


            //옵션2 조건처리
            when(item?.potentialOption2.toString()) {
                "크리티컬 데미지 : +8%" -> binding.tvOption2.text = "크뎀 8%"
                "<쓸만한 샤프 아이즈> 스킬 사용 가능" -> binding.tvOption2.text ="쓸샾⭐"
                "<쓸만한 윈드 부스터> 스킬 사용 가능" -> binding.tvOption2.text ="쓸윈부🌪️"
                "보스 몬스터 공격 시 데미지 : +40%" -> binding.tvOption2.text = "보공40%"
                "보스 몬스터 공격 시 데미지 : +35%" -> binding.tvOption2.text = "보공35%"
                "보스 몬스터 공격 시 데미지 : +30%" -> binding.tvOption2.text = "보공30%"
                "보스 몬스터 공격 시 데미지 : +20%" -> binding.tvOption2.text = "보공20%"
                "몬스터 방어율 무시 : +40%" -> binding.tvOption2.text = "방무40%"
                "몬스터 방어율 무시 : +35%" -> binding.tvOption2.text = "방무35%"
                "몬스터 방어율 무시 : +30%" -> binding.tvOption2.text = "방무30%%"
                "모든 스킬의 재사용 대기시간 : -2초(10초 이하는 10%감소, 5초 미만으로 감소 불가)" -> binding.tvOption2.text = "쿨감-2초"
                "모든 스킬의 재사용 대기시간 : -1초(10초 이하는 5%감소, 5초 미만으로 감소 불가)" -> binding.tvOption2.text = "쿨감-1초"
                "아이템 드롭률 : +20%" -> binding.tvOption2.text = "드랍 20%"
                "메소 획득량 : +20%" -> binding.tvOption2.text ="메획 20%"
                "캐릭터 기준 9레벨 당 STR : +2" -> binding.tvOption2.text ="렙당STR:+2"
                "캐릭터 기준 9레벨 당 DEX : +2" -> binding.tvOption2.text ="렙당DEX:+2"
                "캐릭터 기준 9레벨 당 INT : +2" -> binding.tvOption2.text ="렙당INT:+2"
                "캐릭터 기준 9레벨 당 LUK : +2" -> binding.tvOption2.text ="렙당LUK:+2"
                "HP 회복 아이템 및 회복 스킬 효율 : +30%" -> binding.tvOption2.text = "기타"
                "4초 당 22의 MP 회복" -> binding.tvOption2.text = "기타"
                else -> binding.tvOption2.text = item?.potentialOption2
            }


            //옵션3 조건처리
            when(item?.potentialOption3.toString()) {

                "크리티컬 데미지 : +8%" -> binding.tvOption3.text = "크뎀 8%"
                "<쓸만한 샤프 아이즈> 스킬 사용 가능" -> binding.tvOption3.text ="<쓸샾>"
                "<쓸만한 윈드 부스터> 스킬 사용 가능" -> binding.tvOption3.text ="<쓸윈부>"
                "보스 몬스터 공격 시 데미지 : +40%" -> binding.tvOption3.text = "보공40%"
                "보스 몬스터 공격 시 데미지 : +35%" -> binding.tvOption3.text = "보공35%"
                "보스 몬스터 공격 시 데미지 : +30%" -> binding.tvOption3.text = "보공30%"
                "보스 몬스터 공격 시 데미지 : +20%" -> binding.tvOption3.text = "보공20%"
                "몬스터 방어율 무시 : +40%" -> binding.tvOption2.text = "방무40%"
                "몬스터 방어율 무시 : +35%" -> binding.tvOption2.text = "방무35%"
                "몬스터 방어율 무시 : +30%" -> binding.tvOption2.text = "방무30%%"
                "모든 스킬의 재사용 대기시간 : -2초(10초 이하는 10%감소, 5초 미만으로 감소 불가)" -> binding.tvOption3.text = "쿨감-2초"
                "모든 스킬의 재사용 대기시간 : -1초(10초 이하는 5%감소, 5초 미만으로 감소 불가)" -> binding.tvOption3.text = "쿨감-1초"
                "아이템 드롭률 : +20%" -> binding.tvOption3.text = "드랍 20%"
                "메소 획득량 : +20%" -> binding.tvOption3.text ="메획 20%"
                "캐릭터 기준 9레벨 당 STR : +2" -> binding.tvOption3.text ="렙당STR:+2"
                "캐릭터 기준 9레벨 당 DEX : +2" -> binding.tvOption3.text ="렙당DEX:+2"
                "캐릭터 기준 9레벨 당 INT : +2" -> binding.tvOption3.text ="렙당INT:+2"
                "캐릭터 기준 9레벨 당 LUK : +2" -> binding.tvOption3.text ="렙당LUK:+2"
                "HP 회복 아이템 및 회복 스킬 효율 : +30%" -> binding.tvOption3.text = "HP효율+30%"
                "4초 당 22의 MP 회복" -> binding.tvOption3.text = "기타"
                else -> binding.tvOption3.text = item?.potentialOption3
            }
            //에디1 조건처리
            when(item?.additionalPotentialOption1.toString()) {
                "크리티컬 데미지 : +3%" -> binding.tvAddTvOption1.text = "크뎀 3%"
                "크리티컬 데미지 : +1%" -> binding.tvAddTvOption1.text = "크뎀 1%"
                "보스 몬스터 공격 시 데미지 : +18%" -> binding.tvAddTvOption1.text = "보공18%"
                "보스 몬스터 공격 시 데미지 : +12%" -> binding.tvAddTvOption1.text = "보공12%"
                "모든 스킬의 재사용 대기시간 : -1초(10초 이하는 5%감소, 5초 미만으로 감소 불가)" -> binding.tvAddTvOption1.text = "쿨감-1초"
                "아이템 드롭률 : +5%" -> binding.tvAddTvOption1.text = "드랍 5%"
                "메소 획득량 : +5%" -> binding.tvAddTvOption1.text ="메획 5%"
                "캐릭터 기준 9레벨 당 STR : +2" -> binding.tvAddTvOption1.text ="렙당STR:+2"
                "캐릭터 기준 9레벨 당 DEX : +2" -> binding.tvAddTvOption1.text ="렙당DEX:+2"
                "캐릭터 기준 9레벨 당 INT : +2" -> binding.tvAddTvOption1.text ="렙당INT:+2"
                "캐릭터 기준 9레벨 당 LUK : +2" -> binding.tvAddTvOption1.text ="렙당LUK:+2"
                "캐릭터 기준 9레벨 당 STR : +1" -> binding.tvAddTvOption1.text ="렙당STR:+1"
                "캐릭터 기준 9레벨 당 DEX : +1" -> binding.tvAddTvOption1.text ="렙당DEX:+1"
                "캐릭터 기준 9레벨 당 INT : +1" -> binding.tvAddTvOption1.text ="렙당INT:+1"
                "캐릭터 기준 9레벨 당 LUK : +1" -> binding.tvAddTvOption1.text ="렙당LUK:+1"
                else -> binding.tvAddTvOption1.text = item?.additionalPotentialOption1
            }
            //에디2 조건처리
            when(item?.additionalPotentialOption2.toString()) {
                "보스 몬스터 공격 시 데미지 : +18%" -> binding.tvAddTvOption2.text = "보공18%"
                "보스 몬스터 공격 시 데미지 : +12%" -> binding.tvAddTvOption2.text = "보공12%"
                "크리티컬 데미지 : +3%" -> binding.tvAddTvOption2.text = "크뎀 3%"
                "크리티컬 데미지 : +1%" -> binding.tvAddTvOption2.text = "크뎀 1%"
                "모든 스킬의 재사용 대기시간 : -1초(10초 이하는 5%감소, 5초 미만으로 감소 불가)" -> binding.tvAddTvOption2.text = "쿨감-1초"
                "아이템 드롭률 : +5%" -> binding.tvAddTvOption2.text = "드랍 5%"
                "메소 획득량 : +5%" -> binding.tvAddTvOption2.text ="메획 5%"
                "캐릭터 기준 9레벨 당 STR : +2" -> binding.tvAddTvOption2.text ="렙당STR:+2"
                "캐릭터 기준 9레벨 당 DEX : +2" -> binding.tvAddTvOption2.text ="렙당DEX:+2"
                "캐릭터 기준 9레벨 당 INT : +2" -> binding.tvAddTvOption2.text ="렙당INT:+2"
                "캐릭터 기준 9레벨 당 LUK : +2" -> binding.tvAddTvOption2.text ="렙당LUK:+2"
                "캐릭터 기준 9레벨 당 STR : +1" -> binding.tvAddTvOption2.text ="렙당STR:+1"
                "캐릭터 기준 9레벨 당 DEX : +1" -> binding.tvAddTvOption2.text ="렙당DEX:+1"
                "캐릭터 기준 9레벨 당 INT : +1" -> binding.tvAddTvOption2.text ="렙당INT:+1"
                "캐릭터 기준 9레벨 당 LUK : +1" -> binding.tvAddTvOption2.text ="렙당LUK:+1"
                else -> binding.tvAddTvOption2.text = item?.additionalPotentialOption2
            }
            //에디3 조건처리
            when(item?.additionalPotentialOption3.toString()) {
                "보스 몬스터 공격 시 데미지 : +18%" -> binding.tvAddTvOption3.text = "보공18%"
                "보스 몬스터 공격 시 데미지 : +12%" -> binding.tvAddTvOption3.text = "보공12%"
                "크리티컬 데미지 : +3%" -> binding.tvAddTvOption3.text = "크뎀 3%"
                "크리티컬 데미지 : +1%" -> binding.tvAddTvOption3.text = "크뎀 1%"
                "모든 스킬의 재사용 대기시간 : -1초(10초 이하는 5%감소, 5초 미만으로 감소 불가)" -> binding.tvAddTvOption3.text = "쿨감-1초"
                "아이템 드롭률 : +5%" -> binding.tvAddTvOption3.text = "드랍 5%"
                "메소 획득량 : +5%" -> binding.tvAddTvOption3.text ="메획 5%"
                "캐릭터 기준 9레벨 당 STR : +2" -> binding.tvAddTvOption3.text ="렙당STR:+2"
                "캐릭터 기준 9레벨 당 DEX : +2" -> binding.tvAddTvOption3.text ="렙당DEX:+2"
                "캐릭터 기준 9레벨 당 INT : +2" -> binding.tvAddTvOption3.text ="렙당INT:+2"
                "캐릭터 기준 9레벨 당 LUK : +2" -> binding.tvAddTvOption3.text ="렙당LUK:+2"
                "캐릭터 기준 9레벨 당 STR : +1" -> binding.tvAddTvOption3.text ="렙당STR:+1"
                "캐릭터 기준 9레벨 당 DEX : +1" -> binding.tvAddTvOption3.text ="렙당DEX:+1"
                "캐릭터 기준 9레벨 당 INT : +1" -> binding.tvAddTvOption3.text ="렙당INT:+1"
                "캐릭터 기준 9레벨 당 LUK : +1" -> binding.tvAddTvOption3.text ="렙당LUK:+1"
                else -> binding.tvAddTvOption3.text = item?.additionalPotentialOption3
            }







        }
    }
}