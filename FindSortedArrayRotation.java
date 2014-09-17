public class FindSortedArrayRotation{

    public static void main(String []args){
        int[] arr = {1, 2, 3};
        int result = FindSortedArrayRotation(arr);
        System.out.println(result);
    }
    
    public static int FindSortedArrayRotation(int A[]) {
        int start = 0;
        int end = A.length-1;
        
        while(A[start]<A[end]){
            int mid = start + (end-start)/2;
            if(A[mid] > A[end])
                start = mid+1;
            else
                end = mid;
        }
        
        return start;
    }
}