class Return
{
	int a;
	Return(int i)	
	{
		a=i;	
	}
	Return ReturnTheOb()
	{
		Return temp=new Return(a+10);
		return temp;
	}
}

class ReturnObject
{
	public static void main(String args[])
	{
		Return m1=new Return(2);
		Return m2;
		m2=m1.ReturnTheOb();
		System.out.println("m1.a="+m1.a);
		System.out.println("m2.a="+m2.a);
		m2=m2.ReturnTheOb();
		System.out.println("m2.a="+m2.a);
	}
}