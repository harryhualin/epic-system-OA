
/*
 * Find thelargest sum contiguous sub array. The length of 
 * the returned sub array must beat least of length 2.
 */ 
 
 
import java.util.*;
 public class largestSumSubArray{
 	
 	public static void main(String[] args){
 		int[] array = {
			-2, 1, -3, 2, 5, -5, 4
		};
		find(array);
 	}

 	public static void find(int[] num){
 		int maxEndingHere = num[0];
 		int max = num[0];
 		List<Integer> res = new ArrayList<Integer>();
      res.add(num[0]);
 		String result = "";
      
 		for(int i=1;i<num.length;i++){
 			if(maxEndingHere+num[i]<num[i]){
            res.clear();
 			}
         res.add(num[i]);

 			maxEndingHere = Math.max(maxEndingHere+num[i],num[i]);
 			if(maxEndingHere>max){
 				result = res.toString(); // be careful, this is pass by reference, so result and res point to the same object
 			max = maxEndingHere;            
 			}

 		}
 		System.out.println(result);
   } 
}     
/* 	
 	public static void find(int[] num){
 		int maxEndingHere = num[0];
 		int max = num[0];
 		List<Integer> res = new ArrayList<Integer>();
      res.add(num[0]);
 		String result = "";
      
 		for(int i=1;i<num.length;i++){
 			if(maxEndingHere+num[i]>num[i]){
 				res.add(num[i]);
 			}else{
 				res = new ArrayList<Integer>();
 				res.add(num[i]);
 			}
 			maxEndingHere = Math.max(maxEndingHere+num[i],num[i]);
 			if(maxEndingHere>max){
 				result = res.toString(); // be careful, this is pass by reference, so result and res point to the same object
 			}
 			max = Math.max(max,maxEndingHere);
 		}
 		System.out.println(result);
 	}
*/




/*
import java.util.Arrays;

import java.util.*;

public class largestSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maximumSubarray(nums));
	}
	
	public static List<Integer> maximumSubarray(int[] nums) {
		List<Integer> rst = new ArrayList<>();
		if (nums == null || nums.length <= 1)
			return rst;
		
		int maxEndHere = nums[0];
		int maxTotal = nums[0];
		List<Integer> tmp = new ArrayList<>();
		tmp.add(nums[0]);
		
		for (int i = 1; i < nums.length; i++) {
			if (maxEndHere + nums[i] < maxEndHere) {
				tmp.clear();
			}
			tmp.add(nums[i]);
			maxEndHere = Math.max(maxEndHere + nums[i], nums[i]);
			
			if (maxEndHere > maxTotal) {
				maxTotal = maxEndHere;
				rst = new ArrayList<>(tmp);
			}
		}
		return rst.size() >= 2 ? rst : new ArrayList<Integer>();
	}
}
*/
