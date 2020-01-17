import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocStats{

    private List<String> words = new ArrayList<String>();
    private List<Integer> wordCount = new ArrayList<Integer>();

    public DocStats(File file){
        try {
            Scanner fr = new Scanner(file);
            while(fr.hasNext()){
                checkWords(fr.next());
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void checkWords(String w){
        for(int i = 0; i < words.size(); i++){
            if (words.get(i).equals(w)) { // if word is in the list then increase wordCount by one
                wordCount.set(i, wordCount.get(i) + 1);
            } else { // if word not in list add word to list and add new number to word count.
                words.add(w);
                wordCount.add(1);
            }
        }
    }
    public String getWS(String w) throws WordNotFoundException {
        for(int i = 0; i < words.size(); i++){
            if(words.get(i).equals(w)){
                return w + "  appears " +wordCount.get(i) + " times. ";
            }
        }
        throw new WordNotFoundException("Word not in list");
    }

    public int getWC(){
        return wordCount.size();
    }
}
