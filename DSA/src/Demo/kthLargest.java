package Demo;

import java.util.PriorityQueue;

public class kthLargest {
	static int findkthLargest(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();	
		for(int num : arr) {
			minHeap.offer(num);
			if(minHeap.size() >k) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
		}
	public static void main(String[] args) {
		int[] arr = {10, 5, 20, 8, 15, 30};
		System.out.println(findkthLargest(arr,3));
		
	}

}
