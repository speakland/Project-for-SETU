import java.io.File;
import java.io.IOException;

/**
 * The Main class contains the main method to demonstrate the functionality of the FileExample class.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // Specify the name of the test file.
        String fileName = "testFile";

        // Specify the name of the source file for copying.
        File sourceFile = new File("sourceFile");

        // Create a FileExample object with the specified test file name.
        FileExample testFile = new FileExample(fileName);

        // Call the testFunc method to demonstrate file operations.
        testFunc(testFile, sourceFile);
    }

    /**
     * Method to test various file operations using the FileExample class.
     *
     * @param testFile   The FileExample object to perform operations on.
     * @param sourceFile The source file for copying content.
     * @throws IOException Exception that may occur during file operations.
     */
    public static void testFunc(FileExample testFile, File sourceFile) throws IOException {
        // Insert text into the file from the console.
        System.out.println("Insert into file from console (type 'exit' to stop):");
        testFile.fileInsert();

        // Display the content of the file.
        System.out.println("Text file showcase:");
        testFile.fileExtraction();

        // Erase the content of the file.
        System.out.println("Text file showcase after erasing:");
        testFile.eraseFile();

        // Display the content of the file after erasing.
        testFile.fileExtraction();

        // Copy content from another file to the current file.
        System.out.println("Text file showcase after copying from another file:");
        testFile.copyFromFile(sourceFile);

        // Display the content of the file after copying.
        testFile.fileExtraction();
    }
}
