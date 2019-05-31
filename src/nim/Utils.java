package Nim;
import java.util.Scanner;
/**
 * @author Ellie Lombardi is a pop-a-holic.
 */
public class Utils
{
   Scanner scan = new Scanner(System.in);
   int pileA = 3;
   int pileB = 4;
   int pileC = 5;
   String player1;
   String player2;

   public String getPiles ()
   {
      return "\n" + "A: " + this.pileA + "        " + "B: " + this.pileB + "        " + "C: " + this.pileC + "\n";
   }

   public String getPilesStars ()
   {
      System.out.println();
      String output = "A: ";
      // Pile A
      for (int counter = 0; counter < this.pileA; counter++) {
         output += "*";
      }
      // Pile B
      output += "\n" + "B: ";
      for (int counter = 0; counter < this.pileB; counter++) {
         output += "*";
      }
      // Pile C
      output += "\n" + "C: ";
      for (int counter = 0; counter < this.pileC; counter++) {
         output += "*";
      }
      return output;
   }

   public String getPilesVerticle ()
   {
      // Set up all 3 piles to have a "default" of the space.
      String[] verticlePilesA = new String[5];
      for (int i = 0; i < verticlePilesA.length; i++) {
         verticlePilesA[i] = "  ";
      }
      String[] verticlePilesB = new String[5];
      for (int i = 0; i < verticlePilesB.length; i++) {
         verticlePilesB[i] = "  ";
      }
      String[] verticlePilesC = new String[5];
      for (int i = 0; i < verticlePilesC.length; i++) {
         verticlePilesC[i] = "  ";
      }

      // Add stars for the things remaining
      for (int i = 0; i < this.pileA; i++) {
         verticlePilesA[i] = "X";
      }
      for (int i = 0; i < this.pileB; i++) {
         verticlePilesB[i] = "X";
      }
      for (int i = 0; i < this.pileC; i++) {
         verticlePilesC[i] = "X";
      }

      String output = "";
      for (int i = 0; i < 5; i++) {
         output += verticlePilesA[(verticlePilesA.length - 1) - i] + "    " + verticlePilesB[(verticlePilesB.length - 1) - i] + "    " + verticlePilesC[(verticlePilesC.length - 1) - i];
         output += "\n";
      }
      output += "---------------" + "\n";
      output += "A" + "    " + "B" + "    " + "C";

      return output;
   }

   public int getPilesTotal ()
   {
      return this.pileA + this.pileB + this.pileC;
   }

   public void choosePile ()
   {
      String pile = scan.nextLine();
      pile = pile.toUpperCase();
//      boolean isInputCorrect = false;
//      if ("A".equals(pile) || "B".equals(pile) || "C".equals(pile)) {
//         isInputCorrect = true;
//      }
      while (!("A".equals(pile) || "B".equals(pile) || "C".equals(pile))) {
         System.out.println("Please enter A, B, or C.");
         pile = scan.nextLine();
         pile = pile.toUpperCase();
//         if ("A".equals(pile) || "B".equals(pile) || "C".equals(pile)) {
//            isInputCorrect = true;
//         }
      }
      switch (pile) {
         case "A":
            pileA();
            break;
         case "B":
            pileB();
            break;
         case "C":
            pileC();
      }
   }



   public void pileA ()
   {
      if (pileA == 0) {
         System.out.println("Nice try, but that pile is empty. Please choose again.");
         choosePile();
      }
      System.out.println("How many would you like to remove?");
      int remove = convertStringInputToInt();
      if (remove > pileA) {
         System.out.println("Sorry, but pile A doesn't have that many. Try again.");
         System.out.println("Please choose a pile:");
         choosePile();
      }


      else {
         pileA -= remove;
      }
   }

   public void pileB ()
   {
      if (pileB == 0) {
         System.out.println("Nice try, but that pile is empty. Please choose again.");
         choosePile();
      }
      System.out.println("How many would you like to remove?");
      int remove = convertStringInputToInt();
      if (remove > pileB) {
         System.out.println("Sorry, but pile B doesn't have that many. Try again.");
         System.out.println("Please choose a pile:");
         choosePile();
      }
      else {
         pileB -= remove;
      }
   }

   public void pileC ()
   {
      if (pileC == 0) {
         System.out.println("Nice try, but that pile is empty. Please choose again.");
         choosePile();
      }
      System.out.println("How many would you like to remove?");
      int remove = convertStringInputToInt();
      if (remove > pileC) {
         System.out.println("Sorry, but pile C doesn't have that many. Try again.");
         System.out.println("Please choose a pile:");
         choosePile();
      }
      else {
         pileC -= remove;
      }
   }

   public int convertStringInputToInt ()
   {
      String removeInput;
      int remove = 0;
      removeInput = scan.nextLine();
      String removeInputLower = removeInput.toLowerCase();
      do {
         switch (removeInputLower) {
            case "1":
            case "one":
               remove = 1;
               break;
            case "2":
            case "two":
               remove = 2;
               break;
            case "3":
            case "three":
               remove = 3;
               break;
            case "4":
            case "four":
               remove = 4;
               break;
            case "5":
            case "five":
               remove = 5;
               break;
            default:
               remove = -999;
               System.out.print(removeInput + " is an invalid option. Please try again: ");
               removeInput = scan.nextLine();
               removeInputLower = removeInput.toLowerCase();
         }
      }
      while (remove == -999);
      return remove;
   }

}
