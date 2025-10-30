package Ej4;


import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMultihilo4 {
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(5400);

        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");
            new HiloCliente4(cliente).start();
        }
    }
}
