//Alvin Collier
//3.23.2018
//bracket and brace detection
//I have a lot of system.out's I used for debugging 
//I left the commented out code in so you could see
//the process I used to test this.

package stacks;

import java.util.Scanner;

public class Brackets {

	static int index = 0;
	//static String s = "{a[b(c)d]e}";
	static StackX stack = new StackX(10);

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter text with {}, [], or () to see if you close them correctly");
		String s = sc.nextLine();
		System.out.println(findBracket(s));

		while( !stack.isEmpty() )     // until it's empty,
		{                             // delete item from stack
			char value = stack.pop();
			System.out.print(value);      // display it
			System.out.print(" ");
		}  // end while
		System.out.println("");

		sc.close();

	}

	public static boolean findBracket(String s) {
		char[] c = new char[s.length()];
		c = s.toCharArray();
		boolean match = true;
		if(index < c.length) {
			//System.out.print("Checking at index " + index + " : ");
			if(c[index] == '{' || c[index] == '[' || c[index] == '(') {
				//System.out.println(c[index] +" was added to the stack");
				stack.push(c[index]);
			}

			if(c[index] == '}') {
				if(stack.pop() == '{') {
					//System.out.println(c[index] +"Found match at " + index);
					index++;
					match = (findBracket(s));
				}
				else {
					match = false;
				}
			}
			else if(c[index] == ']') {
				if(stack.pop() == '[') {
					//System.out.println(c[index] +"Found match at " + index);
					index++;
					match = (findBracket(s));
				}
				else {
					match = false;
				}
			}
			else if(c[index] == ')'){
				if(stack.pop() == '(') {
					//System.out.println( c[index] +"Found match at " + index);
					index++;
					match = (findBracket(s));
				}
				else {
					match = false;
				}
			}
			else {
				index++;
				match = (findBracket(s));
			}
		}
		return match;

	}



}
