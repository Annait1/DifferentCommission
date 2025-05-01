fun main() {
    println(calculateCommision("Visa", 73_000, 5000))
}

fun calculateCommision(
    cardType: String = "Мир",
    monthlyTotal : Int = 0,
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
            if (monthlyTotal + transferAmount <= 75_000) {
                0.0
            } else {
                transferAmount * 0.006 + 20
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

