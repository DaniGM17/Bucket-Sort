import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author dania
 */
public class BucketSort {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public static float[] leerArreglo(int n) throws IOException {
        float[] a = new float[n];
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < a.length; i++) {
            System.out.println("Escriba el valor [" + i + "]: ");
            entrada = bufer.readLine();
            a[i] = Float.parseFloat(entrada);
        }
        return a;
    }
    
    public static void bucketSort(float[] listaD, int t) {
        if (t <= 0) {
            return;
        }
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] bucket = new ArrayList[t];

        for (int i = 0; i < t; i++) {
            bucket[i] = new ArrayList<Float>();
        }

        for (int i = 0; i < t; i++) {
            int bucketIndex = (int) listaD[i] * t;
            bucket[bucketIndex].add(listaD[i]);
        }

        for (int i = 0; i < t; i++) {
            Collections.sort((bucket[i]));
        }

        int index = 0;
        for (int i = 0; i < t; i++) {
            for (int j = 0, size = bucket[i].size(); j < size; j++) {
                listaD[index++] = bucket[i].get(j);
            }
        }
    }

     public static void imprimirArreglo(float[] a) {
        System.out.println("-------------------------");
        System.out.println("Lista ordenada");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%4d", a[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws IOException {
        float[] array;
        int t;
        System.out.println("Programa que ordena la lista de números");
        System.out.println("Escribe la longitud de la lista a ingresar: ");
        entrada = bufer.readLine();
        t = Integer.parseInt(entrada);
        array = leerArreglo(t);
        bucketSort(array, t);
        imprimirArreglo(array);
    }

}
