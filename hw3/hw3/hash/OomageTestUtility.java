package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {


        int[] bucket = new int[M];
        int size = oomages.size();
        for (Oomage oomage : oomages) {
            int index = (oomage.hashCode() & 0x7FFFFFFF) % M;
            bucket[index]++;
        }
        int low = size / 50;
        double high = size / 2.5;
        for (int i = 0; i < M; i++) {
            if (bucket[i] >  high || bucket[i] < low) {
                return false;
            }
        }
        return true;
    }
}
