package banking;

import java.util.Scanner;

public class BankingSystemUI {

    private Scanner scanner;
    private Customer customer;
    private CardDatabase database;


    public BankingSystemUI(){
        database = new CardDatabase();
        scanner = new Scanner(System.in);
        customer = new Customer();

    }

    public void start(){
        while (true){

            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");

            int input=0;

            try{            // scanner.nextInt() would be leave over \n and mess everything up
                 input = Integer.parseInt(scanner.nextLine());

            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }

            if (input == 0){
                System.out.println("Bye!");
                return;
            }

            else if (input == 1){

                CreditCard card = new CreditCard();

                System.out.println("Your card has been created");
                System.out.println("Your card number:");
                System.out.println(card.getNumber());
                System.out.println("Your card PIN: ");
                System.out.println(card.getPin());

            }

            else if (input == 2){

                System.out.println("Enter your card number: ");

                String number = scanner.nextLine();

                System.out.println("Enter your PIN: ");
                String PIN = scanner.nextLine();


                if (customer.loginSuccessful(number, PIN)){
                    System.out.println("You have successfully logged in!");
                    userMenu();

                }
                else {
                    System.out.println("Wrong card number or PIN!");
                }

            }

        }


    }

    public void userMenu(){

        while (true){

            System.out.println("1. Balance");
            System.out.println("2. Add income");
            System.out.println("3. Do transfer");
            System.out.println("4. Close account");
            System.out.println("5. Log out");
            System.out.println("0. Exit");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input){         // switch instead of if/else because of situation: we are just switching a single variable, that we know the values to.
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    return;
                case 1:
                    System.out.println("Balance: " + customer.balance());
                    break;
                case 2:
                    System.out.println("Enter income:");
                    int money = scanner.nextInt();
                    customer.addMoney(money);
                    System.out.println("Income was added!");
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    customer.closeAccount();
                    System.out.println("The account has been closed!");
                    return;         // wanted to break out of two loops, so made this code block into method and used return instead.
                case 5:
                    System.out.println("You have successfully logged out!");
                    return;



            }
        }
    }




    public void transfer(){


        System.out.println("Transfer");
        System.out.println("Enter card number:");
        String otherNumber = scanner.nextLine();



        if (CardNumbers.verifyLuhn(Long.parseLong(otherNumber)) == false){
            System.out.println("Probably you made a mistake in the card number. Please try again!");
            return;
        }
        else if (database.searchCard(otherNumber) == null){
            System.out.println("Such a card does not exist.");
            return;
        }
        else if (customer.getCardNumber().equals(otherNumber)){
            System.out.println("You can't transfer money to the same account!");
            return;
        }
        System.out.println("Enter how much money you want to transfer:");
        int amount = scanner.nextInt();

        if (amount > customer.balance()){
            System.out.println("Not enough money!");
        }
        else{
            customer.transferMoneyTo(otherNumber, amount);
            System.out.println("Success!");
        }
        return;



    }


    public static void main(String[] args){
        CardDatabase.setup("card.s3db");
        BankingSystemUI setup = new BankingSystemUI();

        setup.start();

    }








}
