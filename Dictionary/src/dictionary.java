//Alvin Collier
//2.16.2018
//dictionary linear vs binary search

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dictionary {

	public static void main(String[] args) {

		final int SIZE = 48040;

		String[] word = new String[SIZE];
		String[] def = new String[SIZE];

		String fileName = "dictionary-1.txt";
		Scanner inputStream = null;
		System.out.println("The file " + fileName + "\ncontains the following lines:\n");

		try 
		{
			inputStream = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}

		int index = 0;
		while(inputStream.hasNextLine())
		{
			word[index] = inputStream.next();
			def[index] = inputStream.nextLine();
			index++;
		}

		inputStream.close();

		for(int i = 0; i <SIZE; i++) {
			//added some formatting stuff to print the list out nicer
			//it really doesnt make a difference...
			if(word[i].length() < 7) {
				System.out.println(word[i] + ":\t\t" + def[i]);
			}
			else {
				System.out.println(word[i] + ":\t" + def[i]);
			}

		}

		System.out.println("searching for zombies using linear search");
		int indexReturned = linearSearch(word, "zombies");
		System.out.println(word[indexReturned] + ": " + def[indexReturned]);

		System.out.println("searching for zombies using binary search");
		indexReturned = binarySearch(word, "zombies");
		System.out.println(word[indexReturned] + ": " + def[indexReturned]);
		
		for(int n=1; n < 100000; n*=10) {
			long startTime = System.nanoTime();
			for(int i = 0; i < n; i++) {
				linearSearch(word, "zombies");
			}
			long endTime = System.nanoTime();
			System.out.println("Time to run linear search " + n + " times " + (endTime - startTime));
			
			long startTime2 = System.nanoTime();
			for(int i = 0; i < n; i++) {
				binarySearch(word, "zombies");
			}
			long endTime2 = System.nanoTime();
			System.out.println("Time to run binary search " + n + " times " + (endTime2 - startTime2));
			
		}

	}

	public static int linearSearch(String[] array, String key) {

		int index = 0;
		//int countSteps = 0;
		int numOfElements = array.length;
		while(index < numOfElements) {
			//countSteps++;
			if(array[index].equals(key)) {
				//System.out.println("The number of steps for linear search is " + countSteps);
				return index;
			}
			index++;
		}
		//System.out.println("The number of steps for linear search is " + countSteps);
		return -1;
	}



	public static int binarySearch(String[] array, String key) {

		int low = 0;
		int high = array.length-1;
		//int countSteps = 0;
		
		while(high >= low) {
			//countSteps++;
			int mid = (low+high)/2;
			if(key.compareTo(array[mid])< 0) {
				high = mid -1;
			}
			else if(key.equals(array[mid])) {
				//System.out.println("The number of steps for binary search is " + countSteps);
				return mid;
			}
			else {
				low = mid+1;
			}
		}
		
		//System.out.println("The number of steps for binary search is " + countSteps);
		return -1;
	}

}
