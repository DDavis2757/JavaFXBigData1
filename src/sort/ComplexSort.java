package sort;

/**
 *
 * @author Dillon Davis
 */
public class ComplexSort {
    public static void mergeSort(int[] a, String direction){
        int nElems = a.length;
        int[] workSpace = workSpace = new int[nElems];
        recMergeSort(a, direction, workSpace, 0, nElems-1);
        
    }
    
    public static void recMergeSort(int[] a, String direction, int[] workSpace,
            int lowerBound, int upperBound){
            if(lowerBound == upperBound){
                return;
            } else{
             int mid = (lowerBound+upperBound)/2;
             recMergeSort(a,direction,workSpace,lowerBound,mid);
             recMergeSort(a,direction,workSpace,mid+1,upperBound);
             merge(a,direction,workSpace,lowerBound,mid+1,upperBound);
    }
}
    public static void merge(int[] a, String direction, int[] workSpace,
            int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound+1;
        
        while(lowPtr<=mid && highPtr<=upperBound){
            if(a[lowPtr]<a[highPtr]&& direction.equalsIgnoreCase("A")
                    || a[lowPtr]>a[highPtr]&&direction.equalsIgnoreCase("D")){
                workSpace[j++]=a[lowPtr++];
            } else {
                workSpace[j++] = a[highPtr++];
            }
        }
        while(lowPtr<=mid){
            workSpace[j++] =a[lowPtr++];
        }
        while(highPtr<=upperBound){
            workSpace[j++]=a[highPtr++];
        }
        for(j=0;j<n;j++){
            a[lowerBound + j] = workSpace[j];
        }
    }
    
     public static void quickSort(int[] a, String direction){
        if(direction.equals("A")){
            ascendingQuickSort(a, 0, a.length-1);
        }
        if(direction.equals("D")){
            descendingQuicksort(a, 0, a.length);
        }
    }
    
    public static void ascendingQuickSort(int[] a, int low, int high) {

        int idx = split(a, low, high);

        if (low < idx - 1) {
            ascendingQuickSort(a, low, idx - 1);
        }

        if (high > idx) {
            ascendingQuickSort(a, idx, high);
        }
    }
    
    public static int split(int[] a, int left, int right) {
        int pivot = a[left];

        while (left <= right) {
            
            while (a[left] < pivot) {
                left++;
            }
            
            while (a[right] > pivot) {
                right--;
            }

            
            if (left <= right) {
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;

                
                left++;
                right--;
            }
        }
        return left;
    }

    public static void descendingQuicksort(int[] a, int left, int right) {
        if (left < right) {
            int pivot = left;
            for (int i = left + 1; i < right; i++) {
                if (a[i] > a[left]) {
                    descendingSwap(a, i, ++pivot);
                }
            }
            descendingSwap(a, left, pivot);
            descendingQuicksort(a, left, pivot);
            descendingQuicksort(a, pivot + 1, right);
        }
    }

    private static void descendingSwap(int[] a, int left, int right) {
        int temp = a[right];
        a[right] = a[left];
        a[left] = temp;
    }
}
