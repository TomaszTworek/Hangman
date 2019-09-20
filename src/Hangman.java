import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hangman {
    private GameState gameState;
    private Scanner scan = new Scanner(System.in);
    private Judge judge;

    public Hangman() throws FileNotFoundException {
        String wordChosenFromFile = WordDictionary.chooseRandomWordFromFile(new File("Countries.txt"));
        //String wordChosen = wordDictionary.getRandomWord();
        gameState = new GameState(wordChosenFromFile);
        judge = new Judge(gameState);
    }


    private void printHiddenGuessWord() {
        for (char x : gameState.getGuessWord().toCharArray()) {
            if (gameState.isCharAlreadyUsed(x)) {
                System.out.print(x);
            } else {
                System.out.print("*");
            }
        }
        System.out.println();
    }

    private char getUserGuess() {
        while (true) {
            try {
                return scan.nextLine().charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Nieprawidłowy znak");
            }
        }
    }

    public void start() {
        do {
            printHiddenGuessWord();
            char userGuess = getUserGuess();

            if (!gameState.isCharInGuessWord(userGuess)) {
                gameState.loseHealthPointAndPrintLifePoints();
                if (gameState.getHealthPoint() <= 0) {
                    System.out.println("Przegrałeś!");
                    System.out.println("Zgadywane słowo: " + gameState.getGuessWord());
                    break;
                }
            }

            if (gameState.isCharAlreadyUsed(userGuess)
                    || !gameState.isCharInGuessWord(userGuess)) {
                continue;
            }

            gameState.addUserGuess(userGuess);


            if (judge.isPlayerWin()) {
                System.out.println("Wygrałeś!\n");
                break;
            }

        } while (true);
    }
}