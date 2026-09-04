package com.example.data

data class Crop(
    val id: String,
    val name: String,
    val category: String,
    val harvestDays: String,
    val harvestDaysMin: Int,
    val harvestDaysMax: Int,
    val containerType: String,
    val difficultyLevel: String,
    val steps: List<String>,
    val tips: String,
    val nutritionBenefit: String,
    val mainImageRes: Int = 0,
    val isDroughtResistant: Boolean = false,
    val plantingSeason: String? = null,
    val waterConservationTip: String? = null
)

object CropData {
    val categories = listOf(
        "အားလုံး",
        "အမြန်ရက်တို (၇ - ၃၀ ရက်)",
        "အလယ်ပိုင်း အပူဒဏ်ခံသီးနှံ",
        "ဆာလာအိတ်/ကွန်တိန်နာစိုက်"
    )

    val crops = listOf(
        Crop(
            id = "crop_01",
            name = "ပဲပင်ပေါက်",
            category = "အမြန်ရက်တို (၇ - ၃၀ ရက်)",
            harvestDays = "၃ - ၅ ရက်",
            harvestDaysMin = 3,
            harvestDaysMax = 5,
            containerType = "ရေသန့်ဘူးစိုက် / ခြင်းတောင်း",
            difficultyLevel = "အလွန်လွယ်ကူ",
            steps = listOf(
                "ပဲတီစိမ်းကို ရေ ၈ မှ ၁၂ နာရီခန့် စိမ်ပါ။",
                "ရေစစ်ပြီး အပေါက်ဖောက်ထားသော ရေသန့်ဘူးထဲတွင် ထည့်ပါ။",
                "အလင်းရောင်မရရန် အဝတ်မည်းဖြင့် အုပ်ထားပါ။ တစ်နေ့လျှင် ရေ ၂ ကြိမ် လောင်းပေးပါ။"
            ),
            tips = "အလင်းရောင်မရသောနေရာတွင်ထားမှသာ ပဲပင်ပေါက် ဖြူဖွေးတုတ်ခိုင်မည်။",
            nutritionBenefit = "ပရိုတင်း၊ ဗီတာမင်စီ ကြွယ်ဝသည်။",
            mainImageRes = com.example.R.drawable.crop_bean_sprouts
        ),
        Crop(
            id = "crop_02",
            name = "ပဲစင်းငုံ",
            category = "အလယ်ပိုင်း အပူဒဏ်ခံသီးနှံ",
            harvestDays = "၅ လ - ၇ လ",
            harvestDaysMin = 150,
            harvestDaysMax = 210,
            containerType = "မြေပြင်စိုက်ပျိုးရန် (အနည်းဆုံး ၂ ပေကွာ)",
            difficultyLevel = "အသင့်အတင့်",
            steps = listOf(
                "မြေကို ထွန်ယက်၍ အစိုဓာတ်ရချိန်တွင် မျိုးစေ့ချပါ။",
                "တစ်ပင်နှင့်တစ်ပင် ၂ ပေခန့် ခွာ၍ စိုက်ပါ။ (သီးညှပ်စိုက်ပျိုးရန် အထူးသင့်လျော်သည်)",
                "အပင်ငယ်စဉ် ပေါင်းလိုက်ပေးပါ။ အမြစ်နက်နက်ဆင်းသောကြောင့် ရေငတ်ဒဏ်ကို ကောင်းစွာခံနိုင်သည်။"
            ),
            tips = "မြေပဲ၊ နှမ်း စသည်တို့နှင့် သီးညှပ်တွဲဖက်စိုက်ပျိုးပါက မြေဆီလွှာပိုမိုကောင်းမွန်စေသည်။ မြန်မာနိုင်ငံအလယ်ပိုင်းအတွက် အသင့်တော်ဆုံးဖြစ်သည်။",
            nutritionBenefit = "အသားဓာတ် (Protein) အလွန်မြင့်မားစွာ ပါဝင်သည်။",
            mainImageRes = com.example.R.drawable.crop_pigeon_pea,
            isDroughtResistant = true,
            plantingSeason = "မိုးဦး (မေလ၊ ဇွန်လ)",
            waterConservationTip = "အပင်ခြေရင်းတွင် ကောက်ရိုး သို့မဟုတ် သစ်ရွက်ခြောက်များဖြင့် ဖုံးအုပ်ပေးပါ (Mulching)။"
        ),
        Crop(
            id = "crop_03",
            name = "ဒန့်ဒလွန်",
            category = "အလယ်ပိုင်း အပူဒဏ်ခံသီးနှံ",
            harvestDays = "၆ လ (အသီး)",
            harvestDaysMin = 180,
            harvestDaysMax = 200,
            containerType = "မြေပြင် (သို့) ပုံးကြီးများ",
            difficultyLevel = "လွယ်ကူ",
            steps = listOf(
                "မျိုးစေ့ (သို့မဟုတ်) ကိုင်းဖြတ်၍ စိုက်ပျိုးနိုင်ပါသည်။",
                "ရေဆင်းကောင်းသော မြေကိုကြိုက်နှစ်သက်သည်။ ရေဝပ်ခြင်းကို လုံးဝမခံနိုင်ပါ။",
                "အပင် ၃ ပေခန့်မြင့်လာလျှင် ခေါင်းနှိမ်ပေးပါက ဘေးကိုင်းများစွာထွက်လာပါမည်။"
            ),
            tips = "အပူဒဏ်ကို အလွန်ခံနိုင်ရည်ရှိပြီး ပြုစုစောင့်ရှောက်ရန် သိပ်မလိုပါ။ အရွက်ကို နေ့စဉ် ဟင်းချိုချက်သောက်နိုင်သည်။",
            nutritionBenefit = "ဗီတာမင်အေ၊ စီ၊ ကယ်လ်စီယမ်နှင့် သံဓာတ် အထူးကြွယ်ဝသည်။ (အာဟာရဘဏ်ဟု ခေါ်သည်)",
            mainImageRes = com.example.R.drawable.crop_moringa,
            isDroughtResistant = true,
            plantingSeason = "အချိန်မရွေး (ရေလောင်းနိုင်လျှင်)",
            waterConservationTip = "ရေသန့်ဘူးအောက်ခြေကို အပေါက်ငယ်ဖောက်၍ အပင်ခြေရင်းတွင်ပြောင်းပြန်စိုက်ထားပါ (DIY Drip - အစက်ချရေလောင်းစနစ်)။"
        ),
        Crop(
            id = "crop_04",
            name = "နှမ်း (Sesame)",
            category = "အလယ်ပိုင်း အပူဒဏ်ခံသီးနှံ",
            harvestDays = "၇၅ - ၉၀ ရက်",
            harvestDaysMin = 75,
            harvestDaysMax = 90,
            containerType = "မြေပြင်စိုက်",
            difficultyLevel = "အသင့်အတင့်",
            steps = listOf(
                "မြေကို ညက်အောင်ထွန်ယက်ပါ။",
                "မျိုးစေ့ကို သဲနှင့်ဆတူရော၍ ကြဲပက်ပါ (သို့မဟုတ်) တန်းဆွဲစိုက်ပါ။",
                "အပင်ပေါက်စုံချိန် (၁၅ ရက်သား) တွင် အပင်ခွဲပေးပါ။"
            ),
            tips = "ရေဝပ်ခြင်းကို လုံးဝမခံနိုင်ပါ။ မိုးများပါက အထွက်နှုန်းကျဆင်းနိုင်သဖြင့် အလယ်ပိုင်းဒေသနှင့်သာ အကိုက်ညီဆုံးဖြစ်သည်။",
            nutritionBenefit = "အကျိုးပြုအဆီများ၊ ကယ်လ်စီယမ် ကြွယ်ဝသည်။",
            mainImageRes = com.example.R.drawable.crop_sesame,
            isDroughtResistant = true,
            plantingSeason = "မိုးဦး (သို့မဟုတ်) မိုးနှောင်း",
            waterConservationTip = "မိုးရွာသွန်းပြီးနောက် မြေဆီလွှာအစိုဓာတ်မဆုံးရှုံးစေရန် ကြားပေါင်းလိုက်၍ မြေဆွပေးပါ။"
        ),
        Crop(
            id = "crop_05",
            name = "ဆီးပင် / ဇီးပင်",
            category = "အလယ်ပိုင်း အပူဒဏ်ခံသီးနှံ",
            harvestDays = "၁ နှစ် မှ ၃ နှစ်",
            harvestDaysMin = 365,
            harvestDaysMax = 1095,
            containerType = "မြေပြင်စိုက်ပျိုးရန် (အပင်ကြီး)",
            difficultyLevel = "လွယ်ကူ",
            steps = listOf(
                "မျိုးစေ့ကို တိုက်ရိုက်ချစိုက်နိုင်သလို ကိုင်းကူးကိုင်းဆက်နည်းဖြင့်လည်း စိုက်နိုင်သည်။",
                "အပင်စိုက်မည့် ကျင်းကို ၂ ပေပတ်လည်တူး၍ သဘာဝမြေဆွေး ထည့်ပေးပါ။",
                "ပထမ ၁ နှစ်အတွင်းသာ ရေမှန်မှန်လောင်းရန် လိုအပ်ပြီး ကြီးလာပါက အလွန်ပူပြင်းသောဒဏ်ကို ကောင်းစွာခံနိုင်သည်။"
            ),
            tips = "မြေဆီလွှာညံ့ဖျင်းသောနေရာ၊ ကျောက်စရစ်မြေများတွင်ပင် ရှင်သန်နိုင်သည်။",
            nutritionBenefit = "ဗီတာမင်စီ နှင့် ဓာတ်တိုးဆန့်ကျင်ပစ္စည်းများ ပါဝင်သည်။",
            mainImageRes = com.example.R.drawable.crop_jujube,
            isDroughtResistant = true,
            plantingSeason = "မိုးဦး",
            waterConservationTip = "နွေရာသီတွင် အပင်ခြေရင်းကို သစ်ရွက်ခြောက်များဖြင့် အုပ်ပေးထားပါ။"
        )
    )
}
