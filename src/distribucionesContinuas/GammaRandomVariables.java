package distribucionesContinuas;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.GammaDistribution;
//https://commons.apache.org/proper/commons-math/javadocs/api-3.5/org/apache/commons/math3/distribution/GammaDistribution.html

/**
 *
 * @author Aurora
 */
public class GammaRandomVariables {
    
    private GammaDistribution distribution;
    private double shape, scale;
    public GammaRandomVariables(double shape, double scale){
        this.shape=shape;
        this.scale=scale;
        this.distribution=new GammaDistribution(shape, scale);
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
