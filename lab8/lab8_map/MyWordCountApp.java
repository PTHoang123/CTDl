package lab8_map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException{
		Scanner sc = new Scanner(new File(fileName));
		while(sc.hasNext()){
			String word = sc.next();
			if(map.containsKey(word)){
				map.put(word, map.get(word) + 1);
			}else{
				map.put(word, 1);
			}
		}
		System.out.println(map);
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		return map.size();

	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		loadData();
		Set<String> set = new HashSet<>();
		set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String word = it.next();
			System.out.println(word + " - " + map.get(word));
		}

	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() throws FileNotFoundException{
		Map<String, Integer> map2 = new TreeMap<String, Integer>();
		map2.putAll(map);
		for(String word : map2.keySet()){
			System.out.println(word + " - " + map2.get(word));
		}
	}
	public static void main(String[] args) {
		MyWordCountApp app = new MyWordCountApp();
		try {
			app.printWordCountsAlphabet();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
