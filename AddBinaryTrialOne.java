public class AddBinaryTrialOne{

    public static void main(String []args){
        String result = addBinary("101111", "10");
        System.out.println(result);
    }
    
    public static String addBinary(String a, String b) {
        if(a==null || a.trim().length()==0)
            return b;
        if(b==null || b.trim().length()==0)
            return a;
        
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        char[] c;
        char[] d;
        
        StringBuilder str = new StringBuilder();
        int len = 0;
        if(x.length < y.length) {
            len = x.length;
            c = y;
            d = x;
        }else {
            len = y.length;
            c = x;
            d = y;
        }
        char carry = '0';
        int j=1;
        for(int i=len-1;i>=0;i--){
            if(c[c.length-j]-'1'==0){
                if(d[i]-'1'==0){
                    if(carry=='1'){
                        str.insert(0, '1');
                        carry = '1';
                    }
                    else {
                        str.insert(0, '0');
                        carry = '1';
                    }
                }else{
                    if(carry=='1'){
                        str.insert(0, '0');
                        carry = '1';
                    }else{
                        str.insert(0, '1');
                        carry = '0';
                    }
                }
            }
            else{
                if(d[i]-'1'==0){
                    if(carry=='1'){
                        str.insert(0, '0');
                        carry = '1';
                    }else{
                        
                        str.insert(0, '1');
                        carry = '0';
                    }
                }else{
                    if(carry=='1'){
                        str.insert(0, '1');
                        carry = '0';
                    }else{
                        str.insert(0, '0');
                        carry = '0';
                    }
                }
            }
            j++;
        }
        
        if(len==x.length){
            carry = helper(y, y.length-j, carry, str);
        }else{
            carry = helper(x, x.length-j, carry, str);
        }
        
        if(carry=='1')
            str.insert(0, '1');
        return str.toString();
    }
    
    public static char helper(char[] z,int n, char carry, StringBuilder str){
        for(int i=n;i>=0;i--){
                if(z[i]-'1'==0){
                    if(carry=='1'){
                        str.insert(0, '0');
                        carry = '1';
                    }
                    else {
                        str.insert(0, '1');
                        carry = '0';
                    }
                }else{
                    if(carry=='1'){
                        str.insert(0, '1');
                        carry = '0';
                    }else{
                        str.insert(0, '0');
                        carry = '0';
                    }
                }
        }
        
        return carry;
    }
}
