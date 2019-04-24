package lab3;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) throws EmptyException {
        ArrayList<Customer> arrivalLine = new ArrayList<>();
        arrivalLine.add(new Customer(0, 8));
        arrivalLine.add(new Customer(1, 5));
        arrivalLine.add(new Customer(2, 3));
        arrivalLine.add(new Customer(4, 1));
        arrivalLine.add(new Customer(4, 5));
        arrivalLine.add(new Customer(4, 4));
        arrivalLine.add(new Customer(5, 4));
        arrivalLine.add(new Customer(6, 1));
        arrivalLine.add(new Customer(7, 3));
        EventSimulator es = new EventSimulator(3, arrivalLine);
        es.simulate();
    }
}
