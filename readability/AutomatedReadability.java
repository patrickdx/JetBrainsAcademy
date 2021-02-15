package readability;

public class AutomatedReadability {


    public static double getScore(int words, int characters, int sentences) {
        double score = 4.71 * characters/words + 0.5*words/sentences - 21.43;
        return score;
    }



}
