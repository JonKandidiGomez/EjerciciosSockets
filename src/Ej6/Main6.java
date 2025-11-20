package Ej6;

import java.io.*;
import java.net.Socket;


public class Main6 {
    public static void main(String[] args) throws IOException {
        Socket conexion = new Socket("localhost", 5005);
        InputStream e = conexion.getInputStream();
        DataInputStream entrada = new DataInputStream(e);
        OutputStream s = conexion.getOutputStream();
        DataOutputStream salida = new DataOutputStream(s);
        int opcion = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(entrada.readUTF());

        while (true) {
            System.out.println("Introduce un numero para sumar o 0 para finalizar el programa: ");

            opcion = Integer.parseInt(br.readLine());
            salida.writeInt(opcion);
            String respuesta = entrada.readUTF();
            System.out.println(respuesta);
            if (respuesta.equals("Programa finalizado.")) {
                break;
            }
        }

        entrada.close();
        salida.close();
        conexion.close();
    }
}
