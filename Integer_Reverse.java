package Integer_Reverse;
import java.util.Scanner;

/**
	Name: Integer_Reverse V2.0
	Date: 2018/12/9
	Author: Sean Stewart
	Function: To reverse an Integer, for example:
	          123-->321; -123-->-321
	          120-->21;  -120-->-21
	Fix:1. �������0�ᱨ����Ϊ����0��������Ļ��Ὣ��ת��Ϊ���ַ��������µ���
		2. ���ת�������Int��ȡֵ��Χ�Ĵ��󣬱������룺1534236469
*/

class Integer_Reverse {
	/*
	 ����Ҫָ����������ֵΪint������void
	 �����void���ں��������ͨ��ִ�������佫������ַ�������ʽ��ӡ����ô��ʹת��ʧ��
	 Ҳ�Ὣ�ַ�������ʵת������ȷ����ӡ���������������쳣����������0��������ַ���''������̨
	 ���������������Ϊ����������ȷ
	 */
    public static int reverse(int x) {
        String str = String.valueOf(x);  
        String str1 = new String();
		int N = str.length();
		char[] char_array = str.toCharArray();
        char t;
        long lstr;
        
        // carry out reverse
        if(x==0) return 0;             // 0 is special
        else if(char_array[0]=='-'){
           for(int i=1; i<(N+1)/2; i++){
            t = char_array[i];
            char_array[i] = char_array[N-i];
            char_array[N-i] = t;
        } 
        }
        else{
            for(int i=0; i<N/2; i++){
            t = char_array[i];
            char_array[i] = char_array[N-1-i];
            char_array[N-1-i] = t;
        } 
        }
    
        /* 
         remove abundant 0 at the beginning
         and should contain two occasions
         */
        if(char_array[0]!='-') {
        	for(int j=0; j<N; j++) {
    			if(char_array[j]=='0') continue;
    			else 
    				str1 = new String(char_array,j,N-j);
    				break;
    		}
        }
        else {
        	for(int j=1; j<N; j++) {
    			if(char_array[j]=='0') continue;
    			else 
    				str1 = new String(char_array,j,N-j);
    				str1 = '-'+str1;
    				break;
    		}
        }
        
        //Ҫ��Long�ͣ���Ϊstr1��������ܳ���Int��ȡֵ��Χ
        lstr = Long.parseLong(str1); 
        
        /*
        check if post_conversion oversized, if so ,return 0
        otherwise return int value by forced type conversion
        */
        
        if(lstr>Integer.MAX_VALUE||lstr<Integer.MIN_VALUE) return 0; 
        else return (int)lstr; //δ���Int��ʾ��Χ����ǿ������ת��Ϊint
    }
    public static void main(String[] args) {
    	System.out.println("���������֣�4�ֽ�����������");
    	Scanner sc = new Scanner(System.in);
    	int value = sc.nextInt();
    	int n = reverse(value);
    	System.out.println("ת�����Ϊ��"+n);
    	sc.close();
    }
}