package distribucionesContinuas;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.BetaDistribution;
//https://commons.apache.org/proper/commons-math/javadocs/api-3.5/org/apache/commons/math3/distribution/BetaDistribution.html

/**
 *
 * @author Aurora
 */
public class BetaRandomVariables {
    
    private BetaDistribution distribution;
    private double alpha, beta;
    public BetaRandomVariables(double alpha, double beta){
        this.alpha=alpha;
        this.beta=beta;
        this.distribution=new BetaDistribution(alpha, beta);
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
            // Computes the quantile function of this distribution.
            R.add(this.distribution.inverseCumulativeProbability(v)); 
        }
        
        return R;
    }
    
}
