class Stack
{
	int stck[]=new int [10];
	int tos;
	Stack()
	{
		tos=-1;	
	}
	void push(int item)
	{
		if(tos==9)	
			System.out.println("stack is full");
		else
			stck[++tos]=item;
	}
	
	int pop()
	{
		if(tos<0)	
		{
		System.out.println("stack underflow");
		return 0;
		}
		else
			return stck[tos--];
	}
}

class TestStack
{
	public static void main(String args[])
	{
	Stack m1=new Stack();
	Stack m2=new Stack();
	int i;
	for(i=0;i<10;i++)
		m1.push(i);
	for(i=10;i<20;i++)
		m2.push(i);
	System.out.println("stack in m1:");
	for(i=0;i<10;i++)
		System.out.println(m1.pop());
	System.out.println("stack in m2:");
	for(i=0;i<10;i++)
		System.out.println(m2.pop());
	}

}