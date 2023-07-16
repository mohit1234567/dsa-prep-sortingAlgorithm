package sortingPackage;

public class HeapDemo {
	public static void main(String[] args) {
		int[] heap = new int[] {9,6,8,2,1,4,3};
		int size = heap.length;
		for(int i = 0; i<heap.length;i++) {
			System.out.print(heap[i] + ",");
		}
		System.out.println('\n' +"After sorting"+ '\n');
		heapSort(heap,size);
		for(int i = 0; i<heap.length;i++) {
			System.out.print(heap[i] + ",");
		}
	}
	
	private static void heapify(int[] heap, int i,int size) {
		//for MAX_HEAP
		int L = (2*i) +1;
		int R = (2*i) +2;
		
		int tempLargestIndex = 0;
		if(size>L && heap[L]>heap[i]) {
			tempLargestIndex = L;
		}
		else {
			tempLargestIndex = i;
		}
		if(size>R &&heap[R]>heap[tempLargestIndex]) {
			tempLargestIndex = R;
		}
		if(tempLargestIndex != i) {
			//swap
			int temp = heap[i];
			heap[i] = heap[tempLargestIndex];
			heap[tempLargestIndex]=temp;
			heapify(heap,tempLargestIndex,size);
		}
		
	}
	private static void heapSort(int[] heap,int size) {
		// First Build MAX_HEAP from given array
				for(int i= (size/2)-1;i>0;i--) {
					heapify(heap,i,i+1);
				}
				// Now apply EXTRACT_MAX algorithm;
				for(int i = size-1; i>0; --i) {
					int temp = heap[0];
					heap[0] = heap[i];
					heap[i] = temp;
					heapify(heap,0,i);
				}
	}
}
