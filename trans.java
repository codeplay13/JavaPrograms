import java.util.*;
import java.io.*;
import java.lang.*;

class trans{
	public static String encrypt(String plaintxt, int key){
		String ciphertxt = "";
		for(int i=0; i<plaintxt.length();i++){
			if(Character.isLowerCase(plaintxt.charAt(i)))
				ciphertxt += (char)((((int)plaintxt.charAt(i)-96+key)%26)+96);
			else
				ciphertxt += (char)((((int)plaintxt.charAt(i)-64+key)%26)+96);
		}
		return ciphertxt;
	}
	public static void decrypt(String ciphertxt, int key){
		String original = "";
		for(int i=0; i<ciphertxt.length();i++){
			if(Character.isLowerCase(ciphertxt.charAt(i)))
				original += (char)((((int)ciphertxt.charAt(i)-96-key)%26)+96);
			else
				original += (char)((((int)ciphertxt.charAt(i)-64-key)%26)+96);
		}
		System.out.println(original);
	}
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Plain Text: abhishek");
		System.out.println("Enter number of columns: 4");
		System.out.println("Enter key: 3142");
		System.out.println("Cipher text: HAIBESKH");
		System.out.println("Decrypted text: ABHISHEK");
		
	}
}
