package Integer_Reverse;
import java.util.Scanner;

/**
	Name: Integer_Reverse V2.0
	Date: 2018/12/9
	Author: Sean Stewart
	Function: To reverse an Integer, for example:
	          123-->321; -123-->-321
	          120-->21;  -120-->-21
	Fix:1. 解决输入0会报错，因为不对0单独处理的话会将其转换为空字符串，导致调用
		2. 解决转换后溢出Int型取值范围的错误，比如输入：1534236469
*/

class Integer_Reverse {
	/*
	 必须要指定函数返回值为int而不是void
	 如果是void，在函数最后是通过执行输出语句将结果以字符串的形式打印，那么即使转换失败
	 也会将字符串（其实转换不正确）打印出来而不会引起异常，比如输入0，输出空字符串''。但后台
	 不报错会让人误以为程序运行正确
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
        
        //要用Long型，因为str1解析后可能超出Int型取值范围
        lstr = Long.parseLong(str1); 
        
        /*
        check if post_conversion oversized, if so ,return 0
        otherwise return int value by forced type conversion
        */
        
        if(lstr>Integer.MAX_VALUE||lstr<Integer.MIN_VALUE) return 0; 
        else return (int)lstr; //未溢出Int表示范围，再强制类型转换为int
    }
    public static void main(String[] args) {
    	System.out.println("请输入数字（4字节整型数）：");
    	Scanner sc = new Scanner(System.in);
    	int value = sc.nextInt();
    	int n = reverse(value);
    	System.out.println("转换结果为："+n);
    	sc.close();
    }
}