class Room
{
	int length,bredth;
	Room(int x,int y)
	{
	length=x;
	bredth=y;	
	}
	int area()
	{
	return (length*bredth);
	}
}
	
class BedRoom extends Room
{
	int height;
	BedRoom(int x,int y,int z)
	{
	super(x,y);
	height=z;
	}
	int volume()
	{
	return (length*bredth*height);
	}
	int add()
	{
	return (length+bredth+height);	
	}
}
	
class Inheritance
{
	public static void main(String args[])	
	{
	BedRoom room1=new BedRoom(14,12,10);
	int area1=room1.area();
	int volume1=room1.volume();
	int add1=room1.add();
	System.out.println("area1="+area1);
	System.out.println("volume="+volume1);
	System.out.println("add1="+add1);
	}
		
}