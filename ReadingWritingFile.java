import java.io.*;

class ReadingWritingFile
{
	public static void main(String args[])
	throws IOException
	{
		int i;
		FileInputStream fin;
		FileOutputStream fout;
		try
		{
			try
			{
				fin=new FileInputStream(args[0]);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File Not Found");
				return;
			}
			try
			{
				fout=new FileOutputStream(args[1]);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File Not Found");
				return;
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Usage:ReadingFile");
				return;
			}
		
		try
		{
			do
			{
				i=fin.read();
				if(i!=-1)
					fout.write(i);
			}while(i!=-1);
		}
		catch(IOException e)
		{
			System.out.print("File errors");
		}
		fin.close();
		fout.close();
	}
}