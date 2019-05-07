import java.util.ArrayList;

public class Bus {

    private String destination;
    private int capacity;
    private ArrayList<Person> passengers;

    public Bus(String destination, int capacity){
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public int passengerCount() {
        return passengers.size();
    }

    public void addPassenger(Person person) {
        if(seatEmpty()){
            passengers.add(person);
        }
    }

    public void removePassenger(Person person) {
        passengers.remove(person);
    }

    public void pickUpFromBusStop(BusStop busStop, Person person) {
        if (seatEmpty()){
            busStop.removePersonFromQueue(person);
            this.addPassenger(person);
        }
    }

    private boolean seatEmpty(){
        return passengerCount() < capacity;
    }

    public int remainingCapacity() {
        return (capacity - passengerCount());
    }

    public void clearBusStop(BusStop busStop) {
        int passengersToBeCollected = busStop.peopleInQueue();
        if (remainingCapacity() >= passengersToBeCollected){
            ArrayList<Person> collectedPassengers = busStop.clearQueue();
            for (Person person : collectedPassengers){
                addPassenger(person);
            }
        }
    }
}
