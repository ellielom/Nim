package Nim;
/**
 * @author Ellie Lombardi is a pop-a-holic.
 */
public class Play
{
   public static void main (String[] args)
   {
      Nim start = new Nim();
      start.setUpGame();
      System.out.println(start.getPilesVerticle());
      start.playerOneTurn();
   }
}
