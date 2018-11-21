import java.io.*;

class ReadingStringArray
{
	public static void main(String args[])
	throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=new String[100];
		int i,k;
		System.out.println("Enter the String without stop");
		for(i=0;i<100;i++)
		{
			str[i]=br.readLine();
			
			if(str[i].equalsIgnoreCase("stop"))break;
				
		}
		
		for(k=0;k<i;k++)
				System.out.println(str[k]);
		
			
	}
}