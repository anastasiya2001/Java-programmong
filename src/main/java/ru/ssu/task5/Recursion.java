import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Recursion {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Recursion <directory_path> <target_string>");
            return;
        }

        String directoryPath = args[0];
        String targetString = args[1];

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory not found.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Provided path is not a directory.");
            return;
        }

        // Perform recursive search and archive
        archiveFiles(directory, targetString);

        System.out.println("Archiving completed.");
    }

    private static void archiveFiles(File directory, String targetString) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    archiveFiles(file, targetString); // Recursive call for directories
                } else if (file.getName().contains(targetString)) {
                    // If file name contains targetString, archive it
                    archiveFile(file);
                }
            }
        }
    }

    private static void archiveFile(File file) {
        try {
            File archiveFile = new File(file.getParent(), file.getName() + ".zip");
            FileOutputStream fos = new FileOutputStream(archiveFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry zipEntry = new ZipEntry(file.getName());

            zos.putNextEntry(zipEntry);

            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            fis.close();
            zos.closeEntry();
            zos.close();
            fos.close();

            // Deleting the original file after archiving
            file.delete();

            System.out.println("File " + file.getName() + " archived successfully.");

        } catch (IOException e) {
            System.out.println("Error archiving file: " + e.getMessage());
        }
    }
}
