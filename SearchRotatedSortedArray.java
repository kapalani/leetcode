public class SearchRotatedSortedArray{

    public static void main(String []args){
        //int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int[] arr = {1, 3};
        int result = search(arr, 3);
        System.out.println(result);
    }
    
    public static int search(int[] A, int target) {
        if(A.length==0)
            return -1;
        
        int start = 0;
        int end = A.length-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(A[mid]==target)
                return mid;
                
            else if(A[start]<=A[mid]){
                if(A[start]<=target && target<A[mid])
                    end = mid-1;
                else
                    start = mid+1;
            }
            
            else {
                if(A[mid]<target && target<=A[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        
        return -1;
    }
}
