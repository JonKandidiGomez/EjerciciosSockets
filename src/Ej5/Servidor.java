package Ej5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDateTime;

public class Servidor {
    public static void main(String[] args) throws IOException {
        System.out.println("Servidor Activo");
        DatagramSocket servidor = new DatagramSocket(9000);
        byte[] peticionRecibida = new byte[1024];
        DatagramPacket lect = new DatagramPacket(peticionRecibida, peticionRecibida.length);
        servidor.receive(lect);

        System.out.println("Ha llegado una peticion\n" +
                new String(lect.getData(), 0, lect.getLength()) +
                "\nprocedente de: " + lect.getAddress() +
                "\nen el puerto: " + lect.getPort());

        String hora = "HORA DEL SERVIDOR: " + LocalDateTime.now();
        byte[] respuesta = hora.getBytes();
        DatagramPacket resp = new DatagramPacket(respuesta, respuesta.length, lect.getAddress(), lect.getPort());
        servidor.send(resp);
        System.out.println("Sirviendo la peticion");
    }
}
