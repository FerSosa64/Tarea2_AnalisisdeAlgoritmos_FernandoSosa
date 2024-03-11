/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.tarea2_algortimos;

import java.util.Random;

/**
 *
 * @author Fernando Sosa
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arreglo = generarArreglo(100000);
        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);
        
        heapSort(arreglo);
        
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

    public static void heapSort(int[] arreglo) {
        int n = arreglo.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arreglo, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arreglo[0];
            arreglo[0] = arreglo[i];
            arreglo[i] = temp;

            heapify(arreglo, i, 0);
        }
    }

    public static void heapify(int[] arreglo, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arreglo[l] > arreglo[largest])
            largest = l;

        if (r < n && arreglo[r] > arreglo[largest])
            largest = r;

        if (largest != i) {
            int swap = arreglo[i];
            arreglo[i] = arreglo[largest];
            arreglo[largest] = swap;

            heapify(arreglo, n, largest);
        }
    }

    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
