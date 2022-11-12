
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
            } else {
                aux = m.get(clave);
                aux.add(",");
                aux.add(p);
                m.put(clave, aux);
            }
        }
    }

    public void rellenarGrafo(){
        
    }
    
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
