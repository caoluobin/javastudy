package org.clb.io.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.clb.io.netty.handler.client.SimpleClientHandler;

public class NettyClient {
    public static void main(String[] args) {
        NettyClient nettyClient= new NettyClient();
        nettyClient.init("127.0.0.1",83);
    }
    Bootstrap bootstrap = new Bootstrap();

    public void init(String host, Integer port) {
        EventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ChannelPipeline pipeline = ch.pipeline();

                        // 添加你的处理器（例如，解码器、编码器、业务逻辑处理器等）
                        // pipeline.addLast(new YourDecoder());
                        // pipeline.addLast(new YourEncoder());
                        // pipeline.addLast(new YourClientHandler());

                        // 示例：添加一个简单的字符串编码器和解码器以及一个处理器
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new SimpleClientHandler());
                    }
                });
        try {
            ChannelFuture future = bootstrap.connect(host, port).sync();
            Channel channel = future.channel();

            // 发送消息到服务器
            String message = "Hello, Server!";
            channel.writeAndFlush(message);

            // 等待连接关闭
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
