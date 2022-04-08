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

    //Se implementa el BST para cada idioma
    BinarySearchTree english = new BinarySearchTree();
    BinarySearchTree spanish = new BinarySearchTree();
    BinarySearchTree french = new BinarySearchTree();

    //El metodo para leer el archivo general
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
                //Se crea el arbol para cada idioma
                english.insert(texto[0], texto);
                spanish.insert(texto[1], texto);
                french.insert(texto[2], texto);

            }

            System.out.println("Archivo leido con exito");
        } catch (Exception e) {
            System.out.println("Error al leer archivo");
        }

    }

    
    /** 
     * @param choice
     * Este metodo muestra la palabra en el idioma traducido a partir del txt con el diccionario
     */
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
    
    
    /** 
     * @param entrada
     * @param salida
     * Este metodo traduce las palabras del idioma de entrada al idioma de salida
     */
    public void traducir(int entrada, int salida){

        System.out.println("Ingrese ruta del archivo: ");
        String src = input.nextLine();

        //Lee el archivo
        try {
            file = new File(src);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            write = new FileWriter(src, true);
            pw = new PrintWriter(write);
            pw.println("\nTraduccion: ");

        } catch (Exception e) {
            System.out.println("No se encuentra el archivo...");
        }

        try {
            String next;
            while ((next = br.readLine()) != null) 
            {
                String traduccion = "";
                String[] texto = next.split(" ");   //Se separa el texto del archivo por espacios

                for (int i = 0; i < texto.length; i++) {
                    
                    String[] traductor = null;
                    //Busca la palabra en los arboles dependiendo del idioma de entrada
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

                    //Verifica si se logro la traduccion
                    if (traductor == null) 
                    {
                        //Las palabras que no se encuentran en el diccionario
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
            //Se cierra el write
            try {
                if (null != write) 
                {
                    write.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
