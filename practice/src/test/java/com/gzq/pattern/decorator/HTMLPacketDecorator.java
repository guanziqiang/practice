package com.gzq.pattern.decorator;

public class HTMLPacketDecorator extends MPackerDecorator{

    public HTMLPacketDecorator(PacketService packetService) {
        super(packetService);
    }

    @Override
    public String handleContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(packetService.handleContent());
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

}
