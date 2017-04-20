package sort;

/**
 * Big-O time of O(n*n)
 *
 * @author 55jphillip
 */
public class SimpleSorts {

    public static void bubbleSort(int[] a, String direction) {
        int out, in;
        boolean moreChanges = true;

        for (out = a.length - 1; out > 0 && moreChanges; out--) {
            moreChanges = false;
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1] && direction.equalsIgnoreCase("A")
                        || a[in] < a[in + 1] && direction.equalsIgnoreCase("D")) {
                    int temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                    moreChanges = true;
                }
            }
        }
    }
    
    public static void insertionSort(int[] a, String direction){
        int j, i;
            if(direction.equalsIgnoreCase("A")){
            for (i = 1; i < a.length; i++) {
                int temp = a[i];
                j = i;
                while (j > 0 && a[j - 1] > temp) {
                    a[j] = a[j - 1];
                    --j;
                }
                a[j] = temp;
            }
        }
            else if(direction.equalsIgnoreCase("D")){
            for (i = 1; i < a.length; i++) {
                int temp = a[i];
                for(j = i-1;(j>=0) && (a[j] < temp);j--){
                    a[j+1] = a[j];
                }
                a[j+1] = temp;
            }
        }
    }
    
    
    
    
    public static void selectionSort(int[] a, String direction){
        int temp;
        for(int i = a.length -1; i>0; i--){
            int first = 0;
            for(int j = 1; j<= i; j++){
                if(a[j] > a[first] && direction.equals("A") || a[j] < a[first]
                    && direction.equals("D")) {
                first=j;
            }
          }
            temp =a[first];
            a[first] = a[i];
            a[i]=temp;                 
        }
    }

}
