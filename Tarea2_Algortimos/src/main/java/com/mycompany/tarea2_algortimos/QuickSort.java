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
public class QuickSort {

    public static void main(String[] args) {
        int[] arreglo = generarArreglo(100);
        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);
        
        quickSort(arreglo,0,arreglo.length-1);
        
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

    public static void quickSort(int[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha);
            quickSort(arreglo, izquierda, indiceParticion - 1);
            quickSort(arreglo, indiceParticion + 1, derecha);
        }
    }

    public static int particion(int[] arreglo, int izquierda, int derecha) {
        int pivote = arreglo[derecha];
        int i = (izquierda - 1);
        for (int j = izquierda; j < derecha; j++) {
            if (arreglo[j] < pivote) {
                i++;
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[derecha];
        arreglo[derecha] = temp;

        return i + 1;
    }



    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
}
