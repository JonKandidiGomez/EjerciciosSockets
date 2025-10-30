package Ej2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5999);
        Socket cliente = servidor.accept();
        InputStream e = cliente.getInputStream();
        DataInputStream entrada = new DataInputStream(e);
        OutputStream s = cliente.getOutputStream();
        DataOutputStream salida = new DataOutputStream(s);
        String peticion = "";

        while (!peticion.equalsIgnoreCase("fin")) {
            String respuesta;
            peticion = entrada.readUTF().toLowerCase();
            if(peticion.equals("fin")) {
                salida.writeUTF("Programa finalizado.");
            } else {
                respuesta = peticion.toUpperCase();
                salida.writeUTF(respuesta);
            }
        }

        entrada.close();
        salida.close();
        cliente.close();
    }
}