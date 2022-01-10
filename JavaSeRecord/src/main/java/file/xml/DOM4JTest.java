package file.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class DOM4JTest {
 
    /** 
     * DOM4J读写XML示例 
     *
     */

    // 声明写XML的对象
    XMLWriter writer = null;
    SAXReader reader = new SAXReader();  

    OutputFormat format = OutputFormat.createPrettyPrint();  

    String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\xml\\parse\\student.xml";

    //创建需要写入的File对象
    File file = new File(filePath);  
    
    /*
     * 创建xml文件方法
     */
	public void createXml(){
        try {  
        	
        	System.out.println(filePath);

            // 新建student.xml文件并新增内容  
            Document document = DocumentHelper.createDocument();

            //增加根节点  <学生信息></学生信息>
            Element root = document.addElement("学生信息");

            //增加根节点下的子元素 <学生></学生>
            Element student = root.addElement("学生");

            //增加student节点的属性
            student.addAttribute("sid", "003");

            //增加<学生></学生>点下的子元素<编号></编号>
            Element id = student.addElement("编号");

            //为<编号></编号>元素添加内容
            id.setText("001");
            Element name = student.addElement("姓名");
            name.setText("灰机");
            Element age = student.addElement("年龄");
            age.setText("18");

            // 设置XML文件的编码格式
            format.setEncoding("utf-8");

            //生成XMLWriter对象
            writer = new XMLWriter(new FileWriter(file), format);

            //开始写入，write方法中包含上面创建的Document对象
            writer.write(document);
            writer.close();  

            System.out.println("操作结束! ");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
	
	/*
	 * 读取以及修改xml文件中的内容
	 */
	public void modifyElement() throws DocumentException, IOException{

        // 读取XML文件
		Document document = reader.read(file);

        // 得到根节点
        Element root = document.getRootElement();
        boolean bl = false;  
        //查找特定的元素，并修改其内容
        for (Iterator i = root.elementIterator("学生"); i.hasNext();) {  
            Element student = (Element) i.next();  
            if (student.attributeValue("sid").equals("001")) {  
                // 修改学生sid=001的学生信息  
                student.selectSingleNode("姓名").setText("王五");  
                student.selectSingleNode("年龄").setText("25");  

                writer = new XMLWriter(new FileWriter(filePath), format);  
                writer.write(document);  
                writer.close();  
                bl = true;  
                break;  
            }  
        }  
	}
	
	/*
	 * 读取xml中的内容
	 */
	@Test
	public void queryXml() throws DocumentException, IOException{

        // 读取XML文件
		Document document = reader.read(file);

        // 得到根节点
        Element root = document.getRootElement();

        //根节点的标签
        System.out.println(root.getName());
        Iterator it = root.elementIterator();
        //读取xml中的元素
        while (it.hasNext()) {
            Element element = (Element) it.next();
            //未知属性名称情况下
            Iterator attrIt = element.attributeIterator();
            while (attrIt.hasNext()) {
                Attribute a  = (Attribute) attrIt.next();
                System.out.println(element.getName()+":"+a.getName()+":"+a.getValue());
            }

        }
	}
	
    public static void main(String[] args) {  
        
    	DOM4JTest test = new DOM4JTest();
    	try {
			test.queryXml();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
    }
}
