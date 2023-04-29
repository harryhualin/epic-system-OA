/*
 * Given a number find whether the digits in the number can be used to form 
 * an equation with + and '='. That is if the number is 123, we can have a 
 * equation of 1+2=3. But even the number 17512 also forms the equation 12+5=17.
 */

public class plusEqualNumber{
	public static void main(String[] args){
		divide("17512");
	}

	public static void divide(String input){
		int half = input.length()/2;
		for(int i=0;i<half;i++){
			for(int j=i+1;j<i+1+half;j++){
				int n1 = Integer.parseInt(input.substring(0,i+1));
				int n2 = Integer.parseInt(input.substring(i+1,j+1));
				if(j+1>=input.length()){
					continue;
				}
				int n3 = Integer.parseInt(input.substring(j+1,input.length()));
				if(check(n1, n2, n3) != null){
					System.out.println(check(n1,n2,n3));
					return;
				}
			}
		}
		System.out.println("Not Found!");
	}

	public static String check(int n1, int n2, int n3){
		if(n1 == n2+n3){
			return n2+"+"+n3+"="+n1;
		}
		if(n2 == n1+n3){
			return n1+"+"+n3+"="+n2;
		}
		if(n3 == n1+n2){
			return n1+"+"+n2+"="+n3;
		}
		return null;
	}


}