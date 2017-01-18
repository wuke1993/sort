/**
 * @author: wuke 
 * @date  : 20160831 9:27:52pm
 * Title  : Sorting
 * Description : 
 */
public class Sorting {
	/*
	 * Swaps two elements in one array
	 */
	private static void swap(Comparable[] data, int index1, int index2) {
		Comparable temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	/*
	 * Sorts one array using the selection sort algorithm.
	 * Select the smallest one in every loop, 
	 * and then put it into the position it belongs to
	 */
	public static void selectionSort(Comparable[] data) {
		int min;
		for(int index = 0; index < data.length-1; index++) {
			min = index;
			for(int scan = index + 1; scan < data.length; scan++) {
				if(data[scan].compareTo(data[min]) < 0)
					min = scan;
			}
			swap(data, min, index);
		}
	}
	
	/*
	 * Sorts one array using the insertion sort algorithm.
	 * insert every elements one by one into the sub sorted list
	 */
	public static void insertionSort(Comparable[] data) {
		for(int index = 1; index < data.length; index++) {
			Comparable key = data[index];
			int postion = index;
		
			//Shift larger values to the right
			while(postion > 0 && data[postion-1].compareTo(key) > 0) {
				data[postion] = data[postion-1];
				postion--;
			}
			data[postion] = key; // find the proper position for the key
		}
	}
	
	/*
	 * Sorts one array using the bubble sort algorithm.
	 * In every loop, compare all the adjacent elements from the begining, 
	 * and exchange their position is necessary, then when one loop is finshed, 
	 * the last element is sorted.
	 */
	public static void bubbleSort(Comparable[] data) {
		for(int i = 1; i < data.length; i++) {
			for(int j = 0; j < data.length - i; j++) {
				if(data[j].compareTo(data[j+1]) > 0)
					swap(data, j, j+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Comparable[] data = {9,6,8,12,3,1,7};
		//bubbleSort(data);
		//insertionSort(data);
		selectionSort(data);
		for(int i = 0; i < data.length; i++)
			System.out.print(data[i] + "   ");
	}
}

