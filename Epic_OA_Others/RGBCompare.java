import java.util.*;
//Given a string of RGB value (rr, gg, bb)which represents in hexadecimal.
//Compare if rr or gg or bb is the biggest, or two of those values are equal and larger than the third one,
//or three valuesare equal with each other.

public class RGBCompare{
	private String color;
	private int number;
	public static void main(String[] args){
		RGB("010202");
		RGB("030201");
		RGB("ffffff");
	}

	public RGBCompare(String color, int number){
		this.color = color;
		this.number = number;
	}

	public static void RGB(String input){
		int R = Integer.parseInt(input.substring(0,2),16);
		RGBCompare r = new RGBCompare("R",R);
		int G = Integer.parseInt(input.substring(2,4),16);
		RGBCompare g = new RGBCompare("G",G);
		int B = Integer.parseInt(input.substring(4,6),16);
		RGBCompare b = new RGBCompare("B",B);
		List<RGBCompare> list = new ArrayList<RGBCompare>();
		list.add(r);
		list.add(g);
		list.add(b);
		Collections.sort(list, new Comparator<RGBCompare>(){
			public int compare(RGBCompare r1, RGBCompare r2){
				if(r1.number > r2.number){
					return 1;
				}else{
					if(r1.number == r2.number){
						return 0;
					}else{
						return -1;
					}
				}
			}
		});
		// for(RGBCompare rgb:list){
		// 	System.out.println(rgb.color);
		// }

		if(list.get(0).number == list.get(2).number){
			System.out.println("Three equal");
			return;
		}
		if(list.get(1).number == list.get(2).number){
			System.out.println(list.get(1).color+ " and "+list.get(2).color+" is larger than "+list.get(0).color);
			return;
		}
		System.out.println(list.get(2).color+" is largest, second largest is "+list.get(1).color+", smallest is "+list.get(0).color+".");

		// int[] RGB = {R, G, B};
		// Arrays.sort(RGB);
		// if(RGB[0] == RGB[2]){
		// 	System.out.println("All the three are equal.");
		// 	return;
		// }
		// if(RGB[1] == RGB[2]){
		// 	System.out.println("Two equal, larger than the third.");
		// 	return;
		// }
		// System.out.println("One largest.");
	}
}