package tadmap;
import java.util.Map;
/**
 *
 * @author Matteo
 */
public class TADPolinomio implements Polinomio{
    
    Map <Integer, Double> polinomio;
    
    public TADPolinomio(){
        polinomio = (Map<Integer, Double>) new HashMap<Integer, Double>();
    }
    
    @Override
    public int grado() {
        if (polinomio.isEmpty()){
            return 0;
        }
        else {
            int i = 0;
            int j = 0;
            while(i != polinomio.size()){
                if(polinomio.containsKey(j)){
                    i++;
                    j++;
                }else{
                    j++;
                }
            }
            return j;
        }    
    }

    @Override
    public double coeficiente(int n) {
        if(polinomio.get(n) == null){
            return 0;
        }
        else{
           return polinomio.get(n); 
        }
    }

    @Override
    public void añadirTermino(int exponente, double coeficiente) throws IllegalArgumentException {
        if (exponente<0){
            throw new IllegalArgumentException("El valor del exponente es negativo");
        }
        else if(coeficiente == 0){
            throw new IllegalArgumentException("El coeficiente es igual a 0");
        }
        else{
            polinomio.put(exponente, coeficiente);
        }
    }

    @Override
    public void eliminarTermino(int exponente) {
        polinomio.remove(exponente);
    }

    public Map<Integer, Double> suma(Map<Integer, Double> p) {
        
        if (p.isEmpty()){
            return polinomio;
        }
        else {
            int i = 0;
            int j = 0;
            while(i != p.size()){
                if(p.containsKey(j)){
                    if(polinomio.containsKey(j)){
                        double num= (polinomio.get(j)+p.get(j));
                        polinomio.put(j,num);
                    }
                    polinomio.put(j,p.get(j));
                    i++;
                    j++;
                }else{
                    j++;
                }
            }
            return polinomio;
        } 
    }

    public Map derivada() {
        
        if(polinomio.isEmpty()){
            return polinomio;
        }
        else{
            int i = 0;
            int j = 0;
            while(i != polinomio.size()){
                if(polinomio.containsKey(j)){
                    double der = polinomio.get(j)*j;
                    polinomio.remove(j);
                    polinomio.put(j--, der); 
                    i++;
                    j++;
                }
                else{
                    j++;
                }
            }
            return polinomio;
        }
    }

    
}
