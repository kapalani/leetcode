public class AddBinaryTrialTwo{

    public static void main(String []args){
        String result = addBinary("101111", "10");
        System.out.println(result);
    }
    
    public static String addBinary(String a, String b) {
        if(a==null || a.trim().length()==0)
            return b;
        if(b==null || b.trim().length()==0)
            return a;
        
        int end_a = a.length()-1;
        int end_b = b.length()-1;
        int carry = 0;
        StringBuilder str = new StringBuilder();
        while(end_a >=0 || end_b >=0){
            
            int current_a = end_a >= 0 ? a.charAt(end_a--)-'0' : 0;
            int current_b = end_b >= 0 ? b.charAt(end_b--)-'0' : 0;
            int current = (current_a + current_b + carry)%2;
            carry = (current_a + current_b + carry)/2;
            str.insert(0, current);
        }
        if(carry>0)
            str.insert(0, 1);
        return str.toString();
    }
}
