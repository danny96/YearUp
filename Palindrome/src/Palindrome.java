
public class Palindrome {

	public static void main(String[] args)
	{
		String string1 = "race car"; 
		String string2 = "hair"; 
				 
				 
		boolean isString1Palindrome = IsPalindrome(string1); 
		boolean isString2Palindrome = IsPalindrome(string2); 
		
		if (isString1Palindrome) 
		{ 
			
		}
	}
	public static boolean IsPalindrome(String wordInput) 
	{ 
	  boolean isPalindrome = true; 
	  if (wordInput !=null) 
	  { 
	     String wordInputNoSpaceAndLowerCase = wordInput.replace ("",""); 
	     char[] wordInputChars = wordInputNoSpaceAndLowerCase.toCharArray(); 
	 
	 
	  for (int i = 0, k = wordInputChars.length - 1; i < wordInputChars.length; i++, k--) 
	  {
	         if (wordInputChars[i] != wordInputChars[k]) 
	         { 
	           isPalindrome = false; 
	           break; 
	} 
	} 
	} 
	else 
	{ 
	 System.out.println("You gave me a null string :("); 
	 isPalindrome = false;
	} 
	 
	 return isPalindrome; 
	}
	}
	  
	
	 
	
