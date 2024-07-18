package lesson.twosum;

public class TwoSum {
    public static void main(String[] args) {
        Integer[] numbers = {10, 15, 50, 30, 54, 21, 6};
        Integer target=10;
        searchNumber(numbers, target);

    }

    private static void searchNumber(Integer[] l, Integer number) {
        for (Integer i = 0; i < l.length - 1; i++) {
            for (Integer j = 1; j < l.length; j++) {
                if (l[i] + l[j] == number) {
                    System.out.println("znaleziono");
                    return;
                }
            }
        }

        System.out.println("problem");
    }
}
