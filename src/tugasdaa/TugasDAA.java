package tugasdaa;
import java.util.Arrays;
public class TugasDAA {
    public static void main(String[] args) {
        // array input
        int arr[] = {12, 11, 13, 5, 6, 7}; 
        System.out.println("Array Input"); 
        printArray(arr); 
        // array output
        TugasDAA ob = new TugasDAA(); 
        ob.sort(arr, 0, arr.length-1);   
        System.out.println("\nArray Output"); 
        printArray(arr); 
    }
    
    public void merge(int[] arr, int start, int mid, int end){
         /* ukuran dari dua subarray */
        int n1 = mid - start + 1; 
        int n2 = end - mid;   
        /* array kosong (temp) */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        /* masukan elemen ke array temp */
        for (int i=0; i<n1; ++i) 
            L[i] = arr[start + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[mid + 1+ j]; 
        /* Gabung kedua array temp */
        // inisialisasi indeks untuk sub-array
        int i = 0, j = 0;   
        // inisialisasi indeks array yang sudah digabung
        int k = start;       
        while (i < n1 && j < n2){ 
            if (L[i] <= R[j]){ 
                arr[k] = L[i]; 
                i++; 
            } else{ 
                arr[k] = R[j]; 
                j++; 
            } k++; 
        } 
        /* jika masih ada elemen dari subarray kiri */
        while (i < n1){ 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        /* jika masih ada elemen dari subarray kanan */
        while (j < n2){ 
            arr[k] = R[j]; 
            j++; 
            k++; 
        }        
    }
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r){ 
        if (l < r){ 
            // Find the middle point 
            int m = (l+r)/2;   
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r);   
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
    /* A utility function to print array of size n */
    static void printArray(int arr[]){ 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    
    // method untuk mencari elemen puncak dengan divide & conquer
    public static int maxArray(int[] A, int start, int end){
        // inisialisasi variable elemen puncak
        int max;        
        // jika tersisa 1 elemen pada array
        if(start == end){
            max = A[start];   
        // jika tersisa 2 elemen pada array    
        } else if(start + 1 == end){
            // membandingkan 2 elemen tersebut
            if(A[start] < A[end]){
                max = A[end];
            } else{
                max = A[start];
            }
        // jika terdapat beberapa elemen pada array    
        } else{
            // membagi array menjadi 2 sub-array
            int mid = start + (end - start)/2;
            // rekursif terhadap sub-array
            int left = maxArray(A, start, mid);
            int right = maxArray(A, mid+1, end);
            // membandingkan elemen puncak dari kedua sub-array
            if(left > right)
                max = left;
            else
                max = right;
        }
        return max;
    }
    
    // method combineSort untuk menggabung dan sortir array
    public static int[] combineSort(int[] A, int[] B){
        // inisialisasi Array C         
        int[] C = new int[A.length+B.length];        
        // mendefinisi indeks elemen untuk array A dan B
        int a = 0, b = 0;
        // mengisi array C         
        for(int i = 0; i < C.length; i++){
        // jika elemen dari array A dan B masih ada untuk diselidiki           
            if(a < A.length && b < B.length){
             // jika elemen dari array B lebih kecil
                if(B[b] < A[a]){
                    // masukan elemen ke array C
                    C[i] = B[b];
                    b++;
                }
            // jika elemen dari array A lebih kecil
                else{
                    // masukan elemen ke array C
                    C[i] = A[a];
                    a++;
                }
            }
        // jika sudah tidak ada elemen dari array A untuk diselidiki
        // tapi masih ada elemen dari array B untuk diselidiki
        else if(b < B.length){
            // masukan elemen ke array C
                C[i] = B[b];
                b++;
            }
        // jika sudah tidak ada elemen dari array B untuk diselidiki
        // tapi masih ada elemen dari array A untuk diselidiki
        else{
        // masukan elemen ke array C
                C[i] = A[a];
                a++;
            }
        }
        return C;
    }
}
