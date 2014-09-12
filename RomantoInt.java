import java.util.*;
import java.lang.*;
import java.io.*;
public class RomantoInt{

  public static void main (String[] args) throws java.lang.Exception
  {
	  int result = romanToInt("MCMXCVI");
    System.out.println(result);
	}

	public static int romanToInt(String s) {
    if(s==null)
      return -1;
    int val += getVal(s.charAt(s.length()-1));
        
    int current = 0;
    int previous = val;
        
    for(int i=s.length()-2;i>=0;i--){
      current = getVal(s.charAt(i));
      if(previous > current)
        val -= getVal(s.charAt(i));
      else
        val += getVal(s.charAt(i));
      previous = current;
    }
        
    return val;
  }
    
  public static int getVal(char a){
    switch(a){
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      
    }
  }
}
