/**
 * @author: wuke 
 * @date  : 20160901 11:01:28am
 * Title  : QuickSort
 * Description : 
 */
public class QuickSort {
	/*
	 * Swaps two elements in one array
	 */
	private static void swap(Comparable[] data, int index1, int index2) {
		Comparable temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	/*     
	 * Sorts one array using the quick sort algorithm.
	 */
	public static void quickSort(Comparable[] data, int min, int max) {
		int pivot;
		if(min < max) {
			pivot = partition(data, min, max); // make partition
			quickSort(data, min, pivot-1); // sort left partition
			quickSort(data, pivot+1, max); // sort right partition 
			
		}
	}
	
	/*
	 * Creates the partitions needed for quick sort
	 */
	private static int partition(Comparable[] data, int min, int max) {
		// use the first element as the partition value
		Comparable partitionValue = data[min];
		
		int left = min;
		int right = max;
		
		while(left < right) {
			// Search for an element that is > than the partition element
			while(data[left].compareTo(partitionValue) <= 0 && left < right)
				left++;
			// Search for an element that is < than the partition element
			while(data[right].compareTo(partitionValue) > 0)
				right--;
			// if(left < right) then swap them
			if(left < right)
				swap(data, left, right);
		}
		
		// Move the partition element to its final position
		swap(data, min, right);
		
		return right;
	}
	
	public static void main(String[] args) {
		Comparable[] data = {9,6,8,12,3,1,7};
		quickSort(data, 0, 6);
		for(int i = 0; i < data.length; i++)
			System.out.print(data[i] + "   ");
	}
}
