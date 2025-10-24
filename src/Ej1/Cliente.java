package Ej1;

import java.io.*;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket conexion = new Socket("localhost", 4999);
        InputStream e = conexion.getInputStream();
        DataInputStream entrada = new DataInputStream(e);
        OutputStream s = conexion.getOutputStream();
        DataOutputStream salida = new DataOutputStream(s);

        salida.writeUTF("petición de datos");
        String mensaje = entrada.readUTF();
        System.out.println("Mensaje escrito desde el server:\n" +
                mensaje);

        entrada.close();
        salida.close();
        conexion.close();
    }
}
