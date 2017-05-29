import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.System.currentTimeMillis
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by nbsaw on 2017/5/27.
 */

//class Request{
//
//    init {
//
//    }
//
//    constructor(url:String){
//
//    }
//
//    fun get():Request{
//
//    }
//
//    fun get(url:String){
//
//    }
//
//    fun post():Request{
//
//    }
//
//    fun post(url:String){
//
//    }
//
//    fun text(){
//
//    }
//}

fun main(args: Array<String>) {
    var star = currentTimeMillis()
    var baidu = URL("http://www.bilibili.com")
    var con = baidu.openConnection() as HttpURLConnection
    con.requestMethod = "GET"
    con.useCaches = false
    var input = BufferedReader(InputStreamReader(con.inputStream))
    while (true){
        var line: String? = input.readLine() ?: break
        println(line)
    }
    input.close()
    con.disconnect()
    println("耗时 ${(currentTimeMillis() - star)} ms")
}