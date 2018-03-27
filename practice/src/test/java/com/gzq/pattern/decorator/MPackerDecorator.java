package com.gzq.pattern.decorator;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public abstract class MPackerDecorator implements PacketService {
    PacketService packetService = null;

    public MPackerDecorator(PacketService packetService) {
        this.packetService = packetService;
    }

    /**
     * 装饰着模式
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        PacketService packetService = new HeaderPacketDecorator(
                new HTMLPacketDecorator(new BodyPacketServiceImpl()));
        System.out.println(packetService.handleContent());
        
        new DataOutputStream(new BufferedOutputStream(new FileOutputStream("d:\t.txt"))); 
    }

}
