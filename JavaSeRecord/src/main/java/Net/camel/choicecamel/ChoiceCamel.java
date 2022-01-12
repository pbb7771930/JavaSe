package Net.camel.choicecamel;
 
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ModelCamelContext;
import org.apache.log4j.PropertyConfigurator;
 
 
/**
 *  * 基于内容的路由
 * <p>
 *  *
 * <p>
 *  * @author 
 * <p>
 *  * @time 2019年03月20日下午3:52:11
 * <p>
 *  
 */
 
public class ChoiceCamel {
    
    public static void main(String[] args) throws Exception {
 
        PropertyConfigurator.configure("./config/log4j.properties");
 
        PropertyConfigurator.configureAndWatch("./config/log4j.properties", 1000);
 
 
        // 这是camel上下文对象，整个路由的驱动全靠它了。
        ModelCamelContext camelContext = new DefaultCamelContext();
        
        // 启动route
        camelContext.start();
        
        // 将我们编排的一个完整消息路由过程，加入到上下文中
        camelContext.addRoutes(new camel.choicecamel.ChoiceCamelRouteBuilder());
 
 
        // 通用没有具体业务意义的代码，只是为了保证主线程不退出
        synchronized (ChoiceCamel.class) {
            ChoiceCamel.class.wait();
        }
    }
}
