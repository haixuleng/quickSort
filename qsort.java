package quickSort;

import java.io.FileNotFoundException;

public class qsort {
	int[] input;
	int numberOfComparison;
	public qsort(String fileName) throws FileNotFoundException{
		//loadText test = new loadText(fileName);
		//input = test.get();
		numberOfComparison = 0;
		System.out.println(fileName);
		loadText test = new loadText(fileName);
		input = test.get();
		//System.out.println(input);
	}
	
	public int[] get(){
		int[] result = run(input, 0, input.length);
		System.out.println("Number of comparisons: " + numberOfComparison);
		return result;
	}
	
	public int[] run(int[] A, int l, int r){
		if(r - l <= 1){
			return A;
		}
		else{
			numberOfComparison = numberOfComparison + r - l - 1; // m - 1 comparisons
			partition pt = new partition(A, l, r);
			quickSortType result = pt.get_median(); // switch betwen first and last
			int[] partitionedArray = result.array;
			int indexOfPivot = result.index;
			int left_l = l;
			int left_r = indexOfPivot;
			int right_l = indexOfPivot + 1;
			int right_r = r;
			int[] sortedLeft = run(partitionedArray, left_l, left_r);
			int[] sortedRight = run(sortedLeft, right_l, right_r);
			
			return sortedRight;
		}
	}
}
