import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5500);
        Socket cliente = servidor.accept();
        InputStream e = cliente.getInputStream();
        DataInputStream entrada = new DataInputStream(e);
        String peticion = entrada.readUTF();

        System.out.println("Lo recibido desde el cliente: " + peticion);

        OutputStream s = cliente.getOutputStream();
        DataOutputStream salida = new DataOutputStream(s);
        salida.writeUTF("Petición recibida.");

        entrada.close();
        salida.close();
        cliente.close();
        servidor.close();
    }
}
