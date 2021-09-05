package machine;

public class Recipes {
    private int waterNeeded;
    private int coffeeNeeded;
    private int moneyNeeded;
    private int milkNeeded;
    private int cupsNeeded = 1;
    private boolean enoughIngredients;

    /**
     * @param w    water needed for recipe
     * @param c    coffee needed for recipe
     * @param mon  money needed for recipe
     * @param milk milk needed for recipe
     */
    Recipes(int w, int c, int mon, int milk) {
        waterNeeded = w;
        coffeeNeeded = c;
        moneyNeeded = mon;
        milkNeeded = milk;
    }

    public boolean checkIfAvailable(CoffeeMachineProgram coffeeMachine,
                                    int amountOfCups
    ) {
        int moneyAvailable = coffeeMachine.moneyNow;
        int waterAvailable = coffeeMachine.waterNow;
        int milkAvailable = coffeeMachine.milkNow;
        int coffeeAvailable = coffeeMachine.coffeeNow;
        int cupsAvailable = coffeeMachine.cupsNow;

        boolean result =
                moneyAvailable >= moneyNeeded * amountOfCups &&
                        waterAvailable >= waterNeeded * amountOfCups &&
                        milkAvailable >= milkNeeded * amountOfCups &&
                        coffeeAvailable >= coffeeNeeded * amountOfCups &&
                        cupsAvailable >= cupsNeeded * amountOfCups;

        if ((waterAvailable < waterNeeded * amountOfCups)) {
            System.out.println("Sorry, not enough water!");
        } else if (milkAvailable < milkNeeded * amountOfCups) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeAvailable < coffeeNeeded * amountOfCups) {
            System.out.println("Sorry, not enough coffee!");
        } else if (cupsAvailable < cupsNeeded * amountOfCups) {
            System.out.println("Sorry, not enough cups!");
        }
        ;
        return result;
    }

    public void useResources(CoffeeMachineProgram coffeeMachine) {
        boolean resoursesAvaible = checkIfAvailable(coffeeMachine, 1);
        if (resoursesAvaible) {
            System.out.println("I have enough resources, making you a coffee!");
            coffeeMachine.moneyNow += moneyNeeded;
            coffeeMachine.waterNow -= waterNeeded;
            coffeeMachine.milkNow -= milkNeeded;
            coffeeMachine.coffeeNow -= coffeeNeeded;
            coffeeMachine.cupsNow -= cupsNeeded;
        }
    }
}