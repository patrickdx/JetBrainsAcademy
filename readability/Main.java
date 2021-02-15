package readability;

import java.util.Scanner;




public class Main {


    public static void main(String[] args)  {       // input file containing text from command line
        Scanner scanner = new Scanner(System.in);
        ReadabilityLevel input = new ReadabilityLevel(args[0]);
        input.start();
    }



}
