package com.android.maplemate.Data

import com.google.gson.annotations.SerializedName

data class Equipment(
    @SerializedName("character_class")
    val characterClass: String?,  //
    @SerializedName("character_gender")
    val characterGender: String?,  //성별
    @SerializedName("date")
    val date: String?, // 조회날짜
    @SerializedName("dragon_equipment")
    val dragonEquipment: List<DragonEquipment?>?, // 비어있음
    @SerializedName("item_equipment")
    val itemEquipment: List<ItemEquipment?>?,  // 장비아이템
    @SerializedName("mechanic_equipment")
    val mechanicEquipment: List<MechanicEquipment?>?,
    @SerializedName("title")
    val title: Title?,
) {
    data class DragonEquipment(
        @SerializedName("cuttable_count")
        val cuttableCount: String?,
        @SerializedName("date_expire")
        val dateExpire: String?,
        @SerializedName("equipment_level_increase")
        val equipmentLevelIncrease: Int?,
        @SerializedName("equipment_slot")
        val equipmentSlot: String?,
        @SerializedName("gender")
        val gender: String?,
        @SerializedName("golden_hammer_flag")
        val goldenHammerFlag: String?,
        @SerializedName("growth_exp")
        val growthExp: Int?,
        @SerializedName("growth_level")
        val growthLevel: Int?,
        @SerializedName("item_add_option")
        val itemAddOption: ItemAddOption?,
        @SerializedName("item_base_option")
        val itemBaseOption: ItemBaseOption?,
        @SerializedName("item_description")
        val itemDescription: String?,
        @SerializedName("item_equipment_part")
        val itemEquipmentPart: String?,
        @SerializedName("item_etc_option")
        val itemEtcOption: ItemEtcOption?,
        @SerializedName("item_exceptional_option")
        val itemExceptionalOption: ItemExceptionalOption?,
        @SerializedName("item_icon")
        val itemIcon: String?,
        @SerializedName("item_name")
        val itemName: String?,
        @SerializedName("item_shape_icon")
        val itemShapeIcon: String?,
        @SerializedName("item_shape_name")
        val itemShapeName: String?,
        @SerializedName("item_starforce_option")
        val itemStarforceOption: ItemStarforceOption?,
        @SerializedName("item_total_option")
        val itemTotalOption: ItemTotalOption?,
        @SerializedName("scroll_resilience_count")
        val scrollResilienceCount: String?,
        @SerializedName("scroll_upgrade")
        val scrollUpgrade: String?,
        @SerializedName("scroll_upgradeable_count")
        val scrollUpgradeableCount: String?,
        @SerializedName("soul_name")
        val soulName: String?,
        @SerializedName("soul_option")
        val soulOption: String?,
        @SerializedName("special_ring_level")
        val specialRingLevel: Int?,
        @SerializedName("starforce")
        val starforce: String?,
        @SerializedName("starforce_scroll_flag")
        val starforceScrollFlag: String?
    ) {
        data class ItemAddOption(
            @SerializedName("all_stat")
            val allStat: String?,
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("boss_damage")
            val bossDamage: String?,
            @SerializedName("damage")
            val damage: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("equipment_level_decrease")
            val equipmentLevelDecrease: Int?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemBaseOption(
            @SerializedName("all_stat")
            val allStat: String?,
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("base_equipment_level")
            val baseEquipmentLevel: Int?,
            @SerializedName("boss_damage")
            val bossDamage: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("ignore_monster_armor")
            val ignoreMonsterArmor: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_hp_rate")
            val maxHpRate: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("max_mp_rate")
            val maxMpRate: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemEtcOption(
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemExceptionalOption(
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemStarforceOption(
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemTotalOption(
            @SerializedName("all_stat")
            val allStat: String?,
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("boss_damage")
            val bossDamage: String?,
            @SerializedName("damage")
            val damage: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("equipment_level_decrease")
            val equipmentLevelDecrease: Int?,
            @SerializedName("ignore_monster_armor")
            val ignoreMonsterArmor: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_hp_rate")
            val maxHpRate: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("max_mp_rate")
            val maxMpRate: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )
    }

    data class ItemEquipment(
        @SerializedName("additional_potential_option_1")
        val additionalPotentialOption1: String?,
        @SerializedName("additional_potential_option_2")
        val additionalPotentialOption2: String?,
        @SerializedName("additional_potential_option_3")
        val additionalPotentialOption3: String?,
        @SerializedName("additional_potential_option_grade")
        val additionalPotentialOptionGrade: String?,
        @SerializedName("cuttable_count")
        val cuttableCount: String?,
        @SerializedName("date_expire")
        val dateExpire: String?,
        @SerializedName("equipment_level_increase")
        val equipmentLevelIncrease: Int?,
        @SerializedName("equipment_slot")
        val equipmentSlot: String?,
        @SerializedName("gender")
        val gender: String?,
        @SerializedName("golden_hammer_flag")
        val goldenHammerFlag: String?,
        @SerializedName("growth_exp")
        val growthExp: Int?,
        @SerializedName("growth_level")
        val growthLevel: Int?,
        @SerializedName("item_add_option")
        val itemAddOption: ItemAddOption?,
        @SerializedName("item_base_option")
        val itemBaseOption: ItemBaseOption?,
        @SerializedName("item_description")
        val itemDescription: String?,
        @SerializedName("item_equipment_part")
        val itemEquipmentPart: String?,
        @SerializedName("item_etc_option")
        val itemEtcOption: ItemEtcOption?,
        @SerializedName("item_exceptional_option")
        val itemExceptionalOption: ItemExceptionalOption?,
        @SerializedName("item_icon")
        val itemIcon: String?,
        @SerializedName("item_name")
        val itemName: String?,
        @SerializedName("item_shape_icon")
        val itemShapeIcon: String?,
        @SerializedName("item_shape_name")
        val itemShapeName: String?,
        @SerializedName("item_starforce_option")
        val itemStarforceOption: ItemStarforceOption?,
        @SerializedName("item_total_option")
        val itemTotalOption: ItemTotalOption?,
        @SerializedName("potential_option_1")
        val potentialOption1: String?,
        @SerializedName("potential_option_2")
        val potentialOption2: String?,
        @SerializedName("potential_option_3")
        val potentialOption3: String?,
        @SerializedName("potential_option_grade")
        val potentialOptionGrade: String?,
        @SerializedName("scroll_resilience_count")
        val scrollResilienceCount: String?,
        @SerializedName("scroll_upgrade")
        val scrollUpgrade: String?,
        @SerializedName("scroll_upgradeable_count")
        val scrollUpgradeableCount: String?,
        @SerializedName("soul_name")
        val soulName: String?,
        @SerializedName("soul_option")
        val soulOption: String?,
        @SerializedName("special_ring_level")
        val specialRingLevel: Int?,
        @SerializedName("starforce")
        val starforce: String?,
        @SerializedName("starforce_scroll_flag")
        val starforceScrollFlag: String?
    ) {
        data class ItemAddOption(
            @SerializedName("all_stat")
            val allStat: String?,
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("boss_damage")
            val bossDamage: String?,
            @SerializedName("damage")
            val damage: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("equipment_level_decrease")
            val equipmentLevelDecrease: Int?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemBaseOption(
            @SerializedName("all_stat")
            val allStat: String?,
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("base_equipment_level")
            val baseEquipmentLevel: Int?,
            @SerializedName("boss_damage")
            val bossDamage: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("ignore_monster_armor")
            val ignoreMonsterArmor: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_hp_rate")
            val maxHpRate: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("max_mp_rate")
            val maxMpRate: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemEtcOption(
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemExceptionalOption(
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemStarforceOption(
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemTotalOption(
            @SerializedName("all_stat")
            val allStat: String?,
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("boss_damage")
            val bossDamage: String?,
            @SerializedName("damage")
            val damage: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("equipment_level_decrease")
            val equipmentLevelDecrease: Int?,
            @SerializedName("ignore_monster_armor")
            val ignoreMonsterArmor: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_hp_rate")
            val maxHpRate: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("max_mp_rate")
            val maxMpRate: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )
    }

    data class MechanicEquipment(
        @SerializedName("cuttable_count")
        val cuttableCount: String?,
        @SerializedName("date_expire")
        val dateExpire: String?,
        @SerializedName("equipment_level_increase")
        val equipmentLevelIncrease: Int?,
        @SerializedName("equipment_slot")
        val equipmentSlot: String?,
        @SerializedName("gender")
        val gender: String?,
        @SerializedName("golden_hammer_flag")
        val goldenHammerFlag: String?,
        @SerializedName("growth_exp")
        val growthExp: Int,
        @SerializedName("growth_level")
        val growthLevel: Int?,
        @SerializedName("item_add_option")
        val itemAddOption: ItemAddOption?,
        @SerializedName("item_base_option")
        val itemBaseOption: ItemBaseOption?,
        @SerializedName("item_description")
        val itemDescription: String?,
        @SerializedName("item_equipment_part")
        val itemEquipmentPart: String?,
        @SerializedName("item_etc_option")
        val itemEtcOption: ItemEtcOption?,
        @SerializedName("item_exceptional_option")
        val itemExceptionalOption: ItemExceptionalOption?,
        @SerializedName("item_icon")
        val itemIcon: String?,
        @SerializedName("item_name")
        val itemName: String?,
        @SerializedName("item_shape_icon")
        val itemShapeIcon: String?,
        @SerializedName("item_shape_name")
        val itemShapeName: String?,
        @SerializedName("item_starforce_option")
        val itemStarforceOption: ItemStarforceOption?,
        @SerializedName("item_total_option")
        val itemTotalOption: ItemTotalOption?,
        @SerializedName("scroll_resilience_count")
        val scrollResilienceCount: String?,
        @SerializedName("scroll_upgrade")
        val scrollUpgrade: String?,
        @SerializedName("scroll_upgradeable_count")
        val scrollUpgradeableCount: String?,
        @SerializedName("soul_name")
        val soulName: String?,
        @SerializedName("soul_option")
        val soulOption: String?,
        @SerializedName("special_ring_level")
        val specialRingLevel: Int?,
        @SerializedName("starforce")
        val starforce: String?,
        @SerializedName("starforce_scroll_flag")
        val starforceScrollFlag: String?
    ) {
        data class ItemAddOption(
            @SerializedName("all_stat")
            val allStat: String?,
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("boss_damage")
            val bossDamage: String?,
            @SerializedName("damage")
            val damage: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("equipment_level_decrease")
            val equipmentLevelDecrease: Int?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemBaseOption(
            @SerializedName("all_stat")
            val allStat: String?,
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("base_equipment_level")
            val baseEquipmentLevel: Int?,
            @SerializedName("boss_damage")
            val bossDamage: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("ignore_monster_armor")
            val ignoreMonsterArmor: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_hp_rate")
            val maxHpRate: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("max_mp_rate")
            val maxMpRate: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemEtcOption(
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemExceptionalOption(
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemStarforceOption(
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )

        data class ItemTotalOption(
            @SerializedName("all_stat")
            val allStat: String?,
            @SerializedName("armor")
            val armor: String?,
            @SerializedName("attack_power")
            val attackPower: String?,
            @SerializedName("boss_damage")
            val bossDamage: String?,
            @SerializedName("damage")
            val damage: String?,
            @SerializedName("dex")
            val dex: String?,
            @SerializedName("equipment_level_decrease")
            val equipmentLevelDecrease: Int?,
            @SerializedName("ignore_monster_armor")
            val ignoreMonsterArmor: String?,
            @SerializedName("int")
            val int: String?,
            @SerializedName("jump")
            val jump: String?,
            @SerializedName("luk")
            val luk: String?,
            @SerializedName("magic_power")
            val magicPower: String?,
            @SerializedName("max_hp")
            val maxHp: String?,
            @SerializedName("max_hp_rate")
            val maxHpRate: String?,
            @SerializedName("max_mp")
            val maxMp: String?,
            @SerializedName("max_mp_rate")
            val maxMpRate: String?,
            @SerializedName("speed")
            val speed: String?,
            @SerializedName("str")
            val str: String?
        )
    }

    data class Title(
        @SerializedName("date_expire")
        val dateExpire: String?,
        @SerializedName("date_option_expire")
        val dateOptionExpire: String?,
        @SerializedName("title_description")
        val titleDescription: String?,
        @SerializedName("title_icon")
        val titleIcon: String?,
        @SerializedName("title_name")
        val titleName: String?
    )
}