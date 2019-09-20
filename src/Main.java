import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    private final static String NEW_GAME = "Rozpocznij grę";
    private final static String ADD_WORD = "Dodaj słowo do słownika";
    private final static String EXIT = "Wyjdź";

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu(
                NEW_GAME,
                ADD_WORD,
                EXIT
        );

        System.out.println("Witaj w grze!!\n");
        boolean displayMenu = true;
        while (displayMenu) {
            switch (menu.printMenuAndGetChoice()) {
                case NEW_GAME:
                    Hangman game = new Hangman();
                    game.start();
                    break;
                case ADD_WORD:
                    WordDictionary wordDictionary = new WordDictionary();
                    wordDictionary.addWord();
                    break;
                case EXIT:
                    displayMenu = false;
                    break;
            }
        }

    }
}