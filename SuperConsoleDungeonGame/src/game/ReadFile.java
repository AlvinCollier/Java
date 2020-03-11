/*	Alvin Collier
	2017 Dragoon Domain All rights reserved
	Super Extra Console Dungeon Game
	Explore a rich text environment, where you will explore a
	dungeon consisting of infinite level, each with multiple
	paths, which are basically random, and your only objective
	is to collect treasure.
*/

package game;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {

	private String path;
	
	public ReadFile(String path) {
		this.path = path;
	}
	
	public String[] OpenFile() throws IOException {
		
		FileReader fin = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fin);
		
		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];
		
		for(int i = 0; i < numberOfLines; i++) {
			textData[i] = textReader.readLine();
		}
		
		textReader.close();
		return textData;
	}
	
	public int readLines() throws IOException {
		
		FileReader fin = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fin);
		
		String line;
		int numberOfLines = 0;
		
		while((line = textReader.readLine()) != null) {
			numberOfLines++;
		}
		textReader.close();
		
		return numberOfLines;
	}
}
