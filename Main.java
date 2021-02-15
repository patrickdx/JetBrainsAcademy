package readability;

import java.util.Scanner;

// first time hackathon
//theme: education
// parses sentences, syllables, ... using regex
// finds readability level of text, based on 4 indexes, (coleman_liau, flesch_kincaid, smog, automatedreadability).



public class Main {


    public static void main(String[] args)  {       // input file containing text from command line
        Scanner scanner = new Scanner(System.in);
        ReadabilityLevel input = new ReadabilityLevel(args[0]);
        input.start();
    }



}
