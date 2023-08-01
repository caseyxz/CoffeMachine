package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private final int espressoWater = 250;
    private final int espressoBeans = 16;
    private final int espressoPrice = 4;
    private final int latteWater = 350;
    private final int latteMilk = 75;
    private final int latteBeans = 20;
    private final int lattePrice = 7;
    private final int cappuccinoWater = 200;
    private final int cappuccinoMilk = 100;
    private final int cappuccinoBeans = 12;
    private final int cappuccinoPrice = 6;

    private int machineWater;
    private int machineMilk;
    private int machineBeans;
    private int machineMoney;
    private int machineCups;
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine machine1 = new CoffeeMachine();
        machine1.setMachineCups(9);
        machine1.setMachineMilk(540);
        machine1.setMachineWater(400);
        machine1.setMachineBeans(120);
        machine1.setMachineMoney(550);
        machine1.startMachine();

    }

    private void displayStats() {
        System.out.printf("\nThe coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n\n", machineWater, machineMilk, machineBeans,machineCups, machineMoney);
    }

    private void startMachine() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String choice = in.nextLine();

        if (!choice.equals("exit")) {
            if (choice.equals("buy")) {
                buyCoffee();
            }
            else if (choice.equals("fill")) {
                fillMachine();
            }
            else if (choice.equals("take")){
               takeOutMoney();
            }
            else if (choice.equals("remaining")){
                displayStats();
            }
            startMachine();
        }


    }
    private void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String order = in.nextLine();

        if (order.equals("1")) {
           makeEspresso();
        }
        else if (order.equals("2")) {
            makeLatte();
        }
        else if (order.equals("3")){
            makeCappuccino();
        }
    }
    private void makeEspresso() {
        if (checkIngredients(espressoWater,0, espressoBeans)) {
            System.out.println("I have enough resources, making you a coffee!");

            machineWater -= espressoWater;
            machineBeans -= espressoBeans;
            machineCups-- ;
            machineMoney += espressoPrice;

            System.out.println("Here's your coffee!");
            printEspresso();
        }
    }
    private void makeLatte() {
        if (checkIngredients(latteWater,latteMilk, latteBeans)) {
            System.out.println("I have enough resources, making you a coffee!");

            machineWater -= latteWater;
            machineBeans -= latteBeans;
            machineMilk -= latteMilk;
            machineCups-- ;
            machineMoney += lattePrice;

            System.out.println("Here's your coffee!");
            printLatte();
        }
    }
    private void makeCappuccino() {
        if (checkIngredients(cappuccinoWater, cappuccinoMilk, cappuccinoBeans)) {
            System.out.println("I have enough resources, making you a coffee!");

            machineWater -= cappuccinoWater;
            machineBeans -= cappuccinoBeans;
            machineMilk -= cappuccinoMilk;
            machineCups-- ;
            machineMoney += cappuccinoPrice;

            System.out.println("Here's your coffee!");
            printCappuccino();
        }
    }

    private boolean checkIngredients(int water, int milk, int beans) {
        boolean enoughIngredients = true;
        if (water > machineWater) {
            System.out.println("Sorry, not enough water!");
            enoughIngredients = false;
        }
        if (milk > machineMilk) {
            System.out.println("Sorry, not enough milk!");
            enoughIngredients = false;
        }
        if (beans > machineBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            enoughIngredients = false;
        }
        if (machineCups < 1) {
            System.out.println("Sorry, not enough cups!");
            enoughIngredients = false;
        }
        return enoughIngredients;
    }
    private void fillMachine() {
        System.out.println("Write how many ml of water you want to add: ");
        machineWater += in.nextInt();
        System.out.println("Write how many ml of milk you want to add:  ");
        machineMilk += in.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        machineBeans += in.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        machineCups += in.nextInt();
    }

    private void takeOutMoney() {
        System.out.printf("I gave you $%d\n", machineMoney);
        setMachineMoney(0);
    }
    public void setMachineMilk(int machineMilk) {
        this.machineMilk = machineMilk;
    }

    public void setMachineWater(int machineWater) {
        this.machineWater = machineWater;
    }

    public void setMachineBeans(int machineBeans) {
        this.machineBeans = machineBeans;
    }

    public void setMachineMoney(int machineMoney) {
        this.machineMoney = machineMoney;
    }

    public void setMachineCups(int machineCups) {
        this.machineCups = machineCups;
    }

    private void printEspresso(){
        System.out.println("  .-=-.\n" +
                " ,|`~'|\n" +
                " `|   | \n" +
                "   `~'");

    }
    private void printCappuccino(){
        System.out.println("  .-~~-.\n" +
                ",|`-__-'|\n" +
                "||      |\n" +
                "`|      |\n" +
                "  `-__-'");

    }
    private void printLatte(){
        System.out.println("  .=%%=.\n" +
                ",|`=%%='|\n" +
                "||      |\n" +
                "`|      |\n" +
                "  `-__-'");

    }
}
