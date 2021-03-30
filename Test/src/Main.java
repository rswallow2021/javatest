
//
import java.io.*;
import java.util.Arrays;

/**
 * Copy one file to another using low level byte streams,
 * read and write a whole.at once.
 * @author www.codejava.net
 */
public class Main {
 
    public static void main(String[] args) {
 
        String inputFile = "C:\\Users\\rswal\\Downloads\\Tom_Jerry.pgm";
        String outputFile = "output.xyz";
 
 
        try (
            InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);
        ) {
 
            long fileSize = new File(inputFile).length();
 
            byte[] allBytes = new byte[(int) fileSize];
 
            inputStream.read(allBytes);
 
            outputStream.write(allBytes);
            byte lastByte;
            for(int i =0;i<allBytes.length;i++) 
            {
            	byte curByte = allBytes[i];
            	if(i<16) 
            	{
              	  	
            	}
            	else 
            	{
            		
            		
            	}
            	lastByte = curByte;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }
