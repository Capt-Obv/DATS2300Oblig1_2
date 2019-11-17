

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.NoSuchElementException;
import java.util.Random;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) throws java.util.NoSuchElementException {

        //exception if the array is full
        if(a.length==0) {
            throw new java.util.NoSuchElementException("Tabellen er tom");
        }

        //for loop to run the whole array
        for (int i = 0; i < a.length-1; i++) {
            //if test to check if theres a need for position change
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }

        //returning the last and largest element in the array
        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) throws NoSuchElementException {
        if(a.length==0)
            throw new NoSuchElementException("Tabellen er tom");

        int teller = 0;
        for(int i = 0; i<a.length-1; i++){
            if(a[i]>a[i+1]){
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                teller++;
            }
        }
        return teller;
    }
    public static void bytt(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static int[] randPerm(int n){
        int[] a = new int[n];

        for (int i = 0; i<n ; i++) a[i] = i+1;

        Random r = new Random();

        for(int k = n-1 ; k>0 ; k--) {
            int i = r.nextInt(k + 1);
            bytt(a,k,i);
        }
        return a;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int antallUlike = 0;

        if(a.length!=0){
            if(ombyttinger(a)!=0){
                throw new IllegalStateException("Array is not sorted");
            }
        }

        if(a.length==0) return antallUlike;
        else{
            for (int i = 0; i < a.length -1 ; i++){
                if(a[i]!=a[i+1]){
                    antallUlike++;
                }
            }
        }
        antallUlike++;

        return antallUlike;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int antallUlike = 0;
        for (int i = 0; i < a.length; i++) {
            boolean test = true;
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] == a[j]) test = false;
            }

            if (test) antallUlike++;
        }

        return antallUlike;
    }

    public static void boblesortering(int[] a, int fra, int til)     // hører til klassen Tabell
    {
        for (int n = til; n > fra; n--)           // n reduseres med 1 hver gang
        {
            for (int i = fra+1; i < n; i++)                // går fra 1 til n
            {
                if (a[i - 1] > a[i]) bytt(a, i - 1, i);  // sammenligner/bytter
            }
        }
    }
/*
    public static int partition(int[] a, int fra, int til) {
        int pivot = a[fra];
        int i = fra;
        int j = til-1;
        while(i<j) {
            while(a[i]<pivot){
                i++;
            }

            if (i < j) {
                bytt(a, i, j);
                fra++;
                til--;
            }

        }
        System.out.println(pivot);
        int temp = a[fra];
        a[til] = pivot;
        a[til] = temp;
        return j;
    }
    public static void quickSort(int[] arr, int start, int end){

        int  partition = partition(arr, start, end);

        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }


    }
*/

    public static int partition(int arr[], int left, int right)

    {

        int i = left, j = right;

        int tmp;

        int pivot = arr[(left + right) / 2];



        while (i <= j) {

            while (arr[i] < pivot)

                i++;

            while (arr[j] > pivot)

                j--;

            if (i <= j) {

                tmp = arr[i];

                arr[i] = arr[j];

                arr[j] = tmp;

                i++;

                j--;

            }

        };



        return i;

    }



    public static void quickSort(int arr[], int left, int right) {

        int index = partition(arr, left, right);

        if (left < index - 1)

            quickSort(arr, left, index - 1);

        if (index < right)

            quickSort(arr, index, right);

    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int n = a.length;
        int delt = a.length/2;
        int m = n - 1;
        int venstre = 0;
        int k = 0;
        int høyre = a.length - 1;
        boolean cont = true;
        boolean test = false;
        int testv = 1;
        int testh = 1;

        if (n > 2) {
            while (cont) {

                while ((a[venstre] % 2 == 1 || a[venstre] % 2 == -1) && venstre < høyre) {
                    venstre++;
                    k++;
                }
                while (a[høyre] % 2 == 0 && venstre < høyre) {
                    høyre--;
                }

                if (venstre < høyre) {
                    //byttte plass
                    bytt(a, venstre++, høyre--);
                    /*
                    int temp = a[høyre];
                    a[høyre] = a[venstre];
                    a[venstre] = temp;


 */
                } else cont = false;
            }
        }

        if (a.length > 2) {
            if (n % 2 == 0) {
                for (int i = 0; i < delt; i++) {

                    if (a[i] % 2 == 0) {
                        testv++; }
                }
                for (int i = delt + 1; i < delt; i++) {
                    if (a[i] % 2 != 0) {
                        testh++;
                    }

                }
                if ((testv != delt) && (testh != delt)) {
                        venstre = delt;
                        høyre = delt;
                        test = true;
                    }
                }


            int q = venstre + høyre;
            boolean l = q != a.length;
            if (q != a.length) {
                if (test) {
                    venstre = delt;
                    høyre = venstre;
                }
            }

            if (n == 0 || n == 1) {
            } else if (venstre == 0 || venstre == m) {
                quickSort(a, 0, a.length);
            } else {
                quickSort(a, 0, venstre);
                quickSort(a, venstre, a.length);
            }
        }
    }


    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

    public static void main(String args[]){
        int[] tom = {};
        System.out.println(tom.length);
        delsortering(tom);
        int[] rand = {1, 2, 3, 4, 5, 6};
        delsortering(rand);
    }

}  // Oblig1
