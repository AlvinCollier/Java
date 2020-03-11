/*	Alvin Collier
	2017 Dragoon Domain All rights reserved
	Super Extra Console Dungeon Game
	Explore a rich text environment, where you will explore a
	dungeon consisting of infinite level, each with multiple
	paths, which are basically random, and your only objective
	is to collect treasure.
*/

package game;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteFile {

	private String path;
	private boolean append = false;
	
	public WriteFile(String path) {
		this.path = path;
	}
	
	public WriteFile(String path, boolean append) {
		this.path = path;
		this.append = append;
	}
	
	public void writeToFile(String textLine) throws IOException {
		
		FileWriter write = new FileWriter(path, append);
		PrintWriter printLine = new PrintWriter(write);
		
		printLine.printf("%s" + "%n", textLine);
		
		printLine.close();
	}
	
}
