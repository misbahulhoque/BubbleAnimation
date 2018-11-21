import java.io.*;

class ReadingString
{
	public static void main(String args[])
	throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		System.out.println("Enter the String without stop");
		do
		{
			str=br.readLine();
			System.out.println(str);
		}while(!str.equals("stop"));
	}
}