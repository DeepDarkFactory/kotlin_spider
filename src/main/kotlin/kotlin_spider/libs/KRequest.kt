package kotlin_spider.libs

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset

/**
 * Created by nbsaw on 2017/5/27.
 */

class KRequest {
    private var client: URL
    private var connect: HttpURLConnection

    constructor(url: String) {
        client = URL(url)
        connect = client.openConnection() as HttpURLConnection
    }

    // 使用Get形式的请求
    fun get(): KRequest {
        connect.requestMethod = "GET"
        return this
    }

    // 使用Post形式的请求
    fun post(): KRequest {
        connect.requestMethod = "POST"
        return this
    }

    // 设置cookie
    fun cookie(cookie: String): KRequest {
        connect.setRequestProperty("cookie", cookie)
        return this
    }

    // 设置Ua
    fun ua(ua: String): KRequest {
        connect.setRequestProperty("User-Agent", ua)
        return this
    }

    // 设置header
    fun header(key :String,value:String):KRequest {
        connect.setRequestProperty(key,value)
        return this;
    }



    // 获取Dom
    fun dom(): Document {
        var input = BufferedReader(InputStreamReader(connect.inputStream))
        var result = ""
        while (true) {
            var line: String? = input.readLine() ?: break
            result += line
        }
        return Jsoup.parse(result)
    }

    // 获取Json对象
    fun json(): JsonObject {
        var rawJson = dom().body().text()
        return JsonParser().parse(rawJson).asJsonObject
    }

    // 获取Json数组
    fun jsonArray(): JsonArray {
        var rawJson = dom().body().text()
        return JsonParser().parse(rawJson).asJsonArray
    }

    // 设置form data
    fun formData(data:Map<String,String>) :KRequest{
        var Data = ""
        data.forEach { t, u -> Data += "$t=$u&" }
        connect.doOutput = true
        connect.outputStream.write(Data.toByteArray(Charset.forName("UTF-8")))
        return this
    }

    // 静态方法区
    companion object {
        fun get(url: String): KRequest {
            return KRequest(url).get()
        }

        fun post(url: String): KRequest {
            return KRequest(url).post()
        }


    }

    override fun toString(): String {
        return dom().toString()
    }

}