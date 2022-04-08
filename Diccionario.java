import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Diccionario {
    
    Scanner input = new Scanner(System.in);

    File file = null;
    FileReader fr = null;
    FileWriter  write = null;
    PrintWriter pw = null;
    BufferedReader br = null;

    BinarySearchTree english = new BinarySearchTree();
    BinarySearchTree spanish = new BinarySearchTree();
    BinarySearchTree french = new BinarySearchTree();

    public void readFile() {

        System.out.println("Ingrese ruta del archivo: ");
        String src = input.nextLine();

        try {
            file = new File(src);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch (Exception e) {
            System.out.println("No se encuentra el archivo...");
        }

        try {
            String next;
            while ((next = br.readLine()) != null) 
            {
                String[] texto = next.toLowerCase().split(",");

                english.insert(texto[0], texto);
                spanish.insert(texto[1], texto);
                french.insert(texto[2], texto);

            }

            System.out.println("Archivo leido con exito");
        } catch (Exception e) {
            System.out.println("Error al leer archivo");
        }

    }

    public void mostrarDiccionario(int choice) {

        switch(choice) {
        case 1:
            System.out.println("\n Diccionario en ingles: ");
            english.getBST();
            break;

        case 2:
            System.out.println("\n Diccionario en espanol: ");
            spanish.getBST();
            break;
        
        case 3:
            System.out.println("\n Diccionario en frances: ");
            french.getBST();
            break;

        default:
            System.out.println("Opcion no existente...");
        }

    }
    
    public void traducir(int entrada, int salida){

        System.out.println("Ingrese ruta del archivo: ");
        String src = input.nextLine();

        try {
            file = new File(src);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            write = new FileWriter(src, true);
            pw = new PrintWriter(write);
            pw.println("Traduccion: ");

        } catch (Exception e) {
            System.out.println("No se encuentra el archivo...");
        }

        try {
            String next;
            while ((next = br.readLine()) != null) 
            {
                String traduccion = "";
                String[] texto = next.toLowerCase().split(",");

                for (int i = 0; i < texto.length; i++) {
                    
                    String[] traductor = null;
                    switch(entrada) {
                    case 1:
                        traductor = english.getNode(texto[i].toLowerCase());
                        break;

                    case 2:
                        traductor = spanish.getNode(texto[i].toLowerCase());
                        break;

                    case 3:
                        traductor = french.getNode(texto[i].toLowerCase());
                        break;
                    
                    default:
                        System.out.println("No es una opcion...");
                    }

                    if (traductor == null) 
                    {
                        traduccion += " *" + texto[i] + "* ";
                    } else 
                    {
                        traduccion += " " + traductor[salida - 1] + " ";
                    }
                }
                
                pw.println(traduccion);

            }

            System.out.println("Archivo traducido con exito");
            
        } catch (Exception e) {
            System.out.println("Error al leer archivo");
        } finally {

            try {
                if (null != write) {
                    write.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
