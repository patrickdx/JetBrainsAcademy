package readability;

import java.sql.SQLOutput;

public class Flesch_Kincaid {


    public static double getScore(int words, int sentences, int syllables){

        double score = 0.39*words/sentences+ 11.8 * syllables/words -15.59;
        return score;
    }



}
