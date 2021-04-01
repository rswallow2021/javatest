
//
import java.io.*;
import java.util.Arrays;

public class Decompress {
 
    public static void main(String[] args) {
 
       // String inputFile = "C:\\Users\\rswal\\Downloads\\Tom_Jerry.pgm";
    	 String outputFile = "POST_thebiggie.pgm";
         
        String inputFile = "output.xyz";
 
 
        try (
            InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);
        ) {
 
            long fileSize = new File(inputFile).length();
            initialize(outputStream);
            byte[] allBytes = new byte[(int) fileSize];
 
            inputStream.read(allBytes);
            
            int count = 0;
            boolean on = true;
            for(int i =0;i<allBytes.length;i++) 
            {
	            if(i<14) 
	            {

	                outputStream.write(allBytes[i]);
	            }
	            else if(on) 
	            {
	            	count = allBytes[i]& 0xff;
	            	on= !on;
	            }
	            else 
	            {
	            	for(int j =0;j<count;j++) 
	            	{

		            	outputStream.write(allBytes[i]);
	            	}
	            	on= !on;
	            }
            }
            System.out.print("Done Decompressing");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void initialize(OutputStream outputStream) {
    	try {
        outputStream.write(80);
        outputStream.write(53);
        outputStream.write(10);	}
    	catch(IOException e) {
            e.printStackTrace();}

    }
    }
