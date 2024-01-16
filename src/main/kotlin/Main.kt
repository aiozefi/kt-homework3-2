import kotlin.math.max

const val ERROR_LIMIT = -1
const val ERROR_TYPE = -2

fun calculateCommission(cardType: String = "VK Pay", amount: Int = 100, previous: Int = 0): Int {
    return when (cardType) {
        "Mir", "Visa" ->
            if (amount <= 150_000 && amount + previous <= 600_000) max(35, (amount * 0.0075).toInt())
            else ERROR_LIMIT

        "MasterCard", "Maestro" ->
            if (previous <= 75000) 0
            else if (amount <= 150_000 && amount + previous <= 600_000) max(20, (amount * 0.006).toInt() + 20)
            else ERROR_LIMIT

        "VK Pay" ->
            if (amount <= 15_000 && amount + previous <= 40_000) 0
            else ERROR_LIMIT

        else -> ERROR_TYPE
    }
}

fun main() {
    println(calculateCommission()) // VK Pay, без предыдущих переводов, сумма перевода 100
    println(
        calculateCommission(
            cardType = "Visa",
            previous = 50000,
            amount = 1000
        )
    ) // Visa, предыдущие переводы 50000, сумма перевода 1000
    println(
        calculateCommission(
            cardType = "MasterCard",
            previous = 80000,
            amount = 1000
        )
    ) // MasterCard, предыдущие переводы 80000, сумма перевода 1000
}
