
//
import java.io.*;
import java.util.Arrays;

public class Main {
 
    public static void main(String[] args) {
 
       // String inputFile = "C:\\Users\\rswal\\Downloads\\Tom_Jerry.pgm";
    	 String inputFile = "thebiggie.pgm";
        String outputFile = "output.xyz";
        try (
            InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);
        ) {
            long fileSize = new File(inputFile).length();
            byte[] allBytes = new byte[(int) fileSize];
            inputStream.read(allBytes);
            byte lastByte = allBytes[16];
            int repeatCount = 1;
            for(int i =3;i<allBytes.length;i++) 
            {
            	if(i==allBytes.length/2) 
            	{
            		System.out.println("50% done!");
            	}
            	byte curByte = allBytes[i];
            	if(i<17) 
            	{
            		outputStream.write(curByte);
            	}
            	else 
            	{
            		if(curByte!=lastByte||repeatCount==255) 
	        		{
	        			outputStream.write(repeatCount);
	        			outputStream.write(lastByte& 0xff);
	            		repeatCount=1;
	        		}
            		else if(curByte==lastByte) 
            		{
            			repeatCount++;
            		}
            	}
            	lastByte = curByte;
            }
            System.out.print("Done Compressing");
            System.out.print("Done Writing");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }
