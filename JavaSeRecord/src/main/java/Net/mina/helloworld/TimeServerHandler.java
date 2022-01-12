package Net.mina.helloworld;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
/**
 * Mina服务器,handle业务逻辑
 * @author alienware
 *
 */
public class TimeServerHandler extends IoHandlerAdapter {

	/**
	 * 当一个新客户端连接后触发此方法
	 */
	@Override
	public void sessionCreated(IoSession session){
		//显示客户端的ip和端口
		System.out.println("服务端和客户端" + session.getRemoteAddress() + "创建连接成功!");
	}
	
	@Override
    /*
     * (non-Javadoc)
     * @see org.apache.mina.core.service.IoHandlerAdapter#sessionOpened(org.apache.mina.core.session.IoSession)
     */
    public void sessionOpened(IoSession session) throws Exception {
    
		System.out.println("服务端与客户端" + session.getRemoteAddress() + "连接打开...");

    }
	
	/**
	 * 当接口中其他方法抛出异常未被捕获时触发此方法
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
	}
	
	/**
	 * 当接收到客户端的请求信息后触发此方法
	 * 消息接收事件
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String strMsg = message.toString();
		if(strMsg.trim().equalsIgnoreCase("quit")){
			session.close(true);
			return;
		}
		//返回消息字符串
		session.write("Hi Client! i'm server!");
		//打印客户端传来的消息内容
		System.out.println("Message written : " + strMsg );
	}
	
	/**
	 * 当连接空闲时触发此方法
	 */
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("IDLE" + session.getIdleCount(status));
	}
	
}
