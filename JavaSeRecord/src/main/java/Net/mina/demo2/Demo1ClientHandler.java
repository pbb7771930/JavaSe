package Net.mina.demo2;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class Demo1ClientHandler extends IoHandlerAdapter {
 
    private static Logger logger = Logger.getLogger(Demo1ClientHandler.class);

    @Override
    //客户端收到消息时调用的方法
    public void messageReceived(IoSession session, Object message) throws Exception {

        String msg = message.toString();

        logger.info("客户端接收到的信息为：" + msg);

    }

    @Override
    //发生异常时调用的方法
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {

        logger.error("客户端发生异常...", cause);

    }

}