// the all variable and method of Outer class can be accessed by Inner class.
// but the variable & method in Inner class can't accessed by Outer class.

class Outer{
	int outer_x=10;
	void test(){					//The Inner class defined in a body of for loop.
		for(int i=0;i<10;i++)
		{
			class Inner{
				void display(){
					System.out.println("outer_x="+outer_x);
					}
				}
		Inner inner=new Inner();
		inner.display();
		}
	}
}

class NestedClass{
	public static void main(String args[]){
		Outer outer=new Outer();
		outer.test();
	}
	}