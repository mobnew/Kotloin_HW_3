import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun miniBank_10kMirDefault() {
        val ammount = 100000
        val result = ru.netology.miniBank(ammount)
        assertEquals(0,result)
    }

    @Test
    fun miniBank_10kMir() {
        val ammount = 100000
        val cardType = "Mir"
        val result = ru.netology.miniBank(ammount,cardType)
        assertEquals(0,result)
    }

    @Test
    fun miniBank_bigAmmount() {
        val ammount = 160_000
        val result = ru.netology.miniBank(ammount)
        assertEquals(-1,result)
    }

    @Test
    fun miniBank_wrongCardType() {
        val ammount = 60_000
        val cardType = "Union"
        val result = ru.netology.miniBank(ammount,cardType)
        assertEquals(-2,result)
    }

    @Test
    fun miniBank_MCSmall() {
        val ammount = 20_000
        val cardType = "MC"
        val result = ru.netology.miniBank(ammount,cardType)
        assertEquals(0,result)
    }

    @Test
    fun miniBank_MCBig() {
        val ammount = 120_000
        val cardType = "MC"
        val result = ru.netology.miniBank(ammount,cardType)
        assertEquals(290,result)
    }

    @Test
    fun miniBank_Visa() {
        val ammount = 120_000
        val cardType = "Visa"
        val result = ru.netology.miniBank(ammount,cardType)
        assertEquals(900,result)
    }

    @Test
    fun miniBank_lastMonth() {
        val ammount = 120_000
        val cardType = "MC"
        val ammountLastMounth = 500_000
        val result = ru.netology.miniBank(ammount,cardType,ammountLastMounth)
        assertEquals(-1,result)
    }
}