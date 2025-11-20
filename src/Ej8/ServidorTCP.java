package Ej8;

import Ej8.ClienteTCP;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(5555);
        System.out.println("Servidor TCP Multicliente escuchando en el puerto 5555");

        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");
            new Thread(new ClienteTCP(cliente)).start();
        }
    }

}
