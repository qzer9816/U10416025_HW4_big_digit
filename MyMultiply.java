//U10416025
import java.io.Console;
public class MyMultiply {
    //main method
    public static void main(String[] args) {
	//use console() method get the str1 and str2
	Console console = System.console();
	System.out.println("Enter the first number:");
	String str1 = console.readLine();
	System.out.println("Enter the second number:");
	String str2 = console.readLine();
		
	//int str1 and str2 length
        int len1 = str1.length();
        int len2 = str2.length();
		
	//array
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        
        //swap the level of digital bits
        covertdata(s1, len1);  
        covertdata(s2, len2);  
        System.out.println("number1:"+str1);  
        System.out.println("number2:"+str2);

        multiply(s1, len1, s2, len2);
    }
    
    public static void covertdata(char data[], int len) {
        //swap the level of digital bits
        for (int i = 0; i < len / 2; i++) {
            data[i] += data[len - 1 - i];
            data[len - 1 - i] = (char) (data[i] - data[len - 1 - i]);
            data[i] = (char) (data[i] - data[len - 1 - i]);
        }
    }
    
     public static void multiply(char a[], int alen, char b[], int blen) {  
        //cause the answer can not exceed the two numbers digital total
        int csize = alen + blen + 3;  
	//int the answer array
        int[] c = new int[csize];  
        //add 0 in the answer array
        for (int ii = 0; ii < csize; ii++) {  
            c[ii] = 0;  
        }  
        //multiply the two numbers
        for (int j = 0; j < blen; j++) {  
            for (int i = 0; i < alen; i++) {  
                c[i + j] +=  Integer.parseInt(String.valueOf(a[i]))* Integer.parseInt(String.valueOf(b[j]));  
            }  
        }  
        int m = 0;  
        //deal with the carry number
        for (m = 0; m < csize; m++) {  
            int carry = c[m] / 10;  
            c[m] = c[m] % 10;  
            if (carry > 0)  
                c[m + 1] += carry;  
        }  
        //find the head number of answer
        for (m = csize - 1; m >= 0;) {  
            if (c[m] > 0)  
                break;  
            m--;  
        }
        
        //print the answer
        System.out.print("multiply answer:");
        for (int n = 0; n <= m; n++) {
            System.out.print(c[m - n]);
        }
        System.out.println("");
     }
}
