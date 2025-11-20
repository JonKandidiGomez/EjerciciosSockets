package Ej8;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteTCP implements Runnable {

    private final Socket socket;


    public ClienteTCP(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());

            System.out.println("Cliente conectado desde: " + socket.getInetAddress());

            Datos objCliente = (Datos) inObjeto.readObject();
            System.out.println(Thread.currentThread().getName() + " objeto recibido = " + objCliente);
            objCliente.setResultado(objCliente.getNum1() * objCliente.getNum2());
            System.out.println(Thread.currentThread().getName() + " resultado calculado = " + objCliente.getResultado());
            outObjeto.writeObject(objCliente);
            System.out.println(Thread.currentThread().getName() + " objeto enviado al cliente");

            outObjeto.close();
            inObjeto.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
