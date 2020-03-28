package quickSort;
import java.io.FileNotFoundException;
public class main {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Start ....");
		qsort test = new qsort("data/QuickSort.txt");
		//qsort test = new qsort("data/test.txt");
		int[] result = test.get();
		System.out.println("Sorted array:");
		//for(int i = 0; i < result.length; i++) {
		//	System.out.print("Index " + i + ": ");
		//	System.out.println(result[i]);
		//}
	}
}
