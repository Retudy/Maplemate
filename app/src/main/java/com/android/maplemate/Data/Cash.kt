package com.android.maplemate.Data


import com.google.gson.annotations.SerializedName

data class Cash(
    @SerializedName("additional_cash_item_equipment_preset_1")
    val additionalCashItemEquipmentPreset1: List<AdditionalCashItemEquipmentPreset1?>?,
    @SerializedName("additional_cash_item_equipment_preset_2")
    val additionalCashItemEquipmentPreset2: List<AdditionalCashItemEquipmentPreset2?>?,
    @SerializedName("additional_cash_item_equipment_preset_3")
    val additionalCashItemEquipmentPreset3: List<AdditionalCashItemEquipmentPreset3?>?,
    @SerializedName("cash_item_equipment_preset_1")
    val cashItemEquipmentPreset1: List<CashItemEquipmentPreset1?>?,
    @SerializedName("cash_item_equipment_preset_2")
    val cashItemEquipmentPreset2: List<CashItemEquipmentPreset2?>?,
    @SerializedName("cash_item_equipment_preset_3")
    val cashItemEquipmentPreset3: List<CashItemEquipmentPreset3?>?,
    @SerializedName("character_class")
    val characterClass: String?,
    @SerializedName("character_gender")
    val characterGender: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("preset_no")
    val presetNo: Int?
) {
    data class AdditionalCashItemEquipmentPreset1(
        @SerializedName("base_preset_item_disable_flag")
        val basePresetItemDisableFlag: String?,
        @SerializedName("cash_item_coloring_prism")
        val cashItemColoringPrism: CashItemColoringPrism?,
        @SerializedName("cash_item_description")
        val cashItemDescription: String?,
        @SerializedName("cash_item_equipment_part")
        val cashItemEquipmentPart: String?,
        @SerializedName("cash_item_equipment_slot")
        val cashItemEquipmentSlot: String?,
        @SerializedName("cash_item_icon")
        val cashItemIcon: String?,
        @SerializedName("cash_item_label")
        val cashItemLabel: String?,
        @SerializedName("cash_item_name")
        val cashItemName: String?,
        @SerializedName("cash_item_option")
        val cashItemOption: List<CashItemOption?>?,
        @SerializedName("date_expire")
        val dateExpire: String?,
        @SerializedName("date_option_expire")
        val dateOptionExpire: String?
    ) {
        data class CashItemColoringPrism(
            @SerializedName("color_range")
            val colorRange: String?,
            @SerializedName("hue")
            val hue: Int?,
            @SerializedName("saturation")
            val saturation: Int?,
            @SerializedName("value")
            val value: Int?
        )

        data class CashItemOption(
            @SerializedName("option_type")
            val optionType: String?,
            @SerializedName("option_value")
            val optionValue: String?
        )
    }

    data class AdditionalCashItemEquipmentPreset2(
        @SerializedName("base_preset_item_disable_flag")
        val basePresetItemDisableFlag: String?,
        @SerializedName("cash_item_coloring_prism")
        val cashItemColoringPrism: CashItemColoringPrism?,
        @SerializedName("cash_item_description")
        val cashItemDescription: String?,
        @SerializedName("cash_item_equipment_part")
        val cashItemEquipmentPart: String?,
        @SerializedName("cash_item_equipment_slot")
        val cashItemEquipmentSlot: String?,
        @SerializedName("cash_item_icon")
        val cashItemIcon: String?,
        @SerializedName("cash_item_label")
        val cashItemLabel: String?,
        @SerializedName("cash_item_name")
        val cashItemName: String?,
        @SerializedName("cash_item_option")
        val cashItemOption: List<CashItemOption?>?,
        @SerializedName("date_expire")
        val dateExpire: String?,
        @SerializedName("date_option_expire")
        val dateOptionExpire: String?
    ) {
        data class CashItemColoringPrism(
            @SerializedName("color_range")
            val colorRange: String?,
            @SerializedName("hue")
            val hue: Int?,
            @SerializedName("saturation")
            val saturation: Int?,
            @SerializedName("value")
            val value: Int?
        )

        data class CashItemOption(
            @SerializedName("option_type")
            val optionType: String?,
            @SerializedName("option_value")
            val optionValue: String?
        )
    }

    data class AdditionalCashItemEquipmentPreset3(
        @SerializedName("base_preset_item_disable_flag")
        val basePresetItemDisableFlag: String?,
        @SerializedName("cash_item_coloring_prism")
        val cashItemColoringPrism: CashItemColoringPrism?,
        @SerializedName("cash_item_description")
        val cashItemDescription: String?,
        @SerializedName("cash_item_equipment_part")
        val cashItemEquipmentPart: String?,
        @SerializedName("cash_item_equipment_slot")
        val cashItemEquipmentSlot: String?,
        @SerializedName("cash_item_icon")
        val cashItemIcon: String?,
        @SerializedName("cash_item_label")
        val cashItemLabel: String?,
        @SerializedName("cash_item_name")
        val cashItemName: String?,
        @SerializedName("cash_item_option")
        val cashItemOption: List<CashItemOption?>?,
        @SerializedName("date_expire")
        val dateExpire: String?,
        @SerializedName("date_option_expire")
        val dateOptionExpire: String?
    ) {
        data class CashItemColoringPrism(
            @SerializedName("color_range")
            val colorRange: String?,
            @SerializedName("hue")
            val hue: Int?,
            @SerializedName("saturation")
            val saturation: Int?,
            @SerializedName("value")
            val value: Int?
        )

        data class CashItemOption(
            @SerializedName("option_type")
            val optionType: String?,
            @SerializedName("option_value")
            val optionValue: String?
        )
    }

    data class CashItemEquipmentPreset1(
        @SerializedName("base_preset_item_disable_flag")
        val basePresetItemDisableFlag: String?,
        @SerializedName("cash_item_coloring_prism")
        val cashItemColoringPrism: CashItemColoringPrism?,
        @SerializedName("cash_item_description")
        val cashItemDescription: String?,
        @SerializedName("cash_item_equipment_part")
        val cashItemEquipmentPart: String?,
        @SerializedName("cash_item_equipment_slot")
        val cashItemEquipmentSlot: String?,
        @SerializedName("cash_item_icon")
        val cashItemIcon: String?,
        @SerializedName("cash_item_label")
        val cashItemLabel: String?,
        @SerializedName("cash_item_name")
        val cashItemName: String?,
        @SerializedName("cash_item_option")
        val cashItemOption: List<CashItemOption?>?,
        @SerializedName("date_expire")
        val dateExpire: String?,
        @SerializedName("date_option_expire")
        val dateOptionExpire: String?
    ) {
        data class CashItemColoringPrism(
            @SerializedName("color_range")
            val colorRange: String?,
            @SerializedName("hue")
            val hue: Int?,
            @SerializedName("saturation")
            val saturation: Int?,
            @SerializedName("value")
            val value: Int?
        )

        data class CashItemOption(
            @SerializedName("option_type")
            val optionType: String?,
            @SerializedName("option_value")
            val optionValue: String?
        )
    }

    data class CashItemEquipmentPreset2(
        @SerializedName("base_preset_item_disable_flag")
        val basePresetItemDisableFlag: String?,
        @SerializedName("cash_item_coloring_prism")
        val cashItemColoringPrism: CashItemColoringPrism?,
        @SerializedName("cash_item_description")
        val cashItemDescription: String?,
        @SerializedName("cash_item_equipment_part")
        val cashItemEquipmentPart: String?,
        @SerializedName("cash_item_equipment_slot")
        val cashItemEquipmentSlot: String?,
        @SerializedName("cash_item_icon")
        val cashItemIcon: String?,
        @SerializedName("cash_item_label")
        val cashItemLabel: String?,
        @SerializedName("cash_item_name")
        val cashItemName: String?,
        @SerializedName("cash_item_option")
        val cashItemOption: List<CashItemOption?>?,
        @SerializedName("date_expire")
        val dateExpire: String?,
        @SerializedName("date_option_expire")
        val dateOptionExpire: String?
    ) {
        data class CashItemColoringPrism(
            @SerializedName("color_range")
            val colorRange: String?,
            @SerializedName("hue")
            val hue: Int?,
            @SerializedName("saturation")
            val saturation: Int?,
            @SerializedName("value")
            val value: Int?
        )

        data class CashItemOption(
            @SerializedName("option_type")
            val optionType: String?,
            @SerializedName("option_value")
            val optionValue: String?
        )
    }

    data class CashItemEquipmentPreset3(
        @SerializedName("base_preset_item_disable_flag")
        val basePresetItemDisableFlag: String?,
        @SerializedName("cash_item_coloring_prism")
        val cashItemColoringPrism: CashItemColoringPrism?,
        @SerializedName("cash_item_description")
        val cashItemDescription: String?,
        @SerializedName("cash_item_equipment_part")
        val cashItemEquipmentPart: String?,
        @SerializedName("cash_item_equipment_slot")
        val cashItemEquipmentSlot: String?,
        @SerializedName("cash_item_icon")
        val cashItemIcon: String?,
        @SerializedName("cash_item_label")
        val cashItemLabel: String?,
        @SerializedName("cash_item_name")
        val cashItemName: String?,
        @SerializedName("cash_item_option")
        val cashItemOption: List<CashItemOption?>?,
        @SerializedName("date_expire")
        val dateExpire: String?,
        @SerializedName("date_option_expire")
        val dateOptionExpire: String?
    ) {
        data class CashItemColoringPrism(
            @SerializedName("color_range")
            val colorRange: String?,
            @SerializedName("hue")
            val hue: Int?,
            @SerializedName("saturation")
            val saturation: Int?,
            @SerializedName("value")
            val value: Int?
        )

        data class CashItemOption(
            @SerializedName("option_type")
            val optionType: String?,
            @SerializedName("option_value")
            val optionValue: String?
        )
    }
}