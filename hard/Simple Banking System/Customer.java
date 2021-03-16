package banking;

import java.util.ArrayList;

public class Customer {     // customer stores all accounts (cards)

    private CreditCard loggedInCard;
    private CardDatabase database;


    public Customer(){
        database = new CardDatabase();
    }

    public boolean loginSuccessful(String cardNumber, String pin){

        CreditCard possibleCard = database.searchCard(cardNumber); // assign creditcard as a card from database


        if (possibleCard != null && cardNumber.equals(possibleCard.getNumber()) && pin.equals(possibleCard.getPin())){
            loggedInCard = possibleCard;    // now we have reference of logged in card
            return true;
        }
        return false;

    }


    public int balance(){

        return database.searchCard(loggedInCard.getNumber()).getBalance();

    }

    public void addMoney(int amount){

        amount += loggedInCard.getBalance();
        database.updateBalance(amount, loggedInCard.getNumber());


    }
    // balance() vs loggedinCard.getBalance might be confusing, since balance() searchs database while getBalance returns object balance.
    // getBalance() is needed however for the CreditCard balance and return of the search method...
    // in some cases getBalance does not reeturn same thing as balance()
    public void transferMoneyTo(String number, int amount){
        database.updateBalance(amount, number);
        database.updateBalance(balance()-amount, loggedInCard.getNumber());      // subtract amount from sending card
    }

    public void closeAccount(){

        database.delete(loggedInCard.getNumber());

    }

    public String getCardNumber(){
        return loggedInCard.getNumber();
    }




}
