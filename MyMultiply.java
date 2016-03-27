//U10416025 張詠淳
import java.io.Console;
public class MyMultiply {
    //main method
    public static void main(String[] args) {
		//藉由System新增的console( )方法取得標準輸入輸出裝置的Console物件str1,str2
		Console console = System.console();
		System.out.println("Enter the first number:");
		String str1 = console.readLine();
		System.out.println("Enter the second number:");
		String str2 = console.readLine();
		
	//數字長度
        int len1 = str1.length();
        int len2 = str2.length();
		
	//陣列
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        
        //高低位對調
        covertdata(s1, len1);  
        covertdata(s2, len2);  
        System.out.println("乘數:"+str1);  
        System.out.println("乘數:"+str2);

        multiply(s1, len1, s2, len2);
    }
    
    public static void covertdata(char data[], int len) {
        //高低位對調
        for (int i = 0; i < len / 2; i++) {
            data[i] += data[len - 1 - i];
            data[len - 1 - i] = (char) (data[i] - data[len - 1 - i]);
            data[i] = (char) (data[i] - data[len - 1 - i]);
        }
    }
    
     public static void multiply(char a[], int alen, char b[], int blen) {  
        //兩數乘積位數不會超過成數位數和+3位
        int csize = alen + blen + 3;  
	//定義乘積數陣列
        int[] c = new int[csize];  
        //陣列填充0
        for (int ii = 0; ii < csize; ii++) {  
            c[ii] = 0;  
        }  
        //對齊後逐位相乘
        for (int j = 0; j < blen; j++) {  
            for (int i = 0; i < alen; i++) {  
                c[i + j] +=  Integer.parseInt(String.valueOf(a[i]))* Integer.parseInt(String.valueOf(b[j]));  
            }  
        }  
        int m = 0;  
        //進位處理
        for (m = 0; m < csize; m++) {  
            int carry = c[m] / 10;  
            c[m] = c[m] % 10;  
            if (carry > 0)  
                c[m + 1] += carry;  
        }  
        //找到最高位
        for (m = csize - 1; m >= 0;) {  
            if (c[m] > 0)  
                break;  
            m--;  
        }  
}
