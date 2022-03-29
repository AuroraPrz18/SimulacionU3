package distribucionesContinuas;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.NormalDistribution;
// https://commons.apache.org/proper/commons-math/javadocs/api-3.5/org/apache/commons/math3/distribution/NormalDistribution.html

public class NormalRandomVariable {

    private NormalDistribution distribution;
    private double mean;
    private double standardesviation;
    
    public NormalRandomVariable(){
        distribution=new NormalDistribution(); // Create a normal distribution with mean equal to zero and standard deviation equal to one.
        this.mean=0.00;
        this.standardesviation=1.00;
    }
    
    public NormalRandomVariable(double mean, double standarddesviation){
        this.mean=mean;
        this.standardesviation=standarddesviation;
        this.distribution=new NormalDistribution(mean,standarddesviation);
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
