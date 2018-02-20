 import java.util.Scanner;

public class Map2
{
  private static char[] map = new char[51];
  private static int characterLocation;
  private static int HealthPoints =100;
  private static boolean playing = true;
  private static Scanner play = new Scanner(System.in);
  
  // INITIALIZE MAP FUNCTIONS ----------------------------------------
  public static void Map2() 
  {
   for (int i =1; i<map.length; i++)
   {
    int goldfish = (int)(Math.random()*2);
    if (goldfish ==0)
      map[i] = ' ';
    else if (goldfish ==1)
      map[i] = ' ';
   }
  }
   public static void MapCharacter()
   {
     int location = (int)(Math.random()* map.length-1) +1;
     if(map[location] == 'M' && location < map.length) location++;
     characterLocation = location;
     map[characterLocation] = 'C';
     
    /* for(int k =1; k<map.length; k++)
     {
       System.out.print(map[k]);                    // map print
              if (k > 0 && k % 10 ==0)
       System.out.println("");
         
     } */
   }
   public static void PrintMap()
   {
       for(int k =1; k<map.length; k++)
     {
       System.out.print(map[k]);
              if (k > 0 && k % 10 ==0)
       System.out.println("");
         
     }
   }
   // RNG METHOD---------------------------------
   public static int rANDOM()
   {
     return (int)(Math.random()* map.length-1) +1;
   }
   /// MONSTER METHODS --------------------------
   public static void MapMonster()
   {
     int temp = 0;
     do{
     int monsterAt =rANDOM(); //1
     if (monsterAt == characterLocation) monsterAt++;
     //if (monsterAt1 == monsterAt1) monsterAt++;
     map[monsterAt] = 'M';
     temp ++;}
     while(temp < 5);  // whatever temp goes to is the # of monsters
   }
   public static void CheckForMonsters()
   {
     int safe =0;
     for(int i =0; i< map.length; i++)
     {if(map[i] == 'M') safe++;}
      System.out.println( "There are " + safe + " monsters remaining");
   }
   
    public static int CheckForMonstersInt()
    {
     int safety =0;
     for(int i =0; i< map.length; i++)
     {if(map[i] == 'M') safety++;}
     return safety;
    }
   
   // Move functions --------------------------------------------------
   private static void CharacterLeft()
   {
     if(characterLocation >1)
     {characterLocation--;      map[characterLocation] = 'C';   map[characterLocation + 1] = ' ';}
     PrintMap();
   }
   private static void CharacterRight()
   {
     if(characterLocation < map.length-1)
     {characterLocation++;      map[characterLocation] = 'C'; map[characterLocation - 1] = ' ';}
     PrintMap();
   }
   private static void CharacterDown()
   {
     if(characterLocation < map.length-10)
     {characterLocation += 10;      map[characterLocation] = 'C'; map[characterLocation - 10] = ' ';}
     PrintMap();
   }
   private static void CharacterUp()
   {
     if(characterLocation > 10)
     {characterLocation -= 10;      map[characterLocation] = 'C'; map[characterLocation + 10] = ' ';}
     PrintMap();
   }
   public static void MoveCharacter()
   {
     Scanner input = new Scanner(System.in);
     System.out.println("1- left, 2- right, 3- down, 4- up");
     int direction = input.nextInt();
     if(direction ==1)
     CharacterLeft();
     else if(direction ==2)
     CharacterRight();
     else if(direction ==3)
     CharacterDown();
     else if(direction ==4)
     CharacterUp();
     else if(direction >4 || direction <1)
     System.out.println("Please enter a different direction");
   }
  /// MAIN METHOD ----------------------------------
    public static void main( String[] args)
  {
      do{     // loop for playing is true
    Map2();
    MapMonster();
    MapCharacter();
    PrintMap();
    do{       // Loop for you win! Play again?
      MoveCharacter();
      CheckForMonsters();
    }while (CheckForMonstersInt()>0);
    System.out.println("You Win!!!");
    System.out.println("Play again? Yes/No`");
    String checkplay = play.nextLine();
    if(checkplay.charAt(0) == 'y' || checkplay.charAt(0) == 'Y')
      playing =true;
    else if(checkplay.charAt(0) == 'N' || checkplay.charAt(0) == 'n') 
      playing =false;
      }while(playing);
      System.out.println("Thanks for playing!");
    
    /*
    System.out.println("Play again?  Yes/No");
    Scanner check = new Scanner(System.in);
    char next = check.nextChar();
    if(next == Y){    Map2();
    MapMonster();
    MapCharacter();
    PrintMap();
    do{
      MoveCharacter();
      CheckForMonsters();
    }while (CheckForMonstersInt()>0);
    System.out.println("You Win!!!");
    //System.out.println("Play again?  Yes/No");
    */
    }

    /* while(characterLocation + 1 != 'M' || characterLocation -1 != 'M');
      if(characterLocation + 1 == 'M')
        {System.out.println("There's a Monster to your Right! FIGHT? 1-yes 2-no");}
      else if(characterLocation - 1 == 'M')
        {System.out.println("There's a Monster to your Left! FIGHT? 1-yes 2-no");} */
  }
    
    
    // 