import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class WordDictionary {
    Random rand = new Random();
    private String randomWord = "";

    public String getRandomWord() {
        return randomWord;
    }


    public static String chooseRandomWordFromFile(File file) throws FileNotFoundException {
        String randomWord = "";
        int i = 0;

        Random rand = new Random();
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            i++;
            String line = sc.nextLine();
            if (rand.nextInt(i) == 0)
                randomWord = line;
        }
        return randomWord.toLowerCase();

    }

    public void addWord() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dodaj nowe słowo: ");
        String country = scanner.nextLine();
        Writer output = new BufferedWriter(new FileWriter("Countries.txt", true));
        output.append("\n"+country);
        output.close();
    }
}
