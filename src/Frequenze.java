/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe che implementa le frequenze
 * @author rodman
 */
public class Frequenze {
    
    private final int freq;
    private final int time_point;
    
    public Frequenze(int f, int t){
        this.time_point = t;
        this.freq = f;
        
    }
    
    /**
     * 
     * @return frequenza
     */
    int get_freq(){
        return this.freq;
    }
    
    /**
     * 
     * @return time_point
     */
    int get_time_point(){
        return this.time_point;
    }
    
    /**
     * 
     * @return stampa frequenza e time_point
     */
    @Override
    public String toString(){
        String s = "f:"+this.freq +", t:"+ this.time_point;
        return s;
    }
}
