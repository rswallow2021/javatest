import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "80";
		byte b =(byte) Integer.parseInt(a);  
   	 String outputFile = "Tom_Jerry.txt";
		System.out.print(b);
        try {
			OutputStream outputStream = new FileOutputStream(outputFile);
			 try {
				outputStream.write(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
