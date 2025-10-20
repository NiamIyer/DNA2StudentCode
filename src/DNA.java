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
        int max = 0;
        int curr = 0;
        for (int i = 0; i < sequence.length(); i++) {
            int k = i;
            curr = 0;
            while ((k + STR.length() < sequence.length()) && (sequence.substring(k,k + STR.length()).equals(STR))) {
                curr ++;
                k += STR.length();
                if (k > sequence.length()) {
                    if (curr > max) {
                        return curr;
                    }
                    return max;
                }
            }
            if (curr > max) {
                max = curr;
            }
        }
        return max;
    }
}
