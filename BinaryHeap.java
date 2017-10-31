
public class BinaryHeap {

	//data members: array and size
	int[] heap;
	int size;
	
	//constructor: instantiate the array with size 10
	public BinaryHeap() {
		heap = new int[10];
	}
	
	public void add(int data) {
		//grow the heap if it's too small
		if(heap.length == size) {
			grow_heap();
		}
		//
		heap[size] = data;
		int index = size - 1;
		while(index > 0 && heap[index] < heap[parent(index)]) {
			swap(heap, index, parent(index));
			index = parent(index);
		}
		size++;
	}
	
	public int remove() {
		try {
			if (size > 0) {
				int temp = heap[0];
				heap[0] = heap[--size];
				bubble_down(0);
				return temp;
			} else {
				throw new Exception("Empty");
			}
		} catch (Exception e) {
			System.out.println("The heap is empty");
			return -1;
		}
	}
	
	private int parent(int index) {
		return (index - 1)/2;
	}
	
	private int lchild(int index) {
		return index * 2 + 1;
	}
	
	private int rchild(int index) {
		return 2 * (index + 1);
	}
	
	private void grow_heap() {
		int[] newarr = new int[heap.length*2];
		System.arraycopy(heap, 0, newarr, 0, heap.length);
		heap = newarr;
	}
	
	private void swap(int[] arr, int index, int parent) {
		int temp = arr[index];
		arr[index] = arr[parent];
		arr[parent] = temp;
	}
	
	private void bubble_down(int index) {
		boolean swapped = true;
		while(swapped && lchild(index) < size) {
			swapped = false;
			int child = lchild(index);
			if(rchild(index) < size && heap[rchild(index)] < heap[child]) {
				child = rchild(index);
			}
			if(heap[index] > heap[child]) {
				swap(heap, index, child);
				index = child;
				swapped = true;
			}
			
		}
	}
}
