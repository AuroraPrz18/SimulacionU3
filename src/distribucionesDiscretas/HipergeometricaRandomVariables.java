package distribucionesDiscretas;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.HypergeometricDistribution;
// https://commons.apache.org/proper/commons-math/javadocs/api-3.5/org/apache/commons/math3/distribution/HypergeometricDistribution.html

/**
 *
 * @author Aurora
 */
public class HipergeometricaRandomVariables {
    private int populationSize, numberOfSuccesses, sampleSize;
    private HypergeometricDistribution distribution;
    
    public HipergeometricaRandomVariables(int populationSize, int numberOfSuccesses, int sampleSize){ 
        this.populationSize = populationSize; 
        this.numberOfSuccesses = numberOfSuccesses; 
        this.sampleSize = sampleSize; 
        this.distribution =new HypergeometricDistribution(populationSize, numberOfSuccesses, sampleSize); // Construct a new hypergeometric distribution with the specified population size, number of successes in the population, and sample size.
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
