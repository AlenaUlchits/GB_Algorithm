public class HeapSort {
    public void sort(Integer[] array){
        int size = array.length;
        for(int i = size/2 - 1; i >=0; i--){
            side(array, size, i);
        }
        for (int i = size -1; i >=0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            side(array, i, 0);
        }
    }
    public void side(Integer[] arr, int size, int root){
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if(left < size && arr[left] > arr[largest]){
            largest = left;
        }
        if (right < size && arr[right]>arr[largest]) {
            largest = right;
        }
        if (largest != root){
            int swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;
            side(arr, size, largest);
        }
    }

}
