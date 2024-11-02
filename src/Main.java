// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
//        System.out.print("Hello and welcome!");
//        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Shift+F9 to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Ctrl+F8.
//            System.out.println("i = " + i);
//        }

        char[] cs = {'a', 'b', 'c','a','b','d'};
        Main test= new Main();
        test.getNext(cs);
    }

    public int[] getNext(char[] t){
        int j = 0, k = -1;

        int[] next = new int[t.length];
        next[j] = k;
        while (j<t.length-1){
            if(k==-1 || t[j] == t[k]){
                j++;
                k++;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
        return next;
    }
}