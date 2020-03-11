//Alvin Collier
//2.22.2018
//Sorting Stuff

package sorting;

import java.util.Random;

public class SortTest {
	public static long countBubbleSortSwaps = 0;
	public static long countBubbleSortComps = 0;
	public static double startTime;
	public static double endTime;
	public static long countSelectSortSwaps = 0;
	public static long countSelectSortComps = 0;
	public static long countInsertSortSwaps = 0;
	public static long countInsertSortComps = 0;

	public static void main(String[] args) {
		for(int i = 100; i < 1100; i+=100) {
			System.out.println("For " + i + " items!");
			countBubbleSortSwaps = 0;
			countBubbleSortComps = 0;
			countSelectSortSwaps = 0;
			countSelectSortComps = 0;
			countInsertSortSwaps = 0;
			countInsertSortComps = 0;
			int[] list = new int[i];
			list = makeList(i);
			bubbleSort(list);
			list = makeList(i);
			insertionSort(list);
			list = makeList(i);
			selectionSort(list);
			System.out.println("------------------------------------");
		}

	}
	public static int[] makeList(int length) {
		int[] list = new int[length];
		for(int i = 0; i < length; i++) {
			list[i] = length - i;
		}
		return list;
	}
	public static int[] orderedList(int length) {
		int[] list = new int[length];
		for(int i = 0; i < length; i++) {
			list[i] = i;
		}
		return list;
	}
	public static int[] randList(int length) {
		Random rand = new Random();
		int[] list = new int[length];
		for(int i = 0; i < length; i++) {
			list[i] = rand.nextInt(i+1);
		}
		return list;
	}
	public static void bubbleSort(int[] list) {
		startTime = System.nanoTime();
		//int count = 0;
		boolean needNextPass = true;
		for(int k = 1; k < list.length && needNextPass; k++) {
			//count++;
			countBubbleSortComps++;
			needNextPass = false;
			for(int i = 0; i < list.length - k; i ++) {
				//count++;
				countBubbleSortComps+=2;
				if(list[i] > list[i + 1]) {
					//count++;
					countBubbleSortSwaps++;
					int temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
					needNextPass = true;
				}
			}
		}
		endTime = System.nanoTime();
		//System.out.println("Bubble Sort steps " + count);
		System.out.println("Bubble Sort time " + (endTime - startTime));
		System.out.print(countBubbleSortSwaps +" ");
		System.out.println(countBubbleSortComps);
	}
	public static void insertionSort(int [] list) {
		startTime = System.nanoTime();
		//long count = 0;
		for(int i = 1; i < list.length; i++) {
			countInsertSortComps++;
			//count++;
			int item = list [i];
			int k;
			for(k = i -1; k >= 0 && list[k] > item; k--)
			{
				countInsertSortComps++;
				//count++;
				list[k+1] = list[k];
				countInsertSortSwaps++;
			}
			list[k+1] = item;
		}
		endTime = System.nanoTime();
		//System.out.println("Insertion Sort steps " + count);
		System.out.println("Insertion Sort time " + (endTime - startTime));
		System.out.print(countInsertSortSwaps +" ");
		System.out.println(countInsertSortComps);
	}
	public static void selectionSort(int [] list) {
		startTime = System.nanoTime();
		//long count = 0;
		for(int i = 0; i < list.length -1; i++) {
			countSelectSortComps++;
			//count++;
			int currentMin = list[i];
			int minIndex = i;
			for(int j = i +1; j < list.length; j++) {
				countSelectSortComps+=2;
				//count++;
				if (currentMin > list[j]) {
					countSelectSortSwaps++;
					//count++;
					currentMin = list[j];
					minIndex = j;
				}
			}
			countSelectSortComps++;
			if(minIndex != i) {
				countSelectSortSwaps++;
				//count++;
				list[minIndex] = list[i];
				list[i] = currentMin;
			}
		}
		endTime = System.nanoTime();
		//System.out.println("Selection Sort steps " + count);
		System.out.println("Selection Sort time " + (endTime - startTime));
		System.out.print(countSelectSortSwaps +" ");
		System.out.println(countSelectSortComps);
	}

}