package banking;

import java.util.Objects;

public class CreditCard {

    final private String number;   // values dont change
    final private String PIN;       // b/c if pin: 0001 -> 1 instead of "0001"
    private int balance;
    private int id;                 // id is a dedicated row in the database table used for identification of the cards.
//    private static int count=1;     // to increment id


    public CreditCard(){

        number = CardNumbers.generateNumber();
        PIN = CardNumbers.generatePin();
        balance =0;

        CardDatabase data = new CardDatabase();
        data.insert(number, PIN);

    }


    public CreditCard(String number, String PIN, int id, int balance){    // for already generated card
        this.number = number;
        this.PIN = PIN;
        this.id = id;
        this.balance = balance;
    }

    public String getPin(){
        return this.PIN;
    }

    public String getNumber(){
        return this.number;
    }

    public int getBalance(){
        return this.balance;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return balance == that.balance && Objects.equals(number, that.number) && Objects.equals(PIN, that.PIN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, PIN, balance);
    }



}
