package com.mycompany.tarea2_algortimos;

import java.util.Random;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arreglo = generarArreglo(10000);
        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);
        
        selectionSort(arreglo);
        
        System.out.println("\nArreglo ordenado:");
        imprimirArreglo(arreglo);
    }

    public static int[] generarArreglo(int cantidad) {
        int[] arreglo = new int[cantidad];
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            arreglo[i] = i + 1;
        }

        for (int i = 0; i < cantidad; i++) {
            int indiceAleatorio = random.nextInt(cantidad);
            int temp = arreglo[i];
            arreglo[i] = arreglo[indiceAleatorio];
            arreglo[indiceAleatorio] = temp;
        }

        return arreglo;
    }

    public static void selectionSort(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arreglo[j] < arreglo[min_idx])
                    min_idx = j;
            int temp = arreglo[min_idx];
            arreglo[min_idx] = arreglo[i];
            arreglo[i] = temp;
        }
    }

    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
}
