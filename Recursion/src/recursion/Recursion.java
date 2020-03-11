//Alvin Collier
//3.9.2018
//count hi and count hi2
//also taking out duplicate characters

package recursion;

public class Recursion {

	public static void main(String[] args) {
		
		String s ="hihixhihixhiahibhichixhi";
		String sub = "hi";
		String xclude = "xhi";
		System.out.println(hiCount(s, sub));
		System.out.println((hiCount(s, sub)-hiCount(s,xclude)));
		
		String s2 = "aaaammaazzzinnnggg";
		int index = 0;
		System.out.println(reduceDuplicates(s2, index));

	}
	
	public static int hiCount(String str, String sub) {
		
		int indexOfSub = str.indexOf(sub);
		if(indexOfSub < 0) {
			return 0;
		}
		
		int lengthOfSub = sub.length();
		String smallerStr1 = str.substring(0, indexOfSub);
		String smallerStr2 = str.substring(indexOfSub + lengthOfSub);
		
		return 1 + hiCount((smallerStr1+smallerStr2), sub);
	}
	
	public static String reduceDuplicates(String str, int index) {
		
		StringBuilder sb = new StringBuilder(str);
		char[] character = str.toCharArray();
		if(index+1 < character.length) {
			if(character[index] == character[index+1]) {
				sb.deleteCharAt(index+1);
			}
			else {
				index++;
			}
		}
		else {
			return str;
		}
		
		return reduceDuplicates(sb.toString(), index);
	}

	

}
