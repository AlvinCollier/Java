//Alvin Collier
//2.16.2018
//dictionary linear vs binary search
//word object
//word to your mother

public class Word {

	private String word;
	private String def;
	
	public Word(String word, String def) {
		this.word = word;
		this.def = def;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", def=" + def + "]";
	}
	
	public int compareTo(String key) {
		return word.compareTo(key);
	}
	
	public boolean equals(String key) {
		return word.equals(key);
	}
		
}
