package lab8_map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.print.attribute.standard.MediaSize.ISO;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("data/short.txt"));
		String line = null;
		int index = 1;
		while(true) {
			line = reader.readLine();
			if(line == null)
				break;
		
		StringTokenizer tokens = new StringTokenizer(line, " ");
		while(tokens.hasMoreTokens()) {
			String word = tokens.nextToken();
			ArrayList<Integer> listIndex = map.get(word);
			if(!tokens.hasMoreTokens()) {
				if(listIndex == null) {
					listIndex = new ArrayList<Integer>();
					listIndex.add(-index);
					map.put(word, listIndex);
				} else {
					map.put(word, listIndex);
				}
			} else {
				if(listIndex == null) {
					listIndex = new ArrayList<Integer>();
					listIndex.add(index);
					map.put(word, listIndex);
					index++;
				} else {
					map.put(word, listIndex);
					index++;
				}
			}
		}
		}
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) throws IOException {
		ArrayList<Integer> listIndex = map.get(word);
		if(listIndex == null) {
			listIndex = new ArrayList<Integer>();
			listIndex.add(-position);
			map.put(word, listIndex);
		} else {
			if(listIndex.get(listIndex.size() - 1) < 0) {
				listIndex.add(-position);
			} else {
				listIndex.add(position);
			}
			map.put(word, listIndex);
		}
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		Map<String, ArrayList<Integer>> map2 = new TreeMap<String, ArrayList<Integer>>();
		map2.putAll(map);
		for(String word : map2.keySet()) {
			System.out.println(word + " - " + map2.get(word));
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		for(String word : map.keySet()){
			for(int i = 0; i < map.get(word).size(); i++){
				if(map.get(word).get(i) < 0){
					System.out.println(word + "\n");
				}else{
					System.out.println(word + " ");
				}
			}
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		String word = "";
		int max = 0;
		for(String w : map.keySet()){
			if(map.get(w).size() > max){
				max = map.get(w).size();
				word = w;
			}
		}
		return word;
	}

}