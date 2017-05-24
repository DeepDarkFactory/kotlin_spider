package music163

import us.codecraft.webmagic.Page
import us.codecraft.webmagic.Request
import us.codecraft.webmagic.Site
import us.codecraft.webmagic.Spider
import us.codecraft.webmagic.processor.PageProcessor
import us.codecraft.webmagic.utils.HttpConstant
import java.lang.System.currentTimeMillis

/**
 * Created by nbsaw on 2017/5/23.
 */
var count = 0

class zhiHuSpider : PageProcessor {
    private var site = Site.me().setRetryTimes(3).setSleepTime(100)

    override fun process(page: Page) {
        //获取页面需要的内容
        var items = page.html.xpath("//*[@id=\"artist-top50\"]//ul[@class=\"f-hide\"]//li//a").nodes()
        for (item in items){
            println("${item.xpath("/a/text()")} : ${item.links()}")
            count ++
        }
    }

    override fun getSite(): Site {
        return site
    }

}

fun main(args:Array<String>){
    var startTime :Long = currentTimeMillis()
    var endTime :Long
    System.out.println("开始爬取...")
    val request = Request("http://music.163.com/artist?id=5781")
//    request.method = HttpConstant.Method.POST
    Spider.create(zhiHuSpider()).addRequest(request).thread(5).run()
    endTime = currentTimeMillis()
    System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"  + count + "条记录")
}