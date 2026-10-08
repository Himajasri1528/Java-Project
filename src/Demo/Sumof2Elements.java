package Demo;

public class Sumof2Elements {
	public static void main(String[] args) {
		int[] arr = {2, 8, 3, 7, 5, 5};
		for (int i =0; i <arr.length; i++) {
			for(int j = i + 1; j< arr.length;j++) {
				if(arr[i] + arr[j] == 10) {
					System.out.println(arr[i] +" + " + arr[j] +" = 10");
				}
			}
		}
	}

}
