/*LZW Compression and Decompression Algorithm
Created by : Anirudh Lakshminarayanan
Student ID : 800964326
*/

/*
Programmin Language used : Java
Compiler used : JDK1.8
*/

/*
Lzw Compression:

Filename is passed during the file execution in command line. 
File should be present in the same location as source file. 
File is created with the name Filename.lzw in the same location as source file 

Class names:readfile,compress,LZW_comp

readfile reads the contents from the file and returns it to a string
Compress class implements compression algorithm and converts the ASCII into a 2 bytes file
LZW_comp is the main class which gets filename and bitlength and calls readfile and compress

Compression filename : LZW_comp.java
File Compilation : javac LZW_comp.java
File Execution : java LZW filename bitlength
example : java input1.txt 12
input1.lzw file will be created
*/

/*
Lzw Decompression:

Filename is passed during the file execution in command line. 
File should be present in the same location as source file. 
File is created with the name Filename_decoded.txt in the same location as source file 

Class names:decompress,LZW_comp


decompress class implements decompression algorithm and converts it into a original string and stores it into a file.
LZW_comp is the main class which gets filename and bitlength and decrypts the file into ASCII value and calls decompress

Compression filename : LZW_decomp.java
File Compilation : javac LZW_comp.java
File Execution : java LZW filename bitlength
example : java input1.lzw 12
          input1_decoded.txt file will be created
*/

/*
Data Structure used for LZW algorithm : HashMap,ArrayList,Array

HashMap data structure is used mainly to store already defined ASCII values and to add ASCII values of new string
ArrayList data structure is used to store encoded values as int and to traverse each value to decode it 
Array data structure to store encoded values into a file.
*/