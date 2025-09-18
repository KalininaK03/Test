package task2;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static final String[] WORDS = {"java", "program", "computer", "game", "school"};
    private static final int MAX_LIVES = 6;

    private String word;
    private char[] guessedWord;
    private int lives;
    private boolean gameWon;

    public Hangman() {
        Random rand = new Random();
        this.word = WORDS[rand.nextInt(WORDS.length)];
        this.guessedWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            guessedWord[i] = '_';
        }
        this.lives = MAX_LIVES;
        this.gameWon = false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (lives > 0 && !gameWon) {
            displayGameState();
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            boolean found = processGuess(guess);
            if (!found) {
                lives--;
                System.out.println("Wrong letter!");
            }
            checkWinCondition();
            displayHangman();
        }

        displayGameResult();
        scanner.close();
    }

    private void displayGameState() {
        System.out.println("Word: " + String.valueOf(guessedWord));
        System.out.println("Lives left: " + lives);
    }

    private boolean processGuess(char guess) {
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                guessedWord[i] = guess;
                found = true;
            }
        }
        return found;
    }

    private void checkWinCondition() {
        gameWon = true;
        for (char c : guessedWord) {
            if (c == '_') {
                gameWon = false;
                break;
            }
        }
    }

    private void displayHangman() {
        String[] hangmanArt = {
            " O \n/|\\\n/ \\",
            " O \n/|\\\n/  ",
            " O \n/|\\",
            " O \n/| ",
            " O \n | ",
            " O "
        };
        if (lives < MAX_LIVES) {
            System.out.println(hangmanArt[lives]);
        }
    }

    private void displayGameResult() {
        if (gameWon) {
            System.out.println("You won! The word was: " + word);
        } else {
            System.out.println("Game over! The word was: " + word);
            System.out.println(hangmanArt[0]);
        }
    }

    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.play();
    }
}