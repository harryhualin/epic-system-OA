import java.util.*;

public class allPrime{
	public static void main(String[] args){
		find(100);
	}

	public static void find(int input){
		List<Integer> res = new ArrayList<Integer>();
		res.add(2);
		for(int i=3;i<=Math.sqrt(input);i++){
			int len = res.size();
			for(int k=0;k<len;k++){
				if(i%res.get(k)==0){
					break;
				}else{
					if(!res.contains(i)){
						res.add(i);
						}
				}
			}
		}
		System.out.println(res);
	}
}