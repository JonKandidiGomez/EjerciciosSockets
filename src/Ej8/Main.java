package Ej8;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket conexion = new Socket("localhost", 5555);
        ObjectOutputStream outObjeto = new ObjectOutputStream(conexion.getOutputStream());
        ObjectInputStream inObjeto = new ObjectInputStream(conexion.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduce el primer numero:");
        int n1 = Integer.parseInt(br.readLine());
        System.out.println("Introduce el segundo numero:");
        int n2 = Integer.parseInt(br.readLine());

        Datos d = new Datos(n1, n2);
        System.out.println("Objeto enviado al servidor: " + d);
        outObjeto.writeObject(d);

        Datos dRespuesta = (Datos) inObjeto.readObject();
        System.out.println("Objeto recibido del servidor: " + dRespuesta);

        conexion.close();
        outObjeto.close();
        inObjeto.close();
    }
}
