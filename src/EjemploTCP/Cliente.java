package EjemploTCP;

import java.io.*;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket conexion = new Socket("localhost", 5500);
        InputStream e = conexion.getInputStream();
        DataInputStream entrada = new DataInputStream(e);
        OutputStream s = conexion.getOutputStream();
        DataOutputStream salida = new DataOutputStream(s);

        salida.writeUTF("mi primera conexion");

        String respuesta = entrada.readUTF();
        System.out.println("La respuesta recibida: " + respuesta);
        entrada.close();
        salida.close();
        conexion.close();
    }
}
