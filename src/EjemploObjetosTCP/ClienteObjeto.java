package EjemploObjetosTCP;

import java.io.*;
import java.net.*;

public class ClienteObjeto {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 6000);
        Persona persona = new Persona("Ana", 25);
        ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
        outObjeto.writeObject(persona); // Envía el objeto
        socket.close();
    }
}