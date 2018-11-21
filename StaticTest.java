class Test{
	static int a=3;
	static int b;
	static void meth(int x){
		System.out.println("x="+x+" a="+a+" b="+b);
		}
	static{
		System.out.println("initialization of static variable:");
		b=a*4;
		}
	}
class StaticTest{
	public static void main(String args[]){
		Test.meth(10);							// static method & variable can be called 
		System.out.println("b="+Test.b);		// from other class by class-name.method &
		}										// class-name.variable	
	}
	