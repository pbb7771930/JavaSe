package Net.mina.demo2;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
/*
 * 模拟手机发短信
 */
public class MinaClient02{

    private static Logger logger = Logger.getLogger(MinaClient02.class);

    private static String HOST = "127.0.0.1";

    private static int PORT = 3005;

    public static void main(String[] args) {

        // 创建一个非阻塞的客户端程序
        IoConnector connector = new NioSocketConnector();  // 创建连接

        // 设置链接超时时间
        connector.setConnectTimeoutMillis(3000);;

        //添加消息过滤器
        connector.getFilterChain().addLast(   
                "codec", new ProtocolCodecFilter(
                		new TextLineCodecFactory(Charset.forName("UTF-8"), LineDelimiter.WINDOWS.getValue(),
                        LineDelimiter.WINDOWS.getValue())));

        // 添加业务逻辑处理器类
        connector.setHandler(new Demo1ClientHandler());// 添加业务处理

        IoSession session = null;

        try {
        	// 创建连接
            ConnectFuture future = connector.connect(new InetSocketAddress(HOST, PORT));
            
            future.awaitUninterruptibly();// 等待连接创建完成

            session= future.getSession();// 获得session
            
            String sendPhone = "13681803609"; // 当前发送人的手机号码
            String receivePhone = "13721427169"; // 接收人手机号码
            String message = "测试发送短信，这个是短信信息哦，当然长度是有限制的哦....";
            String msg = sendPhone + ";" + receivePhone + ";" + message;

            session.write(msg);// 发送消息

        }catch (Exception e) {

            logger.error("客户端链接异常...", e);

        }

        session.getCloseFuture().awaitUninterruptibly();// 等待连接断开

        connector.dispose();

    }

}