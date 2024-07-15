package Ejercicio;

import java.util.ArrayList;
import java.util.List;

/*
 * Dados n pares de paréntesis, implementa un algoritmo para generar todas las combinaciones
 * válidas de paréntesis.
 *
 * Ejemplo 1:
 *  Input:
 *    n: 1
 *  Output:
 *    ["()"]
 *
 * Ejemplo 2:
 *  Input:
 *    n: 3
 *  Output:
 *    ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Ecoja la mejor estructura de datos para que sea mas eficiente
 * Se debe usar StringBuilder
 */
public class EjercicioDos {
    public List<String> generateParenthesis(int n) {
        List<String> resultado = new ArrayList<>();
        generate(resultado, new StringBuilder(), 0, 0, n);
        return resultado;
    }

    private void generate(List<String> resultado, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            resultado.add(current.toString());
            return;
        }

        if (open < max) {
            current.append('(');
            generate(resultado, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        if (close < open) {
            current.append(')');
            generate(resultado, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
