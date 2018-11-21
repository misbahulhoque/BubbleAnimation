class Constructor
{
	int i,j;
	Constructor(int x,int y)	
	{
		i=x;
		j=y;	
	}
	Constructor(int x)
	{
		i=x;
		j=10;	
	}
	int mult()
	{
		return (i*j);
	}
}

class ConstructorTest
{
	public static void main(String args[])	
	{
		Constructor m1=new Constructor(1,6);
		System.out.println(m1.i+" "+m1.j);
		System.out.println("result="+m1.mult());
		Constructor m2=new Constructor(1);
		System.out.println("m2.i="+m2.i);
		System.out.println("result="+m2.mult());
	}
}