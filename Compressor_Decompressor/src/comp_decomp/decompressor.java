package comp_decomp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
public class decompressor {

    public static void method(File file) throws IOException {

        String fileDirectory = file.getParent();

        /*now we are going to take the compressed file int the file input stream*/
        FileInputStream fileInputStream = new FileInputStream(file);

        /*so as the file is  compressed file,, we are using the GZIP input stream to assured that compressed file
         * are read properly*/
        GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);

        /*the output stream is going to look like normal file so we can use normal file output stream*/
        FileOutputStream fileOutputStream = new FileOutputStream(fileDirectory + "/DecompressedFile");

        byte[] buffer = new byte[1024];
        int length;
        while((length = gzipInputStream.read(buffer)) != 1){
            fileOutputStream.write(buffer,0,length);
        }
        gzipInputStream.close();
        fileOutputStream.close();
        fileInputStream.close();

    }

    public static void main(String[] args) throws IOException {
        File path = new File("");
        method(path);
    }
}
