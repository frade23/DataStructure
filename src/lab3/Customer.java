package lab3;

public class Customer {
    private int arrival;
    private int service;
    // create a Customer
    Customer(int arrival, int service){
        this.arrival = arrival;
        this.service = service;
    }
    // get the arrival time
    int getArrival(){
        return this.arrival;
    }
    // set the arrival time
    public void setArrival (int arrival){
        this.arrival = arrival;
    }
    // get the service time
    int getService(){
        return this.service;
    }
    // set the service time
    public void setService(int service){
        this.service = service;
    }
}
