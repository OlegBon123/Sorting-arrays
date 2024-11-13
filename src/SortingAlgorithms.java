import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String[] args) {

        int[] array = {9, 5, 1, 4, 3, 8, 7, 2, 6};

        System.out.println("Сортування вставками:");
        insertionSort(array.clone());
        System.out.println("\nСортування злиттям:");
        mergeSort(array.clone(), 0, array.length - 1);
    }

    public static void insertionSort(int[] arr) {
        System.out.println("Початковий масив: " + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println("Відсортований масив: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        System.out.println("Відсортований масив: " + Arrays.toString(arr));
    }
}

