package Ej5_bis;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorMultihilo {
    public static void main(String[] args) throws IOException {
        System.out.println("Servidor Activo");
        DatagramSocket servidor = new DatagramSocket(6000);

        while (true) {
            byte[] peticion = new byte[1024];
            DatagramPacket dp = new DatagramPacket(peticion, peticion.length);
            servidor.receive(dp);
            Thread hilo = new Thread(new Cliente(servidor, dp));
            System.out.println("Cliente conectado");
            hilo.start();
        }
    }
}
