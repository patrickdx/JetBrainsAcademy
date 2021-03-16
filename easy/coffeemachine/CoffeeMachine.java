package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int water;
    private int coffee;
    private int milk;
    private int cups;
    private int money;

    public CoffeeMachine(){     // inital
        this.water =400;
        this.coffee =120;
        this.milk =540;
        this.cups = 9;
        this.money =550;
    }

    public int take(){
        return money;
    }

    public void addMilk(int amount){
        milk += amount;
    }

    public void addWater(int amount){
        water += amount;
    }

    public void addCoffee(int amount){
        coffee += amount;
    }

    public void addCups(int amount){
        cups += amount;
    }

    public void machineContents(){
        System.out.println( water + " of water\n" +
                 milk + " of milk\n" +
                 coffee + " of coffee beans\n" +
                 cups + " of disposable cups\n" +
                 money + " of money");
    }

    public void takeMoney(){
        this.money =0;
    }


    public void buy(int coffeeChoice){


        if (coffeeChoice == 1){       // expresso
            String culprit = checkResources(250,0,16);

            if(culprit.length() !=0){  // not enought ingredients
                System.out.println("Sorry, not enough " + culprit + "!" );
                return;     // jump out of method
            }
            System.out.println("I have enough resources, making you a coffee!");

            water -= 250;
            coffee -= 16;
            money += 4;
            cups--;
        }
        else if (coffeeChoice ==  2){     // latte
            String culprit = checkResources(350,75,20);

            if(culprit.length() !=0){  // not enought ingredients
                System.out.println("Sorry, not enough " + culprit + "!" );
                return;     // jump out of method
            }
            System.out.println("I have enough resources, making you a coffee!");


            water -= 350;
            milk -= 75;
            coffee -= 20;
            money += 7;
            cups--;
        }
        else if (coffeeChoice == 3) {  // cappu
            String culprit = checkResources(200,100,12);

            if(culprit.length() !=0){  // not enought ingredients
                System.out.println("Sorry, not enough " + culprit + "!" );
                return;     // jump out of method
            }
            System.out.println("I have enough resources, making you a coffee!");


            water -= 200;
            milk -= 100;
            coffee -= 12;
            money += 6;
            cups--;
        }



    }

    public String checkResources(int enoughWater, int enoughMilk, int enoughCoffee){            // find which ingredient is insufficient
        int enoughCups = 1;
        String culprit= "";

        if (cups ==0){
            culprit= "cups";
        }

        if (water < enoughWater){
            culprit = "water";
        }
        else if (milk < enoughMilk){
            culprit = "milk";

        }
        else if (coffee < enoughCoffee){
            culprit ="coffee";
        }

        return culprit;

    }

    public void userInterface(CoffeeMachine coffe){

        while (true){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.equals("exit")){
                break;
            }

            if (choice.equals("remaining")){
                coffe.machineContents();
            }

            if (choice.equals("buy")){
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String typeofCoffee = scanner.nextLine();
                if (!typeofCoffee.equals("back")){
                    coffe.buy(Integer.parseInt(typeofCoffee));
                }
            }
            else if (choice.equals("fill")){
                System.out.println("Write how many ml of water do you want to add:");
                int amount = scanner.nextInt();
                coffe.addWater(amount);

                System.out.println("Write how many ml of milk do you want to add:");
                amount = scanner.nextInt();
                coffe.addMilk(amount);

                System.out.println("Write how many grams of coffee beans do you want to add:");
                amount = scanner.nextInt();
                coffe.addCoffee(amount);

                System.out.println("Write how many disposable cups of coffee do you want to add:");
                amount = scanner.nextInt();
                coffe.addCups(amount);

            }
            else if (choice.equals("take")){
                System.out.println("I gave you $" + coffe.money);
                coffe.takeMoney();
            }
        }

    }
    public static void main(String[] args) {            // looks nice :)

        CoffeeMachine coffe = new CoffeeMachine();
        coffe.userInterface(coffe);                     // would make UI in another class!

    }


}
