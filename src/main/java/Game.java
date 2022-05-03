import java.util.*;

public class Game {
    //Table with all the films in game
    final static String[] table = {
            "the shawshank redemption",
            "the godfather",
            "the dark knight",
            "schindler's list",
            "pulp fiction",
            "the lord of the rings",
            "the good the bad and the ugly",
            "fight club",
            "the lord of the rings",
            "forrest gump",
            "star wars",
            "inception",
            "the lord of the rings",
            "the matrix",
            "samurai",
            "star wars",
            "city of god",
            "the silence of the lambs",
            "batman begins",
            "die hard",
            "chinatown",
            "room",
            "dunkirk",
            "fargo",
            "no country for old men" };

    public static void main(String[] args) {
        //Start game screen and rules
        System.out.println("Welcome in game! Guess The Movie");
        System.out.println("You have 10 points and after every wrong answer you are losing 1 point!");
        System.out.println("Good luck and let's win this game!");
        Set<Character> wrongUserLetters = new HashSet<>();
        String title = getRandomMovieTitle();
        char[] userTitle = init(title);
        System.out.print("\n" + "You are guessing: ");
        System.out.println(userTitle);
        int wrongGuesses = 0;

        //Implements user guessing
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n" + "Guess a letter: ");
            char letter = scanner.nextLine().charAt(0);
            boolean correct = false;
            for(int i = 0; i < title.length(); i++){
                if (letter == title.charAt(i)) {
                    userTitle[i] = letter;
                    correct = true;
                }
            }

            //Counting user wrong guesses
            if (!correct){
                boolean newWrongLetterAdded = wrongUserLetters.add(letter);
                if (newWrongLetterAdded){
                    wrongGuesses++;
                    System.out.println("You have guessed (" + wrongGuesses +  ") wrong letters: " + wrongUserLetters);
                }else {
                    System.out.println("\n" + "This letter was used before!");
                    System.out.println("You have guessed (" + wrongGuesses + ") wrong letters: " + wrongUserLetters);
                }
            }
            System.out.print("\n" + "You are guessing: ");
            System.out.println(userTitle);

            //Implements when game will end
        } while (! Arrays.equals(userTitle, title.toCharArray()) && wrongGuesses != 10);
        if (wrongGuesses == 10){
            System.out.println("You lose!");
            System.out.println("Try again, next round is your!");
        } else {
            System.out.println("You win!");
            System.out.println("You have guesses '" + title + "' correctly.");
        }
    }

    //Changing chars from title to "_"
    private static char[] init(String title) {
        char[] userTitle = new char[title.length()];
        for(int i = 0; i < title.length(); i++){
            userTitle[i]  = '_';
        }
        return userTitle;
    }

    //Getting Random Movie Title
    private static String getRandomMovieTitle() {
        int max = table.length;
        int min = 0;
        Random random = new Random();
        int randomIndex = random.nextInt(max - min);
        return table[randomIndex];
    }
}
