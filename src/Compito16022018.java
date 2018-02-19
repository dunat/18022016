
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
        System.out.println(words.toString());
        

    }
    
    
}
