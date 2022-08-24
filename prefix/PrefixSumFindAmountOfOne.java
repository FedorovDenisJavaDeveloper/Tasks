package prefix;

import java.util.Arrays;

public class PrefixSumFindAmountOfOne {
    public static void main(String[] args) {
        //ищем 1 и считаем их сумму!!!!
        int[] init = {5,7,0,1,2,1,3,1,2,1,4,1,2,1,3,1,2,1};
        int[] prefix = new int[init.length+1];
        prefix[0]=0;
        for (int i = 1; i < prefix.length; i++) {
            if(init[i-1]==1){
                prefix[i] = prefix[i-1]+1;
            } else {
                prefix[i] = prefix[i-1];
            }
        }
        System.out.println(Arrays.toString(init));
        System.out.println(Arrays.toString(prefix));
    }
}
