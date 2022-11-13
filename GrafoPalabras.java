package p6;

import java.util.*;
import grafo.*;

public final class GrafoPalabras {

    HashMap<String, List<String>> palabras;
    ListaAdyacencia<String, Integer> grafoPalabras;

    public GrafoPalabras(List<String> palabras) {
        insertarPalabras(palabras);
        insertarVertices(palabras);
        insertarArcos();
    }

    public void insertarArcos() {
        for (Iterator<String> claves = palabras.getClaves(); claves.hasNext();) {
            List<String> lista = palabras.get(claves.next());

            if (lista.size() > 1) {
                for (int i = 0; i < lista.size(); i++) {
                    for (int j = i + 1; j < lista.size(); j++) {
                        Arco ida = new Arco(new Vertice(lista.get(i)), new Vertice(lista.get(j)), 0);
                        Arco vuelta = new Arco(new Vertice(lista.get(j)), new Vertice(lista.get(i)), 0);
                        grafoPalabras.insertarArco(ida);
                        grafoPalabras.insertarArco(vuelta);
                    }

                }
            }
        }
    }

    public void insertarVertices(List<String> p) {
        for (String palabra : p) {
            grafoPalabras.insertarVertice(new Vertice<>(palabra));
        }
    }

    //Suponemos que las palabras estan separadas por una coma ','
    public void insertarPalabras(List<String> p) throws IllegalArgumentException {
        if (p.isEmpty()) {
            throw new IllegalArgumentException("Lista vacía");
        } else {
            for (String palabra : p) {
                List<String> aux = new ArrayList();
                for (int i = 0; i < palabra.length(); i++) {
                    String clave = reemplazaCaracter(palabra, i, '_');
                    if (!palabras.containsKey(clave)) {
                        aux.add(palabra);
                        palabras.put(clave, aux);
                        aux.clear();
                    } else {
                        aux = palabras.get(clave);
                        aux.add(palabra);
                        palabras.put(clave, aux);
                        aux.clear();
                    }
                }
            }
        }
    }

    //Reemplaza el caracter de la posicion indicada por otro caracter que quieras, en este caso lo uso para sustituir por '_' para la clave
    public static String reemplazaCaracter(String str, int pos, char letra) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == pos) {
                sb.append(letra);
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
    

