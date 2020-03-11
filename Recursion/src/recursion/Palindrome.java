package recursion;

public class Palindrome {

	public static void main(String[] args) {

		String s = "Reviled did I live, said I, as evil I did deliver";
		String s2 = "Not a palindrome";
		String s3 = "almost a palindrome, tsmla";
		System.out.println(palindrome(s3));

	}

	public static boolean palindrome(String str)
	{
		boolean result = false;
		StringBuilder sb = new StringBuilder(str.toLowerCase().replaceAll(",", "").replaceAll(" ", ""));
		System.out.println(sb.toString());
		if(sb.length() == 1) {
			if(sb.charAt(0) == sb.charAt(sb.length()-1)) {
				result = true;
			}
		}
		else if(sb.charAt(0) == sb.charAt(sb.length()-1)) {
			sb.deleteCharAt(0);
			sb.deleteCharAt(sb.length()-1);
			String str2 = sb.toString();
			
			result = palindrome(str2);
		}
		else {
			result = false;
		}
		
		return result;
	}

}
