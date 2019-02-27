package rockPaperScissors;
import java.util.*;
public class ternary //-1, 0, and 1
{
	static Random random = new Random();
	public int whatIsStored = 0;
	
	public ternary(int start)
	{
		set(start);
	}
	
	public ternary()
	{
	}

	public void set(int i) //stores a valid ternary value
	{
		if(i == -1 || i == 0 || i == 1)
		{
			whatIsStored = i;
		}else
		{
			throw(new IllegalArgumentException("-1, 1, and 0 only"));
		}
	}

	public void add() //adds 1
	{
		whatIsStored ++;
		if(whatIsStored >= 2)
			whatIsStored = -1;
	}

	public void sub() //subtracts 1
	{
		whatIsStored --;
		if(whatIsStored <= -2)
			whatIsStored = 1;
	}

	public void add(int amount) //adds amount, loops
	{
		if(amount > 0)
		{
			for(int i = 0; i < amount; i++)
			{
				whatIsStored++;
				if(whatIsStored >= 2)
					whatIsStored = -1;
			}
		}
		if(amount < 0)
		{
			amount *= -1;
			sub(amount);
		}
	}
	
	public void sub(int amount) //adds amount, loops
	{
		if(amount > 0)
		{
			for(int i = 0; i < amount; i++)
			{
				whatIsStored--;
				if(whatIsStored <= -2)
					whatIsStored = 1;
			}
		}
		if(amount < 0)
			add(amount);
	}
	
	public int get() //returns the stored value
	{
		return whatIsStored;
	}
	
	public int get(int offset)
	{
		if(offset > 0)
		{
			for(int i = 0; i < offset; i++)
			{
				whatIsStored++;
				if(whatIsStored == 2)
					whatIsStored = -1;
			}
			return whatIsStored;
		}
		if(offset < 0)
		{
			for(int i = 0; i > offset; i--)
			{
				whatIsStored--;
				if(whatIsStored == -2)
					whatIsStored = 1;
			}
			return whatIsStored;
		}
		return whatIsStored;
	}

	public void inv() //inverts the ternary (1 becomes -1, -1 becomes 1, 0 stays the same)
	{
		whatIsStored *= -1;
	}

	public static int rand() //returns a random valid ternary value
	{
		return random.nextInt(3) - 1;
	}
}
