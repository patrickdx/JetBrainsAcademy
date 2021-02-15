package readability;

public class Smog {


    public static double getScore(int polysyllables, int sentences){
        double  score = 1.043*Math.sqrt(polysyllables * (30/sentences)) + 3.1291;
        return score;
    }
}
