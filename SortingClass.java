public class SortingClass {

	/*
	 *  Build a max heap from the input data
	 *  The biggest value of this tree is  at the top (root)
	 *  Replace it with the last item of the heap followed by reducing the size of heap by 1.
	 *  Finally, heapify the root of tree.
	 */
	public void heapSort(int []arrayToSort){
		int length = arrayToSort.length; 
		   
	    for (int i = length / 2 ; i >= 0; i--) {
	    	heapifyForHeapSort(arrayToSort, i, length);     	
	    }

	     for (int i=length-1; i>0; i--) { 
	    	 swap(arrayToSort,0,i);
	         heapifyForHeapSort(arrayToSort, 0, i); 
	      }
	}
	
	/*
	 * In the lesson, we were taught the array starting from 1. 
	 * But in the sort algorithm I wrote, the array starts from 0, 
	 * so the left child becomes 2 * i + 1 and right child becomes 2 * i + 2. 
	 * Because it is the zeroth element of the root directory.
	 * The reason I write this algorithm like this is not to create different arrays for heap sort, 
	 * just as I create arrays in other sort algorithms, I create it in the same way.
	 * 
	 *		      #(0) //root
	 *	        /   \
	 *	   [i] #(1)  #(2)
	 *	     /   \
	 * 	   #(3)   #(4)
	 *   [2*i+1] [2*i+2]
	 */
	public void heapifyForHeapSort(int arrayToSort[], int i, int length){ 
        int largest = i; //parent  
        int leftChild = 2*i+1;  //left child
        int rightChild = 2*i+2; //right child
  
        if (leftChild <length && arrayToSort[leftChild] > arrayToSort[largest]) 
            largest = leftChild; 
   
        if (rightChild < length && arrayToSort[rightChild] > arrayToSort[largest]) 
            largest = rightChild; 
  
        if (largest != i) { 
        	swap(arrayToSort, i, largest);
            heapifyForHeapSort(arrayToSort, largest, length); 
        } 
    } 
	
	/*
	 * This sort is to take two pivots, one in the left end of the array and the second, in the right end  of the array
	 *  The array is then thought of as three parts. In the first part, the sequence is arranged by applying swap operation, 
	 *  with the numbers smaller than the left pivot, the second part greater and equal numbers  than the left pivot, 
	 *  and the smaller and equal numbers from the right pivot, and the third part is larger than the right pivot. 
	 *  This process then continues by applying to all three parts.
	 */
	
	public void dualPivotOuickSort(int []arrayToSort ,int left , int right){
		if(right>left) {		
			int arrLeft=arrayToSort[left];
			int arrRight=arrayToSort[right];
			if(arrLeft>arrRight) {
				swap(arrayToSort, left, right);	
				arrLeft=arrayToSort[left];
				arrRight=arrayToSort[right];
			}
			int tempLeft=left+1;
			int tempRight=right-1;
			int k=tempLeft;
		
			while(k<=tempRight) {
				if(arrayToSort[k]<arrLeft) {
					swap(arrayToSort, k, tempLeft);
					tempLeft=tempLeft+1;
				}
				else {
					if(arrayToSort[k]>=arrRight) {
						while(arrayToSort[tempRight]>arrRight && k<tempRight) {
							tempRight=tempRight-1;
						}
						swap(arrayToSort, k, tempRight);
						tempRight=tempRight-1;
						
						if(arrayToSort[k]<arrLeft) {
							swap(arrayToSort, k, tempLeft);
							tempLeft=tempLeft+1;
						}
					}	
				}
				k=k+1;
			}
			tempLeft=tempLeft-1;
			tempRight=tempRight+1;
			swap(arrayToSort, left, tempLeft);
			swap(arrayToSort, right, tempRight);

			dualPivotOuickSort(arrayToSort, left, tempLeft-1);
			dualPivotOuickSort(arrayToSort, tempLeft+1, tempRight-1);
			dualPivotOuickSort(arrayToSort, tempRight+1, right);
		}
	}
	
	/*
	 * This sort starts, it sets a gap value equal to half the size of the array. 
	 * Starting from the beginning  of the array, it is compared to the number that is far from the gap value. 
	 * If it is smaller, it is replaced by  swap operation. This process continues until the end of the series. 
	 * Then the gap number is divided into  two. The same process continues until the number of gap equals one.
	 */
	
	public void shellSort(int []arrayToSort){	
		int gap=arrayToSort.length/2;
		while(gap>0) {
			for(int j=gap;j<arrayToSort.length;j++) {
				
				for(int i=j-gap;i>=0;i=i-gap) {
					
					if(arrayToSort[i+gap]<=arrayToSort[i]) {
						swap(arrayToSort,i,i+gap);
					}
					else
						break;
				}			
			}
			gap=gap/2;
		}
	}
	
	/*
	 * I used the swap method in all sort methods
	 * Replaces two desired elements
	 */
	public void swap(int []arrayToSort, int i, int j) {
		int temp=arrayToSort[i];
		arrayToSort[i]=arrayToSort[j];
		arrayToSort[j]=temp;
	}	
	
	/*
	 * This method to see the elements in the array in console
	 */
	public void printArray(int []arryToSort) {
    	System.out.println();
    	for (int i=0; i<arryToSort.length; ++i) {
    		if(i%50==0)
    			System.out.println();
    		System.out.print(arryToSort[i]+" ");
    	}		 
    }
}