class Over
{
void test()
{
	System.out.println("parameter is nill");
}	
void test(int i)
{
	System.out.println("parameter is only 1");
}
void test(int i,int j)
{
	System.out.println("parameter is two");	
}
}

class OverMethod
{
	public static void main(String args[])	
	{
		Over misbah=new Over();
		misbah.test(1,2);
		misbah.test();
		misbah.test(1);
		
	}
}