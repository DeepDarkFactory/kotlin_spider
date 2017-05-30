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

/**
 * Created by nbsaw on 2017/5/27.
 */

class KRequest {
    private var client: URL
    private var connect: HttpURLConnection
    private val LINE_FEED = "\r\n"
    private var charset = "utf8"

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
    fun header() {

    }

    // 设置form data
    fun formData() {

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
        connect.setRequestProperty("Content-Type", "application/json")
        var rawJson = InputStreamReader(connect.inputStream).readLines().toString()
        return JsonParser().parse(rawJson).asJsonObject
    }

    // 获取Json数组
    fun jsonArray(): JsonArray {
        connect.setRequestProperty("Content-Type", "application/json")
        var rawJson = InputStreamReader(connect.inputStream).readLines().toString()
        return JsonParser().parse(rawJson).asJsonArray
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

//    override fun toString(): String {
//        return dom().toString()
//    }
}