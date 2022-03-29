package distribucionesDiscretas;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.PoissonDistribution;
//https://commons.apache.org/proper/commons-math/javadocs/api-3.5/org/apache/commons/math3/distribution/PoissonDistribution.html
/**
 *
 * @author Aurora
 */
public class PoissonRandomVariable {
    private double lambda;
    private PoissonDistribution distribution;
    public PoissonRandomVariable(double lambda){ 
        this.lambda = lambda; //Parametro es la media de Poisson
        this.distribution =new PoissonDistribution(lambda);
    }
     public List<Double> density(List<Integer> X){ // Es entero porque son los defectos (o algo así)
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