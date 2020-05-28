package search
import java.io.File
import java.util.Scanner

// for ALL Strategy
fun allStrategy(peopleData: MutableList<Int>?, peopleDataFromFile: List<String>) {
    if (peopleData != null) {
        println("${peopleData.size} persons found:")
    }
    if (peopleData != null) {
        for (index in peopleData) {
            println(peopleDataFromFile[index])
        }
    }
}

// for ANY Strategy
fun anyStrategy(query: String, peopleQueryDataStructure: MutableMap<String, MutableList<Int>>, peopleDataFromFile: List<String>) {
    val simpleQueries = query.split(" ").toTypedArray()

    val querySet = mutableListOf<Int>()

    for (q in simpleQueries) {
        val peopleData = peopleQueryDataStructure[q.toLowerCase()]
        if (peopleData != null) {
            for (index in peopleData) {
                if (index !in querySet) {
                    querySet.add(index)
                }
            }
        }
    }


    if (querySet != null) {
        println("${querySet.size} persons found:")
    }
    if (querySet != null) {
        for (index in querySet) {
            println(peopleDataFromFile[index])
        }
    }
}

// for NONE Strategy
fun noneStrategy(query: String, peopleQueryDataStructure: MutableMap<String, MutableList<Int>>, peopleDataFromFile: List<String>) {
    val simpleQueries = query.split(" ").toTypedArray()

    val querySet = mutableListOf<Int>()

    for (q in simpleQueries) {
        val peopleData = peopleQueryDataStructure[q.toLowerCase()]
            if (peopleData != null) {
                for (index in peopleData) {
                    if (index !in querySet) {
                        querySet.add(index)
                    }
                }
        }
    }

    if (querySet != null) {
        println("${querySet.size} persons found:")
    }
    if (querySet != null) {
        for (index in peopleDataFromFile.indices) {
            if (index !in querySet) {
                println(peopleDataFromFile[index])
            }
        }
    }
}


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var fileName = "text.txt" // Initially Set to Some File
    for (i in args.indices) {
        if (args[i] == "--data") {
            fileName = args[i + 1]
            break
        }
    }

    val peopleDataFromFile = File(fileName).readLines()

    // Inverted Indices Data Structure
    val peopleQueryDataStructure = mutableMapOf<String, MutableList<Int>>()

    for (index in peopleDataFromFile.indices) {
        val peopleArray = peopleDataFromFile[index].split(" ")
        for (people in peopleArray) {
            if (peopleQueryDataStructure[people.toLowerCase()] != null) {
                peopleQueryDataStructure[people.toLowerCase()]?.add(index)
            } else {
                peopleQueryDataStructure[people.toLowerCase()] = mutableListOf(index)
            }

        }
    }

    do {
        println()
        println("=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit")
        val option = scanner.nextInt()

        when (option) {
            0 -> {}
            1 -> {
                println()
                println("Select a matching strategy: ALL, ANY, NONE")
                val strategy = scanner.next()

                println()
                println("Enter a name or email to search all suitable people.")
                val query = readLine()!!

                if (strategy == "ALL") {
                    val peopleData = peopleQueryDataStructure[query.toLowerCase()]
                    allStrategy(peopleData, peopleDataFromFile)
                } else if (strategy == "ANY") {
                    anyStrategy(query, peopleQueryDataStructure, peopleDataFromFile)
                } else if (strategy == "NONE") {
                    noneStrategy(query, peopleQueryDataStructure, peopleDataFromFile)
                }
            }
            2 -> {
                println()
                println("All people:")
                for (peopleData in peopleDataFromFile) {
                    println(peopleData)
                }
            }
            else -> {
            }
        }
    } while (option != 0)

    println()
    println("Bye!")
}
