import com.huaban.analysis.jieba.JiebaSegmenter

/**
 * Created by nbsaw on 2017/5/24.
 */

fun main(args:Array<String>){
    var text = "我今天好像日了狗"
    var sg =JiebaSegmenter()
    System.out.println(sg.sentenceProcess(text))
}