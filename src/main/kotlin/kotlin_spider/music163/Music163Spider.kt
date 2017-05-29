//package com.nbsaw.kotlin_spider.music163
//
//import com.huaban.analysis.jieba.JiebaSegmenter
//import us.codecraft.webmagic.Page
//import us.codecraft.webmagic.Request
//import us.codecraft.webmagic.Site
//import us.codecraft.webmagic.Spider
//import us.codecraft.webmagic.processor.PageProcessor
//import java.lang.System.currentTimeMillis
//import java.util.*
//
//
///**
// * Created by nbsaw on 2017/5/23.
// */
//var count = 0
//var musicList = LinkedList<String>()
//var word = HashMap<String,Int>()
//var wordList = LinkedList<List<String>>()
//
//class songsIdSpider : PageProcessor {
//    private var site = Site.me().setRetryTimes(3).setSleepTime(100)
//    override fun process(page: Page) {
//        //获取页面需要的内容
//        var items = page.html.xpath("//*[@id=\"artist-top50\"]//ul[@class=\"f-hide\"]//li//a").nodes()
//        for (item in items){
//            musicList.add(item.links().regex("\\d+$").toString())
//            count ++
//        }
//    }
//    override fun getSite(): Site {
//        return site
//    }
//}
//
//
//class lyricSpider : PageProcessor {
//    private var site = Site.me().setRetryTimes(3).setSleepTime(100)
//    override fun process(page: Page) {
//        //获取页面需要的内容
//        var text = page.json.jsonPath("lrc.lyric").replace("\\[.+\\]","").replace("\\pP|\\pS", "").replace("作曲家","").replace("作曲","").replace("作词","")
//        var sg = JiebaSegmenter()
//        wordList.add(sg.sentenceProcess(text.toString()))
//    }
//
//
//    override fun getSite(): Site {
//        return site
//    }
//
//}
//
//fun getLyric(){
//    musicList.forEach{
//        Spider.create(lyricSpider()).addUrl("http://music.163.com/api/song/lyric?os=osx&id=$it&lv=-1&kv=-1&tv=-1").thread(5).run()
//    }
//}
//
//fun getRank(){
//    wordList.forEach {
//        it.forEach {w ->
//            var key = w.trim().replace("\n","")
//            if (word[key] != null){
//                word[key] = word[key]!! + 1
//            }
//            else if (!key.trim().isEmpty() && key.length > 1)
//                word[key] = 1
//        }
//    }
//    // 如果你行看看输出的结果
//
//    // 正序输出结果
////    word.entries.stream().sorted(Map.Entry.comparingByValue()).forEach(::println)
//    // 逆序输出结果
////    word.entries.stream().sorted(Map.Entry.comparingByValue{o1,o2 -> o2.compareTo(o1)}).forEach(::println)
//}
//
//
//
//
//fun kotlin_spider.main(args:Array<String>){
//    var startTime :Long = currentTimeMillis()
//    var endTime :Long
//    System.out.println("开始爬取...")
//    val request = Request("http://music.163.com/artist?id=1049179")
//    Spider.create(songsIdSpider()).addRequest(request).thread(5).run()
//    endTime = currentTimeMillis()
//    getLyric()
//    getRank()
//    System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"  + count + "条歌曲")
//}