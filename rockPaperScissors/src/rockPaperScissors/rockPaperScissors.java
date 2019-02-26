package rockPaperScissors;
import java.util.*;
public class rockPaperScissors
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<ternary> humanMoveHistory = new ArrayList<ternary>();
		ArrayList<ternary> winHistory = new ArrayList<ternary>();
		System.out.println("0 quit\n1 rock\n2 paper\n3 scissor");
		
		ternary userChoice = new ternary(0);
		userChoice.set(userInput(input));
		ternary robot = ai(winHistory, humanMoveHistory);
		winHistory.add(winLose(userChoice, robot));
	}

	public static int userInput(Scanner input)
	{
		int userInput = input.nextInt();
		if(userInput < 0 || userInput > 3)
		{
			throw(new IllegalArgumentException("Invalid input"));
		}else if(userInput == 0)
		{
			System.exit(0);
		}else
		{
			userInput -= 2;
			return userInput;
		}
		return userInput;
	}

	public static ternary ai(ArrayList<ternary> winHistory, ArrayList<ternary> humanMoveHistory) //-1 = rock, 0 = paper, 1 = scissor
	{
		ternary lastMove = humanMoveHistory.get(humanMoveHistory.size() - 1);
		ternary moveBeforeThat = humanMoveHistory.get(humanMoveHistory.size() - 2);
		ternary output = new ternary(0);
		if(winHistory.size() > 1)
		{
			if(lastMove.get() == moveBeforeThat.get() && winHistory.get(winHistory.size() - 1).get() != winHistory.get(winHistory.size() - 2).get())
			{
				output.set(lastMove.get()); //returns what would've lost to your last 2 moves (assumes you won't do it thrice)
				output.sub();
				return output;
			}else if(winHistory.get(winHistory.size() - 1).get() == -1) //assumes user repeat and returns what would win against that
			{
				output.set(lastMove.get());
				output.sub();
				return output;
			}
		}else if(winHistory.size() == 1)
		{
			if(winHistory.get(winHistory.size() - 1).get() == -1) //assumes a repeat
			{
				lastMove.add();
				return lastMove;
			}
		}else if(winHistory.size() == 0)
		{
			output.set(0);
			return output;
		}
		return lastMove;
		/*
			Start with paper *
			check the past 2 moves (if same then play what would lose to that) *
			if lose then predict a repeat *
			if win then assume they assume a change (assume they play what would've won against your last move)
			*** Implement a NN ASAP ***
		*/
	}
	
	public static ternary winLose(ternary human, ternary robot) //-1 = lose, 0 = tie, 1 = win
	{
		if(human.get(-1) == robot.get())
			return 1;
		if(robot.get(-1) == human.get())
			return -1;
		return 0;
	}
}