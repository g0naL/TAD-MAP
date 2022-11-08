/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tadmapa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author roimo
 */
public class HashMap <K,V> implements TADMap <K,V>{
   
    private List <HashItem<K,V>>[] map;
    
    public HashMap (){
        map = new List[20];
       for(int i = 0; i < map.length; i++){
            map[i] = new ArrayList<>();
        }
    }
    
    public int funcionHash(K clave){
        return Math.abs(Math.abs(clave.hashCode()))% map.length;
    }
    
    public void clear (){
        for(List <HashItem<K,V>> li : map){
            
        }
    }
    
    public boolean containsKey(K k){
        int index = funcionHash(k);
        for(HashItem hi : map[index]){
            if (hi.getClave().equals(k)){
                return true;
            }
        }
        return false;
    }
    
    public boolean containsValue(V v){
        for( List<HashItem<K, V>> li : map){
            for(HashItem <K,V> hi : li){
                if(hi.getClave().equals(v)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public int size(){
        int numElem = 0;
        for(List <HashItem<K,V>> li : map){
            numElem += li.size();
        }
        return numElem;
    }
    
    public boolean isEmpty(){
        for (List <HashItem<K,V>> hi : map){
            if(!hi.isEmpty()){
                return false;
            }
        }
        return true;
    }
    
    
    public V get (K k){
        int index = funcionHash(k);
        for(HashItem <K,V> ha : map[index]){
            if (ha.getClave().equals(k)){
                return ha.getValor();
            }
        }
        return null;
    }
    
    public void put(K k, V v) {
       
        if(get(k) == null){  //get(k) = clave, entonces si esa clave no está en la lista, añadimos el par de datos
          int index = funcionHash(k);
          map[index].add(new HashItem (k,v));
        }else{
           remove (k);
           int index = funcionHash(k);
           map[index].add(new HashItem (k,v));
        }
        
    }
    
    
    public V remove(K k) {
        V viejo = null;
        int index = funcionHash(k);
        for(HashItem ha : map[index]){
            if(ha.getClave().equals(k)){
                viejo = get(k);
                map[index].remove(ha);
                return viejo;
            }
        }
        return null;
    }
    

    
    public Iterator<K> getClaves(){
        List <K> claves= new ArrayList();
        for( List <HashItem<K,V>> li : map){
            for( HashItem <K,V> hi : li){
                claves.add(hi.getClave());
            }
        }
        return claves.iterator();
    }
    
    
    public Iterator<V> getValues(){
        List<V> valores = new ArrayList<>();
        for (List<HashItem<K,V>> li : map){
            for (HashItem<K,V> hi : li){
               valores.add(hi.getValor()); 
            }
        }
        return valores.iterator();
    }
    
//    public Iterable<HashItem<K,V>> getSets(){
//        List <HashItem <K ,V>> KV = new ArrayList<>();
//        for ( List < HashItem <K,V>> li : map){
//            KV.add(li.get());
//        }
//    }
}
