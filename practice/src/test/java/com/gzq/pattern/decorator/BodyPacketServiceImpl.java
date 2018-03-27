package com.gzq.pattern.decorator;

public class BodyPacketServiceImpl implements PacketService{

    @Override
    public String handleContent() {
        return "网页的展示内容";
    }

}
