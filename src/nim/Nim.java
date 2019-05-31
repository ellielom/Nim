package Nim;
import java.util.Random;
import java.util.Scanner;
/**
 * @author Ellie Lombardi is a pop-a-holic.
 */
public class Nim
{
   Utils util = new Utils();
   Random rnd = new Random();
   Scanner scan = new Scanner(System.in);
   int numPlayers;
   boolean pileAEmpty = false;
   boolean pileAEven = false;
   boolean pileBEmpty = false;
   boolean pileBEven = false;
   boolean pileCEmpty = false;
   boolean pileCEven = false;

   public String getP1Name ()
   {
      return util.player1;
   }

   public String getP2Name ()
   {
      return util.player2;
   }


   public void setPlayerOneName (String arg1)
   {
      util.player1 = arg1;
   }

   public void setPlayerTwoName (String arg1)
   {
      util.player2 = arg1;
   }

   public void setUpGame ()
   {
      System.out.println("\n" + "~~Welcome to Nim!~~" + "\n");
      System.out.print("How many players will there be?: ");
      this.numPlayers = util.convertStringInputToInt();
//      while (this.numPlayers > 2 || this.numPlayers < 1) 
      while (!(this.numPlayers == 2 || this.numPlayers == 1)) {
         System.out.println("Sorry, there can only be one or two players.");
         System.out.print("How many players will there be?: ");
         this.numPlayers = util.convertStringInputToInt();
      }
      System.out.println();
      System.out.print("Player 1, enter your name: ");
      setPlayerOneName(scan.nextLine());
      System.out.println();
      if (this.numPlayers == 2) {
         System.out.print("Player 2, enter your name: ");
         setPlayerTwoName(scan.nextLine());
         System.out.println();
      }
      else {
         setPlayerTwoName("The Computer");
      }
   }

   public void playerOneTurn ()
   {
//      Scanner scan = new Scanner(System.in);
      if (util.getPilesTotal() == 1 || util.getPilesTotal() == 0) {
         System.out.println(getP1Name() + " must pick up the last counter, so " + getP2Name() + " wins!");
      }
      else {
         System.out.println(util.player1 + ", choose a pile:");
         util.choosePile();
         System.out.println(util.getPilesVerticle());
         System.out.println();
         if (this.numPlayers == 1) {
            this.computerTurn();
         }
         else {
            this.playerTwoTurn();
         }
      }
   }

   public void playerTwoTurn ()
   {
      if (util.getPilesTotal() == 1 || util.getPilesTotal() == 0) {
         System.out.println(getP2Name() + " must pick up the last counter, so " + getP1Name() + " wins!");
      }
      else {
         System.out.println(util.player2 + ", choose a pile:");
         util.choosePile();
         System.out.println(util.getPilesVerticle());
         System.out.println();
         this.playerOneTurn();
      }
   }

   
   public int numEmptyPiles ()
   {
      int empty = 0;
      if (util.pileA == 0) {
         empty++;
         this.pileAEmpty = true;
      }
      if (util.pileB == 0) {
         empty++;
         this.pileBEmpty = true;
      }
      if (util.pileC == 0) {
         empty++;
         this.pileCEmpty = true;
      }
      return empty;
   }

   public boolean isPileEven (int pile)
   {
      boolean answer = false;
      if (pile % 2 == 0) {
         answer = true;
      }
      return answer;
   }

   public boolean isPileOdd (int pile)
   {
      boolean answer = false;
      if (pile % 2 == 1) {
         answer = true;
      }
      return answer;
   }

   public boolean isPileLessThan3 (int pile)
   {
      return pile < 3;
   }

   public boolean arePilesLessThan3 (int pileOne, int pileTwo)
   {
      return isPileLessThan3(pileOne) && isPileLessThan3(pileTwo);
   }

   public boolean isPileOddAndLessThan3 (int pile)
   {
      // removed ! is Pilelessthan 3
      return isPileLessThan3(pile) && isPileOdd(pile);
   }

   public boolean arePilesOddAndLessThan3 (int pileOne, int pileTwo)
   {
      // removed ! is Pilelessthan 3
      return isPileLessThan3(pileOne) && isPileOdd(pileOne) && isPileLessThan3(pileOne) && isPileOdd(pileOne);
   }

   public boolean isPileEvenAndLessThan3 (int pile)
   {
      return isPileLessThan3(pile) && isPileEven(pile);
   }

   public boolean arePilesEvenAndLessThan3 (int pileOne, int pileTwo)
   {
      return isPileEvenAndLessThan3(pileOne) && isPileEvenAndLessThan3(pileTwo);
   }

   public boolean arePilesEvenAndLessThan3 (int pileOne, int pileTwo, int pileThree)
   {
      return arePilesEvenAndLessThan3(pileOne, pileTwo) && isPileEvenAndLessThan3(pileThree);
   }


   public boolean isPileEvenAndGreaterThanOrEqualTo3 (int pile)
   {
      return isPileEven(pile) && !isPileLessThan3(pile);
   }


   public boolean isPileOddAndGreaterThanOrEqualTo3 (int pile)
   {
      // added ! to isPileLessThan3
      return !isPileEven(pile) && !isPileLessThan3(pile);
   }

   public boolean arePilesOddAndGreaterThanOrEqualTo3 (int pileOne, int pileTwo)
   {
      return isPileOddAndGreaterThanOrEqualTo3(pileOne) && isPileOddAndGreaterThanOrEqualTo3(pileTwo);
   }



   public int howManyPilesEven (int pileOne, int pileTwo)
   {
      int numEvenPiles = 0;
      if (isPileEven(pileOne)) {
         numEvenPiles++;
      }
      if (isPileEven(pileTwo)) {
         numEvenPiles++;
      }
      return numEvenPiles;
   }

   public int howManyPilesEven (int pileOne, int pileTwo, int pileThree)
   {
      int numEvenPiles = howManyPilesEven(pileOne, pileTwo);
      if (isPileEven(pileThree)) {
         numEvenPiles++;
      }
      return numEvenPiles;
   }



   public void computerTurn ()
   {
      if (util.getPilesTotal() > 1) {
         // -------------------------------------------------
         // IF THERE IS ONE PILE LEFT
         // -------------------------------------------------
         if (numEmptyPiles() == 2) {
            // Take all but one from the last pile
            if (util.pileA > 0) {
               System.out.println("The computer chooses Pile A.");
               System.out.println("The computer takes " + (util.pileA - 1) + " from the pile." + "Ellie Test3");
               util.pileA = util.pileA - (util.pileA - 1);
            }
            else if (util.pileB > 0) {
               System.out.println("The computer chooses Pile B.");
               System.out.println("The computer takes " + (util.pileB - 1) + " from the pile.");
               util.pileB = util.pileB - (util.pileB - 1);
            }
            else {
               System.out.println("The computer chooses Pile C.");
               System.out.println("The computer takes " + (util.pileC - 1) + " from the pile.");
               util.pileC = util.pileC - (util.pileC - 1);
            }
         }

         // -------------------------------------------------
         // IF THERE ARE TWO PILES LEFT
         // -------------------------------------------------
         else if (numEmptyPiles() == 1) {
            // If one pile is greater than or equal to three and is an even number, take away 2
            if (isPileEvenAndGreaterThanOrEqualTo3(util.pileA) || isPileEvenAndGreaterThanOrEqualTo3(util.pileB) || isPileEvenAndGreaterThanOrEqualTo3(util.pileC)) {
               if (isPileEvenAndGreaterThanOrEqualTo3(util.pileA) && util.pileA != 0) {
                  System.out.println("\n" + "The computer chooses Pile A.");
                  System.out.println("The computer takes " + 2 + " from the pile." + "Ellie Test10 \n");
                  util.pileA -= 2;
               }
               else if (isPileEvenAndGreaterThanOrEqualTo3(util.pileB)) {
                  System.out.println("\n" + "The computer chooses Pile B.");
                  System.out.println("The computer takes " + 2 + " from the pile." + "\n");
                  util.pileB -= 2;
               }
               else {
                  System.out.println("\n" + "The computer chooses Pile C.");
                  System.out.println("The computer takes " + 2 + " from the pile." + "\n");
                  util.pileC -= 2;
               }
            }
            // if both piles are odd and > = 3, take 1 from either pile
            else if (arePilesOddAndGreaterThanOrEqualTo3(util.pileA, util.pileB) || arePilesOddAndGreaterThanOrEqualTo3(util.pileA, util.pileC) || arePilesOddAndGreaterThanOrEqualTo3(util.pileB, util.pileC)) {
               int whichPile = rnd.nextInt(1);
               switch (whichPile) {
                  case 0:
                     if (arePilesOddAndGreaterThanOrEqualTo3(util.pileA, util.pileB)) {
                        System.out.println("\n" + "The computer chooses Pile A.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "Ellie Test4" + "\n");
                        util.pileA--;
                     }
                     else if (arePilesOddAndGreaterThanOrEqualTo3(util.pileA, util.pileC)) {
                        System.out.println("\n" + "The computer chooses Pile C.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                        util.pileC--;
                     }
                     else {
                        System.out.println("\n" + "The computer chooses Pile B.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                        util.pileB--;
                     }
                     break;
                  case 1:
                     if (arePilesOddAndGreaterThanOrEqualTo3(util.pileA, util.pileB)) {
                        System.out.println("\n" + "The computer chooses Pile B.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                        util.pileB--;
                     }
                     else if (arePilesOddAndGreaterThanOrEqualTo3(util.pileA, util.pileC)) {
                        System.out.println("\n" + "The computer chooses Pile A.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "Ellie Test5 \n");
                        util.pileA--;
                     }
                     else {
                        System.out.println("\n" + "The computer chooses Pile C.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                        util.pileC--;
                     }
                     break;
               }
            }

            // If both piles are even & less than three (ie, 2) EL Note: In else if, and some others, the only option really is "2" or maybe "1". Instead of calling the methods, I could just check if the piles are == to the desired number, however, for practice, I wanted to use the methods for 'flexibility'. 
            else if (arePilesEvenAndLessThan3(util.pileA, util.pileB) || arePilesEvenAndLessThan3(util.pileA, util.pileC) || arePilesEvenAndLessThan3(util.pileB, util.pileC)) {
               // Take 1 from either
               int whichPile = rnd.nextInt(1);
               switch (whichPile) {
                  case 0:
                     if (arePilesEvenAndLessThan3(util.pileA, util.pileB) && util.pileA != 0) {
                        System.out.println("\n" + "The computer chooses Pile A.");
                        System.out.println("The computer takes " + 1 + " from the pile. Ellie Test6" + "\n");
                        util.pileA--;
                     }
                     else if (arePilesEvenAndLessThan3(util.pileA, util.pileC)) {
                        System.out.println("\n" + "The computer chooses Pile C.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                        util.pileC--;
                     }
                     else {
                        System.out.println("\n" + "The computer chooses Pile B.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                        util.pileB--;
                     }
                     break;
                  case 1:
                     if (arePilesEvenAndLessThan3(util.pileA, util.pileB)) {
                        System.out.println("\n" + "The computer chooses Pile B.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                        util.pileB--;
                     }
                     else if (arePilesEvenAndLessThan3(util.pileA, util.pileC)) {
                        System.out.println("\n" + "The computer chooses Pile A.");
                        System.out.println("The computer takes " + 1 + " from the pile. Ellie Test7" + "\n");
                        util.pileA--;
                     }
                     else {
                        System.out.println("\n" + "The computer chooses Pile C.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                        util.pileC--;
                     }
                     break;
               }
            }

            // If one pile is < 3 and is even 
            else if (isPileEvenAndGreaterThanOrEqualTo3(util.pileA) || isPileEvenAndGreaterThanOrEqualTo3(util.pileB) || isPileEvenAndGreaterThanOrEqualTo3(util.pileC)) // Take one from the biggest pile 
            {
               if (util.pileA > util.pileB && util.pileA > util.pileC) {
                  System.out.println("\n" + "The computer chooses Pile A.");
                  System.out.println("The computer takes " + 1 + " from the pile.Ellie Test8" + "\n");
                  util.pileA--;
               }
               else if (util.pileB > util.pileA && util.pileB > util.pileC) {
                  System.out.println("\n" + "The computer chooses Pile B.");
                  System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                  util.pileB--;
               }
               else {
                  System.out.println("\n" + "The computer chooses Pile C.");
                  System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                  util.pileC--;
               }
            }
            // If both piles have an odd number and less than 3
            else if (arePilesOddAndLessThan3(util.pileA, util.pileB) || arePilesOddAndLessThan3(util.pileA, util.pileC) || arePilesOddAndLessThan3(util.pileB, util.pileC)) {
               int whichPile = rnd.nextInt(1);
               switch (whichPile) {
                  case 0:
                     if (arePilesOddAndLessThan3(util.pileA, util.pileB)) {
                        System.out.println("\n" + "The computer chooses Pile A.");
                        System.out.println("The computer takes " + 1 + " from the pileEllie Test9." + "\n");
                        util.pileA--;
                     }
                     else if (arePilesOddAndLessThan3(util.pileA, util.pileC)) {
                        System.out.println("\n" + "The computer chooses Pile C.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                        util.pileC--;
                     }
                     else {
                        System.out.println("\n" + "The computer chooses Pile B.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                        util.pileB--;
                     }
                     break;
                  case 1:
                     if (arePilesOddAndLessThan3(util.pileA, util.pileB)) {
                        System.out.println("\n" + "The computer chooses Pile B.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                        util.pileB--;
                     }
                     else if (arePilesOddAndLessThan3(util.pileA, util.pileC)) {
                        System.out.println("\n" + "The computer chooses Pile A.");
                        System.out.println("The computer takes " + 1 + " from the pile. " + "ELLIE TEST1" + "\n");
                        util.pileA--;
                     }
                     else {
                        System.out.println("\n" + "The computer chooses Pile C.");
                        System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                        util.pileC--;
                     }
                     break;
               }
            }
            // If one pile has an even number less than 3 and the other pile has an odd number less than 3 (ie, 1 & 2)
            else if (howManyPilesEven(util.pileA, util.pileB) == 1 && arePilesLessThan3(util.pileA, util.pileB) || howManyPilesEven(util.pileB, util.pileC) == 1 && arePilesLessThan3(util.pileB, util.pileC) || howManyPilesEven(util.pileA, util.pileC) == 1 && arePilesLessThan3(util.pileA, util.pileC)) {
               // Take 2 from the biggest pile
               if (util.pileA > util.pileB && util.pileA > util.pileC) {
                  System.out.println("\n" + "The computer chooses Pile A.");
                  System.out.println("The computer takes " + 2 + " from the pile. Ellie Test12" + "\n");
                  util.pileA -= 2;
               }
               else if (util.pileB > util.pileA && util.pileB > util.pileC) {
                  System.out.println("\n" + "The computer chooses Pile B.");
                  System.out.println("The computer takes " + 2 + " from the pile." + "\n");
                  util.pileB -= 2;
               }
               else {
                  System.out.println("\n" + "The computer chooses Pile C.");
                  System.out.println("The computer takes " + 2 + " from the pile." + "\n");
                  util.pileC -= 2;
               }
            }

         }
         // -------------------------------------------------
         // IF THERE ARE THREE PILES LEFT
         // -------------------------------------------------
         else if (numEmptyPiles() == 0) {
            // Choose a random pile. If even, take all. If odd, take one.
            int whichPile = rnd.nextInt(2);
            switch (whichPile) {
               case 0:
                  if (util.pileA % 2 == 0) {
                     System.out.println("\n" + "The computer chooses Pile A.");
                     System.out.println("The computer takes the whole pile." + "\n");
                     util.pileA = 0;
                  }
                  else {
                     System.out.println("\n" + "The computer chooses Pile A.");
                     System.out.println("The computer takes " + 1 + " from the pile.Ellie Test11" + "\n");
                     util.pileA--;
                  }
                  break;
               case 1:
                  if (util.pileB % 2 == 0) {
                     System.out.println("\n" + "The computer chooses Pile B.");
                     System.out.println("The computer takes the whole pile." + "\n");
                     util.pileB = 0;
                  }
                  else {
                     System.out.println("\n" + "The computer chooses Pile B.");
                     System.out.println("The computer takes " + 1 + " from the pile." + "\n");
                     util.pileB--;
                  }
                  break;
               case 2:
                  if (util.pileC % 2 == 0) {
                     System.out.println("\n" + "The computer chooses Pile C.");
                     System.out.println("The computer takes the whole pile." + "\n");
                     util.pileC = 0;
                  }
                  else {
                     System.out.println("\n" + "The computer chooses Pile A.");
                     System.out.println("The computer takes " + 1 + " from the pile. " + "ELLIE TEST2" + "\n");
                     util.pileC--;
                  }
                  break;
            }
         }

         System.out.println(util.getPilesVerticle());
         System.out.println();
         this.playerOneTurn();
      }
      else {
         System.out.println(getP2Name() + " must pick up the last counter, so " + getP1Name() + " wins!");
      }
   }


   public String getPilesStars ()
   {
      return util.getPilesStars();
   }

   public String getPilesVerticle ()
   {
      return util.getPilesVerticle();
   }

}
