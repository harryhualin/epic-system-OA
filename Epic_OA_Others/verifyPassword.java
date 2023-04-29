/*
 * Verify if the given password is valid/invalid
 * 1. must be 5-12 characters long 
 * 2. must contain at least one number and one lower case character 
 * 3. a sequence must not be followed by the same sequence 
 * (like 123123qs is invalid, 123qs123 is valid)
 */

public class verifyPassword{

	public static void main(String[] args){
		String password1 = "123123qs";
		String password2 = "123qs123";
		verify(password1);
		verify(password2);
	}

	public static boolean verify(String password){
		int length = password.length();
		if(length<5 || length>12){
			System.out.println("Invalid!");
			return false;
		}
		boolean containNumber = false;
		boolean containLower = false;
		for(int i=0;i<password.length();i++){
			if(password.charAt(i) >= '0' && password.charAt(i) <= '9'){
				containNumber = true;
			}
			if(password.charAt(i) > 'a' && password.charAt(i) < 'z'){
				containLower = true;
			}
		}
		if(!containNumber || !containLower){
			System.out.println("Invalid!");
			return false;
		}
		for(int i=0;i<password.length();i++){
			int index = password.indexOf(password.charAt(i),i+1); //find the first index where c shows again
		if(index != -1){
			String str1 = password.substring(i,index);
			if(2*index-i<password.length()){
				String str2 = password.substring(index,index+str1.length());
				if(str1.equals(str2)){
					System.out.println("Invalid!");
					return false;
				}
			}
			
		}
		}
		
		System.out.println("Valid!");
		return true;
	}
}