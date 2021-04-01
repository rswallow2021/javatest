
//
import java.io.*;
import java.util.Arrays;

public class Main {
 
    public static void main(String[] args) {
 
       // String inputFile = "C:\\Users\\rswal\\Downloads\\Tom_Jerry.pgm";
    	 String inputFile = "Tom_Jerry.pgm";
         
        String outputFile = "output.xyz";
 
 
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
            for(int i =3;i<allBytes.length;i++) 
            {
            	if(i==allBytes.length/2) 
            	{
            		System.out.println("50% done!");
            	}
            	byte curByte = allBytes[i];
            	if(i<17) 
            	{
              	  	output+= ((int)curByte& 0xff) + " ";
            	}
            	else 
            	{
            		if(curByte==lastByte) 
            		{
            			repeatCount++;
            		}
            		else 
            		{
            			output += " ";
            			for(int j =0;j<10;j++) 
            			{

                			output+= repeatCount + "x" +((int)lastByte& 0xff) ; 
                			output+= repeatCount + "x" +((int)lastByte& 0xff) ; 
                			output+= repeatCount + "x" +((int)lastByte& 0xff) ; 
                			output+= repeatCount + "x" +((int)lastByte& 0xff) ; 
                			output+= repeatCount + "x" +((int)lastByte& 0xff) ; 
                			output+= repeatCount + "x" +((int)lastByte& 0xff) ; 
                			output+= repeatCount + "x" +((int)lastByte& 0xff) ; 
                			output+= repeatCount + "x" +((int)lastByte& 0xff) ; 
                			output+= repeatCount + "x" +((int)lastByte& 0xff) ; 
            			}
            		}
            		
            	}
            	lastByte = curByte;
            }
            System.out.print("Done Compressing");
            outputStream.write(output.getBytes());
            System.out.print("Done Writing");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }
