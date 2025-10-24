package Ej1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(4999);
        Socket cliente = servidor.accept();
        InputStream e = cliente.getInputStream();
        DataInputStream entrada = new DataInputStream(e);

        entrada.readUTF();
        System.out.println("ATENDIENDO AL CLIENTE");
        OutputStream s = cliente.getOutputStream();
        DataOutputStream salida = new DataOutputStream(s);
        salida.writeUTF("La fecha sel sistema y la hora es: " + LocalDateTime.now());
        cliente.close();
        entrada.close();
        salida.close();
    }
}
