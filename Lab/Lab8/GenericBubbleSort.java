package Lab.Lab8;


import java.util.Arrays;

public class GenericBubbleSort {

    public static <T extends Comparable<T>>
    void bubbleSort(T[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 8, 1, 3};
        String[] names = {"Zara", "Anesu", "Tariro"};

        bubbleSort(numbers);
        bubbleSort(names);

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(names));
    }
}
