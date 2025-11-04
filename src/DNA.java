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

    public static int STRCount(String sequence, String STR) {
        long STRHash = hash(STR);
        int STRLength = STR.length();
        int seqLength = sequence.length();
        long indexVal = findIndexVal(STRLength);
        int current = 0;
        int max = 0;
        long seqHash = hash(sequence.substring(0, STRLength));

        int i = 0;
        // While loop because i is incremented in different ways, not always by 1
        while (i <= seqLength - STRLength) {
            // Monte Carlo algorithm, does not also check if the Strings are equal due to low likelihood of error
            if (seqHash == STRHash) {
                current++;
                // Recalculates new hash because the window slides over by STRLength instead of just by 1
                i += STRLength;
                // Makes sure that new String will be in bounds
                if (i + STRLength <= seqLength) {
                    seqHash = hash(sequence.substring(i, i + STRLength));
                }
            }
            // If not a match
            else {
                // Checks to see if in middle of streak
                if (current > 0) {
                    if (current > max) {
                        max = current;
                    }
                    current = 0;
                    // Has to reset i back to the next index after the previously checked one because the end of one STR can be the start of another
                    // (Like in tricky)
                    i -= STRLength - 1;
                    // Recalculates Hash because the window isn't sliding over by 1
                    if (i <= seqLength - STRLength) {
                        seqHash = hash(sequence.substring(i, i + STRLength));
                    }
                }
                // If there wasn't a match and there wasn't an active streak
                else {
                    // Makes sure that the next window is valid, then slides the window forward by 1
                    if (i < seqLength - STRLength) {
                        seqHash = removeFirstIndex(sequence.charAt(i + STRLength), sequence.charAt(i), seqHash, indexVal);
                    }
                    i++;
                }
            }
        }
        if (max < current) {
            max = current;
        }
        return max;
    }
    public static long hash(String str) {
        // Horner's method (shown in slides) with changes variables
        long h = 0;
        // h can multiply by itself over time to have separate powers,
        // and continuously mods by P to make sure that it never goes over the long limit
        for (int i = 0; i < str.length(); i++) {
            h = (h * RADIX + str.charAt(i)) % P;
        }
        return h;
    }
    public static long findIndexVal(int STRLength) {
        // Finds the power that the first index's radix is raised to
        long val = 1;
        // Multiplies by 1 less than the STR length because h is originally 0
        for (int i = 0; i < STRLength - 1; i++) {
            val = (val * RADIX) % P;
        }
        return val;
    }
    public static long removeFirstIndex(char add, char initial, long hash, long indexVal) {
        // Uses the code given from the slides in class, removes the first term and adds the next term from the hash
        // Removes the first term
        hash = (hash + P - ((initial * indexVal) % P)) % P;
        // Adds the next term
        hash = ((hash * RADIX) + add) % P;
        return hash;
    }
}

