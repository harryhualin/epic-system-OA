/*
 * Write a program to display the advisered average for the list of 
 * numbers my omitting the three largest number in the series.
 * E.g:3,6,12,55,289,600,534,900,172.  
 * avg = (3+6+12+55+289+172)/6 and eliminating 534,900,600
 */

public class adviseredAverageNumber{

//be carefull
	public static void main(String[] args){
		int[] A = {3,6,12,55,289,600,534,900,172};
		average(A);
	}

	public static void average(int[] num){
		if(num.length <=3){
			System.out.println(0.0);
			return;
		}
		int lar1=Math.max(Math.max(num[0],num[1]),num[2]),lar3=Math.min(Math.min(num[0],num[1]),num[2]),lar2=num[0]+num[1]+num[2]-lar1-lar3;
		int sum = lar1+lar2+lar3;
		for(int i=3;i<num.length;i++){
			sum += num[i];
			if(num[i]>lar1){
				lar3 = lar2;
				lar2 = lar1;
				lar1 = num[i];
			}else{
				if(num[i]<lar1 && num[i]>lar2){
				lar3 = lar2;
				lar2 = num[i];
			}else{if(num[i]<lar2 && num[i]>lar3){
				lar3 = num[i];
			}}
			}
			
		}
		System.out.println("The three largest number are: "+lar1+" "+ lar2+" "+lar3);
		System.out.println((double)(sum-lar1-lar2-lar3)/(num.length-3));
	}
}