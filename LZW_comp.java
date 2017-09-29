/*
LZW Compression Algorithm
Created by : Anirudh Lakshminarayanan
Student ID : 800964326
*/
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

/*class to read files used for reading both text file and encoded file*/
class readfile{
public static String file_contents (String filename) throws IOException
{
StringBuffer input = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
		    for (String line = null; (line = br.readLine()) != null;) {
		        
		    	input = input.append(line);
		    }
		
    return input.toString();
 }
}


class Compress {
    public static void LZWComp(String File,String Filename,int bitlength) throws IOException {
        
String string="";
Integer a[]=new Integer[File.length()];
int j=0;
        double ASCII_Total=Math.pow(2,bitlength);
        int ASCII=255;
		char symbol;
 BufferedWriter outputWriter = null;
 /*converting integer to 2 bytes using UTF_16BE and creating a .lzw file*/
 outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Filename.substring(0, Filename.indexOf(".")) + ".lzw"),"UTF_16BE"));
        /*Map data structure to store ASCII values*/
        Map<String,Integer> ASCII_table = new HashMap<String,Integer>();
        for (int i = 0; i < 255; i++)
            ASCII_table.put(String.valueOf((char)i),i);
    /* LZW compression implementation*/    
for(int i=0;i<File.length();i++){
symbol=File.charAt(i);	
String new_string = string + symbol;
            if (ASCII_table.containsKey(new_string))
{
                string = new_string;
} 
           else {
a[j]=(ASCII_table.get(string));
j++;

if(ASCII_table.size()<ASCII_Total)
                ASCII_table.put(new_string, (int)ASCII++);
                string =String.valueOf(symbol);
		   
			}
        } 
		
a[j]=(ASCII_table.get(string));

	/*store encoded values into a file*/	
			for(int i=0;i<a.length;i++){
			
				if(a[i]!=null){
				outputWriter.write(a[i]);}
}
	
  outputWriter.flush();  
  outputWriter.close();  
 
   }
}
/*Class for decompressing the file*/
public class LZW_comp{
    public static void main(String[] args) throws IOException{
       readfile file = new readfile();
        
		
        /* get file contents and compress it */
        String a = file.file_contents(args[0]);
		int bit=Integer.valueOf(args[1]);
        Compress File = new Compress();
        File.LZWComp(a, args[0],bit);
        
}
}