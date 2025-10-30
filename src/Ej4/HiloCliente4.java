package Ej4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class HiloCliente4 extends Thread {
    private final Socket socket;

    public HiloCliente4(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream e = socket.getInputStream();
            DataInputStream entrada = new DataInputStream(e);
            OutputStream s = socket.getOutputStream();
            DataOutputStream salida = new DataOutputStream(s);
            int opcion = 0;

            while (opcion != 5) {
                String respuesta;
                opcion = entrada.readInt();
                if (opcion == 5) {
                    salida.writeUTF("Programa finalizado.");
                } else {
                    int op1 = entrada.readInt();
                    int op2 = entrada.readInt();
                    respuesta = calcular(opcion, op1, op2);
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

    private String calcular(int opcion, int op1, int op2) {
        return switch (opcion) {
            case 1 -> op1 + " + " + op2 + " es igual a " + (op1 + op2);
            case 2 -> op1 + " - " + op2 + " es igual a " + (op1 - op2);
            case 3 -> op1 + " X " + op2 + " es igual a " + (op1 * op2);
            case 4 -> op1 + " / " + op2 + " es igual a " + (op1 / op2);
            default -> "";
        };
    }
}