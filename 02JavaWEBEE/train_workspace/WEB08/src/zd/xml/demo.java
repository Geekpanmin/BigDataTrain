package zd.xml;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
public class demo {
	public static void main(String[] args) throws DocumentException {
		//获取文档的解析器
		SAXReader reader=new SAXReader();
		//加载xml文件 返回document  代表整个文档
		Document document=reader.read("src/Demo1.xml");
		//获取根节点
		Element rootElement=document.getRootElement();//<books>
		Object obj=rootElement.elements("book").get(0);//<book>
		Element book1=(Element) obj;
		Element element=book1.element("author");//<author>
		String text=element.getText();
		System.out.println(text);
		
	}

}
