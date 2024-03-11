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
public class BubbleSort {

    public static void main(String[] args) {
        int[] arreglo = generarArreglo(10000);
        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);
        
        bubbleSort(arreglo);
        
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

    public static void bubbleSort(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }


    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
}
