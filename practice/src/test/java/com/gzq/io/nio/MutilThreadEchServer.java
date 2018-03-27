package com.gzq.io.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MutilThreadEchServer {
    private static ExecutorService es = Executors.newCachedThreadPool();
    
    static class HandleMessage implements Runnable{
        Socket socket;
        public HandleMessage(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader is = null;
            PrintWriter os = null;
            try {
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                os = new PrintWriter(socket.getOutputStream(), true);
                
                String  inputLine = null;
                long b = System.currentTimeMillis();
                
                while((inputLine=is.readLine()) != null) {
                    System.out.println("服务器收到"+inputLine);
                    os.println(inputLine);
                    os.flush();
                }
                long e = System.currentTimeMillis();
                System.out.println("耗时 "+(e-b)+"毫秒");
                
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    if(is!=null) {
                        is.close();
                    }
                    if(os!=null) {
                        os.close();
                    }
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        }
        
    }
    
    
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket socket = null;
        try {
            ss = new ServerSocket(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while(true) {
                socket = ss.accept();
                System.out.println(socket.getRemoteSocketAddress());
                es.execute(new HandleMessage(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(ss != null) {
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    

}
