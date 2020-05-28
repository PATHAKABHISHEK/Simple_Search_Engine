import java.util.Scanner

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)

    val myString = scanner.next()

    for (i in myString.indices) {
        if (myString.length % 2 == 0) {
            if (i == myString.length / 2 || i == myString.length / 2 - 1) {
                continue
            } else {
                print(myString[i])
            }
        } else {
            if (i == (myString.length - 1) / 2) {
                continue
            } else {
                print(myString[i])
            }
        }
    }

}