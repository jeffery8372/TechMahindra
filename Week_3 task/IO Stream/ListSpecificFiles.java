import java.io.File;
import java.io.FilenameFilter;

public class ListSpecificFiles {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Public"); // Change to your directory
        String extension = ".txt"; // Change to desired extension

        FilenameFilter filter = (dir1, name) -> name.endsWith(extension);

        String[] files = dir.list(filter);
        System.out.println("Files with " + extension + " extension:");
        for (String file : files) {
            System.out.println(file);
        }
    }
}
