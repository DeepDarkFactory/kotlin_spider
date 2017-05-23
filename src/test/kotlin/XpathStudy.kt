import org.w3c.dom.Node
import org.w3c.dom.NodeList
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

/**
 * Created by nbsaw on 2017/5/23.
 */

fun getPath(path:String) :String{
    val loader = Thread.currentThread().contextClassLoader
    return loader.getResource(path).path
}

fun main(args:Array<String>){
    val factory = DocumentBuilderFactory.newInstance()
    factory.isNamespaceAware = true // never forget this!
    val builder = factory.newDocumentBuilder()
    val doc = builder.parse(getPath("books.xml"))
    // XML
    val xmlFactory = XPathFactory.newInstance()
    val xpath = xmlFactory.newXPath()
    val expr = xpath.compile("//book[author='Neal Stephenson']/title/text()")
    var result = expr.evaluate(doc, XPathConstants.NODESET)
    var nodes = result as NodeList
    var count = 0
    while (true){
        var item: Node? = nodes.item(count++) ?: break
        println(item!!.nodeValue)
    }
}