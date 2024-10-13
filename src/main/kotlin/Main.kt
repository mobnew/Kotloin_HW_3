package ru.netology

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val ammount = 100_000
    val cardType = "MC"
    val ammountLastMonth = 55_000

    val fee = miniBank(ammount, cardType, ammountLastMonth)

    when(fee) {
        -1 -> {
            println("Привышены лимиты операций")
            return
        }
        -2 -> {
            println("Не известный тип карты")
        }
        in 0 .. Int.MAX_VALUE -> {
            println("При переводе " + ammount + " комисия составит " + fee + " рублей. Общая сумма: " + (ammount + fee) + " руб.")
        }
    }
}

fun miniBank(ammount: Int, cardType: String = "Mir", ammountLastMonth: Int = 0): Int {
    var fee = 0

    if ((ammount > 150_000) || (ammount + ammountLastMonth > 600_000)) {
        return -1
    }

    when (cardType) {
        "Mir" -> {}
        "Visa" -> {
            fee = maxOf((ammount * 0.0075).toInt(), 35)
        }
        "MC" -> {
            if (ammount + ammountLastMonth >= 75_000) {
                fee = ((ammount + ammountLastMonth - 75000) * 0.006).toInt() + 20
            }
        }
        else -> {
            return -2
        }
    }
    return fee
}