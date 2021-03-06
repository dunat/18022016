
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rodman
 */
public class Hashtag {
    
    private String tag;
    private final ArrayList<Frequenze> frequenze;
    private final List<Pvalue> cum;
    private final List<Pvalue> point;
    private int data_creazione;
    
    /**
     * Costruttore di hashtag
     * @param w Hashtag da caricare
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public Hashtag(String w) throws FileNotFoundException, IOException{
        
        //aggiungo le frequenze
        frequenze = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("/home/rodman/Scrivania/Sperimentazione_twitter/11012018_esecuzione_twitter/hash_piu_frequenti.csv"));
        
        String line;
                
        //lego la prima riga con i time_point
        line = br.readLine();
        String time[] = line.split(",");
        
        //leggo le restanti righe
        line = br.readLine();
        while(line!=null) {
            
            String[] word = line.split(",");
            //controllo se la stringa che leggo e' l'hashtag che sto creando
            if(word[1].equals(w)){
                this.tag = word[1];
                for(int i = 2; i < word.length; i++){
                    //salvo le frequenze relative all'hashtag
                    Frequenze ff = new Frequenze(Integer.parseInt(word[i]),Integer.parseInt(time[i])); 
                    this.frequenze.add(ff);
                }
            }  
            line = br.readLine();
            
        }
        
        br.close();
        
        //aggiungo i cum
        br = new BufferedReader(new FileReader("/home/rodman/Scrivania/Sperimentazione_twitter/11012018_esecuzione_twitter/p-value-freq_CUM.csv"));
        this.cum = new ArrayList<>();       
        //lego la prima riga con i time_point
        br.readLine();
        
        line = br.readLine();
        while(line!=null) {
            
            String[] word = line.split(",");
            if(word[1].equals(w)){
                for(int i = 2; i < word.length; i++){
                    //salvo i p_value cumulativi
                    Pvalue pp = new Pvalue(Double.parseDouble(word[i]),Integer.parseInt(time[i]));
                    this.cum.add(pp);
                }
            }
            line = br.readLine();
        }
        br.close();
        
        //aggiungo i point
        br = new BufferedReader(new FileReader("/home/rodman/Scrivania/Sperimentazione_twitter/11012018_esecuzione_twitter/p-value-freq_POINT.csv"));
        this.point = new ArrayList<>(); 
        //lego la prima riga con i time_point
        br.readLine();
        
        line = br.readLine();
        while(line!=null) {
            
            String[] word = line.split(",");
            if(word[1].equals(w)){
                for(int i = 2; i < word.length; i++){
                    //salvo i p_value pointwise
                    Pvalue pp = new Pvalue(Double.parseDouble(word[i]),Integer.parseInt(time[i]));
                    this.point.add(pp);
                }
            }
            line = br.readLine();
        }
        br.close();
        
        //mi segno la data di creazione dell'hashtag
        int in = 0;
        this.data_creazione = Integer.parseInt(time[2]);
        while(in < this.frequenze.size() && this.frequenze.get(in).get_freq()==0){           
            this.data_creazione = this.frequenze.get(in).get_time_point();
            in++;
        }
    }
    
    /**
     * recupero i p_value cumulativi piu' piccoli
     * @param s soglia minima
     * @return lista dei p_value minori di una certa soglia
     */
    List<Pvalue> get_pValueMin_cum (double s){
        ArrayList<Pvalue> l = new ArrayList<>();
        
        for(int i = 0; i < this.cum.size(); i++){
            if(this.cum.get(i).get_value() <= s){
                if(this.data_creazione < this.cum.get(i).get_time_point()){
                    l.add(this.cum.get(i));
                }
            }
        }
        
        return l;
    }
    
    /**
     * recupero i p_value pointwise piu' piccoli
     * @param s soglia minima
     * @return lista dei p_value minori di una certa soglia
     */
    List<Pvalue> get_pValueMin_point (double s){
        ArrayList<Pvalue> l = new ArrayList<>();
        
        for(int i = 0; i < this.point.size(); i++){
            if(this.point.get(i).get_value() <= s){
                if(this.data_creazione < this.point.get(i).get_time_point()){
                
                l.add(this.point.get(i));
                }
            }
        }
        
        return l;
    }
    
    /**
     * 
     * @return tag
     */
    String getTag(){
        return this.tag;
    }
    
    /**
     *  metodo toString
     * @return stampa a video dell'hashtag e dei suoi attributi
     */
    @Override
    public String toString(){
        String s = this.tag +" Data Creazione: "+this.data_creazione+ "\nFreq: "+this.frequenze + "\nCum: "+this.cum + "\nPoint: "+this.point+"\n";
        return s;
    }
    
    
    
}
