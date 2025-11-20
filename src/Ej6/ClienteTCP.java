package Ej6;

import java.io.*;
import java.net.Socket;


public class ClienteTCP implements Runnable {

    private Socket socket;

    public ClienteTCP(Socket s) {
        this.socket = s;
    }


    @Override
    public void run() {
        try {
            InputStream e = socket.getInputStream();
            DataInputStream entrada = new DataInputStream(e);
            OutputStream s = socket.getOutputStream();
            DataOutputStream salida = new DataOutputStream(s);
            System.out.println("Cliente conectado desde: " + socket.getInetAddress());
            salida.writeUTF("Conectado al servidor");
            int opcion = -1;

            while (opcion != 0) {
                opcion = entrada.readInt();
                if (opcion == 0) {
                    salida.writeUTF("Programa finalizado.");
                } else {
                    System.out.print("Cliente " + socket.getInetAddress() + " envio: " + opcion);
                    //int sTotal = s.sumar(opcion);
//                    System.out.println(" | Suma total: " + sTotal);
//                    salida.writeUTF("Suma total: " + sTotal);
                }
            }

            entrada.close();
            salida.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
