package EjemploObjetosTCP;

import java.io.*;
import java.net.*;

public class ServidorObjeto {
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Esperando objeto...");
        Socket socket = servidor.accept();
        ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
        Persona p = (Persona) inObjeto.readObject(); // Se recibe el objeto
        System.out.println("Recibido: " + p);
        socket.close();
        servidor.close();
    }
}
