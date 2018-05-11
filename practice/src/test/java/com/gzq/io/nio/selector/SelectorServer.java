package com.gzq.io.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class SelectorServer {
    /*标志数字*/
    private static int flag = 0;
    /*定义缓冲区大小*/
    private static int block = 4096;
    /*接收缓冲区*/
    private static ByteBuffer receiveBuffer = ByteBuffer.allocate(block);
    /*发送缓冲区*/
    private static ByteBuffer sendBuffer = ByteBuffer.allocate(block);
    /*定义Selector*/
    private Selector selector;

    public SelectorServer(int port) {
        try {
            ServerSocketChannel open = ServerSocketChannel.open();
            open.configureBlocking(false);
            ServerSocket socket = open.socket();
            socket.bind(new InetSocketAddress(port));
            
            selector = Selector.open();
            open.register(selector, SelectionKey.OP_ACCEPT);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //selector 监听
    public void listen() throws IOException {
        while(true) {
            int i = selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                handleKey(next);
                iterator.remove();
            }
        }
    }

    public void handleKey(SelectionKey selectionKey) throws IOException{
        //接受请求
        ServerSocketChannel serverSocketChannel = null;
        SocketChannel socketChannel = null;
        String receiveText;
        String sendText;
        int count;
        //测试此键的通道是否准备好接受新的套接字连接
        if(selectionKey.isAcceptable()){
            //返回创建此键的通道
            serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
            //接受客户端建立连接的请求，并返回 SocketChannel 对象
            socketChannel = serverSocketChannel.accept();
            //配置为非阻塞
            socketChannel.configureBlocking(false);
            //注册到selector
            socketChannel.register(selector, SelectionKey.OP_READ);
        }else if(selectionKey.isReadable()){
            //返回为之创建此键的通道
            socketChannel = (SocketChannel)selectionKey.channel();
            //将缓冲区清空，以备下次读取
            receiveBuffer.clear();
            //将发送来的数据读取到缓冲区
            
            count = socketChannel.read(receiveBuffer);
        
            
            if(count>0){
                receiveText = new String(receiveBuffer.array(),0,count);
                System.out.println("服务器端接受到的数据---"+receiveText);
                socketChannel.register(selector, SelectionKey.OP_WRITE);
            }
        }else if (selectionKey.isWritable()) {  
            //将缓冲区清空以备下次写入  
            sendBuffer.clear();  
            // 返回为之创建此键的通道。  
            socketChannel = (SocketChannel) selectionKey.channel();  
            sendText="message from server--" + flag++;  
            //向缓冲区中输入数据  
            sendBuffer.put(sendText.getBytes());  
             //将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位  
            sendBuffer.flip();  
            //输出到通道  
            socketChannel.write(sendBuffer);  
            System.out.println("服务器端向客户端发送数据--："+sendText);  
            socketChannel.register(selector, SelectionKey.OP_READ);  
        }  
    } 
    
    
    public static void main(String[] args) throws IOException {
        int port = 8888; 
        SelectorServer server = new SelectorServer(port);
        server.listen();
    }
    

}
