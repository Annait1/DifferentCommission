fun main() {
    /*Обычный пример с картой Visa*/
    println(calculateCommision("Visa", 73_000, 5000))

    /*в рамках лимита*/
    println(calculateCommision("MasterCard", 70_000, 4_000))

    /*  Чуток превысили лимит, комиссия с 3000 тыс.*/
    println(calculateCommision("MasterCard", 74_000, 4_000))

    /*Комиссия с превышающей суммы, то есть с 10000 тыс.*/
    println(calculateCommision("MasterCard", 80_000, 10_000))

}

fun calculateCommision(
    cardType: String = "Мир",
    monthlyTotal: Int = 0,
    transferAmount: Int

): String {

    if (transferAmount > 150_000) {
        return "Превышен заблокирован: превышен суточный лимит "
    }

    if (monthlyTotal + transferAmount > 600_000) {
        return "Превышен заблокирован: превышен месячный лимит"
    }
    val commission = when (cardType) {
        "MasterCard" -> {
            val limit = 75_000
            val total = monthlyTotal + transferAmount
            when {
                monthlyTotal >= limit -> transferAmount * 0.006 + 20
                total <= limit -> 0.0
                else -> {
                    val excess = total - limit
                    excess * 0.006 + 20
                }
            }
        }

        "Visa" -> {
            val percent = transferAmount * 0.0075
            if (percent < 35) 35.0 else percent
        }

        "Мир" -> 0.0
        else ->
            return "Ошибка"
    }
    return "Комиссия составляет: $commission руб."
}

