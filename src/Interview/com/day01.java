import java.util.*;
import java.util.concurrent.locks.Lock;

public class day01 {

    public static void main(String[] args) {

        int array[] = {12, 23, 453, 1234, 5323, 454};//有序的数组
        System.out.println(Arrays.toString(array));
        //查找元素55的位置
        System.out.println(recurBinarySearch(array, 12, 0, array.length - 1));

        System.out.println(find(array, 5, 0, array.length - 1));
    }

    /**
     * 二分法查找元素的位置 非递归算法
     *
     * @param array
     * @param value
     * @return
     */
    public static int myBinarySearch(int array[], int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == value) {
                return mid;
            }
            if (array[mid] > value) {
                high = mid - 1;
            }
            if (array[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分法查找元素的位置 递归算法
     *
     * @param array
     * @param value
     * @param low
     * @param high
     * @return
     */
    public static int recurBinarySearch(int array[], int value, int low, int high) {
        int mid;
        mid = (low + high) / 2;
        if (low > high) {
            return -1;
        }
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] > value) {
            return recurBinarySearch(array, value, low, mid - 1);
        } else {
            return recurBinarySearch(array, value, mid + 1, high);
        }

    }

    public static int find(int array[], int value, int low, int high) {

        int mid = (high + low) / 2;
        if (low > high) {
            return -1;
        }

        if (array[mid] == value) {
            return mid;
        } else if (array[mid] > value) {
           return find(array, value, low, mid - 1);
        } else {
            return find(array, value, mid + 1, high);
        }
    }
}

