import java.util.Random;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {	
		chooseSortAndArrayType();
	}
	
	/*
	 * In this method, inputs are requested from the user.
	 * Which sorting algorithm(heap, dual pivot quick or shell sort)
	 * What is inside the series(equal, random, decreasing or increasing integers)
	 * What size should the array be
	 */
	@SuppressWarnings("resource")
	public static void chooseSortAndArrayType() {
		SortingClass sort = new SortingClass();	
		System.out.println(" * Menu* ");
		System.out.println("1- Heap Sort");
		System.out.println("2- Dual Pivot Quick Sort");
		System.out.println("3- Shell Sort");
		Scanner input=new Scanner(System.in);

		int x=0;
		boolean flag=false;
		while (!flag) {			
			try {
				System.out.println("--> Enter Sort Id: ");
				x=Integer.parseInt(input.nextLine());
				if(x>=1&&x<5)
					break;
				else {
					flag=false;
					System.err.println(" * Try again * ");
					System.out.println("--> Enter Sort Id: ");
					x=Integer.parseInt(input.nextLine());
				}
			}catch (NumberFormatException nfe) {
				 System.err.println(" * Try again * ");
			}
		}
		if(x==1||x==2||x==3) {
			
			System.out.println("\n1- Equal Integers");
			System.out.println("2- Random Integers");
			System.out.println("3- Increasing Integers");
			System.out.println("4- Decreasing Integers");
		
			int number=0;
			
			boolean numFlag=false;
			while (!numFlag) {			
				try {
					System.out.println("--> Enter Integers Id: ");
					number=Integer.parseInt(input.nextLine());
					if(number>=1&&number<5)
						numFlag=true;
					else {
						numFlag=false;
						System.err.println(" * Try again * ");
						System.out.println("--> Enter Integers Id: ");
						number=Integer.parseInt(input.nextLine());
					}
			     }catch (NumberFormatException nfe) {
			    	 System.err.println(" * Try again * ");
			     }
			}

			int size=0;
			
			boolean sizeFlag=false;
			while (!sizeFlag) {			
				try {
					System.out.println("--> Enter Array Size: ");
					size=Integer.parseInt(input.nextLine());
					if(size<Integer.MAX_VALUE)
						break;
					else {
						sizeFlag=false;
						System.err.println(" * Try again * ");
						System.out.println("--> Enter Array Size: ");
						size=Integer.parseInt(input.nextLine());
					}
			     }catch (NumberFormatException nfe) {
			    	 System.err.println(" * Try again * ");
			     }
			}
							
			if(x==1) {
				if(number==1) {
					int arr[]=creatEqual(size);
				//	sort.printArray(arr);
					long startTime=System.nanoTime();
					sort.heapSort(arr);
				    long estimatedTime=System.nanoTime()-startTime;
				//   sort.printArray(arr);
				    System.out.println("\n--> Time: "+estimatedTime);				
				}
				else if(number==2) {
					int arr[]=creatRandom(size);
				//	sort.printArray(arr);
					double startTime=System.nanoTime();
					sort.heapSort(arr);
					double estimatedTime=System.nanoTime()-startTime; 
				//	sort.printArray(arr);
				    System.out.println("\n--> Time: "+estimatedTime);					
				}
				else if(number==3) {
					int arr[]=creatIncreasing(size);
				//	sort.printArray(arr);
					long startTime=System.nanoTime();
					sort.heapSort(arr);
				    long estimatedTime=System.nanoTime()-startTime;
				//  sort.printArray(arr);
				    System.out.println("\n--> Time: "+estimatedTime);					
				}
				else if(number==4) {
					int arr[]=creatDecreasing(size);
				//	sort.printArray(arr);
					long startTime=System.nanoTime();
					sort.heapSort(arr);
				    long estimatedTime=System.nanoTime()-startTime;  
				//  sort.printArray(arr);
				    System.out.println("\n--> Time: "+estimatedTime);					
				}
				else {
					System.out.println("\n  !!! Wrong id !!!");
				}
			}
			else if(x==2) {
				if(number==1) {
					int arr[]=creatEqual(size);
				//	sort.printArray(arr);
					long startTime=System.nanoTime();
					sort.dualPivotOuickSort(arr, 0, size-1);
				    long estimatedTime=System.nanoTime()-startTime;
				//  sort.printArray(arr);
				    System.out.println("\n--> Time: "+estimatedTime);					
				}
				else if(number==2) {
					int arr[]=creatRandom(size);
				//	sort.printArray(arr);
					long startTime=System.nanoTime();
					sort.dualPivotOuickSort(arr, 0, size-1);
				    long estimatedTime=System.nanoTime()-startTime;
				//	sort.printArray(arr);
				    System.out.println("\n--> Time: "+estimatedTime);				
				}
				else if(number==3) {
					int arr[]=creatIncreasing(size);
				//	sort.printArray(arr);
					long startTime=System.nanoTime();
					sort.dualPivotOuickSort(arr, 0, size-1);
				    long estimatedTime=System.nanoTime()-startTime;
				//	sort.printArray(arr);
				    System.out.println("\n--> Time: "+estimatedTime);				
				}
				else if(number==4) {
					int arr[]=creatDecreasing(size);
				//	sort.printArray(arr);
					long startTime=System.nanoTime();
					sort.dualPivotOuickSort(arr, 0, size-1);
				    long estimatedTime=System.nanoTime()-startTime; 
				//	sort.printArray(arr);
				    System.out.println("\n--> Time: "+estimatedTime);
				}
				else {
					System.out.println("\n  !!!  Wrong id  !!!");
				}
			}
			else if(x==3) {
				if(number==1) {
					int arr[]=creatEqual(size);
				//	sort.printArray(arr);
					long startTime=System.nanoTime();
					sort.shellSort(arr);
				    long estimatedTime=System.nanoTime()-startTime;   
				//	sort.printArray(arr);
				    System.out.println("\n--> Time: "+estimatedTime);				
				}
				else if(number==2) {
					int arr[]=creatRandom(size);
				//	sort.printArray(arr);
					long startTime=System.nanoTime();
					sort.shellSort(arr);
				    long estimatedTime=System.nanoTime()-startTime; 
				//	sort.printArray(arr);
				    System.out.println("\n--> Time: "+estimatedTime);				
				}
				else if(number==3) {
					int arr[]=creatIncreasing(size);
				//	sort.printArray(arr);
					long startTime=System.nanoTime();
					sort.shellSort(arr);
				    long estimatedTime=System.nanoTime()-startTime;  
				//	sort.printArray(arr);
				    System.out.println("\n--> Time: "+estimatedTime);
				}
				else if(number==4) {
					int arr[]=creatDecreasing(size);
				//	sort.printArray(arr);
					long startTime=System.nanoTime();
					sort.shellSort(arr);
				    long estimatedTime=System.nanoTime()-startTime; 
				//	sort.printArray(arr);
				    System.out.println("\n--> Time: "+estimatedTime);
				}
				else {
					System.out.println("\n   !!! Wrong id !!!");
				}
			}
		}
		else {
			System.out.println("\n   !!! Wrong id !!!");
		}
	}
	
	/*
	 * It makes all the elements 3 into the array,
	 * so all the elements are equal.
	 */
	public static int[] creatEqual(int arraySize){
		int arr[]=new int[arraySize];
		for(int i=0;i<arraySize;i++) {
			arr[i]=3;
		}	
		return arr;
	}
	
	/*
	 * Randomly creates all the elements of the array and 
	 * places them in the array.
	 */
	public static int[] creatRandom(int arraySize){
		int arr[]=new int[arraySize];
		for(int i=0;i<arraySize;i++) {
			Random r=new Random();
			arr[i]=r.nextInt(100000);
		}	
		return arr;
	}
	
	/*
	 * Arrays the elements of the array in increasing order.
	 */
	public static int[] creatIncreasing(int arraySize){
		int arr[]=new int[arraySize];
		for(int i=0;i<arraySize;i++) {
			arr[i]=i;
		}	
		return arr;
	}
	
	/*
	 * Arrays the elements of the array in decreasing order.
	 */
	public static int[] creatDecreasing(int arraySize){
		int arr[]=new int[arraySize];
		for(int i=0;i<arraySize;i++) {
			arr[i]=arraySize-i;
		}	
		return arr;
	}
}