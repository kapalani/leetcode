public class {

    public static void main(String []argsSearchInsertPosition){
        int arr[] = {1, 3, 4};
        int index = searchInsert(arr, 2);
        System.out.println(index);
    }
     
    public static int searchInsert(int[] A, int target) {
        if(A.length==0)
            return -1;
            
        int start = 0;
        int end = A.length-1;
        int mid = 0;
        
        while(start<=end){
            mid = start + (end-start)/2;
            if(A[mid]==target)
                return mid;
            if(A[mid]>target)
                end = mid-1;
            else
                start = mid+1;
        }
        
        return start;
    }
}