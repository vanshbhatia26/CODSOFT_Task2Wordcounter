import java.util.Scanner;
//import java.util.HashMap;
//timport java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;

public class Word {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String text = "";

        System.out.println("Enter 'T' to input text or 'F' to input a file:");
        String choice = s.nextLine().trim();

        if (choice.equalsIgnoreCase("T")) {
            System.out.println("Enter the text:");
            text = s.nextLine();
        } else if (choice.equalsIgnoreCase("F")) {
            System.out.println("Enter the file path:");
            String filePath = s.nextLine().trim();
            try {
                text = readFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
                System.exit(0);
            }
        } else {
            System.out.println("Invalid choice!");
            System.exit(0);
        }

        int wordCount = countWords(text);
        System.out.println("Total word count: " + wordCount);
    }

    public static int countWords(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        String[] words = text.split("[\\p{Punct}\\s]+");

        int Count = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                Count++;
            }
        }

        return Count;
    }

    public static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            content.append(fileScanner.nextLine()).append(" ");
        }

        fileScanner.close();
        return content.toString();
    }
}
