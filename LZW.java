/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tadmapa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author andre
 */
public class LZW {
    
    Map<String, List<Integer>> primdicc;
    Map<Integer, List<String>> segdicc;
    
//    public void inicio() {
//        for(int i = 0; i < 256; i++) {
//            String aux = Character.toString(i);
//            List<Integer> valor = new ArrayList();
//            valor.add(i);
//            primdicc.put(aux, valor);
//        }
//        
//        for(int i = 0; i < 256; i++) {
//            List<String> letras = new ArrayList();
//            letras.add(Character.toString(i));
//            segdicc.put(i, letras);
//        }
//    }
    
    public String comprimir(String x) {
        
        for(int i = 0; i < 256; i++) {
            String aux = Character.toString(i);
            List<Integer> valor = new ArrayList();
            valor.add(i);
            primdicc.put(aux, valor);
        }
        
        int cont = 0;
        int numCod = 256;
        String resultado = "";
        String C = "";
        while(cont < x.length()) {
            String K = Character.toString(x.charAt(cont));
            if(primdicc.containsKey(C.concat(K))) {
                C = C.concat(K);
            }
            else {
                List<Integer> codigo = new ArrayList();
                codigo.add(numCod);
                primdicc.put(C.concat(K), codigo);
                resultado = resultado + Integer.toString(primdicc.get(C).get(0)) + "-";
                C = K;
                numCod++;
            }
            cont++;
        }
        
        System.out.println(resultado);
        return resultado;
    }
    
    public String descomprimir(String x) {
        
        for(int i = 0; i < 256; i++) {
            List<String> letras = new ArrayList();
            letras.add(Character.toString(i));
            segdicc.put(i, letras);
        }
        
        int cont = 0;
        int Old;
        int New;
        String Cad = "";
        String Car;
        String aux = "";
        String resultado = "";
        int NumCod = 256;
        
        while(x.charAt(cont) != '-') {
            aux = aux + Character.toString(x.charAt(cont));
            cont++;
        }
        cont++;
        Old = Integer.parseInt(aux);
        Car = segdicc.get(Old).get(0);
        resultado = resultado + Car;
        
        while(cont < x.length()) {
            while(x.charAt(cont) != '-') {
                aux = aux + Character.toString(x.charAt(cont));
                cont++;
            }
            cont++;
            New = Integer.parseInt(aux);
            if (!segdicc.containsKey(New)) {
                
            }
            else {
                Cad = segdicc.get(New).get(0);
            }
            resultado = resultado + Cad;
            Car = Character.toString(Cad.charAt(0));
            List<String> trad = new ArrayList();
            
            }

    }
}
