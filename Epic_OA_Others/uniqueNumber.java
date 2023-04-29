/*
 * Write, efficient code for extracting unique elements from a sorted 
 * list of array. e.g. (1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9)-> (1, 3, 5, 9).
 */

public class uniqueNumber{
	public static void main(String[] args){
		int[] a = {
			1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9
		};
		find(a);
	}

	public static void find(int[] list){
		int pos = 0;
		for(int i=1;i<list.length;i++){
			if(list[i] == list[pos]){
				continue;
			}else{
				pos++;
				list[pos] = list[i];
			}
		}
		for(int i=0;i<pos;i++){
			System.out.print(list[i]+",");
		}
		System.out.println(list[pos]);
	}
}