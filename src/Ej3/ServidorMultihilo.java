package Ej3;

import java.io.*;
import java.net.*;

public class ServidorMultihilo {
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(5000);

        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("EjemploTCP.Cliente conectado");
            new HiloCliente(cliente).start();
        }
    }
}
