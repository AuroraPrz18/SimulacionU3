package distribucionesDiscretas;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.GeometricDistribution;
// https://commons.apache.org/proper/commons-math/javadocs/api-3.5/org/apache/commons/math3/distribution/GeometricDistribution.html

/**
 *
 * @author Aurora
 */
public class GeometricaRandomVariables {
    private double p;
    private GeometricDistribution distribution;
    
    public GeometricaRandomVariables(double p){ 
        this.p = p; 
        this.distribution =new GeometricDistribution(p); // Create a geometric distribution with the given probability of success.
    }
    
    public List<Double> density(List<Integer> X){ 
        List<Double> R=new ArrayList<Double>();        
        for(Integer v: X){
            // For a random variable X whose values are distributed according to this distribution, this method returns P(X = x).
            R.add(this.distribution.probability(v)); 
        }        
        return R;
    }
    
    public List<Double> cumulative(List<Integer> X){
        List<Double> R=new ArrayList<Double>();        
        for(Integer v: X){
            // For a random variable X whose values are distributed according to this distribution, this method returns P(X <= x).
            R.add(this.distribution.cumulativeProbability(v)); 
        }        
        return R;
    }
    
    public List<Integer> inverse (List<Double> P){ //Recibimos probabilidad
        List<Integer> R=new ArrayList<Integer>();        
        for(Double v: P){
            R.add(this.distribution.inverseCumulativeProbability(v)); 
        }        
        return R;
    }
}