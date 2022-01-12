package Net.netty.helloword;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class ServerHandler extends ChannelHandlerAdapter {


	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("server channel active... ");
	}


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
			
			
			try{
				ByteBuf buf = (ByteBuf) msg;
				byte[] req = new byte[buf.readableBytes()];
				buf.readBytes(req);  //读取请求
				String body = new String(req, "utf-8");
				System.out.println("Server端收到的消息:::" + body );
				//服务器端给客户端的响应
				String response = "我是server端，我收到了你发送的：" + body ;
				ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
				//.addListener(ChannelFutureListener.CLOSE) 加上这个表示当客户端和服务器通信结束后，Server端会关闭客户端连接，不关则表示保持长连接
				
			}finally{
				ReferenceCountUtil.release(msg);
			}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx)	throws Exception {
		System.out.println("读完了");
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable t)	throws Exception {
		ctx.close();
	}

}
