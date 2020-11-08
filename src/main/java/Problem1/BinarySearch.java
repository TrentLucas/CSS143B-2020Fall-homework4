package Problem1;

public class BinarySearch {
    // This is to be done recursively
    // Do not change signature (return type, function name, parameter types)
    // Add a helper function for recursion calls
    public static int binarySearch(int[] data, int target) {
        // homework
        return binarySearch(data, target, 0, data.length - 1);
    }
    public static int binarySearch(int[] data, int target, int start, int end) {
        int endValue = -1; //Output
        for (int i = end; i >= start; i--) {
            if (target == data[i]) {
                endValue = i;
            }
        }
        return endValue; //Return statement
    }
}
