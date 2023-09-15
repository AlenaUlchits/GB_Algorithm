public class Main {
    public static void main(String[] args) {
        Integer[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        print(arr);
    }

    public static void print(Integer[] array){
        for (int i = 0; i < array.length; ++i){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}