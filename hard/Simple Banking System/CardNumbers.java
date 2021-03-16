package banking;

import java.util.Random;

public class CardNumbers {   // to generate and validate card numbers via Luhn algorithm.


    public static String generateNumber(){

        // 16 digit card with starting 6 digits IIN: 400000, including checksum number.
        // L to specify long number, else complier reads it as Integer, and will complain.
        long number;


        long randomNumber = (long) Math.floor(Math.random() * 900000000L) + 100000000L;
        number = 400000000000000L + randomNumber;      //  400000 + random 9 random digits

        // Luhn Algorithm for last number: checkDigit

        String finalNumber = (String.valueOf(number) + String.valueOf(luhnCheckDigit(number)));

        return finalNumber;
    }

    // https://en.wikipedia.org/wiki/Luhn_algorithm
    // Luhns Algo: from wikipedia


    public static int luhnSum(long number){

        int length = String.valueOf(number).length();
        long temp;
        int sum=0;

        for (int i=0; i<length; i++){

            temp = number%10;   // get rightmost digit

            if (i % 2 ==0){
                if (temp*2 > 9){
                    sum+= temp*2-9;
                }
                else{
                    sum += temp*2;
                }
            }
            else {
                sum += temp;
            }
            number = number/10; // next digit

        }

        return sum;
    }


    public static int luhnCheckDigit(long number){

        int sum = luhnSum(number);
        return ((sum*9) % 10);

    }



    public static boolean verifyLuhn(long number){

        long checkDigit = number%10;

        String originalNumber = Long.toString(number);
        originalNumber= originalNumber.substring(0, originalNumber.length() - 1);   // cut off checkdigit
        int sum = luhnSum(Long.parseLong(originalNumber));

        return (sum + checkDigit) % 10 == 0;

    }


    public static String generatePin(){

        Random rand = new Random();
        String randomPIN = String.format("%04d", rand.nextInt(10000));    // 0000-9999
        return randomPIN;

    }




}
