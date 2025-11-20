package Ej5_bis;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            DatagramSocket socket = new DatagramSocket(6600);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introduce mensaje:");
            String peticion = br.readLine();
            byte[] pet = peticion.getBytes();
            InetAddress dir = InetAddress.getLocalHost();
            DatagramPacket petCliente = new DatagramPacket(pet, pet.length, dir, 6000);
            socket.send(petCliente);

            byte[] rps = new byte[1024];
            DatagramPacket respuestaServer = new DatagramPacket(rps, rps.length);

            socket.receive(respuestaServer);
            System.out.println("Respuesta: " + new String(respuestaServer.getData(), 0, respuestaServer.getLength()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
