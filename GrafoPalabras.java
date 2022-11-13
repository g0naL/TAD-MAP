package p6;

import java.util.*;
import grafo.*;

public final class GrafoPalabras {

    Map<String, List<String>> palabras;
    ListaAdyacencia<String, Integer> grafoPalabras;
    
    public GrafoPalabras(List<String> palabras){
        insertarPalabras(palabras);
        insertarVertices(palabras);
        insertarArcos();
    }
    //SIN ACABAR
    public void insertarArcos() {
        for (String clave : palabras.keySet()) {
            Iterator<Vertice<String>> it = grafoPalabras.vertices();
        }
    }
    
    public void insertarVertices(List<String> p){
        for(String palabra : p){
            Vertice<String> aux;
            aux.setEtiqueta(palabra);
            if(!grafoPalabras.estaVertice(aux))
                grafoPalabras.insertarVertice(aux);
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
                        aux.add(",");
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
    

