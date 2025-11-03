/**
 * DNA
 * <p>
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *</p>
 * <p>
 * Completed by: [Niam]
 *</p>
 */

public class DNA {
    public static long P = 145366252001L;
    public static int RADIX = 256;

    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        long STRHash = hash(STR);
        int STRLength = STR.length();
        int seqLength = sequence.length();
        long indexVal = findIndexVal(STRLength);
        long seqHash = hash(sequence.substring(0, STRLength));
        int current = 0;
        int max = 0;
        int i = 0;
        while (i < seqLength - STRLength) {
            seqHash = hash(sequence.substring(i, i + STR.length()));
            if(STRHash == seqHash) {
                current++;
                i += STRLength;
            }
            else {
                if (current > max) {
                    max = current;
                }
                current = 0;
                i++;
            }
        }
    }
    public static long hash(String str) {
        long h = 0;
        for (int i = 0; i < str.length(); i++) {
            h = (h * RADIX + str.charAt(i)) % P;
        }
        return h;
    }
    public static long findIndexVal(int STRLength) {
        long val = 1;
        for (int i = 0; i < STRLength; i++) {
            val = val * RADIX % P;
        }
        return val;
    }

}
