public class RemoveElement
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = {2, 1, 3};
		int result  = removeElement(arr, 1);
		System.out.println(result);
	}
	
	public static int removeElement(int[] A, int elem) {
		if(A.length==0)
			return 0;
		int x = 0;
		int y = 0;
		while(y<A.length){
			if(A[y]!=elem){
				A[x] = A[y];
				x++;
			}
			y++;
		}
		
		return x;
	}
}
