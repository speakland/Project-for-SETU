import java.io.*;
import java.util.Objects;
import java.util.Scanner;

/*
  The FileExample class provides functionality for working with text files in Java.
 */
public class FileExample {
    private File file;

    /*
      Constructor that takes a file name and creates a FileExample object.
      @param fileName The name of the file.
     */
    public FileExample(String fileName) {
        this.file = new File(fileName);
    }

    /*
      Method for inserting text into the file from the console.
     @throws IOException Exception that may occur during file operations.
     */
    public void fileInsert() throws IOException {
        try (FileWriter writer = new FileWriter(file, true)) {
            Scanner scanner = new Scanner(System.in);

            // Read input from the console until "exit" is entered.
            String line = scanner.nextLine();
            while (!Objects.equals(line, "exit")) {
                // Write the input line to the file and append a new line character.
                writer.write(line);
                writer.write("\n");
                line = scanner.nextLine();
            }
        }
    }

    /*
     * Method for extracting and printing the content of the file.
     * @throws IOException Exception that may occur during file operations.
     */
    public void fileExtraction() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Read each line from the file and print it to the console.
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    /*
      Method to erase the content of the file.
      @throws IOException Exception that may occur during file operations.
     */
    public void eraseFile() throws IOException {
        try (FileWriter writer = new FileWriter(file, false)) {
            // Write an empty string to the file, effectively erasing its content.
            writer.write("");
        }
    }

    /*
      Method to copy content from another file to the current file.
      @param sourceFile The file from which to copy the content.
      @throws IOException Exception that may occur during file operations.
     */
    public void copyFromFile(File sourceFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String line;

            // Read each line from the source file and write it to the current file.
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
