class Test
{
	int a,b;
	Test(int i,int j)
	{
	a=i;
	b=j;	
	}
	
	boolean equals(Test o)		//passes object as argument function defination.
	{
	if(o.a==a && o.b==b)	
		return true;
	else
		return false;
	}
	void meth(Test o)
	{
	o.a *=2;	
	o.b /=2;
	}
}

class PassObject
{
	public static void main(String args[])
	{
		Test m1=new	Test(100,22);
		Test m2=new Test(100,22);
		Test m3=new Test(1,1);
		
		System.out.println("m1==m2:"+m1.equals(m2));	//passes object as argument.
		System.out.println("m1==m3:"+m1.equals(m3));
		System.out.println("m2==m3:"+m2.equals(m3));
		m3.meth(m1);
		System.out.println("after call of meth function");
		System.out.println("m1.a="+m1.a);
		System.out.println("m1.b="+m1.b);
		
	}
}