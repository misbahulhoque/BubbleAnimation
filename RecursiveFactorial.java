class Factorial
{
	int fact(int n)	
	{
		int result;	
		if(n==1)
			result=1;
		else
			result=fact(n-1)*n;
		return result;
	}
}

class RecursiveFactorial
{
	public static void main(String args[])
	{
		Factorial m1=new Factorial();	
		System.out.println("factorial of 3:"+m1.fact(3));
		System.out.println("factorial of 4:"+m1.fact(4));
		System.out.println("factorial of 5:"+m1.fact(5));
		System.out.println("factorial of 6:"+m1.fact(6));
	}
	
}