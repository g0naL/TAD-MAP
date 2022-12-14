/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2b;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.json.*;

/**
 *
 * @author lucas
 */
public class extender {
    
    private static final Map<String, Map <String, String>> Abreviaturas = new HashMap<>();
    
    public static void main (String[] args){
        
        String mensaje= "Bonne apt fidbhdg";
        String extension = extensionAbreviaturas (mensaje, "fr");
        
        System.out.println("mensaje descomprimido:" + extension);
        
        
        
    }
    
    private static final Map<String, Map<String,String>> htAbbreviations = new HashMap<>();
    
    static { 
        for (String i : new String[]{"abbrev.es.json", 
                                     "abbrev.en.json",
                                     "abbrev.fr.json"
        }) {

            String lang = i.substring(7, 9).toUpperCase();
            InputStream is = ExtendAbreviaturas.class.getResourceAsStream(i);  // abre archivo
            JsonReader rdr = Json.createReader(is); // creo u nobjeto de lectura sobre el archivo
            JsonObject jsonObject = rdr.readObject();
            rdr.close();
            Map<String, String> dict = new HashMap<>();
            jsonObject.keySet().forEach((abbrev) -> {
                dict.put(abbrev, jsonObject.getString(abbrev));
            });
            htAbbreviations.put(lang, dict);
        }
    }
    
  /**
     * traduccionAbreviaturas. Este método devuelve un nuevo texto con las abreviaturas extendidas
     * según su idioma correspondiente.
     * @param textoExtender 
     * @param idioma (limitado a Español (ES), Inglés (EN), Francés (FR))
     * @return Texto traducido
     */ 
    
   public static String extensionAbreviaturas (String textoExtender, String idioma) {        
        idioma = idioma.toUpperCase();
        
        if(textoExtender == null) return "Texto vacío";
        
        if(!htAbbreviations.containsKey(idioma)) return "No existe el idioma";
        
        Map<String, String> dic = htAbbreviations.get(idioma);
        String[] abreviaciones = textoExtender.split(" ");
        String texto = "";
        
        for(int i=0; i<abreviaciones.length; i++){
            
            if(dic.containsKey(abreviaciones[i])){
                
                texto = texto.concat(dic.get(abreviaciones[i]));
            
            }else {
                
                texto = texto.concat(abreviaciones[i]);
            }
            
            texto = texto.concat(" ");
        }
        
        texto = texto.substring(0, texto.length()-1);
        return texto;
   }
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object put(Object key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Iterable keySet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Iterable values() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Iterable entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void insertar(String abbrev, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      
}

    
    
    
    
    
    
}
