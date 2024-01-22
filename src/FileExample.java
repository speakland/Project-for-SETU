import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class FileExample {
    private File file;

    public FileExample(String fileName) {
        this.file = new File(fileName);
    }

    public FileExample(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void fileInsert() throws IOException {
        try (FileWriter writer = new FileWriter(file, true)) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            while (!Objects.equals(line, "exit")) {
                writer.write(line);
                writer.write("\n");
                line = scanner.nextLine();
            }
        }
    }

    public void fileExtraction() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public void eraseFile() throws IOException {
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write("");

        }
    }
    public void copyFromFile(File sourceFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}


