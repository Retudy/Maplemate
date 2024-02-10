package com.android.maplemate.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android.maplemate.Data.Equipment
import com.android.maplemate.R
import com.android.maplemate.databinding.FragmentSecondItemBinding

class SecondFragmentAdapter(
    private val context: Context,
    val items: MutableList<Equipment.ItemEquipment?>
) :
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

    fun submitList(newList: List<Equipment.ItemEquipment?>) {

        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }


    inner class ViewHolder(val binding: FragmentSecondItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(item: Equipment.ItemEquipment?) {

            binding.tvItemIcon.load(item?.itemIcon)
            binding.tvItemPartname.text = item?.itemEquipmentPart
            binding.tvItemName.text = item?.itemName
            // 스타포스가 0 일때
            when (item?.starforce) {

                "0" -> binding.tvStarFoce.visibility = View.GONE
                else -> {
                    binding.tvStarFoce.visibility = View.VISIBLE
                    when (item?.starforce) {
                        else -> binding.tvStarFoce.text = "⭐️${item?.starforce}성"
                    }
                }

            }
            //옵션1 조건처리

            when (item?.potentialOption1) {

                null -> binding.framePotential.visibility = View.GONE
                else -> {
                    binding.framePotential.visibility = View.VISIBLE

                    when (item?.potentialOption1) {
                        //잠재1번
                        else -> binding.tvOption1.text = changedText(item?.potentialOption1)

                    }
                }

            }


            //옵션2 조건처리
            when (item?.potentialOption2) {
                // 윗잠 2번
                else -> binding.tvOption2.text = changedText(item?.potentialOption2)

            }


            //옵션3 조건처리
            when (item?.potentialOption3) {
                // 윗잠 3번


                else -> binding.tvOption3.text = changedText(item?.potentialOption3)
            }

            //에디1 조건처리

            when (item?.additionalPotentialOption1) {

                null -> binding.frameAddPotential.visibility = View.GONE // 1번 옵션이 없으면 레이아웃 날림
                else -> {
                    binding.frameAddPotential.visibility = View.VISIBLE
                    when (item?.additionalPotentialOption1) {
                        //에디 1번옵션
                        else -> binding.tvAddTvOption1.text =
                            changedText(item?.additionalPotentialOption1)


                    }
                }
            }
            //에디2 조건처리
            when (item?.additionalPotentialOption2) {
                //에디 2번옵션
                else -> binding.tvAddTvOption2.text = changedText(item?.additionalPotentialOption2)
            }
            //에디3 조건처리
            when (item?.additionalPotentialOption3) {

                //에디3번옵션
                else -> binding.tvAddTvOption3.text = changedText(item?.additionalPotentialOption3)
            }
            //등급별 잠재옵션 색깔 조건 처리


            // 잠재능력 색상
            when (item?.potentialOptionGrade) {
                "레전드리" -> binding.apply {
                    tvOption1.setTextColor(ContextCompat.getColor(context, R.color.Legendary))
                    tvOption2.setTextColor(ContextCompat.getColor(context, R.color.Legendary))
                    tvOption3.setTextColor(ContextCompat.getColor(context, R.color.Legendary))
                }

                "유니크" -> binding.apply {
                    tvOption1.setTextColor(ContextCompat.getColor(context, R.color.Unique))
                    tvOption2.setTextColor(ContextCompat.getColor(context, R.color.Unique))
                    tvOption3.setTextColor(ContextCompat.getColor(context, R.color.Unique))
                }

                "에픽" -> binding.apply {
                    tvOption1.setTextColor(ContextCompat.getColor(context, R.color.Epic))
                    tvOption2.setTextColor(ContextCompat.getColor(context, R.color.Epic))
                    tvOption3.setTextColor(ContextCompat.getColor(context, R.color.Epic))
                }

                "레어" -> binding.apply {
                    tvOption1.setTextColor(ContextCompat.getColor(context, R.color.Normal))
                    tvOption2.setTextColor(ContextCompat.getColor(context, R.color.Normal))
                    tvOption3.setTextColor(ContextCompat.getColor(context, R.color.Normal))
                }

                else -> binding.tvAddTvOption3.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.Normal
                    )
                )
            }
            // 에디셔널 잠재능력 색상
            when (item?.additionalPotentialOptionGrade) {
                "레전드리" -> binding.apply {
                    tvAddTvOption1.setTextColor(ContextCompat.getColor(context, R.color.Legendary))
                    tvAddTvOption2.setTextColor(ContextCompat.getColor(context, R.color.Legendary))
                    tvAddTvOption3.setTextColor(ContextCompat.getColor(context, R.color.Legendary))
                }

                "유니크" -> binding.apply {
                    tvAddTvOption1.setTextColor(ContextCompat.getColor(context, R.color.Unique))
                    tvAddTvOption2.setTextColor(ContextCompat.getColor(context, R.color.Unique))
                    tvAddTvOption3.setTextColor(ContextCompat.getColor(context, R.color.Unique))
                }

                "에픽" -> binding.apply {
                    tvAddTvOption1.setTextColor(ContextCompat.getColor(context, R.color.Epic))
                    tvAddTvOption2.setTextColor(ContextCompat.getColor(context, R.color.Epic))
                    tvAddTvOption3.setTextColor(ContextCompat.getColor(context, R.color.Epic))
                }

                "레어" -> binding.apply {
                    tvAddTvOption1.setTextColor(ContextCompat.getColor(context, R.color.Normal))
                    tvAddTvOption2.setTextColor(ContextCompat.getColor(context, R.color.Normal))
                    tvAddTvOption3.setTextColor(ContextCompat.getColor(context, R.color.Normal))
                }

                else -> binding.tvAddTvOption3.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.Normal
                    )
                )
            }
        }
    }

    // 문자열 치환 함수
    fun changedText(Option: String?): String {
        return when (Option) {
            "아이템 드롭률 : +5%" -> "드랍 5%"
            "메소 획득량 : +5%" -> "메획 5%"
            "캐릭터 기준 9레벨 당 STR : +2" -> "렙당 STR : +2"
            "캐릭터 기준 9레벨 당 DEX : +2" -> "렙당 DEX : +2"
            "캐릭터 기준 9레벨 당 INT : +2" -> "렙당 INT : +2"
            "캐릭터 기준 9레벨 당 LUK : +2" -> "렙당 LUK : +2"
            "캐릭터 기준 9레벨 당 STR : +1" -> "렙당 STR : +1"
            "캐릭터 기준 9레벨 당 DEX : +1" -> "렙당 DEX : +1"
            "캐릭터 기준 9레벨 당 INT : +1" -> "렙당 INT : +1"
            "캐릭터 기준 9레벨 당 LUK : +1" -> "렙당 LUK : +1"
            "공격 시 15% 확률로 85의 HP 회복" -> "기타"
            "4초 당 16의 HP 회복" -> "기타"
            "4초 당 24의 MP 회복" -> "기타"
            "공격 시 10% 확률로 5레벨 중독효과 적용" -> "기타"
            "공격 시 5% 확률로 2레벨 기절효과 적용" -> "기타"
            "30% 확률로 받은 피해의 70%를 반사" -> "기타"
            "공격 시 3% 확률로 32의 HP 회복" -> "기타"
            "아이템 드롭률 : +20%" -> "드랍 20%"
            "아이템 드롭률 : +5%" -> "드랍 5%"
            "메소 획득량 : +20%" -> "메획 20%"
            "메소 획득량 : +5%" -> "메획 5%"
            "크리티컬 데미지 : +8%" -> "크뎀: +8%"
            "크리티컬 데미지 : +3%" -> "크뎀: +3%"
            "크리티컬 데미지 : +1%" -> "크뎀: +1%"
            "<쓸만한 샤프 아이즈> 스킬 사용 가능" -> "< 쓸샾 >"
            "<쓸만한 윈드 부스터> 스킬 사용 가능" -> "< 쓸윈부 >"
            "모든 스킬의 재사용 대기시간 : -2초(10초 이하는 10%감소, 5초 미만으로 감소 불가)" -> "쿨감 : -2초"
            "모든 스킬의 재사용 대기시간 : -1초(10초 이하는 5%감소, 5초 미만으로 감소 불가)" -> "쿨감 : -1초"
            "HP 회복 아이템 및 회복 스킬 효율 : +30%" -> "기타 옵션"
            "4초 당 22의 MP 회복" -> "기타"
            "공격 시 10% 확률로 6레벨 중독효과 적용" -> "기타"
            "공격 시 15% 확률로 95의 HP 회복" -> "기타"
            "이동속도 : +3" -> "이속: +3"
            "최대 HP : +12%" -> "HP : +12%"
            "최대 HP : +9%" -> "HP : +9%"
            "최대 MP : + 12%" -> "기타"
            "최대 MP : +9%" -> "기타"
            "HP 회복 아이템 및 회복 스킬 효율 : +30%" -> "기타"
            "<쓸만한 미스틱 도어> 스킬 사용 가능" -> "기타"
            "크리티컬 확률 : +3%" -> "크확 : +3%"
            "크리티컬 확률 : +9%" -> "크확 : +9%"

            //보스관련옵션
            "보스 몬스터 공격 시 데미지 : +40%" -> "보공: +40%"
            "보스 몬스터 공격 시 데미지 : +35%" -> "보공: +35%"
            "보스 몬스터 공격 시 데미지 : +30%" -> "보공: +30%"
            "보스 몬스터 공격 시 데미지 : +20%" -> "보공: +20%"
            "보스 몬스터 공격 시 데미지 : +18%" -> "보공: +18%"
            "보스 몬스터 공격 시 데미지 : +12%" -> "보공: +12%"
            "몬스터 방어율 무시 : +40%" -> "방무: +40%"
            "몬스터 방어율 무시 : +35%" -> "방무: +35%"
            "몬스터 방어율 무시 : +30%" -> "방무: +30%"
            "몬스터 방어율 무시 : +15%" -> "방무: +15%"
            "몬스터 방어율 무시 : +4%" -> "방무: +4%"

            null -> ""

            else -> "${Option}"

        }

    }
}