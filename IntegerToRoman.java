public class IntegerToRoman {
	public static void main(String[] args){
		String roman = intToRoman(3898);
		System.out.println(roman);
	}
	
	public static String intToRoman(int num) {
		int [] nums={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,1};
		String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuffer sb = new StringBuffer();
        int i=0;
        while(num>0){
        	int ct = num/nums[i];
        	num = num - nums[i]*ct;
        	for(int j=0;j<ct;j++)
        		sb.append(romans[i]);
        	i++;
        }
        
        return sb.toString();
    }
}
