package DSA;

public class InsertionSort {

    public static void main(String[] args){
        int list[]={5,7,3,4,5,9,0,1};
        printArray(list);
        insertionSort(list);
        printArray(list);
       

    }
    public static void insertionSort(int[] list){

        //"for loop" for traversing from second element to last element
        //i.e unsorted array

        for(int i=1; i<list.length; i++){
            int j=i-1;
            int curr=list[i];
            //"while loop" to shift bigger elements towards right and create
            //space for the current element at right position
            while(j>=0 && curr<list[j]){
                list[j+1]=list[j];
                j--;
            }
            //now j is 1 less than our required position due to j-- from last
            // iteration so we have to put curr at j+1 position
            //
            list[j+1]=curr;

            //using for loop instead of while loop
             // for(int i=1; i<list.length; i++){
        //     int curr=list[i], j;
        //     for(j=i-1; j>=0; j--){
        //         if(list[j]>curr){
        //             list[j+1]=list[j];
        //         }else
        //             break;
        //     }
        //     list[j+1]=curr;
        // } 
        }
    }

    public static void insSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int curr=arr[i];
            int j;
            for(j=i-1; j>=0; j--){
                if(curr<arr[j]){
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+1]=curr;

        }

    }
    public static void printArray(int[] array){
            for(int i: array){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    
}
