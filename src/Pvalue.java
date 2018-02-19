/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rodman
 */
public class Pvalue {
    
    private double value;
    private int time_point;
    
    public Pvalue(double d, int t){
        this.value = d;
        this.time_point = t;
    }
    
    double get_value(){
        return this.value;
    }
    
    int get_time_point(){
        return this.time_point;
    }
    
    @Override
     public String toString(){
        String s = "p:"+this.value +", t:"+ this.time_point;
        return s;
    }
    
}
