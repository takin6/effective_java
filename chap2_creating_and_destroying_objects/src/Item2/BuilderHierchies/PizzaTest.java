package Item2.BuilderHierchies;

import static Item2.BuilderHierchies.Pizza.Topping.*;
import static Item2.BuilderHierchies.NyPizza.Size.*;

public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();

        System.out.println(pizza);
        System.out.println(calzone);
    }
}
