import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileToByteArray {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Public\\example.txt"); // Change to your file

        FileInputStream fis = new FileInputStream(file);
        byte[] fileData = new byte[(int) file.length()];
        fis.read(fileData);
        fis.close();

        System.out.println("File data in bytes: " + new String(fileData));
    }
}
