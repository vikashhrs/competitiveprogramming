import java.util.*;
class Heap {
    int maxSize;
    int heap[];
    int heapSize;

    Heap(int maxSize){
        this.maxSize = maxSize;
        this.heap = new int[maxSize+1];
        this.heapSize = 0;
    }

    public boolean insert(int value){
        if(this.heap != null && this.heapSize < this.maxSize){
            this.heap[++this.heapSize] = value;
            // System.out.println("Before heapify");
            // levelOrder();
            heapifyUpwards(this.heapSize);
            // System.out.println("after heapify");
            // levelOrder();
            return true;
        }
        return false;
    }

    public void heapifyUpwards(int index){
        int parent = index / 2;
		if (index <= 1) {
			return;
		}
		
		if (this.heap[index] < this.heap[parent]) {
			int tmp = this.heap[index];
			this.heap[index] = this.heap[parent];
			this.heap[parent] = tmp;
		}
		heapifyUpwards(parent);
    }

    public void levelOrder() {
		System.out.println("Printing all the elements of this Heap...");
		for (int i = 1; i <= this.heapSize; i++) {
			System.out.print(this.heap[i] + "\t");
		}
		System.out.println();
	}

    public int extractMin(){
        int min = this.heap != null && this.heapSize >= 1 ? this.heap[1] : null;
        if(this.heapSize > 1){
            this.heap[1] = this.heap[this.heapSize];
            this.heapSize--;
            heapifyDownwards(1);
        }else if(this.heapSize == 1){
            this.heapSize--;
        }
        return min;
    }

    public void heapifyDownwards(int index){
        int left = 2*index;
        int right = 2*index + 1;
        int smallestChild = left;
        if (this.heapSize < left) {
			return; 
		}else if (this.heapSize == left) {
			if(this.heap[index] > this.heap[left]) {
				int tmp = this.heap[index];
				this.heap[index] = this.heap[left];
				this.heap[left] = tmp;
			}
			return;
		}else { 
			if(this.heap[left] < this.heap[right]) { 
				smallestChild = left;
			}else {
				smallestChild = right;
			}
			if(this.heap[index] > this.heap[smallestChild]) {
				int tmp = this.heap[index];
				this.heap[index] = this.heap[smallestChild];
				this.heap[smallestChild] = tmp;
			}
		}

        heapifyDownwards(smallestChild);
    }

    public int getHeapSize(){
        return this.heapSize;
    }

    public int getMaxSize(){
        return this.maxSize;
    }
}
public class HeapOperations{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        // boolean contineInsert = true;
        // System.out.println("Enter max size of heap: ");
        // int maxSize = sc.nextInt();
        // while(contineInsert){
        //     System.out.println("Enter the element you would like to insert:");
        //     int value =sc.nextInt();
        //     boolean success = hp.insert(value);
        //     if(!success){
        //         System.out.println("Full heap!");
        //         break;
        //     }
        //     System.out.println("Enter yes to continue or no to exit:");
        //     String response = sc.next();
        //     if(response == "no"){
        //         System.out.println("Thanks you");
        //         contineInsert = false;
        //     }
        // }
        // System.out.println("Done!!");
        int arr[] = {10, 2, 1, -1, -2, 5, -3, 8, 7, 11, 20 , 30, 4, 6, 3 , 2, 1, 10, 12};
        Heap hp = new Heap(arr.length);
        for(int i = 0;i<arr.length;i++){
            hp.insert(arr[i]);
        }
        hp.levelOrder();

        for(int i = 1;i<=hp.getMaxSize();i++){
            System.out.print(hp.extractMin() + " \t");
        }
        System.out.println();
    }
}