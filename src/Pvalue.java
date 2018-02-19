/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe che implementa i p_value
 * @author rodman
 */
public class Pvalue {
    
    private final double value;
    private final int time_point;
    
    /**
     * Crea un p_value
     * @param d value
     * @param t time_point
     */
    public Pvalue(double d, int t){
        this.value = d;
        this.time_point = t;
    }
    
    /**
     * 
     * @return il p_value
     */
    double get_value(){
        return this.value;
    }
    /**
     * 
     * @returntime_point
     */
    int get_time_point(){
        return this.time_point;
    }
    
    /**
     * 
     * @return stampa del p_value e del time_point
     */
    @Override
     public String toString(){
        String s = "p:"+this.value +", t:"+ this.time_point;
        return s;
    }
    
}
