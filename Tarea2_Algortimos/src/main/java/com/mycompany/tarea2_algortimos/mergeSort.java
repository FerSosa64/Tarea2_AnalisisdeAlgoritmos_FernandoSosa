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
public class mergeSort {

    public static void main(String[] args) {
        int[] arreglo = generarArreglo(10000);
        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);
        
        mergeSort(arreglo,0,arreglo.length-1);
        
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

    public static void mergeSort(int[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            mergeSort(arreglo, izquierda, medio);
            mergeSort(arreglo, medio + 1, derecha);
            merge(arreglo, izquierda, medio, derecha);
        }
    }

    public static void merge(int[] arreglo, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arreglo[izquierda + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arreglo[medio + 1 + j];

        int i = 0, j = 0;

        int k = izquierda;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arreglo[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arreglo[k] = R[j];
            j++;
            k++;
        }
    }



    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
