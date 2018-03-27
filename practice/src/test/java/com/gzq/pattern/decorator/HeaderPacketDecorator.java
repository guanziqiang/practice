package com.gzq.pattern.decorator;

public class HeaderPacketDecorator extends MPackerDecorator{

    public HeaderPacketDecorator(PacketService packetService) {
        super(packetService);
    }

    @Override
    public String handleContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cache-Control:no-cache\n");
        sb.append("Date:Mon,31Dec2018030616:30:00GMT\n");
        sb.append(packetService.handleContent());
        return sb.toString();
    }

}
