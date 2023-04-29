import java.util.*;
/*
 * A number is called as a stepping number if the adjacent 
 * digits are having a difference of 1. For eg. 8,343,545 are 
 * stepping numbers. While 890, 098 are not. The difference 
 * between a ‘9’ and ‘0’ should not be considered as1. 
 * Given start number(s) and an end number (e) your function 
 * should list out all the stepping numbers in the range including 
 * both the numbers s & e.
 */
 
public class steppingNumber{
	
   public static void main(String[] args){
      generate("1","1101");
   }
	
   public static void generate(String start, String end){
      List<Integer> res = new ArrayList<Integer>();
      for(int i=start.length();i<=end.length();i++){
         for(int j=1;j<10;j++){
            dfs(Integer.parseInt(start), Integer.parseInt(end),i-1,j,res); // try every digit at the beginning
         }
      }
      System.out.println(res.size());	
      System.out.println(res);
   }
	
   public static void dfs(int start, int end, int length, int num, List<Integer> res){
      if(length == 0){
         if(num>=start && num<=end){ //make sure it is between start and end
            res.add(num);
            return;
         }
      }
      else{
         int last = num%10;
         if(last == 0){           
            dfs(start, end, length-1, num*10+1, res);
         }
         else if(last == 9){
            dfs(start, end, length-1, num*10+8, res);
         }
         else{
            dfs(start, end ,length-1, num*10+last-1, res);
            dfs(start, end, length-1, num*10+last+1, res);
         }
      }
   }
}
