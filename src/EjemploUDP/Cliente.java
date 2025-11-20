package EjemploUDP;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class Cliente {
    public static void main(String[] args) throws IOException {
        DatagramSocket cliente = new DatagramSocket();
        byte[] mensaje = "Hola".getBytes();
        InetAddress dir = InetAddress.getByName("localhost");
        DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length,
                dir, 7777);
        cliente.send(paquete);

        mensaje = "segundo mensaje".getBytes();
        DatagramPacket paquete2 = new DatagramPacket(mensaje, mensaje.length, dir, 7777);
        cliente.send(paquete2);

        byte[] lect = new byte[1024];
        DatagramPacket respuestaServer = new DatagramPacket(lect, lect.length);
        cliente.receive(respuestaServer);
        System.out.println("Respuesta del servidor: " + new String(respuestaServer.getData(), 0, respuestaServer.getLength()));

        cliente.close();
    }
}
