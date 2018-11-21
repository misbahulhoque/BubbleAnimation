class Forall{
	int a;				// a declared as default and is public.
	public int b;		// b declared as public.
	private int c;		// c declared as private.
	int setc(int i){	// to set the value of c.
		c=i;
		return c;
		}
	int getc(){			// to return the value of c.
		return c;
		}
	}
	
	class AccessSpecifiers{
		public static void main(String args[]){
			Forall ob=new Forall();
			ob.a=1;
			ob.b=2;
			ob.setc(3);
			System.out.println("a="+ob.a+" b="+ob.b+" c="+ob.getc());
			ob.setc(100);
			System.out.println("again c="+ob.getc());
			
			}
		}