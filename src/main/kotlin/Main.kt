import java.lang.Math.pow

fun main(args: Array<String>) {
    val a = readLine()!!
    var b = mutableListOf<Byte>()
    for (i in a) {
        b.add(i.toByte())
    }

    var c = mutableListOf<String>()

    for (x in b) {
        var i = 1
        var s = 0
        var my_dec = x.toInt()
        while(my_dec != 0){
            var rem = my_dec % 2
            s += i*rem   //concatenate remainders in bottom-up manner
            my_dec = my_dec / 2;
            i=i*10;
        }
        c.add("0" + s.toString())
    }
    // lets print decomal content
    println(b.joinToString())

    // lets print converted decimal to binary
    println(c.joinToString())
    var d = mutableListOf<Int>()
    for (i in c) {
        var temp = 0

        for (y in 0 until i.length) {

            temp = (temp + Character.getNumericValue(i[y]) * pow(2.0, (i.length - (y + 1)).toDouble())).toInt()
            //(i.length - (y + 1) - to fit power of 2 (2^7, 2^6, 2^5, 2^4, 2^3, 2^2, 2^1, 2^0)


        }
        d.add(temp)

    }
    // check converting binary to decimal
    println(d.joinToString())
    for (i in d) {
        // print restored input word
        print(i.toChar())
    }
}