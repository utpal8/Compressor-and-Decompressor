package comp_decomp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
public class compressor {

    public static void method(File file) throws IOException {

        /*so in order to store the compressed and decompressed file in the same directory i have to make
         * sure that i get the parent of the input file,, and inside that parent i will push the out file */
        /*we are making the file directory*/
        String fileDirectory = file.getParent();

        /*with the file input stream i am going to read the bytes of file*/
        FileInputStream fileInputStream = new FileInputStream(file);
        /*with the file output stream i am going to write the raw bytes of file and stored it*/
        FileOutputStream fileOutputStream = new FileOutputStream(fileDirectory + "/CompressedFile.gz");

        /*now we want our output file is to be compressed so i will use GZIP output stream
         * i passed the file output stream as a parameter because i want that output file as a compressed file*/
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fileOutputStream);

        /*file is the compbination of bits and file input stream is going to read the  input bytes which are
         * present in the file,, so if i need to read something of byte type, then of course i need to make the array
         * of byte type*/
        /*so with the help of buffer variable i am going to read the byte data's and then i am going to write it inside
         * my output file which is gzipOutputStream,,, and i am going to write the compressed data in gzipOutputStream*/
        byte[] buffer = new byte[1024];
        /*gzipOutputStream ---> it helps me to writing the compressed data
         * fileInputStream  ---> it helps me reading the data */

        int length;
        /*so first it will read file input stream inside the buffer array until it reaches the end of the file,
         * or whatever be the length at that moment and then store that particular value inside the length variable*/
        /*so i will get the total value of my input file inside the length*/
        while((length = fileInputStream.read(buffer)) != -1){
            /*Now i want those bytes to be stored in a compressed way inside my output stream file which is GZIP*/
            gzipOutputStream.write(buffer,0,length);
        }
        gzipOutputStream.close();
        fileOutputStream.close();
        fileInputStream.close();

    }
    public static void main(String[] args) throws IOException {
        File path = new File("");
        method(path);
    }
}
