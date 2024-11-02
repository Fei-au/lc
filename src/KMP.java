public class KMP {

    public static void main(String[] args) {
        char[] P = {'a','b','a','b','c','a','b','c','a','c','b','a','b'};
        char[] S = {'a','b','c','a','c'};
        KMP test = new KMP();
        int i = test.match(P,S);
        System.out.println(i);
    }

    int match (char[] P, char[] S){ // KMP 算法
        int[] next = buildNext(P); // 构造 next 表
        int m = S.length, i = 0; // 文本串指针
        int n = P.length, j = 0; //模式串指针
        while (j < n && i < m) // 自左向右逐个比对字符
            if (0 > j || S[i] == P[j]){// 若匹配，或 P 已移除最左侧
                {i++; j++;} // 则转到下一字符
            }else{
                j = next[j]; // 模式串右移（注意：文本串不用回退）
            }
//      delete [] next; // 释放 next 表
        return i - j;
    }

    public int[] buildNext(char[] t){
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
