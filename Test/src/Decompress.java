
//
import java.io.*;
import java.util.Arrays;

public class Decompress {
 
    public static void main(String[] args) {
 
       // String inputFile = "C:\\Users\\rswal\\Downloads\\Tom_Jerry.pgm";
    	 String outputFile = "Tom_Jerry.txt";
         
        String inputFile = "output.xyz";
 
 
        try (
            InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);
        ) {
 
            long fileSize = new File(inputFile).length();
 
            byte[] allBytes = new byte[(int) fileSize];
 
            inputStream.read(allBytes);
            
            byte lastByte = allBytes[16];
            String output = "";
            int repeatCount = 1;
            String curString = "";
            byte curByte ;
            for(int i =0;i<allBytes.length;i++) 
            {
            	curByte= allBytes[i];
            	if(i<13) 
            	{
              	  	output+= ((int)curByte& 0xff) + " ";
            	}
            	else 
            	{
            		
            		if(curByte!= 032) 
            		{
            			
            		}
            		curString+= ((int)curByte& 0xff);
            		
            	}
            }
            outputStream.write(output.getBytes());
            System.out.print("Done Decompressing");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }
