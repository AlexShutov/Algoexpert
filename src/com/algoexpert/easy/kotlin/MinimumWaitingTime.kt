package com.algoexpert.easy.min

fun main(vararg args: String) {
    val t = MinimumWaitingTime()
    print(t.minimumWaitingTime(mutableListOf(3, 2, 1, 2, 6)))
}

class MinimumWaitingTime {

    fun minimumWaitingTime(queries: MutableList<Int>): Int {
        queries.sort()
        var totalTime: Int = 0
        queries.forEachIndexed { index, time ->
            totalTime += time * (queries.size - (index + 1))
        }
        return totalTime
    }
}