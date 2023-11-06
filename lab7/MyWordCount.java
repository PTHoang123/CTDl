package lab7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.List;

import lab7.set_student.Utils;
import lab7.set_student.WordCount;

public class MyWordCount {
    
public static final String fileName = "data/fit.txt";
    private List<String> words = new ArrayList<>();
    public MyWordCount() {
        try {
            this.words.addAll(Utils.loadWords(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
    }}
    // Returns a set of WordCount objects that represents the number of times each //unique token appears in the file
// data/hamlet.txt (or fit.txt)
// In this method, we do not consider the order of tokens.
    public List<WordCount> getWordCounts() {
        List<WordCount> wordCounts = new ArrayList<>();
        HashSet<String> uniqueWords = new HashSet<>();
        for(String word : words) {
            uniqueWords.add(word);
        }
        for(String word: uniqueWords){
            int count = 0;
            for(String word2 : words){
                if(word.contains(word2)){
                    count++;
                }
                wordCounts.add(new WordCount(word, count));
            }
        }
        return wordCounts;
    }
    public Set<String> getUniqueWord(){
        Set<String> uniqueWords = new HashSet<>();
        for(String word: words){
            uniqueWords.add(word);
        }
        return uniqueWords;
    }
    public Set<String> getDistinctWords(){
        Set<String> distinctWords = new HashSet<>();
            List<WordCount> wc = getWordCounts();
            for(WordCount wordCount : wc){
                if(wordCount.getCount() == 1){
                    distinctWords.add(wordCount.getWord());
                }
            }
        
        return distinctWords;
    }
    public  Set<WordCount> exportWordCounts() { 
        List<WordCount> wordCounts = getWordCounts();
        Set<WordCount> re = new TreeSet<>(new Comparator<WordCount>() {
            @Override
            public int compare(WordCount o1, WordCount o2) {
                if(o1.getCount() == o2.getCount()){
                    return o1.getWord().compareTo(o2.getWord());
                }
                return o2.getCount() - o1.getCount();
            }
        });
        for(WordCount wordCount : wordCounts){
            re.add(wordCount);
        }
        return re;
    }
    public Set<WordCount> filterWords(String pattern) {
        Set<WordCount> re = new HashSet<>();
        List<WordCount> list = getWordCounts();
        for(WordCount wc : list ){
            if(wc.getWord().contains(pattern)){
                re.add(wc);
            }
        }
        return re;
    }
}
