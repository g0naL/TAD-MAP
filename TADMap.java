package tadmapa;

import java.util.Iterator;
import java.util.Map.Entry;


public interface TADMap <K,V>{
    abstract interface Map<K,V> {
   
    void clear(); //Limpia toda el mapa
   
    boolean containsKey(K key); //Devuelve un boolean diciendo si contiene la llave
   
    boolean containsValue(V value); //Devuelve un boolean diciendo si una llave o llaves contienen el valor
   
    int size(); //devuelve el número de enteros dentro del mapa
   
    boolean isEmpty(); //devuelve un boolean diciendo si el mapa está vacío
   
    @Override
    int hashCode(); //devuelve el valor del hashcode para este mapa
     
    V get (K key); //Devuelve el valor asociado a la llave, si no tiene asociado ningun valor devuelve null
   
    V put (K key, V value); //Coloca el par clave-valor en el mapa. Si la clave ya existiera, sobrescribe el anterior valor y devuelve el objeto antiguo. Si esa clave no aparecía en la lista, devuelve null
   
    V remove(K key); //Elimina el valor asociado a la llave, si la llave tenía un valor asociado devuelve ese objeto, sino devuelve null
   
    Iterable<K> getClaves(); //Devuelve la coleccion de llaves del mapa
   
    Iterable<V> getValues(); //Devuelve la colección de valores del mapa
   
    Iterable<Entry<K,V>> getSets(); //Devuelve todos los elementos del mapa  
   
}
}
