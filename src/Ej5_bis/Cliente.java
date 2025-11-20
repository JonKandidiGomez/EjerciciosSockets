package Ej5_bis;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDateTime;

public class Cliente implements Runnable {

    private final DatagramSocket socket;
    private final DatagramPacket lect;

    public Cliente(DatagramSocket socket, DatagramPacket lect) {
        this.socket = socket;
        this.lect = lect;
    }

    @Override
    public void run() {
        System.out.println("Ha llegado una peticion\n" +
                new String(lect.getData(), 0, lect.getLength()) +
                "\nprocedente de: " + lect.getAddress() +
                "\nen el puerto: " + lect.getPort());

        String hora = "HORA DEL SERVIDOR: " + LocalDateTime.now();
        byte[] respuesta = hora.getBytes();
        DatagramPacket resp = new DatagramPacket(respuesta, respuesta.length, lect.getAddress(), lect.getPort());
        try {
            socket.send(resp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sirviendo la peticion");
    }
}
