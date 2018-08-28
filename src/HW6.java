import java.util.Scanner;

public class HW6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long i = sc.nextLong();
        System.out.println(new HW6().getResult(i));
    }


    //改进
    public String getResult(long ulDataInput) {

        StringBuilder sb = new StringBuilder();
        long index =ulDataInput;

        while (index!=1){
            for (int i = 2; i <=index ; i++) {
                if(index%i==0){
                    sb.append(i+" ");
                    index =index/i;
                    break;
                }
            }
        }
        return sb.toString();
    }





    //算法容易超时
    public String getResult1(long ulDataInput) {
        StringBuilder sb = new StringBuilder();
        long index = ulDataInput;

        while (index!=2&&index!=3&&index!=5&&index!=7){
            if(index%2==0) {
                sb.append(2+" ");
                index=index/2;
            }
            else if(index%3==0) {
                sb.append(3+" ");
                index=index/3;
            }
            else if(index%5==0){
                sb.append(5+" ");
                index=index/5;
            }
            else if(index%7==0) {
                sb.append(7+" ");
                index=index/7;
            }

        }
        sb.append(index+" ");
        return sb.toString();
    }


}
