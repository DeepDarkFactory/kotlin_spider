import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by nbsaw on 2017/5/27.
 */



class Request{
    constructor(url:String){

    }

    fun get(url:String){

    }

    fun post(url:String){

    }
}

fun main(args: Array<String>) {
    var client =  HttpClientBuilder.create().build()
    var targetHost = HttpGet("http://localhost:3000")
    var response = client.execute(targetHost)
    var rd =  BufferedReader(InputStreamReader(response.entity.content))
    var result = StringBuffer()
    var line = ""
    while (rd.ready()){
        if (line == null) break
        line = rd.readLine()
        result.append(line)
    }
    println(result)
}