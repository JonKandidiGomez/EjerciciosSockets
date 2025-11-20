package EjemploUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        DatagramSocket servidor = new DatagramSocket(7777);
        byte[] buffer = new byte[1024];
        DatagramPacket contenedor = new DatagramPacket(buffer, buffer.length);

        servidor.receive(contenedor);
        String infor = new String(contenedor.getData(), 0, contenedor.getLength());
        int puerto = contenedor.getPort();
        System.out.println("El primer mensaje recibido es: " + infor);
        System.out.println("desde el puerto: " + puerto);

        DatagramPacket contenedor2 = new DatagramPacket(buffer, buffer.length);
        servidor.receive(contenedor2);

        String infor2 = new String(contenedor2.getData(), 0, contenedor2.getLength());
        String direccionIP = String.valueOf(contenedor2.getAddress());
        System.out.println("El segundo mensaje recibido es: " + infor2);
        System.out.println("desde la direccion: " + direccionIP);

        byte[] m = "Respuesta".getBytes();
        DatagramPacket respuesta = new DatagramPacket(m, m.length, contenedor2.getAddress(), contenedor2.getPort());
        servidor.send(respuesta);

        servidor.close();
    }
}
