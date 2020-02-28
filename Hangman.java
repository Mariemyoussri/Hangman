package eg.edu.alexu.csd.datastructure.hangman.c77;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.regex.Pattern;

public class Hangman implements IHangman{
   final int  size = 100000;
   public int maxwrongguesses=1;
   public int lifecounter=0;
   public int i=0;
   public String[] words = new String[size];
   public String secret ;
   public String guess;
   public int state=0;
   private char[] charword;
   
   
   public String[] readfile() {
	   try {
		   FileReader freader = new FileReader("Dictionary.txt");
		   BufferedReader breader = new BufferedReader(freader);
		   String word= null;
		   while((word= breader.readLine())!= null)
		   {
			   words[i]=word.toLowerCase();
			   i++;
		    }
		   breader.close();
	   }
	   catch(IOException e){
		   System.out.println("cant find file");
	   }
	   return words;
   }
	@Override
	public void setDictionary(String[] words) {
		String [] word = readfile();
		for(int j=0;j<i;j++) {
		words[j]=word[j];	
	}
		
	}

	@Override
	public String selectRandomSecretWord() {
		Random rand = new Random();
		int random = rand.nextInt(i);
		secret = words[random];
		charword = new char[secret.length()];
		for(int k=0;k<secret.length();k++) {
			charword[k]='-';
		}
		return words[random];
	}

	@Override
	public String guess(Character c) throws Exception {
		if(secret.matches("[a-zA-Z]*$")) {
			int wrong = 0;
			for(int k=0;k<secret.length();k++) {
			if( secret.charAt(k)==Character.toLowerCase(c)) {
			charword[k]=c;	
			wrong =1;
			}
			}
		if(wrong == 0) {
		if(Character.isLetter(c)) {	
	    System.out.println("Wrong guess\n");
		lifecounter--;
		}
		else if (!Character.isLetter(c)) {
			System.out.println("Wrong input\n");
		}
		}	
		else if(wrong==1) {
			System.out.println("Good guess\n");
		}
		if(lifecounter == 0) {
			System.out.println("you are a loser\n");
			return null;
		}
		 guess = new String(charword);
		 if(guess.equals(secret)) {
			 state = 1;
			System.out.println(" you're a winner\n");
			return guess;
			
		 }
		 return guess;
		}
		else {
			throw new Exception("Error: Buggy word");
		}
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		if(max==null) {
			maxwrongguesses=1;
		}
		else {
		maxwrongguesses = max;
		}
		lifecounter = maxwrongguesses;
		
	}

}
