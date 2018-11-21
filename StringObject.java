//This program is developed for String type class examine.Here we demonstrate
//object of String type and some function for String type object.

class StringObject{
	public static void main(String args[]){
		String str1="My name is Misbah";
		String str2="I read in CSE";
		String str3="University Of Chittagong";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		boolean equality;
		
		equality=str1.equals(str2);		//test for two string is equal.
		if(equality==true)
			System.out.println("True");
		else
			System.out.println("False");
			
		System.out.println("length of str1="+str1.length());	//length method return the length.
		System.out.println("length of str2="+str2.length());
		System.out.println("length of str3="+str3.length());
		System.out.println("char at index of str1="+str1.charAt(0));	//charAt method return char in the index.
		
		}
}
		