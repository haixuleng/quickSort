package quickSort;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class loadText {
	String fileToLoad;
	int length = 0;
	//int[] data;
	public loadText(String fileName) throws FileNotFoundException {
		fileToLoad = fileName;
		size();
	}
	
	public void size() throws FileNotFoundException {
		int size = 0;
		File myObj = new File(fileToLoad);
		Scanner myReader = new Scanner(myObj);
		while(myReader.hasNextLine()) {
			String data = myReader.nextLine();
			//System.out.println(data);
			size = size +1;
		}
		
		length = size;
	}
	
	public int[] get() throws FileNotFoundException {
		size();
		int[] initData = new int[length];
		int index = 0;
		File myObj = new File(fileToLoad);
		Scanner myReader = new Scanner(myObj);
		while(myReader.hasNextLine()) {
			String data = myReader.nextLine();
			initData[index] = Integer.parseInt(data);
			index ++;
		}
		return initData;
	}
}


