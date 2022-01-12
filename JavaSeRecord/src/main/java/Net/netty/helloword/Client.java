package Net.netty.helloword;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {

	public static void main(String[] args) throws Exception{
		//只需要建一个EventLoopGroup对象
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		b.group(group)
		.channel(NioSocketChannel.class)    //指定NIO的模式,client端这里指定为NioSocketChannel
		//一定要使用handler，去绑定具体的事件处理器,server端的话使用childHandler
		.handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel sc) throws Exception {
				//3、 在这里配置具体数据接收方法的处理，ClientHandler对象处理通信内容
				sc.pipeline().addLast(new ClientHandler());
			}
		});
		
		ChannelFuture cf1 = b.connect("127.0.0.1", 8765).sync();
		//ChannelFuture cf2 = b.connect("127.0.0.1", 8764).sync();
		//发送消息
		Thread.sleep(1000);
		//获取channel，写入数据，copiedBuffer将777字节数组转成buffer
		cf1.channel().writeAndFlush(Unpooled.copiedBuffer("我是客户端，我发送了：777".getBytes()));
		//以上写法将下面两句合并到一个方法中
		//cf1.channel().write(Unpooled.copiedBuffer("我是客户端，我发送了：777".getBytes())); //write将数据写入管道
		//cf1.channel().flush();  //flush将数据发送到服务器端
	
		//cf1.channel().writeAndFlush(Unpooled.copiedBuffer("我是客户端，我发送了：666".getBytes()));

		
		Thread.sleep(2000);
		cf1.channel().writeAndFlush(Unpooled.copiedBuffer("我是客户端，我发送了：888".getBytes()));
		//cf2.channel().writeAndFlush(Unpooled.copiedBuffer("666".getBytes()));
		
		cf1.channel().closeFuture().sync();
		//cf2.channel().closeFuture().sync();
		group.shutdownGracefully();
		
		
		
	}
}
