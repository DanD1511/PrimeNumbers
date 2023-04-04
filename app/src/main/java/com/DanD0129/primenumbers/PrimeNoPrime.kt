package com.DanD0129.primenumbers

import kotlin.math.sqrt

class IsPrime {
    fun main() {
        val primeList = giveMeXPrimes(10)
        println("la lista obtenida es: ${primeList.toString()}")

        print("el ultimo numero de la lista anterior es: ${primeList.last()}")

    }

    fun giveMeXPrimes(amount: Int) : List<Int> {
        val listResult = mutableListOf<Int>()
        var primeCount = 0
        var value = 2

        while(primeCount < amount){
            if(isPrime(value)){
                primeCount++
                listResult.add(value)
            }
            value++
        }
        return listResult
    }

    fun isPrime(value: Int): Boolean {
        val sqrtValue = sqrt(value.toDouble()).toInt()
        for(i in 2..(sqrtValue)) {
            if(value % i == 0) {
                return false
            }
        }
        return true
    }
}