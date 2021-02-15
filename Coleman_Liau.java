package readability;

public class Coleman_Liau {


    public static double getScore(double L, double S){
        double score = 0.0588 * L - 0.296 * S - 15.8;
        return score;
    }

}
