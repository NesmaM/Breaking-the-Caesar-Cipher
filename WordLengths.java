import java.io.File;
import edu.duke.*;

/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {
    
    public void countWordLengths (FileResource resource, int[] counts){
        for (String word: resource.words()){
             char chFirst = word.charAt(0);
             char chLast = word.charAt(word.length() - 1);
             if(!(!Character.isLetter(word.charAt(0)) && word.length() == 1)){
                 chLast = word.charAt(word.length() -1);
                 int wordLength = word.length();
                 if(!Character.isLetter(chFirst)){
                     wordLength = wordLength -1;
                    }
                    
                 if (!Character.isLetter(chLast)){
                     wordLength = wordLength -1;
                    }
                 
                 if(wordLength <= 30 && wordLength >0){
                     counts[wordLength] +=1;
                    }
                 
                 else if (wordLength >30){
                     counts[30] +=1;
                    }
                    
                 else {
                     counts[0] +=1;
                    }
                 System.out.println(wordLength + " " + word);
                }
            
        }
        
        System.out.println("Note this file has words that are: ");
        int countAllWords = 0;
        for(int k = 0; k< counts.length ; k++){
            if(counts[k] >0){
                System.out.println(counts[k] + " words of length " + k);
                countAllWords +=counts[k];
            }
        }
        System.out.println("countAllWords = " + countAllWords);
    }

    public void testCountWordLengths(){
        FileResource resource = new FileResource("./data/WordData/romeo.txt");
        int [] counts = new int[31];
        countWordLengths(resource, counts);

    }
}
