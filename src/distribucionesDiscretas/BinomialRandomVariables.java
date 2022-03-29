package distribucionesDiscretas;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.BinomialDistribution;
// https://commons.apache.org/proper/commons-math/javadocs/api-3.5/org/apache/commons/math3/distribution/BinomialDistribution.html

/**
 *
 * @author Aurora
 */
public class BinomialRandomVariables {
    private BinomialDistribution distribucion;
    private double probability;
    private int trials;
    
    // Esta distribucion se debe inicializar con el numero de 
    // La probabilidad estimada es la suma del nimero de veces que se obtuvo un resultado multiplicado por el resultado. Eso dividido entre el numero de veces repetido multiplicado por los objetos analizados en cada vez
    // https://www.youtube.com/watch?v=DXKn_0ceN-8
    public BinomialRandomVariables (double probability, int trials){
        this.trials = trials;
        this.probability = probability;
        this.distribucion = new BinomialDistribution(trials, probability);
    }
    
    public List<Double> density(List<Integer> X){
        List<Double> R=new ArrayList<Double>();        
        for(Integer v: X){
            //For a random variable X whose values are distributed according to this distribution, this method returns P(X = x). Retorna probabilidad de que X=x
            R.add(this.distribucion.probability(v)); 
        }        
        return R;
    }
    
    public List<Double> cumulative(List<Integer> X){
        List<Double> R=new ArrayList<Double>();        
        for(Integer v: X){
            // For a random variable X whose values are distributed according to this distribution, this method returns P(X <= x). Retorna probabilidad de que sea cualquier valor <=x
            R.add(this.distribucion.cumulativeProbability(v)); 
        }        
        return R;
    }
    
    public List<Integer> inverse (List<Double> P){
        List<Integer> R=new ArrayList<Integer>();
        
        for(Double v: P){
            // El inverso de la distribución acumulativa es una función que nos provee un valor específico de la variable asociado a un valor de probabilidad acumulada
            R.add(this.distribucion.inverseCumulativeProbability(v)); 
        }        
        return R;
    }   
}