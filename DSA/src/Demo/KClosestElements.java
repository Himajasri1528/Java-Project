package Demo;
import java.util.*;

public class KClosestElements {
	static List<Integer> findClosest(
			int[] arr, int k, int x){
		PriorityQueue<Integer>maxHeap = new PriorityQueue<>(
			(a, b)-> {
				int diff = Integer.compare(Math.abs(b - x),
						Math.abs(a - x));
				if(diff !=0) {
					return diff;
				}
				return Integer.compare(b,  a);
			
		
			}
			);
		for(int num : arr) {
			maxHeap.offer(num);
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		List<Integer> result=
				new ArrayList<>(maxHeap);
		Collections.sort(result);
		return result;
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4,5};
		System.out.println(findClosest(arr, 2, 3)
				);
	}
}
			


