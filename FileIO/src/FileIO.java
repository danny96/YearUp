import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileIO {

	public static void main(String[] args)  
	{
		try
		{
		String filePath = "C:\\Users\\dellis116\\Documents\\OOP.txt";
		String iReadThis = Read(filePath);
		String originalWord = "dolor";
		String replaceWord = "hedon";
		String replacedString = Replace(iReadThis, originalWord, replaceWord);
		Write(replacedString, filePath);
		}
		catch (IOException ex)
		{
			System.out.println("Someting went wrong while reading or writing from file");
			ex.printStackTrace();
		}
		catch(NullPointerException fileEx)
		{
			System.out.println("You did not supply a valid file patch");
		}
	}
	
	private static void Write(String replacedString, String filePath) throws IOException
	{
		FileWriter writer = null;
		try
		{
		 writer = new FileWriter(filePath);
		 writer.write(replacedString);
	}
		finally
		{
			if (writer !=null)
			{
				writer.close();
			}
		}
				
		}
	
	private static String Replace(String iReadThis, String originalWord, String replaceWord)
	{
		String replacedString = null;
		
		if (iReadThis != null)
		{
			replacedString = iReadThis.replace(originalWord, replaceWord);
		}
		
		return replacedString;
	}
	
	public static String Read(String filePath) throws NullPointerException, IOException
	{
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String fullFile = null;
		
		try
		{
			if (filePath == null)
			{
				throw new NullPointerException();
			}
			fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);
			StringBuilder builder = new StringBuilder();
			
			String iReadThis = bufferedReader.readLine();
			
			while (iReadThis != null)
			{
				builder.append(iReadThis);
				iReadThis = bufferedReader.readLine();
			}
			fullFile = builder.toString();
		}
		finally
		{
			if (fileReader != null)
			{
				fileReader.close();
			}
		}
		return fullFile;
	}

}
