package arrays.rearrangement.q4;

public class Solution {

    public static void main(String args[]){
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n = arr.length;
        rearrange(arr,n);
        System.out.println("Array after rearranging: ");
        printArray(arr,n);
    }

    private static void rearrange(int[] arr, int n) {
        int nextNeg = -1;
        int nextPos = -1;

        for(int i = 0;i<arr.length;i++){
            if(i%2 == 0){
                if(!(arr[i] >=0)){
                    int temp = getNextPostive(arr,i);
                    if(temp == -1)
                        break;
                    int temp1 = arr[temp];
                    arr[temp] = arr[i];
                    arr[i] = temp1;
                }
            } else {
                if (!(arr[i] < 0)) {
                    int temp = getNextNegative(arr,i);
                    if(temp == -1){
                        break;
                    }
                    int temp1 = arr[temp];
                    arr[temp] = arr[i];
                    arr[i] = temp1;
                }
            }
        }
    }

    private static int getNextPostive(int[] arr, int n){

        for(int i = n ;i<arr.length;i++){
            if(arr[i] >=0){
                return i;
            }
        }
        return -1;
    }

    private static int getNextNegative(int[] arr,int n){
        for(int i = n;i<arr.length;i++){
            if(arr[i]<0){
                return i;
            }
        }
        return -1;
    }

    // A utility function to print an array 
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + "   ");
    }
}
