package org.clb.io.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    public int index;

    public NettyServerHandler() {
    }

    public NettyServerHandler(int index) {
        this.index = index;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 读取客户端发来的数据
        ByteBuf buf = (ByteBuf) msg;
        byte[] data = new byte[buf.readableBytes()];
        buf.readBytes(data);
        String received = new String(data);
        System.out.println("Received from client: " +index+ received);

        // 响应客户端
        ctx.writeAndFlush(ctx.alloc().buffer().writeBytes("Hello, client!".getBytes()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 异常处理
        cause.printStackTrace();
        ctx.close();
    }
}
