import java.util.*;

class M{
    int  m;
    public M(int m){
        this.m = m;
    }

    @Override
    public String toString() {
        return String.valueOf(m);
    }
};

public class MyList {


    public static void main(String[] args) {
        java.util.List books = new ArrayList();
        books.add(new M(1));
        books.add(new M(3));
        books.add(new M(4));
        books.add(new M(2));


        books.sort((o1, o2) -> {
            M m1 = (M)o1;
            M m2 = (M)o2;

            return m1.m-m2.m;});
        System.out.println(books);
        books.replaceAll(ele->((M)ele));
        ListIterator lit = books.listIterator();

        while (lit.hasPrevious()){
            System.out.println(lit.previous());
        }

        while (lit.hasNext()){
            System.out.println(lit.next());
        }

        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(100);

        List fixedList = Arrays.asList( "1","2");


    }

}
