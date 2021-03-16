package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadabilityLevel {

    private String TEXT;

    public ReadabilityLevel(String text){
        try {
            File myObj = new File(text);
            Scanner myReader = new Scanner(myObj);
            TEXT = new String(Files.readAllBytes(Paths.get(text)));  // all into a string
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int countMatches(String regex){
        int count=0;
        Pattern sentencePattern = Pattern.compile(regex);
        Matcher matchSentences = sentencePattern.matcher(TEXT);

        while (matchSentences.find()) {
            count++;
        }

        return count;
    }

    public int[] syllableCount(){

        int [] array = new int[2];
        int syllables=0;
        int count1=0;
        int polysyllables=0;

        String words [] = TEXT.split(" ");

        for (int i=0; i< words.length; i++) {
            words[i].concat(" ");

            Pattern sentencePattern = Pattern.compile("(?=[AEIOUYaeiouy][^aeiouy])(?!e[;,.\\s])");      // syllable regex
            Matcher matchSentences = sentencePattern.matcher(words[i]);

            while (matchSentences.find()){
                syllables++;
                count1++;

            }
            if (matchSentences.find() == false) {            // if none found in a word, assume 1.
                syllables++;
            }
            if (count1 >= 2) {
                polysyllables++;
            }
            count1 = 0;

        }

        array[0] = syllables;
        array[1] = polysyllables;
        return array;

    }



    public void start(){

        int sentences =0;
        int words = 0;
        int characters = 0;
        int syllables =0;
        int polysyllables =0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("The text is:");
        System.out.println(TEXT);
        System.out.println();


        sentences = TEXT.split("[?!.]").length;         // ?!. denotes end of sentence.
        words = countMatches("\\s") + 1;                // the last word has no whitespace after it, thus counted as totalWords-1
        characters = countMatches("[^\\t|\\n|\\s]");    // if its not whitespace, newline, or tab, then its a character.


        int array [] = syllableCount();
        syllables = array[0];
        polysyllables = array[1];


        double AR=  AutomatedReadability.getScore(words,characters,sentences);
        double S =Smog.getScore(polysyllables,sentences);
        double FK = Flesch_Kincaid.getScore(words,sentences,syllables);
        double CL = Coleman_Liau.getScore(100.0 * characters/words, 100* sentences/words);


        System.out.printf("Automated Readability Index: %.2f (about " + getReadabilityLevel(AR) + " year olds).%n", AR);
        System.out.printf("Flesch-Kincaid readability tests: %.2f (about " + getReadabilityLevel(FK) + " year olds).%n", FK);
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about " + getReadabilityLevel(S) + " year olds).%n", S);
        System.out.printf("Coleman-Liau: %.2f (about " + getReadabilityLevel(CL) + " year olds).%n", CL);


    }


    public int getReadabilityLevel(double score){

        int ages [] = {6, 7, 9, 10, 11, 12, 13, 14,
                15, 16, 17, 18, 24, 24};

        int roundedScore = (int) Math.round(score);

        if (roundedScore > 14){
            roundedScore = 14;
        }
        return ages[roundedScore-1];


    }
}
