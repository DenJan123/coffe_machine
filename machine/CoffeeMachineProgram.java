package machine;

import java.util.Scanner;

public class CoffeeMachineProgram {
    public static int moneyNow = 550;
    public static int waterNow = 400;
    public static int milkNow = 540;
    public static int coffeeNow = 120;
    public static int cupsNow = 9;
    public static Recipes espresso = new Recipes(
            250,
            16,
            4,
            0
    );
    public static Recipes latte = new Recipes(
            350,
            20,
            7,
            75
    );

    public static Recipes cappuccino = new Recipes(
            200,
            12,
            6,
            100
    );

    public void execute() {
        do {
            String whatToDo = askAction();
            executeAction(whatToDo);
        } while (true);
    }

    public static void printState() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water", waterNow);
        System.out.printf("\n%d ml of milk", milkNow);
        System.out.printf("\n%d g of coffee beans", coffeeNow);
        System.out.printf("\n%d disposable cups", cupsNow);
        System.out.printf("\n$%d of money\n", moneyNow);
    }

    public static String askAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        Scanner sc = new Scanner(System.in);
        String action = sc.nextLine();
        return action;
    }

    public void executeAction(String action) {
        switch (action) {
            case "buy": {
                buy();
                break;
            }
            case "fill": {
                fill();
                break;
            }
            case "take": {
                take();
                break;
            }
            case "remaining": {
                printState();
                break;
            }
            case "exit": {
                exit();
            }
            default: {
                System.out.println("I can't do that");
                break;
            }
        }
    }

    private void exit() {
        System.exit(1);
    }

    public void buy() {
        System.out.println(
                "What do you want to buy? 1 - espresso," +
                        "2 - latte, 3 - cappuccino");
        Scanner sc = new Scanner(System.in);
        String whatToMake = sc.nextLine();

        switch (whatToMake) {
            case "1": {
                espresso.useResources(this);
                break;
            }
            case "2": {
                latte.useResources(this);
                break;
            }
            case "3": {
                cappuccino.useResources(this);
                break;
            }
            case "back":{
                back();
                break;
            }
            default: {
                System.out.println("I don't have other options");
                break;
            }
        }
    }

    private void back() {
        return;
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        Scanner sc = new Scanner(System.in);
        int waterToAdd = sc.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        int milkToAdd = sc.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeToAdd = sc.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        int cupsToAdd = sc.nextInt();

        waterNow += waterToAdd;
        milkNow += milkToAdd;
        coffeeNow += coffeeToAdd;
        cupsNow += cupsToAdd;
    }

    public static void take() {
        System.out.printf("I gave you $%d\n\n", moneyNow);
        moneyNow = 0;
    }
}
