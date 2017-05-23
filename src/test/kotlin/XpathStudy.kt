import org.w3c.dom.Node
import org.w3c.dom.NodeList
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

/**
 * Created by nbsaw on 2017/5/23.
 */

// find absolute path in resources
fun getPath(path:String) :String{
    val loader = Thread.currentThread().contextClassLoader
    return loader.getResource(path).path
}

fun main(args:Array<String>){
    // init dom instance
    val factory = DocumentBuilderFactory.newInstance()
    factory.isNamespaceAware = true // never forget this!
    val builder = factory.newDocumentBuilder()
    val doc = builder.parse(getPath("books.xml"))

    // init xml instance
    val xmlFactory = XPathFactory.newInstance()
    val xpath = xmlFactory.newXPath()

    // XPath expr
    val expr = xpath.compile("/html//book//title")
    var result = expr.evaluate(doc, XPathConstants.NODESET)
    var nodes = result as NodeList

    // loop
    var count = 0
    while (true){
        var item: Node = nodes.item(count++) ?: break
        println("${item.textContent}")
    }
}