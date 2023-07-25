/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author Marina
 */
public class concreta1 implements OrdenamientoStrategy{

    @Override
    public void ordenar(int[] array) {
         int n = array.length;
    for (int i = 1; i < n; i++) {
        int key = array[i];
        int j = i - 1;

        // Mover los elementos mayores que la "key" hacia adelante
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j--;
        }
        
        // Colocar la "key" en su posición correcta
        array[j + 1] = key;
    }
    }
    
}
