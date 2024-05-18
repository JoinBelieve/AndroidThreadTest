package com.example.androidthreadtest

import org.junit.Test

class KotlinBasic {

    @Test
    fun test() {
        println(
            "Use the val keyword when the value doesn't change.\n" +
                    "Use the var keyword when the value can change.\n" +
                    "When you define a function, you define the parameters that can be passed to it.\n" +
                    "When you call a function, you pass arguments for the parameters."
        )
    }

    @Test
    fun testString() {
        var discountPercentage: Int = 0
        var offer: String = ""
        val item = "Google Chromecast"
        discountPercentage = 20
        offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
        println(offer)
    }

    @Test
    fun main() {
        val numberOfAdults = 20
        val numberOfKids = 30
        val total = numberOfAdults + numberOfKids
        println("The total party size is: $total")
    }

    @Test
    fun main2() {
        val baseSalary = 5000
        val bonusAmount = 1000
        val totalSalary = "$baseSalary + $bonusAmount"
        println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
    }

    @Test
    fun main3() {
        val firstNumber = 10
        val secondNumber = 5
        val result = firstNumber + secondNumber
        println("$firstNumber + $secondNumber = $result")
    }

    @Test
    fun main4() {
        val firstNumber = 10
        val secondNumber = 5
        val thirdNumber = 8

        val result = add(firstNumber, secondNumber)
        val anotherResult = subtract(firstNumber, thirdNumber)

        println("$firstNumber + $secondNumber = $result")
        println("$firstNumber - $thirdNumber = $anotherResult")
    }

    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }


    @Test
    fun main5() {
//        val operatingSystem = "Chrome OS"
//        val emailId = "sample@gmail.com"
//        println(displayAlertMessage(operatingSystem, emailId))

        val firstUserEmailId = "user_one@gmail.com"

        // The following line of code assumes that you named your parameter as emailId.
        // If you named it differently, feel free to update the name.
        println(displayAlertMessage(emailId = firstUserEmailId))
        println()

        val secondUserOperatingSystem = "Windows"
        val secondUserEmailId = "user_two@gmail.com"

        println(displayAlertMessage(secondUserOperatingSystem, secondUserEmailId))
        println()

        val thirdUserOperatingSystem = "Mac OS"
        val thirdUserEmailId = "user_three@gmail.com"

        println(displayAlertMessage(thirdUserOperatingSystem, thirdUserEmailId))
        println()

    }

    private fun displayAlertMessage(operatingSystem: String = "Unknown OS", emailId: String) =
        "There's a new sign-in request on $operatingSystem for your Google Account $emailId."


    @Test
    fun main6() {
        val Steps = 4000
        val caloriesBurned = PEDOMETERstepsTOcalories(Steps);
        println("Walking $Steps steps burns $caloriesBurned calories")
    }

    fun PEDOMETERstepsTOcalories(NumberOFStepS: Int): Double {
        val CaloriesBURNEDforEachStep = 0.04
        val TotalCALORIESburned = NumberOFStepS * CaloriesBURNEDforEachStep
        return TotalCALORIESburned
    }


    @Test
    fun main7() {
        println(compareNumber(300, 250))
        println(compareNumber(300, 300))
        println(compareNumber(200, 220))
    }

    private fun compareNumber(timeSpentToday: Int, timeSpentYesterday: Int) =
        timeSpentToday > timeSpentYesterday


    @Test
    fun main8() {
        weather("Ankara", "27", "31", "82%")
        weather("Tokyo", "32", "36", "10%")
        weather("Cape Town", "59", "64", "2%")
        weather("Guatemala City", "50", "55", "7%")
    }

    private fun weather(
        city: String, lowTemperature: String, highTemperature: String,
        rain: String
    ) {
        println("City: $city")
        println("Low temperature: $lowTemperature, High temperature: $highTemperature")
        println("Chance of rain: $rain")
        println()
    }

}