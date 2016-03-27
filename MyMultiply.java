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
}
