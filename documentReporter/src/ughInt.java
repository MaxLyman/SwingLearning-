import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ughInt {
    public static void main(String[] args) {
        Integer integer = 1;

        System.out.println(integer + 1);
        integer = integer + 1;
        System.out.println(integer);

        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        System.out.println(integers.toString());

    }
}
