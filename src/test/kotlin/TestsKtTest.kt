import org.junit.Test

import org.junit.Assert.*

class TestsKtTest {

    @Test
    fun calculateCommissionVisaMirGood() {
        val cardType = "Visa"
        val previousTransfers = 0
        val transferAmout = 1000

        val result = calculateCommission(cardType, previousTransfers, transferAmout)

        assertEquals(35.0,result, 0.0 )
    }
    @Test
    fun calculateCommissionVisaMirBadTransfers() {
        val cardType = "Visa"
        val previousTransfers = 600_000
        val transferAmout = 1000

        val result = calculateCommission(cardType, previousTransfers, transferAmout)

        assertEquals(-1.0,result, 0.0 )
    }
    @Test
    fun calculateCommissionVisaMirBadAmount() {
        val cardType = "Visa"
        val previousTransfers = 0
        val transferAmout = 151_000

        val result = calculateCommission(cardType, previousTransfers, transferAmout)

        assertEquals(-1.0,result, 0.0 )
    }
    @Test
    fun calculateCommissionVisaMinimum() {
        val cardType = "Visa"
        val previousTransfers = 0
        val transferAmout = 1000

        val result = calculateCommission(cardType, previousTransfers, transferAmout)

        assertEquals(35.0,result, 0.0 )
    }
    @Test
    fun calculateCommissionMastercardMaestroGood() {
        val cardType = "Mastercard"
        val previousTransfers = 0
        val transferAmout = 1000

        val result = calculateCommission(cardType, previousTransfers, transferAmout)

        assertEquals(0.0,result, 0.0 )
    }
    @Test
    fun calculateCommissionMastercardMaestroGoodTwo() {
        val cardType = "Mastercard"
        val previousTransfers = 0
        val transferAmout = 76000

        val result = calculateCommission(cardType, previousTransfers, transferAmout)

        assertEquals(476.0,result, 0.0 )
    }
    @Test
    fun calculateCommissionMastercardMaestroBadAmount() {
        val cardType = "Mastercard"
        val previousTransfers = 0
        val transferAmout = 151_000

        val result = calculateCommission(cardType, previousTransfers, transferAmout)

        assertEquals(-1.0,result, 0.0 )
    }
    @Test
    fun calculateCommissionMastercardMaestroBadTransfers() {
        val cardType = "Mastercard"
        val previousTransfers = 600_000
        val transferAmout = 1_000

        val result = calculateCommission(cardType, previousTransfers, transferAmout)

        assertEquals(-1.0,result, 0.0 )
    }
    @Test
    fun calculateCommissionVkPayGood() {
        val cardType = "VK Pay"
        val previousTransfers = 0
        val transferAmout = 10000

        val result = calculateCommission(cardType, previousTransfers, transferAmout)

        assertEquals(0.0,result, 0.0 )
    }
    @Test
    fun calculateCommissionVkPayBadAmount() {
        val cardType = "VK Pay"
        val previousTransfers = 0
        val transferAmout = 16000

        val result = calculateCommission(cardType, previousTransfers, transferAmout)

        assertEquals(-1.0,result, 0.0 )
    }
    @Test
    fun calculateCommissionVkPayBadTransfers() {
        val cardType = "VK Pay"
        val previousTransfers = 40000
        val transferAmout = 1000

        val result = calculateCommission(cardType, previousTransfers, transferAmout)

        assertEquals(-1.0,result, 0.0 )
    }
    @Test
    fun calculateCommissionCardTypeBad() {
        val cardType = "VK ay"
        val previousTransfers = 0
        val transferAmout = 1000

        val result = calculateCommission(cardType,previousTransfers,transferAmout)

        assertEquals(-2.0,result,0.0)
    }
    @Test
    fun calculateCommissionCardTypeMir() {
        val cardType = "МИР"
        val previousTransfers = 0
        val transferAmout = 1000

        val result = when (cardType){
           cardType -> calculateCommission(cardType,previousTransfers,transferAmout)
            else -> -2.0
        }
        assertEquals(35.0,result,0.0)
    }
    @Test
    fun calculateCommissionCardTypeVkpay() {
        val cardType = "VK Pay"
        val previousTransfers = 39000
        val transferAmout = 2000

        val result = when (cardType){
            cardType -> calculateCommission(cardType,previousTransfers,transferAmout)
            else -> -2.0
        }
        assertEquals(-0.0,result,0.0)
    }
    @Test
    fun testCalculateCommission_MaestroWithinLimits_ReturnsCommissionAmount() {
        assertEquals(0.0, calculateCommission("Maestro", 50_000, 4_000), 0.01)
    }


}