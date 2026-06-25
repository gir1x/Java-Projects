import java.util.ArrayList;
import java.util.List;

public class Stream {
    static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

       List<Integer> stream = list.stream()
                .filter(c -> c % 2 == 0)
                .map(c -> c * c)
               .toList();

                stream.forEach(System.out::println);

    }
}
