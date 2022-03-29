/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorNumeros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Karyme Nava
 */
public class CongruencialMixto {
    private int semilla;
    private int multiplicador;
    private int constanteAditiva;
    private int modulo;
    
    public CongruencialMixto(){}
    
    public CongruencialMixto(int semilla, int multiplicador, int constante, int modulo){
        this.semilla = semilla;
        this.multiplicador = multiplicador;
        this.constanteAditiva = constante;
        this.modulo = modulo;
    }

    public int getSemilla() {
        return semilla;
    }

    public void setSemilla(int semilla) {
        this.semilla = semilla;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public int getConstanteAditiva() {
        return constanteAditiva;
    }

    public void setConstanteAditiva(int constanteAditiva) {
        this.constanteAditiva = constanteAditiva;
    }

    public int getModulo() {
        return modulo;
    }

    public void setModulo(int modulo) {
        this.modulo = modulo;
    }
    
    public int siguienteValor(int n){
        return ((multiplicador * n + constanteAditiva) % modulo);
    }
    
    public List<Integer> valores(int n){
        List<Integer> valores = new ArrayList<Integer>();
        int act=semilla;
        for(int i=0; i<n; i++){
            valores.add(act);
            act=siguienteValor(act);
        }
        return valores;
    }
    
    public List<Integer> valores(){
        List<Integer> valores = new ArrayList<Integer>();
        int act=siguienteValor(semilla);
        valores.add(semilla);
        while(semilla!=act){
            valores.add(act);
            act=siguienteValor(act);
        }
        return valores;
    }
    
    public List<Double> valoresReales(int n){
        List<Double> valores = new ArrayList<Double>();
        List<Integer> valores2 = valores(n);
        for(int i=0; i<n; i++){
            valores.add((double)valores2.get(i)/(double)modulo);
        }
        return valores;
    }
    
    public List<Double> valoresReales(){
        List<Double> valores = new ArrayList<Double>();
        List<Integer> valores2 = valores();
        for(int i=0; i<valores2.size(); i++){
            valores.add((double)valores2.get(i)/(double)modulo);
        }
        return valores;
    }
}
