import java.util.ArrayList;
import java.util.List;

public class Test {

    int depth =0;
    public void testCount(){
        depth ++;
        testCount();
    }
    public static void main(String[] args) {


        Test test=null;
        try {
            test = new Test();
            test.testCount();
        }finally {
            System.out.println("count:"+ test.depth);
        }

    }


/*    public static void main(String[] args)
    {

        List<byte[] > list = new ArrayList<>();
        int i=0;
        while (true){
            list.add(new byte[50*1024*1024]);
            System.out.println("·ÖÅä´ÎÊı"+(++i));
        }

    }*/




}
