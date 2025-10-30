package Ej3;

import java.io.*;
import java.net.Socket;

class HiloCliente extends Thread {
    private Socket socket;

    public HiloCliente(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream e = socket.getInputStream();
            DataInputStream entrada = new DataInputStream(e);
            OutputStream s = socket.getOutputStream();
            DataOutputStream salida = new DataOutputStream(s);
            String peticion = "";

            while (!peticion.equalsIgnoreCase("fin")) {
                String respuesta;
                peticion = entrada.readUTF().toLowerCase();
                if (peticion.equals("fin")) {
                    salida.writeUTF("Programa finalizado.");
                } else {
                    respuesta = peticion.toUpperCase();
                    salida.writeUTF(respuesta);
                }
            }

            entrada.close();
            salida.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error en hilo: " + e.getMessage());
        }
    }
}