package eg.edu.alexu.csd.datastructure.hangman.c77;
import java.util.Scanner; 
public class main {

	public static void main(String[] args)
{
   Hangman game = new Hangman();
   Scanner sc = new Scanner(System.in); 
   System.out.println("enter number of max wrong guesses");
   Integer max = sc.nextInt();
   game.setDictionary(game.words);
   game.setMaxWrongGuesses(max);
   String nam = new String();
   String temp = new String();
   temp = game.selectRandomSecretWord();
   while((game.lifecounter!=0)&&(game.state==0)) {
	System.out.println("Number of remaining guesses = "+game.lifecounter);   
	System.out.println("Enter letter of you choice :\n");     
   Character x = sc.next().charAt(0);
   try {
	nam = game.guess(x);
	System.out.println(nam);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   } 
}
}
