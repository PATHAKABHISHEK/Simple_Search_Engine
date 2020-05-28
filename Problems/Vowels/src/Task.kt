fun main() {
    val letter = readLine()!!
    for (i in letter) {
        when (i) {
            'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' -> {
                if (i.isUpperCase()) {
                    println(i.toInt() - 65 + 1)
                } else {
                    println(i.toInt() - 97 + 1)
                }
            }
            else -> {
            println(0)
            }
        }
        }
    }
