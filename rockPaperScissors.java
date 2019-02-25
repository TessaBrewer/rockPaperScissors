import Java.util.*;
public class rockPaperScissors
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<ternary> humanMoveHistory = new ArrayList<ternary>;
		ArrayList<ternary> winHistory = new ArrayList<ternary>;
	}
	public static int ai(int[][] history) //-1 = rock, 0 = paper, 1 = scissors
	{
		/*
			Start with paper
			check the past 2 moves (if same then play what would lose to that)
			if lose then predict a repeat
			if win then assume they assume a repeat
			*** Impliment a NN ASAP ***
		*/
	}
	public static int winLose(int human, int robot) //-1 = lose, 0 = tie, 1 = win
	{
		
	}
}

public class ternary //-1, 0, and 1
{
	private int whatIsStored = 0;

	public static void set(int i)
	{
		if(i == -1 || i == 0 || i == 1)
		{
			whatIsStored = i;
		}else
		{
			throw(new IllegalArgumentException("-1, 1, and 0 only"));
		}
	}

	public static void add()
	{
		whatIsStored ++;
		if(whatIsStored == 2)
			whatIsStored = -1;
	}

	public static void sub()
	{
		whatIsStored --;
		if(whatIsStored == -2)
			whatIsStored = 1;
	}

	public static int get()
	{
		return whatIsStored;
	}

	public static void inv()
	{
		whatIsStored *= -1;
	}
}
