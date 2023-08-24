package DSA;

public class quickSort {
    public static void main(String[] args){
        int arr[]={3,6,4,1,8,0};
        printArray(arr);
        quickSort(arr, 0, arr.length-1);
        printArray(arr);
    }
    public static void quickSort(int[] list, int start, int end){
        if(start>=end){
            return;
        }
        int pivot=list[end];
        int i=start-1,j;//dont't put i=-1, it would then give wrong answer
        //because there's a case when the start is not 0
        for(j=start; j<end; j++){
            if(list[j]<pivot){
                i++;
                int temp=list[j];
                list[j]=list[i];
                list[i]=temp;
            }
        }
        list[j]=list[++i];
        list[i]=pivot;
        quickSort(list,start,i-1);
        quickSort(list, i+1, end);

        


    }
    public static void printArray(int[] array){
            for(int i: array){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    
}
