import java.util.ArrayList;

public class BusStop {
    private String name;
    private ArrayList<Person> queue;

    public BusStop(String name){
        this.name = name;
        this.queue = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int peopleInQueue() {
        return queue.size();
    }

    public void addPersonToQueue(Person person) {
        queue.add(person);
    }

    public Person removePersonFromQueue(Person person) {
        queue.remove(person);
        return person;
    }

    public ArrayList clearQueue() {
        ArrayList<Person> passengers = new ArrayList<>();
        for (Person person : queue){
            passengers.add(person);
        }
        queue.clear();
        return passengers;
    }
}
