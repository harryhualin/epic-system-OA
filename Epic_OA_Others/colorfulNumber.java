import java.util.HashSet;
import java.util.Set;

public class colorfulNumber{
	public static void main(String[] args){
		String s = "12345";
		System.out.println(isColorful(236));
	}

	public static boolean isColorful(int colorfulNumber){
		if(colorfulNumber < 10){
			return true;
		}
		String list = String.valueOf(colorfulNumber);
		int len = list.length();
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<len;i++){
			for(int j=1;j+i<=len;j++){
				String sub = list.substring(i,i+j);
				int product = getProduct(Integer.parseInt(sub));
				if(!set.add(product)){
					return false;
				}
			}
		}
		return true;
	}

	public static int getProduct(int num){
		int res = 1;
		while(num > 0){
			res *= num%10;
			num = num/10;
		}
		return res;
	}
}