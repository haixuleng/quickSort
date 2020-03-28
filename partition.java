package quickSort;
import java.util.Arrays;

public class partition {
	int start;
	int end;
	int[] array;
	int index;
	public partition(int[] A, int l, int r){
		start = l;
		end = r;
		array = A;
		System.out.println("Partition:");
		for(int i = start; i < end; i ++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public void run_first(){// first case, pivot is the first element
		int pivot = array[start]; 
		int i = start + 1; // left most case that is larger than the pivot
		for(int j = start + 1; j < end; j++){
			if(array[j] < pivot){
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp; // swap the element
				i++;
			}
		}
		index = i; // new location of the pivot
		if(i - start > 1) { // swap the pivot with the right most value smaller than it
			array[start] = array[i - 1];
			array[i - 1] = pivot;
		}
	}
	
	public void run_last(){// second case, pivot is the last element
		int temp = array[end - 1];
		array[end - 1] = array[start];
		array[start] = temp;
		int pivot = array[start]; 
		int i = start + 1; // left most case that is larger than the pivot
		for(int j = start + 1; j < end; j++){
			if(array[j] < pivot){
				temp = array[j];
				array[j] = array[i];
				array[i] = temp; // swap the element
				i++;
			}
		}
		index = i; // new location of the pivot
		if(i - start > 1) { // swap the pivot with the right most value smaller than it
			array[start] = array[i - 1];
			array[i - 1] = pivot;
		}
	}
	
	public void run_median(){// second case, pivot is the last element
		int medianIndex = median(array, start, end);
		int temp = array[medianIndex];
		array[medianIndex] = array[start];
		array[start] = temp;
		int pivot = array[start]; 
		int i = start + 1; // left most case that is larger than the pivot
		for(int j = start + 1; j < end; j++){
			if(array[j] < pivot){
				temp = array[j];
				array[j] = array[i];
				array[i] = temp; // swap the element
				i++;
			}
		}
		index = i; // new location of the pivot
		if(i - start > 1) { // swap the pivot with the right most value smaller than it
			array[start] = array[i - 1];
			array[i - 1] = pivot;
		}
	}
	
	public quickSortType get_first(){
		//
		run_first();
		System.out.println("Partition:");
		for(int i = start; i < end; i ++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("Index of Pivot: " + (index - 1));
		return new quickSortType(array, index - 1); //partitioned array and index of pivot
	}
	
	public quickSortType get_last(){
		//
		run_last();
		System.out.println("Partition:");
		for(int i = start; i < end; i ++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("Index of Pivot: " + (index - 1));
		return new quickSortType(array, index - 1); //partitioned array and index of pivot
	}
	
	public quickSortType get_median(){
		//
		run_median();
		System.out.println("Partition:");
		for(int i = start; i < end; i ++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("Index of Pivot: " + (index - 1));
		return new quickSortType(array, index - 1); //partitioned array and index of pivot
	}
	
	private int median(int[] array, int l, int r) {
		int first = array[l];
		int last = array[r - 1];
		int midIndex = (r - l - 1) / 2 + l;
		int middle = array[midIndex];
		System.out.println("Middle element:" + midIndex);
		int fl = first - last;
		int fm = first - middle;
		int lm = last - middle;
		
		if(fl * fm <= 0) {
			System.out.println("Median pivot:" + array[l]);
			return l;
		}
		else if(fm * lm <= 0) {
			System.out.println("Median pivot:" + array[midIndex]);
			return midIndex;
		}
		else {
			System.out.println("Median pivot:" + array[r - 1]);
			return r - 1;
		}
	}
}
