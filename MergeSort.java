package DSA;
public class MergeSort {
    public static void main(String[] args){
        int arr[]={6,2,8,4,9,1};
        printArray(arr);
        divide(arr,0,arr.length-1);
        printArray(arr);

    
    }
    public static void divide(int arr[],int startIdx, int endIdx){
        if(startIdx>=endIdx){
            return;
        }
        int midIdx=startIdx+(endIdx-startIdx)/2;
        divide(arr,startIdx,midIdx);
        divide(arr,midIdx+1,endIdx);
        conquer(arr, startIdx, midIdx, endIdx);

    }
    public static void conquer(int arr[],int startIdx, int midIdx, int endIdx){
        int[] merged=new int[endIdx-startIdx+1];
        int mergedIdx=0, idx1=startIdx, idx2=midIdx+1;

        while(idx1<=midIdx && idx2<=endIdx){
            if(arr[idx1]<arr[idx2]){
                merged[mergedIdx++]=arr[idx1++];
            }
            else{
                merged[mergedIdx++]=arr[idx2++];
            }
        }
        while(idx1<=midIdx){
            merged[mergedIdx++]=arr[idx1++];
        }
        while(idx2<=endIdx){
            merged[mergedIdx++]=arr[idx2++];
        }
        for(int i=0, j=startIdx; i<merged.length; i++, j++){
            arr[j]=merged[i];
        }

    }

    public static void printArray(int[] array){
        for(int i:array){
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    
}
