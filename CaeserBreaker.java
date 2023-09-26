import edu.duke.*;

 * Write a description of CaesarCipher here.
 * 
 * @author (Nesma Abouzaid) 
 * @version (07/09/2023)
 */
public class CaeserBreaker {
    int[] countLetters(String message){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i=0; i<message.length(); i++){
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alphabet.indexOf(ch);
            if(dex != -1){
                counts[dex] +=1;
            }
        }
        return counts;
    }

    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int i =0; i<vals.length ; i++){
            if(vals[i] > vals[maxDex]){
                maxDex = i;
            }
        }
        return maxDex;
    }
    
    public String decrypt(String encrypted, int key){
        CaesarCipher cc = new CaesarCipher();
        System.out.println("Encrypted = " + encrypted);
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex -4;
        if(maxDex <4){
            dkey = 26 - (4- maxDex);
            
        }
        return cc.encrypt(encrypted, 26-key);
        
    }
}
