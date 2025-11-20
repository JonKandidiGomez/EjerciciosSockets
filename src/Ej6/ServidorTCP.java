package Ej6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    private static int PUERTO = 5005;
    private static Contador contador = new Contador();

    public static void main(String[] args) throws IOException {
        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            System.out.println("Servidor TCP Multicliente escuchando en el puerto " + PUERTO);

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado");
                new Thread(new Ej6.ClienteTCP(cliente).start());
            }
        }

    }
}

class Contador {

    private int total;

    public Contador() {
        this.total = 0;
    }

    public synchronized void sumar() {
        total +=
    }
}
