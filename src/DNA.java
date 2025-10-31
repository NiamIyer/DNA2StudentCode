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
        int STRLength = STR.length();
        int current = 0;
        int max = 0;
        boolean running = true;
        int index = 0;
        long seqHash = hash(sequence.substring(0, STRLength));
        for (int i = STRLength; i < sequence.length(); i++) {
            if (STRHash == seqHash) {
                current ++;
                i += STRLength;
                running = true;
                index = i;
            }
            else if (running && seqHash != STRHash) {
                i --;
                if (index == i) {
                    if (max < current) {
                        max = current;
                    }
                    current = 0;
                    running = false;
                }
            }
        }
        return max;
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
