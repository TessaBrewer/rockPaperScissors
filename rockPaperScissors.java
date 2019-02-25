import Java.util.*;
public class rockPaperScissors
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<ternary> humanMoveHistory = new ArrayList<ternary>;
		ArrayList<ternary> winHistory = new ArrayList<ternary>;
		System.out.println("0 quit\n1 rock\n2 paper\n3 scissor");
		
		ternary userChoice = new ternary();
		userChoice.set(userInput);
		ternary robot = ai(winHistory, humanMoveHistory);
	}

	public static int userInput(Scanner input)
	{
		int userInput = input.nextInt();
		if(!userInput >= 0 && userInput <= 3)
		{
			throw(new IllegalArgumentException("Invalid input");
		}else if(userInput = 0)
		{
			System.exit(0);
		}else
		{
			userInput -= 2;
		}
	}

	public static ternary ai(ArrayList<ternary> winHistory, ArrayList<ternary> humanMoveHistory) //-1 = rock, 0 = paper, 1 = scissor
	{
		ternary output = new ternary;
		if(winHistory.size() > 1)
		{
			ternary lastMove = humanMoveHistory.get(humanMoveHistry.size() - 1);
			ternary moveBeforeThat = humanMoveHistory.get(humanMoveHistory.size() - 2);
			if(lastMove.get() == moveBeforeThat.get() && winHistory.get(winHistory.size() - 1).get() != winHistory.get(winHistory.size() - 2).get())
			{
				output.set(lastMove.get()); //returns what would've lost to your last 2 moves (assumes you won't do it thrice)
				output.sub();
				return output;
			}else if(winHistory.get(winHistory.size() - 1).get() == -1) //assumes user repeat and returns what would win against that
			{
				ouput.set(lastMove.get());
				output.sub();
				return output;
			}
		}else if(winHistory.size() == 1)
		{
			if(winHistory.get(winHistory.size() - 1) == -1) //assumes a repeat
			{
				lastMove.add();
				return lastMove;
			}
		}else if(winHistory.size() == 0)
		{
			output.set(0);
			return output;
		}
		/*
			Start with paper *
			check the past 2 moves (if same then play what would lose to that) *
			if lose then predict a repeat *
			if win then assume they assume a change (assume they play what would've won against your last move)
			*** Impliment a NN ASAP ***
		*/
	}
	public static int winLose(int human, int robot) //-1 = lose, 0 = tie, 1 = win
	{
		
	}
}

public class ternary //-1, 0, and 1
{
	Random random = new Random();
	private int whatIsStored = 0;
	
	public ternary(int start)
	{
		set(start);
	}

	public static void set(int i) //stores a valid ternary value
	{
		if(i == -1 || i == 0 || i == 1)
		{
			whatIsStored = i;
		}else
		{
			throw(new IllegalArgumentException("-1, 1, and 0 only"));
		}
	}

	public static void add() //adds 1, loops
	{
		whatIsStored ++;
		if(whatIsStored == 2)
			whatIsStored = -1;
	}

	public static void sub() //subtracts 1, loops
	{
		whatIsStored --;
		if(whatIsStored == -2)
			whatIsStored = 1;
	}

	public static int get() //returns the stored value
	{
		return whatIsStored;
	}

	public static void inv() //inverts the ternary (1 becomes -1, -1 becomes 1, 0 stays the same)
	{
		whatIsStored *= -1;
	}

	public static int ran() //returns a random valid ternary value
	{
		return random.nextInt(3) - 1;
	}
}
