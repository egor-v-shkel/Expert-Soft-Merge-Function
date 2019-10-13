import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Integer> a = randomSortedList();
        List<Integer> b = randomSortedList();

        merge(a, b);

        System.out.println("First array: " + a);
        System.out.println("Second array: " + b);

    }

    private static void merge(List<Integer> a, List<Integer> b) {

        int IndexA = 0;
        int IndexB = 0;
        int SizeA = a.size();
        int SizeB = b.size();
        ArrayList<Integer> mergedList = new ArrayList<>(SizeA + SizeB);

        while (IndexA < SizeA) {
            while (a.get(IndexA) >= b.get(IndexB)) {
                mergedList.add(b.get(IndexB++));
                if (IndexB >= SizeB) break;
            }
            mergedList.add(a.get(IndexA));
            if (IndexB >= b.size()) {
                break;
            }
            IndexA++;
        }
        if (IndexB < b.size()) {  // add remaining
            mergedList.addAll(b.subList(IndexB, SizeB));
        } else if (IndexA < a.size()) {
            mergedList.addAll(a.subList(++IndexA, SizeA));
        }

        a.clear();
        a.addAll(mergedList);

    }

    private static List<Integer> randomSortedList() {
        Random random = new Random();

        List<Integer> result = random
                .ints(5, 0, 11)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("List created. Size = " + result.size() + ". List: " + result + '\n');
        return result;
    }

}