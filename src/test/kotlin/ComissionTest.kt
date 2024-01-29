import org.junit.Test
import org.junit.Assert.assertEquals

class ComissionTest {

    @Test
    fun testVisaOneDayAmount() {
        val cardType = "Visa"
        val amount = 10_000
        val previous = 0

        val result = calculateCommission(cardType = cardType, amount, previous)

        assertEquals(75, result)
    }

    @Test
    fun testMaestroOneDayAmount() {
        val cardType = "Maestro"
        val amount = 10_000
        val previous = 0

        val result = calculateCommission(cardType = cardType, amount, previous)

        assertEquals(0, result)
    }

    @Test
    fun testVkPayOneDayAmount() {
        val cardType = "VK Pay"
        val amount = 10_000
        val previous = 0

        val result = calculateCommission(cardType = cardType, amount, previous)

        assertEquals(0, result)
    }

    @Test
    fun testMaestroDiscountLimit() {
        val cardType = "Maestro"
        val amount = 60_000
        val previous = 20_000

        val result = calculateCommission(cardType = cardType, amount, previous)

        assertEquals(380, result)
    }

    @Test
    fun testOneDayLimitVisa() {
        val cardType = "Visa"
        val amount = 300_000
        val previous = 0

        val result = calculateCommission(cardType = cardType, amount, previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testOneMonthLimitVisa() {
        val cardType = "Visa"
        val amount = 100_000
        val previous = 600_000

        val result = calculateCommission(cardType = cardType, amount, previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testOneDayLimitMaestro() {
        val cardType = "Maestro"
        val amount = 300_000
        val previous = 0

        val result = calculateCommission(cardType = cardType, amount, previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testOneMonthLimitMaestro() {
        val cardType = "Maestro"
        val amount = 100_000
        val previous = 600_000

        val result = calculateCommission(cardType = cardType, amount, previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testOneDayLimitVkPay() {
        val cardType = "VK Pay"
        val amount = 300_000
        val previous = 0

        val result = calculateCommission(cardType = cardType, amount, previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testOneMonthLimitVkPay() {
        val cardType = "VK Pay"
        val amount = 10_000
        val previous = 100_000

        val result = calculateCommission(cardType = cardType, amount, previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testUnknownType() {
        val cardType = "Card"
        val amount = 100_000
        val previous = 0

        val result = calculateCommission(cardType = cardType, amount, previous)

        assertEquals(ERROR_TYPE, result)
    }

    @Test
    fun testDefault() {
        val result = calculateCommission()

        assertEquals(0, result)
    }
}