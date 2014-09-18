public class GasStation{

    public static void main(String []args){
        int[] gas = {3, 6, 2};
        int[] cost = {4, 3, 2};
        int result = canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
    
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        
        if(gas.length==0 || cost.length==0 || gas.length!=cost.length)
            return -1;
        
        int len = gas.length;
        //Lets start from index 0
        int start = 0;
        int currentSum = 0;
        int totalSum = 0;
        
        for(int i=0;i<len;i++){
            currentSum += gas[i]-cost[i];
            totalSum += currentSum;
            if(currentSum<0){
                currentSum=0;
                start=i+1;
            }
        }
        
        if(totalSum<0)
            return -1;
        return start;
    }
}
