package org.clb.io.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.clb.io.netty.handler.NettyServerHandler;

public class NettyServer {

    ServerBootstrap serverBootstrap;

    public void init() {
        try {
            // 创建两个事件循环组，一个用于接收客户端连接，一个用于处理连接后的数据传输
            EventLoopGroup bossGroup = new NioEventLoopGroup(); // 接收连接
            EventLoopGroup workerGroup = new NioEventLoopGroup(); // 处理连接后的数据传输
            serverBootstrap = new ServerBootstrap()
                    .group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // 指定使用 NIO 传输通道
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            // 添加 ChannelHandler 处理客户端的事件
                            ch.pipeline().addLast(new NettyServerHandler(1));
                            ch.pipeline().addLast(new NettyServerHandler(2));
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128) // 设置队列大小
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // 保持连接
            // 绑定端口，开始接受进来的连接
            ChannelFuture future = serverBootstrap.bind(8080).sync();
            // 阻塞，直到服务器 socket 关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
