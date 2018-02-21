
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
public class Compito16022018 {
    
    /**
     * Scandisco il file contentente gli hashtag e li carico 
     * in memoria con i loro attributi
     * @param args
     * @throws IOException 
     */
    public static void main(String args[]) throws IOException{
        
        ArrayList<Hashtag> words = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new FileReader("/home/rodman/Scrivania/Sperimentazione_twitter/11012018_esecuzione_twitter/hash_piu_frequenti.csv"));
        
        String line;
                
        //lego la prima riga con i time_point
        br.readLine();
        
        line = br.readLine();
        while(line!=null) {
            
            String[] temp = line.split(",");
            Hashtag h = new Hashtag(temp[1]);
            words.add(h);
            line = br.readLine();
            
        }
        
        br.close();
        
        BufferedWriter w1 = new BufferedWriter(new FileWriter("/home/rodman/Scrivania/Sperimentazione_twitter/11012018_esecuzione_twitter/hash_pvalue_min_cum_05.txt"));
        BufferedWriter w2 = new BufferedWriter(new FileWriter("/home/rodman/Scrivania/Sperimentazione_twitter/11012018_esecuzione_twitter/hash_pvalue_min_cum_01.txt"));
        BufferedWriter w3 = new BufferedWriter(new FileWriter("/home/rodman/Scrivania/Sperimentazione_twitter/11012018_esecuzione_twitter/hash_pvalue_min_cum_001.txt"));
        BufferedWriter w4 = new BufferedWriter(new FileWriter("/home/rodman/Scrivania/Sperimentazione_twitter/11012018_esecuzione_twitter/hash_pvalue_min_point_05.txt"));
        BufferedWriter w5 = new BufferedWriter(new FileWriter("/home/rodman/Scrivania/Sperimentazione_twitter/11012018_esecuzione_twitter/hash_pvalue_min_point_01.txt"));
        BufferedWriter w6 = new BufferedWriter(new FileWriter("/home/rodman/Scrivania/Sperimentazione_twitter/11012018_esecuzione_twitter/hash_pvalue_min_point_001.txt"));
        
        List<Pvalue> list_pvalue;
        for(int i = 0; i < words.size(); i++){
            list_pvalue = words.get(i).get_pValueMin_cum(0.05);
            w1.write(words.get(i).getTag()+" "+list_pvalue+"\n");
            list_pvalue = words.get(i).get_pValueMin_cum(0.01);
            w2.write(words.get(i).getTag()+" "+list_pvalue+"\n");
            list_pvalue = words.get(i).get_pValueMin_cum(0.001);
            w3.write(words.get(i).getTag()+" "+list_pvalue+"\n");
            
            list_pvalue = words.get(i).get_pValueMin_point(0.05);
            w4.write(words.get(i).getTag()+" "+list_pvalue+"\n");
            list_pvalue = words.get(i).get_pValueMin_point(0.01);
            w5.write(words.get(i).getTag()+" "+list_pvalue+"\n");
            list_pvalue = words.get(i).get_pValueMin_point(0.001);
            w6.write(words.get(i).getTag()+" "+list_pvalue+"\n");
                
        }
        
        w1.close();
        w2.close();
        w3.close();
        w4.close();
        w5.close();
        w6.close();
        //System.out.println(words.toString());
        

    }
    
    
}
