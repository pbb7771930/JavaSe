package Net.mina.demo1;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class Demo1ServerHandler extends IoHandlerAdapter {

    public static Logger logger = Logger.getLogger(Demo1ServerHandler.class);


    @Override
    //第一步：创建连接时会调用该方法
    public void sessionCreated(IoSession session) throws Exception {

        logger.info("服务端与客户端创建连接...");

    }


    @Override
    //第二步：创建连接后，打开连接时会调用该方法
    public void sessionOpened(IoSession session) throws Exception {

        logger.info("服务端与客户端连接打开...");

    }

 
    /*
     * (non-Javadoc)
     * 自定义的业务逻辑处理器继承了IoHandlerAdapter类，它默认覆盖了父类的7个方法，其实我们最关心最常用的只有一个方法：
     * messageReceived()---- 服务端接收到一个消息后进行业务处理的方法； 解析下它的实现：
     * 
     * 服务端一直监听3005端口，如果有客户端连接上服务端并发送信息，服务端解析信息（以文本换行符为每条信息的结束符），返回给客户端一个日期字符串；
     * 如果客户端传递的消息为“bye”，就是客户端告诉服务端，可以终止通话了，关闭与客户端的连接。
     */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {

        String msg = message.toString();

        logger.info("服务端接收到的数据为：" + msg);

        if ("bye".equals(msg)) { // 服务端断开连接的条件
            session.close(true);
        }

        Date date = new Date();

        session.write(date);

    }

    @Override
    //服务端发送消息会调用该方法
    public void messageSent(IoSession session, Object message) throws Exception {

        logger.info("服务端发送信息成功...");
        session.close(); //发送成功后主动断开与客户端的连接，如果不主动断开，建立的是长连接

    }

    @Override
    //服务端关闭连接时，调用的方法
    public void sessionClosed(IoSession session) throws Exception {

    	logger.info("服务端关闭...");

    }

    @Override
    //服务器端未收到消息时进入空间状态，调用该方法
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {

        logger.info("服务端进入空闲状态...");

    }

    @Override

    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {

        logger.error("服务端发送异常...", cause);

    }

}