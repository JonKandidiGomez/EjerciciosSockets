package Ej5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Cliente {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket cliente = new DatagramSocket(9999);

        System.out.println("Introduce mensaje:");
        String peticion = br.readLine();
        byte[] pet = peticion.getBytes();
        InetAddress dir = InetAddress.getLocalHost();
        DatagramPacket petCliente = new DatagramPacket(pet, pet.length, dir, 9000);
        cliente.send(petCliente);

        byte[] rps = new byte[1024];
        DatagramPacket respuestaServer = new DatagramPacket(rps, rps.length);

        cliente.receive(respuestaServer);
        System.out.println("Respuesta: " + new String(respuestaServer.getData(), 0, respuestaServer.getLength()));
    }
}
