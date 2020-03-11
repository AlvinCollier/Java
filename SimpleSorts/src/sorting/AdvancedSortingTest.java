package sorting;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class AdvancedSortingTest {

	public static void main(String[] args) {

		Random rand = new Random();
		rand.setSeed(50);

		PrintWriter outputFile = null;

		try {
			outputFile = new PrintWriter("data.csv");
		} 
		catch (FileNotFoundException e) {
			System.out.println("You done messed up A-Aron!");
			e.printStackTrace();
			System.exit(0);
		}
		outputFile.println("Merge Sorts");
		outputFile.println("n, average time in nano seconds for random arrays");

		for(int n = 10; n < 105; n+=5) {

			long average = 0;
			long sum = 0;
			int numOfTimes = 5;

			for(int count = 0; count < numOfTimes; count++) {
				//int n = 100;
				//make a random array of size n
				int[] array = new int[n];
				for(int i =0; i < n; i++) {
					array[i] = rand.nextInt(n);
					//System.out.println(array[i]);
				}

				long startTime = System.nanoTime();
				mergeSort(array);
				long endTime = System.nanoTime();
				//outputFile.println()
				//System.out.println("Time it took for " + n + " items is " + (endTime - startTime) + " Nano Seconds.");
				sum += (endTime - startTime);
			}

			average = sum/numOfTimes;
			System.out.println("The average time for " + n + " items is " +  average + " Nano Seconds.");
			outputFile.println(n + "," + average);

		}

		//ordered arrays
		outputFile.println("n, average time in nano seconds for ordered arrays");

		for(int n = 10; n < 105; n+=5) {

			long average = 0;
			long sum = 0;
			int numOfTimes = 5;

			for(int count = 0; count < numOfTimes; count++) {
				//int n = 100;
				//make a random array of size n
				int[] array = new int[n];
				for(int i =0; i < n; i++) {
					array[i] = i;
					//System.out.println(array[i]);
				}

				long startTime = System.nanoTime();
				mergeSort(array);
				long endTime = System.nanoTime();
				//outputFile.println()
				//System.out.println("Time it took for " + n + " items is " + (endTime - startTime) + " Nano Seconds.");
				sum += (endTime - startTime);
			}

			average = sum/numOfTimes;
			System.out.println("The average time for " + n + " items is " +  average + " Nano Seconds.");
			outputFile.println(n + "," + average);
		}

		outputFile.println("n, average time in nano seconds for reverse arrays");

		for(int n = 10; n < 105; n+=5) {

			long average = 0;
			long sum = 0;
			int numOfTimes = 5;

			for(int count = 0; count < numOfTimes; count++) {
				//int n = 100;
				//make a random array of size n
				int[] array = new int[n];
				for(int i =0; i < n; i++) {
					array[i] = array.length - i;
					//System.out.println(array[i]);
				}

				long startTime = System.nanoTime();
				mergeSort(array);
				long endTime = System.nanoTime();
				//outputFile.println()
				//System.out.println("Time it took for " + n + " items is " + (endTime - startTime) + " Nano Seconds.");
				sum += (endTime - startTime);
			}

			average = sum/numOfTimes;
			System.out.println("The average time for " + n + " items is " +  average + " Nano Seconds.");
			outputFile.println(n + "," + average);
		}

		outputFile.println("Quick Sorts");
		outputFile.println("n, average time in nano seconds for random arrays");

		for(int n = 10; n < 105; n+=5) {

			long average = 0;
			long sum = 0;
			int numOfTimes = 5;

			for(int count = 0; count < numOfTimes; count++) {

				int[] array = new int[n];
				for(int i =0; i < n; i++) {
					array[i] = rand.nextInt(n);
					//System.out.println(array[i]);
				}
				long startTime = System.nanoTime();
				quickSort(array);
				long endTime = System.nanoTime();
				//outputFile.println()
				//System.out.println("Time it took for " + n + " items is " + (endTime - startTime) + " Nano Seconds.");
				sum += (endTime - startTime);	
				
			}
			
			average = sum/numOfTimes;
			System.out.println("The average time for " + n + " items is " +  average + " Nano Seconds.");
			outputFile.println(n + "," + average);

		}

		outputFile.println("n, average time in nano seconds for ordered arrays");

		for(int n = 10; n < 105; n+=5) {

			long average = 0;
			long sum = 0;
			int numOfTimes = 5;

			for(int count = 0; count < numOfTimes; count++) {

				int[] array = new int[n];
				for(int i =0; i < n; i++) {
					array[i] = i;
					//System.out.println(array[i]);
				}
				long startTime = System.nanoTime();
				quickSort(array);
				long endTime = System.nanoTime();
				//outputFile.println()
				//System.out.println("Time it took for " + n + " items is " + (endTime - startTime) + " Nano Seconds.");
				sum += (endTime - startTime);	

			}
			
			average = sum/numOfTimes;
			System.out.println("The average time for " + n + " items is " +  average + " Nano Seconds.");
			outputFile.println(n + "," + average);

		}
		
		outputFile.println("n, average time in nano seconds for reverse arrays");

		for(int n = 10; n < 105; n+=5) {

			long average = 0;
			long sum = 0;
			int numOfTimes = 5;

			for(int count = 0; count < numOfTimes; count++) {

				int[] array = new int[n];
				for(int i =0; i < n; i++) {
					array[i] = array.length - i;
					//System.out.println(array[i]);
				}
				long startTime = System.nanoTime();
				quickSort(array);
				long endTime = System.nanoTime();
				//outputFile.println()
				//System.out.println("Time it took for " + n + " items is " + (endTime - startTime) + " Nano Seconds.");
				sum += (endTime - startTime);	
				
			}
			
			average = sum/numOfTimes;
			System.out.println("The average time for " + n + " items is " +  average + " Nano Seconds.");
			outputFile.println(n + "," + average);

		}


		outputFile.close();

	}


	public static void mergeSort(int[] list) {
		if (list.length > 1) {
			// Merge sort the first half
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			//System.out.print("array 1 is ");
			for(int i = 0; i < firstHalf.length; i++)
				//System.out.print(firstHalf[i] + " ");
				//System.out.println();
				mergeSort(firstHalf);

			// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2,
					secondHalf, 0, secondHalfLength);
			//System.out.print("array 2 is ");
			for(int i = 0; i < secondHalf.length; i++)
				//System.out.print(secondHalf[i] + " ");
				//System.out.println();
				mergeSort(secondHalf);

			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
			//System.out.println("merged list ");
			//for(int i = 0; i < list.length; i++)
			//System.out.print(list[i] + " ");
			//System.out.println();
		}
	}

	/** Merge two sorted lists */
	public static void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp

		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}

		while (current1 < list1.length)
			temp[current3++] = list1[current1++];

		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}




	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);

		if (high > i)
			quickSort(arr, i, high);
	}

}


