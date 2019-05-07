import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    Bus bus;
    Person person;
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    Person person5;
    BusStop busStop;

    @Before
    public void before(){
        bus = new Bus("Edinburgh", 5);
        person = new Person();
        person1 = new Person();
        person2 = new Person();
        person3 = new Person();
        person4 = new Person();
        person5 = new Person();
        busStop = new BusStop("High Street");
    }

    @Test
    public void hasDestination(){
        assertEquals("Edinburgh", bus.getDestination());
    }

    @Test
    public void hasCapacity(){
        assertEquals(5, bus.getCapacity());
    }

    @Test
    public void startsWithNoPassengers(){
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canAddPassenger(){
        bus.addPassenger(person);
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void doesNotAddPassengerIfCapacityFull(){
        bus.addPassenger(person);
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        bus.addPassenger(person3);
        bus.addPassenger(person4);
        bus.addPassenger(person5);
        assertEquals(5, bus.passengerCount());
    }

    @Test
    public void canRemovePassenger(){
        bus.addPassenger(person);
        bus.addPassenger(person1);
        bus.removePassenger(person1);
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void canPickUpAPassengerFromBusStop(){
        busStop.addPersonToQueue(person);
        bus.pickUpFromBusStop(busStop, person);
        assertEquals(0, busStop.peopleInQueue());
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void canCheckRemainingCapacity(){
        bus.addPassenger(person);
        assertEquals(4, bus.remainingCapacity());
    }


    @Test
    public void canPickUpAllAtBusStop(){
        busStop.addPersonToQueue(person);
        busStop.addPersonToQueue(person2);
        busStop.addPersonToQueue(person3);
        bus.clearBusStop(busStop);
        assertEquals(3, bus.passengerCount());
    }

    @Test
    public void doesntPickUpAllIfNotEnoughSpace(){
        busStop.addPersonToQueue(person);
        busStop.addPersonToQueue(person1);
        busStop.addPersonToQueue(person2);
        busStop.addPersonToQueue(person3);
        busStop.addPersonToQueue(person4);
        busStop.addPersonToQueue(person5);
        bus.clearBusStop(busStop);
        assertEquals(0, bus.passengerCount());
    }
}
