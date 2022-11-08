package tadmap;
import java.util.Map;
/**
 *
 * @author Matteo

 */
public interface Polinomio{
// Produce: Inicializa this al polinomio cero
    
    public int grado();
    
    // Produce: Devuelve el grado del polinomio, es decir, el mayor exponente de un
    // término con coeficiente distinto de cero. Devuelve 0 si es el polinomio cero.

    public double coeficiente(int n);

    // Produce: Devuelve el coeficiente del término de grado n. Si el término no existe,
    // devuelve 0.


    public void añadirTermino(int exponente, double coeficiente) throws IllegalArgumentException;
    
    // Modifica: this
    // Produce: si el exponente es negativo o el coeficiente es 0 lanza la excepción
    // IllegalArgumentException; en otro caso, añade el termino (coeficiente x exponente) a
    // this


    public void eliminarTermino(int exponente);
    
    // Modifica: this
    // Produce: elimina el término con exponente que se pasa como parámetro


    public Map suma(Map<Integer,Double> p);
    
    // Produce: un nuevo polinomio que es la suma de los polinomios p y this


    public Map derivada();
    
    // Produce: Dado el polinomio this de la forma anxn + an-1xn-1 + …+ a1x1 + a0x0
    // devuelve su derivada: (n*an) xn-1+ (n-1 * an-1) xn-2 + …+ a1
}
