import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        FileReader fileReader = null;

        try {
            fileWriter = new FileWriter("mile.txt");
            fileWriter.write("I love PAPL.");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Exception e) {
                System.out.println("Error closing fileWriter: " + e);
            }
        }

        try {
            fileReader = new FileReader("mile.txt");
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String content = scanner.nextLine();
                System.out.println(content);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (Exception e) {
                System.out.println("Error closing fileReader: " + e);
            }
        }
    }
}
