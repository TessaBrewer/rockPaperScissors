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