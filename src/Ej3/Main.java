package Ej3;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket conexion = new Socket("localhost", 5000);
        InputStream e = conexion.getInputStream();
        DataInputStream entrada = new DataInputStream(e);
        OutputStream s = conexion.getOutputStream();
        DataOutputStream salida = new DataOutputStream(s);
        String peticion = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!peticion.equals("fin")) {
            System.out.println("Escribe un texto para mandarlo al servidor o escribe 'fin': ");
            peticion = br.readLine().toLowerCase();
            salida.writeUTF(peticion);
            System.out.println("Respuesta del servidor: " + entrada.readUTF());
        }
        entrada.close();
        salida.close();
        conexion.close();
    }
}
