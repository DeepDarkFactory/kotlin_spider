package com.nbsaw.kotlin_spider.music163

import com.huaban.analysis.jieba.JiebaSegmenter
import kotlin_spider.libs.KRequest
import java.lang.System.currentTimeMillis
import java.util.*
import kotlin.collections.HashMap


/**
 * Created by nbsaw on 2017/5/23.
 */
class Music163Spider{
    var count = 0
    var musicList = LinkedList<String>()
    var word = HashMap<String,Int>()
    var wordList = LinkedList<List<String>>()
    var descList = LinkedList<Any>()

    private fun getMusicList(singerId:String){
        val result = KRequest.get("http://music.163.com/m/artist?id=$singerId")
        var li = result.dom().getElementById("artist-top50").getElementsByTag("li")
        li.stream().forEach {
            var a = it.getElementsByTag("a")[0]
            var href = a.attr("href").replace("/song?id=","")
            musicList.add(href)
            count++
        }
    }

    private fun getLyric(){
        musicList.forEach{
            var text = KRequest("http://music.163.com/api/song/lyric?os=osx&id=$it&lv=-1&kv=-1&tv=-1").json()
            var json = text.asJsonObject.get("lrc").asJsonObject.get("lyric").toString()
                    .replace(Regex("\\\\n"),"")
                    .replace(Regex("\\[.+?\\]"),"")
                    .replace(Regex("\\pP|\\pS"), "")
                    .replace("作曲家","")
                    .replace("作曲","")
                    .replace("作词","")
                    .replace(" ","")
            var sg = JiebaSegmenter()
            wordList.add(sg.sentenceProcess(json))
        }
    }
    private fun getRank(){
        wordList.forEach {
            it.forEach {w ->
                var key = w.trim().replace("\n","")
                if (word[key] != null){
                    word[key] = word[key]!! + 1
                }
                else if (!key.trim().isEmpty() && key.length > 1)
                    word[key] = 1
            }
        }
        // 正序输出结果
            word.entries.stream().sorted { o1, o2 ->  o2.value.compareTo(o1.value)}.forEach{descList.add(mapOf("key" to it.key,"value" to it.value))}
        // 逆序输出结果
//        word.entries.stream().sorted { o1, o2 ->  o1.value.compareTo(o2.value)}.forEach{s -> orderList.add(s)}
    }



    constructor(singName:String){
        var startTime :Long = currentTimeMillis()
        System.out.println("开始爬取...")
        // TODO 数据库缓存支持
        getMusicList(KRequest.post("http://music.163.com/api/search/pc/").formData(mapOf("s" to singName,"type" to "100")).json().get("result").asJsonObject.get("artists").asJsonArray[0].asJsonObject.get("id").toString())
        getLyric()
        getRank()
        println("爬取结束，耗时约${(currentTimeMillis() - startTime)}毫秒，抓取了${count}条歌曲")
    }
}
