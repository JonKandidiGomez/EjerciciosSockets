package Ej4;

import java.io.*;
import java.net.Socket;

public class Main4 {
    public static void main(String[] args) throws IOException {
        Socket conexion = new Socket("localhost", 5400);
        InputStream e = conexion.getInputStream();
        DataInputStream entrada = new DataInputStream(e);
        OutputStream s = conexion.getOutputStream();
        DataOutputStream salida = new DataOutputStream(s);
        int opcion = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (opcion < 5 && opcion > 0) {
            System.out.println("""
                    Elige una opción o escribe 'fin': \
                    
                    1. Sumar
                    2. Restar
                    3. Multiplicar
                    4. Dividir
                    5. Salir""");

            boolean op = false;
            while (!op) {
                try {
                    opcion = Integer.parseInt(br.readLine());
                    if (opcion < 0 || opcion > 5) {
                        System.out.println("Elige una opcion valida");
                    } else {
                        op = true;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Elige una opcion valida");
                }
            }

            if (opcion < 5) {
                System.out.println("Introduce el operando 1");
                boolean primerOP = false;
                int op1 = 0;
                while (!primerOP) {
                    try {
                        op1 = Integer.parseInt(br.readLine());
                        System.out.println("Operando 1 valido");
                        primerOP = true;
                    } catch (NumberFormatException ex) {
                        System.out.println("Error. Introduce un entero válido.");
                    }
                }

                System.out.println("Introduce el operando 2");
                boolean segundoOP = false;
                int op2 = 0;
                while (!segundoOP) {
                    try {
                        op2 = Integer.parseInt(br.readLine());
                        System.out.println("Operando 2 valido");
                        segundoOP = true;
                    } catch (NumberFormatException ex) {
                        System.out.println("Error. Introduce un entero válido.");
                    }
                }
                salida.writeInt(opcion);
                salida.writeInt(op1);
                salida.writeInt(op2);
                System.out.println("Respuesta del servidor:");
                System.out.println(entrada.readUTF());
            }
        }
        entrada.close();
        salida.close();
        conexion.close();
    }
}
