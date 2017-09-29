/*
LZW Decompression Algorithm
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


/*Class for decompressing the file*/
class decompress {
 public static void LZWdecomp(List<Integer> compressed,String Filename,int bitlength) throws IOException{
        double ASCII_Total=Math.pow(2,bitlength);
        double ASCIISize=255;
            String entry="";
            int k; 
			/*Map data structure to store ASCII values*/
       Map<Integer,String> ASCII_table = new HashMap<Integer,String>();
        /*LZW decompression algorithm*/
		for (int i = 0; i < 255; i++)
            ASCII_table.put(i, String.valueOf((char)i));
 BufferedWriter outputWriter = null;
  outputWriter = new BufferedWriter(new FileWriter(Filename.substring(0,Filename.indexOf("."))+"_decoded"+".txt"));
 
        String w = String.valueOf((char)(int)compressed.remove(0));
        StringBuffer result = new StringBuffer(w);
        for (int i=0;i<compressed.size();i++) {
        k=compressed.get(i);
            if (ASCII_table.containsKey(k))
                entry = ASCII_table.get(k);
            else if (k == ASCIISize)
                entry = w + w.charAt(0); 
            result.append(entry);
 if(ASCII_table.size() < ASCII_Total )

            ASCII_table.put((int)ASCIISize++, w + entry.charAt(0));
 
            w = entry;
        }
  /*Write decoded output to file*/
outputWriter.write(result.toString()) ;
  outputWriter.flush();  
  outputWriter.close();  
   }
  
} 
public class LZW_decomp{
    public static void main(String[] args) throws IOException{
       
		
        /* get file contents and compress it */
 		int bit=Integer.valueOf(args[1]);
        
		List < Integer > b = new ArrayList < Integer > ();
        
		/*get contents from .lzw file */
		BufferedReader br = null;
		InputStream inputStream  = new FileInputStream(args[0]);
		
		Reader inputStreamReader = new InputStreamReader(inputStream, "UTF_16BE");
	
		br = new BufferedReader(inputStreamReader);
		  
		double code=0;
		
         /* reads all the encoded values into integer*/ 
         while((code = br.read()) != -1)
         {
        	 b.add((int)code);
         }
		 br.close();
		
        /* decompress file */
        decompress Lzw = new decompress();
        Lzw.LZWdecomp(b, args[0],bit);
    
}
}