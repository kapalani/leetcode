public class Candy{

    public static void main(String []args){
        int arr[] = {2, 2, 1};
        int result = candy(arr);
        System.out.println(result);
    }
    
    public static int candy(int[] ratings) {
        if(ratings.length==0)
            return 0;
    
        if(ratings.length==1)
            return 1;
        
        int[] tmp = new int[ratings.length];
    
        for(int i=0;i<tmp.length;i++)
            tmp[i]=1;
    
        if(ratings[0]>ratings[1])
            tmp[0]++;
    
        for(int i=1;i<ratings.length;i++){
            if(ratings[i-1]<ratings[i])
                tmp[i]=tmp[i-1]+1;
        }
    
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && tmp[i]<=tmp[i+1])
                tmp[i]=tmp[i+1]+1;
        }
        
        int total = 0;
        for(int i:tmp)
            total +=i;
    
        return total;
    }
}