/**
 * Ⅰ基本函数：

 1.valueOf(parament);//将参数转换为制定的类型
 2.add();            //大整数相加
 3.subtract();       //相减
 4.multiply();       //相乘
 5.divide();         //相除取整
 6.remainder();      //取余
 7.pow();            //a.pow(b)=a^b
 8.gcd();            //最大公约数
 9.abs();            //绝对值
 10.negate();        //取反数
 11.mod();           //a.mod(b)=a%b=a.remainder(b);
 12.max(); min();
 13.public int comareTo();
 14.boolean equals();//是否相等
 15.//BigInteger构造函数：
 BigInteger(String val);
 //将指定字符串转换为十进制表示形式；
 BigInteger(String val,int radix);
 //将指定基数的 BigInteger 的字符串表示形式转换为 BigInteger


 Ⅱ.基本常量：
 A=BigInteger.ONE    1
 B=BigInteger.TEN    10
 C=BigInteger.ZERO   0


 Ⅲ.基本操作——读入与输出
 */



import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Convert {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);


        //10转16,8,2
        System.out.println("Input decimal:");
        Integer x = sc.nextInt();
        System.out.println("Convert Hexadecimal: "+Integer.toHexString(x));
        System.out.println("Convert Octal: "+Integer.toOctalString(x));
        System.out.println("Convert Binary: "+Integer.toBinaryString(x));


        //16转10,8,2
        System.out.println("Input Hexadecimal:");
        String hex = sc.next();
        System.out.println("Convert decimal: "+ Integer.valueOf(hex,16));
        System.out.println("Convert decimal: "+ Integer.parseInt(hex,16));
        System.out.println("Convert decimal new: "+ hexStringToAlgorism(hex));

        System.out.println("Convert octal: "+ Integer.toOctalString(Integer.valueOf(hex,16)));
        System.out.println("Convert binary: "+ Integer.toBinaryString(Integer.valueOf(hex,16)));


        //8转16,10,2
        System.out.println("Input Octal:");
        String octal = sc.next();
        System.out.println("Convert Hexadecimal: "+ Integer.toHexString(Integer.valueOf(octal,8)));
        System.out.println("Convert decimal: "+ Integer.valueOf(octal,8));
        System.out.println("Convert decimal: "+ Integer.parseInt(octal,8));
        System.out.println("Convert decimal: "+ Integer.toBinaryString(Integer.valueOf(octal,8)));


        //2转16,10,8
        System.out.println("Input binary:");
        String binary = sc.next();

        System.out.println("Convert Hexadecimal: "+ Integer.toHexString(Integer.valueOf(binary,2)));
        System.out.println("Convert decimal: "+ Integer.valueOf(binary,2));
        System.out.println("Convert decimal: "+ Integer.parseInt(binary,2));
        System.out.println("Convert octal: "+ Integer.toOctalString(Integer.valueOf(binary,2)));


    }

    public static String StringToAsciiString(String content) {
        String result = "";
        int max = content.length();
        for (int i = 0; i < max; i++) {
            char c = content.charAt(i);
            String b = Integer.toHexString(c);
            result = result + b;
        }
        return result;
    }

    /**
     * 十六进制字符串装十进制
     *
     * @param Hex 十六进制字符串
     * @return 十进制数值
     */
    public static BigInteger hexStringToAlgorism(String hexString) {

        BigInteger result = BigInteger.ZERO;

        for(int i=0;i<hexString.length();i++){
            char ch = Character.toUpperCase(hexString.charAt(hexString.length()-1-i));
            int algorism=0;
            if('0'<=ch && ch<='9')
                algorism = ch -'0';
            else
                algorism = ch - 'A' + 10;

            result = result.add(new BigInteger("16").pow(i).multiply(BigInteger.valueOf(algorism)));
        }
        return result;

    }

    /**
     * 十六转二进制
     *
     * @param hex
     *            十六进制字符串
     * @return 二进制字符串
     * 从高位相加
     */
    public static String hexStringToBinary(String hex) {
        hex = hex.toUpperCase();
        String result = "";
        int length = hex.length();
        for (int i = 0; i < length; i++) {
            char ch = hex.charAt(i);
            switch (ch) {
                case '0':
                    result += "0000";
                    break;
                case '1':
                    result += "0001";
                    break;
                case '2':
                    result += "0010";
                    break;
                case '3':
                    result += "0011";
                    break;
                case '4':
                    result += "0100";
                    break;
                case '5':
                    result += "0101";
                    break;
                case '6':
                    result += "0110";
                    break;
                case '7':
                    result += "0111";
                    break;
                case '8':
                    result += "1000";
                    break;
                case '9':
                    result += "1001";
                    break;
                case 'A':
                    result += "1010";
                    break;
                case 'B':
                    result += "1011";
                    break;
                case 'C':
                    result += "1100";
                    break;
                case 'D':
                    result += "1101";
                    break;
                case 'E':
                    result += "1110";
                    break;
                case 'F':
                    result += "1111";
                    break;
            }
        }
        return result;
    }

    /**
     * ASCII码字符串转数字字符串
     *
     * @param String
     *            ASCII字符串
     * @return 字符串
     */
    public static String AsciiStringToString(String content) {
        String result = "";
        int length = content.length() / 2;
        for (int i = 0; i < length; i++) {
            String c = content.substring(i * 2, i * 2 + 2);
            int a = Integer.parseInt(hexStringToAlgorism(c).toString());
            char b = (char) a;
            String d = String.valueOf(b);
            result += d;
        }
        return result;
    }


    /**
     * 将十进制转换为指定长度的十六进制字符串
     *
     * @param algorism
     *            int 十进制数字
     * @param maxLength
     *            int 转换后的十六进制字符串长度
     * @return String 转换后的十六进制字符串
     */
    public static String algorismToHEXString(int algorism, int maxLength) {
        String result = "";
        result = Integer.toHexString(algorism);
        return patchHexString(result.toUpperCase(), maxLength);
    }

    /**
     * HEX字符串前补0，主要用于长度位数不足。
     *
     * @param str
     *            String 需要补充长度的十六进制字符串
     * @param maxLength
     *            int 补充后十六进制字符串的长度
     * @return 补充结果
     */
    static public String patchHexString(String str, int maxLength) {
        String temp = "";
        for (int i = 0; i < maxLength - str.length(); i++) {
            temp = "0" + temp;
        }
        str = (temp + str);
        return str;
    }

    /**
     * 字节数组转为普通字符串（ASCII对应的字符）
     *
     * @param bytearray
     *            byte[]
     * @return String
     */
    public static String bytetoString(byte[] bytearray) {
        String result = "";
        char temp;

        int length = bytearray.length;
        for (int i = 0; i < length; i++) {
            temp = (char) bytearray[i];
            result += temp;
        }
        return result;
    }



    /**
     * 二进制字符串转十进制
     *
     * @param binary
     *            二进制字符串
     * @return 十进制数值
     */
    public static BigInteger binaryToAlgorism(String binary) {

        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(binary.length()-i - 1);
            BigInteger algorism = BigInteger.valueOf(c - '0');
            result = result.add((new BigInteger("2")).pow(i).multiply(algorism));
        }
        return result;
    }


    /**
     * 十六进制串转化为byte数组
     *
     * @return the array of byte
     */
    public static final byte[] hex2byte(String hex) throws IllegalArgumentException {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = hex.toCharArray();
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap = "" + arr[i++] + arr[i];
            int byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = new Integer(byteint).byteValue();
        }
        return b;
    }


    /**
     * 字节数组转换为十六进制字符串
     *
     * @param b
     *            byte[] 需要转换的字节数组
     * @return String 十六进制字符串
     */
    public static final String byte2hex(byte b[]) {
        if (b == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xff);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }
}



