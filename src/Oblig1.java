import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
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

    public static void partitionSort(int[] a, int fra, int til){
        int pivot = a[fra];
        int i = fra -1;
        int j = til +1;
        while(i<j){
            for(i++; a[i]<pivot; i++);
            for(j--; a[j]>pivot; j--);
            if(i<j) bytt(a, i, j);
        }
    }

    public static void delsortering(int[] a) {
        throw new NotImplementedException();
    }
    /*
    ///// Oppgave 4 //////////////////////////////////////

     */
    /*
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

        if (n > 1) {
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
    /*
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
                boblesortering(a, 0, a.length);
            } else {
                boblesortering(a, 0, venstre);
                boblesortering(a, venstre, a.length);
            }
        }
    }

*/
    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

        if(a.length<2){}
        else if(a.length==2){
            char temp = a[0];
            a[0] = a[1];
            a[1] = temp;
        }
        else{
            char siste = a[a.length-1];

            for(int i = a.length-1; i>0; i-- ){
                a[i]= a[i-1];
            }

            a[0] = siste;
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjonLeft(char[] a) {

        if(a.length<2){}
        else if(a.length==2){
            char temp = a[0];
            a[0] = a[1];
            a[1] = temp;
        }
        else{
            char siste = a[0];

            for(int i = 0; i<a.length-1; i++ ){
                a[i+1]= a[i];
            }

            a[a.length] = siste;
        }
    }

    public static void rotasjon(char[] a, int k) {
        int n = a.length;

        if (n == 0) return;
        if(k== 1) rotasjon(a);
        if (k == -1){
            rotasjonLeft(a);
        }

        if(k>n) k = k%n;


        if(k<-1){
            int u = k*-1;
            System.out.println(k);
            reverseArray(a, 0, u - 1);
            reverseArray(a, u, n - 1);
            reverseArray(a, 0, n - 1);
        }
        if(k>1) {
            reverseArray(a, 0, n - 1);
            reverseArray(a, 0, k - 1);
            reverseArray(a, k, n - 1);
        }
    }

    public static void reverseArray(char[] a, int fra,int til){

        char temp = a[fra];
        while(fra<til) {
            temp = a[fra];
            a[fra] = a[til];
            a[til] = temp;
            fra++;
            til--;
        }
    }


    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        String a = "";
        int n = s.length();
        int m = t.length();
        if((n==0) && (m==0)) return a;
        else if(n==0){
            a = t;
            return a;
        }
        else if(m==0){
            a = s;
            return a;
        }
        if(n==0) {
            a = t;
            return a;
        }
        if (m==0) {
            a= s;
            return a;
        }
        if (s.length() > t.length()) {
            for (int i = 0; i < t.length(); i++) {
                a += s.charAt(i);
                a += t.charAt(i);

            }

            for (int i = t.length(); i < s.length(); i++) {
                a += s.charAt(i);
            }
        } else if (t.length() > s.length()) {
            for (int i = 0; i < s.length(); i++) {
                a += s.charAt(i);
                a += t.charAt(i);

            }

            for (int i = s.length(); i < t.length(); i++) {
                a += t.charAt(i);
            }
        }

        else {
            for (int i = 0; i < s.length(); i++) {
                a += s.charAt(i) + t.charAt(i);

            }
        }
        return a;
    }


    /// 7b)
    public static String flett(String... s) {

        System.out.println(Arrays.toString(s));
        String a = "";
        int n = s.length;

        if (n == 0) return a;

        boolean check = true;
        int sum = 0;
        int teller = 0;
        int[] lengthArray = new int[n];
        int[] zeros = new int[n];
        for (String i : s) {
            lengthArray[teller] = i.length();
            sum += i.length();
            System.out.println("sum " + sum);
            zeros[teller] = 0;
            if (i.length() == 0) {
                sum++;
                zeros[teller] = 1;
            }
            teller++;
        }
        /*
        int i = 0;
        int j = 0;
        int k = n-1;
        int l = m-1;
        do{
            System.out.println("i "+i+" j " +j);
            int m = lengthArray[i];
            if(m==0){
                i++;
                if(i>=n-1) {
                    check = false;
                }
                j = 0;
            }

            if (k <= l){
                a += s[i].charAt(j);
                j++;

                if((j >= m-1)) {
                    i++;
                    if (i > n-1) {
                        check = false;
                    }


                }
                }
            }while(check);


*/


        teller = 0;
        //int i = 0;
        int k = 0;
        int conter = 0;
        System.out.println(Arrays.toString(lengthArray) + " sum " + sum);
 /*       while (k < lengthArray.length) {
            //if(lengthArray[k]== 0){}
            for (int i = 0; i < lengthArray[k] - 1; i++) {
                if (lengthArray[k] == 0) {

                } else {
                    System.out.println("teller" +teller);
                    if(teller>=lengthArray[teller]-1) continue;
                    else a += s[i].charAt(teller);

                }
            }
            teller++;
            k++;
   */

 for(int i = 0; i<=lengthArray.length+1; i++)
    for(String q:s){
        if(q.isEmpty()){}
        else if (q.length()>i){System.out.println("q lenge" + q.length()+ " i " +i);
            a += q.charAt(i);
        }
        //else
    }





        System.out.println("svaar" + a);
        return a;
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
        /*
        int[] tom = {};
        System.out.println(tom.length);
        delsortering(tom);
        int[] rand = {1, 2, 3, 4, 5, 6};
        delsortering(rand);
*/
        /*
        char[] a = {};
        char[] c = {'A', 'B'};
        char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        rotasjon(a);
        rotasjon(c , -1);
        rotasjon(d, -3);
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));

         */
        String s = flett("AFK", "BGLP", "CHMQT", "DINRUW", "EJOSVXY");
        //String s = flett("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU");
        //System.out.println("flett"+s);
        System.out.println(s);

    }

}  // Oblig1
