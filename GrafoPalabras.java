package p6;

import java.util.*;
import grafo.*;

public class GrafoPalabras {
    Map<String, List<String>> m;
    ListaAdyacencia<String, Integer> grafoPalabras; 
  
    public void insertarPalabra(String p) {
        List<String> aux = new ArrayList();
        for (int i = 0; i < p.length(); i++) {
            String clave = reemplazaCaracter(p, i, '_');
            if (!m.containsKey(clave)) {
                aux.add(p);
                m.put(clave, aux);
                m.clear();
            } else {
                aux = m.get(clave);
                aux.add(",");
                aux.add(p);
                m.put(clave, aux);
                m.clear();
            }
        }
    }

    public void rellenarGrafo(){
        
    }
    //Reemplaza en la posicion que le pases un caracter de la palabra, ejemplo: reemplazarCaracter(Hola, 1, '_') = H_la
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
