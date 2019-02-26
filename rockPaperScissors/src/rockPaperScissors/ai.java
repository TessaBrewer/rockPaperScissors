package rockPaperScissors;

import java.util.ArrayList;

public class ai 
{
	public static ternary logic(ArrayList<ternary> winHistory, ArrayList<ternary> humanMoveHistory) //-1 = rock, 0 = paper, 1 = scissor
	{
		ternary output = new ternary(0);
		switch(winHistory.size())
		{
			case 0:
				output = first(winHistory, humanMoveHistory);
				return output;
			case 1:
				output = second(winHistory, humanMoveHistory);
				return output;
			default:
				output = allElse(winHistory, humanMoveHistory);
				return output;
		}
		/*
			Start with paper *
			check the past 2 moves (if same then play what would lose to that) *
			if lose then predict a repeat *
			if win then assume they assume a change (assume they play what would've won against your last move)
			*** Implement a NN ASAP ***
		*/
	}
	public static ternary first(ArrayList<ternary> winHistory, ArrayList<ternary> humanMoveHistory)
	{
		ternary output = new ternary(0);
		return output;
	}
	public static ternary second(ArrayList<ternary> winHistory, ArrayList<ternary> humanMoveHistory)
	{
		ternary lastMove = humanMoveHistory.get(humanMoveHistory.size() - 1);
		if(winHistory.get(winHistory.size() - 1).get() == -1) //assumes user repeat so plays what would beat it
		{
			lastMove.add();
			return lastMove;
		}else if(winHistory.get(winHistory.size() - 1).get() == 0) //assumes no repeat so plays what would lose to the last move
		{
			lastMove.sub();
			return lastMove;
		}else //assumes the user copies the AI's last move, so plays what would beat that
		{
			lastMove.sub();
			return lastMove;
		}
	}
	public static ternary allElse(ArrayList<ternary> winHistory, ArrayList<ternary> humanMoveHistory)
	{
		ternary output = new ternary(0);
		ternary lastMove = humanMoveHistory.get(humanMoveHistory.size() - 1);
		ternary moveBeforeThat = humanMoveHistory.get(humanMoveHistory.size() - 2);
		
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
		}else if(winHistory.get(winHistory.size() - 1).get() == 0) //assumes the user will repeat
		{
			output.set(lastMove.get());
			output.sub();
			return output;
		}else if(winHistory.get(winHistory.size() - 1).get() == 1) //assumes user will copy the AI's last move
		{
			output.set(lastMove.get());
			output.add();
			return output;
		}
		return output;
	}
}
