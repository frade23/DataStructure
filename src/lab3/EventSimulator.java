package lab3;

import java.util.ArrayList;
import java.util.Queue;

public class EventSimulator {
    private int tellers;
    private ArrayList<Customer> arrivalLine;
    private BinaryHeap heap = new BinaryHeap(tellers);


    //create an event simulator
    //tellers determine how many customers can be serviced at the same time
    //arrivalLine is the input stream, sorted by arrival time
    EventSimulator(int tellers, ArrayList<Customer> arrivalLine){
        this.tellers = tellers;
        this.arrivalLine = arrivalLine;
    }
    //set the arrival line
    public void setArrivalLine(ArrayList<Customer> arrivalLine){
        this.arrivalLine = arrivalLine;
    }



    //start simulation
    void simulate() throws EmptyException {
        for(int i = 0; i < tellers;i++) {
            Customer customer = arrivalLine.get(i);
            heap.insert(customer.getArrival() + customer.getService());
            System.out.println("Tick " + i + ": process customer who arrival at tick " +
                    customer.getArrival() + " and leave at tick " +
                    (customer.getArrival() + customer.getService()));
        }

        for (int j = tellers; j < arrivalLine.size(); j++){
            Customer customer = arrivalLine.get(j);
            int x = heap.deleteMin();
            heap.insert(x + customer.getService());
            System.out.println("Tick "+ x + ": process customer who arrival at tick "+
                    customer.getArrival() + "and leave at tick " +
                    (x + customer.getService()));
        }
    }


}
