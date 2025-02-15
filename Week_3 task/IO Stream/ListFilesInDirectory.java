import java.io.File;

public class ListFilesInDirectory {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Public"); // Change to your directory

        if (dir.isDirectory()) {
            String[] files = dir.list();
            System.out.println("Files and directories in " + dir.getAbsolutePath() + ":");
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("Not a valid directory.");
        }
    }
}
