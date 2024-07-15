package Ejercicio;

import java.util.ArrayList;
import java.util.List;

/*
 * Implementa un método para devolver todos los subconjuntos de un arreglo de enteros
 * 
 * Se puede sin recursividad
 * Ejemplo:
 *  Input: [1,2,3]
 *
 *  Output:
 *    [
 *      [1,2,3],
 *      [1,2],
 *      [1,3],
 *      [2,3],
 *      [1],
 *      [2],
 *      [3],
 *      []
 *    ]
 * 
 * El  metodo me debe devolver una lista de listas de enteros. 
 * Se puede usar varios metodos 
 * 
 * Ecoja la mejor estructura de datos para que sea mas eficiente
 */
public class EjercicioUno {

    public List<List<Integer>> subsets(List<Integer> set) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(set, 0, new ArrayList<>(), result);

        return result;
    }

    public void generateSubsets(List<Integer> set, int index, List<Integer> currentSubset, List<List<Integer>> result){
        if (index == set.size()){
            result.add(new ArrayList<>(currentSubset));
            return;

        }
        currentSubset.add(set.get(index));
        generateSubsets(set, index + 1, currentSubset, result);

        currentSubset.remove(currentSubset.size() - 1);
        generateSubsets(set, index + 1, currentSubset, result);

    }
}
