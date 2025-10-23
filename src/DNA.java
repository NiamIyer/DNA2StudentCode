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

    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        long STRHash = hash(STR);
        int STRlength = 0;
        for (int i = 0; i < sequence.length(); i++) {

        }
        return 0;
    }

    public static long hash(String str) {
        long h = 0;
        long p = 145366252001L;
        int r = 256;
        for (int i = 0; i < str.length(); i++) {
            h = (h * r + str.charAt(i)) % p;
        }
        return h;
    }

}
