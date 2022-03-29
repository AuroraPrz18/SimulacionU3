package distribucionesContinuas;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.LogNormalDistribution;
// https://commons.apache.org/proper/commons-math/javadocs/api-3.5/org/apache/commons/math3/distribution/LogNormalDistribution.html

/**
 *
 * @author Aurora
 */
public class LognormalRandomVariables {
    private LogNormalDistribution distribution;
    double scale, shape;
    
    public LognormalRandomVariables (double scale, double shape){
        this.scale=scale;
        this.shape=shape;
        distribution=new LogNormalDistribution(); // Create a log-normal distribution using the specified scale and shape.
        // NOTA: Hay un constructor vacio que inicializa lo anterior (Create a log-normal distribution, where the mean and standard deviation of the normally distributed natural logarithm of the log-normal distribution are equal to zero and one respectively.)
    }    
    
    //Permite calcular una probabilidad dada la funciones de densidad/funcion acumulada/ inverso de la acumulada
    public List<Double> density(List<Double> Z){
        List<Double> R=new ArrayList<Double>();
        
        for(Double v: Z){
            // Returns the probability density function (PDF) of this distribution evaluated at the specified point Z.
            R.add(this.distribution.density(v)); 
        }
        
        return R;
    }
    
    public List<Double> cumulative(List<Double> Z){
        List<Double> R=new ArrayList<Double>();
        
        for(Double v: Z){
            // For a random variable Z whose values are distributed according to this distribution, this method returns P(Z <= z).
            R.add(this.distribution.cumulativeProbability(v)); 
        }
        
        return R;
    }
    
    public List<Double> inverse (List<Double> P){
        List<Double> R=new ArrayList<Double>();
        
        for(Double v: P){
            R.add(this.distribution.inverseCumulativeProbability(v)); 
        }
        
        return R;
    }
    
}
