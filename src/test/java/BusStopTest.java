import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    BusStop busStop;
    Person person;
    Person person1;


    @Before
    public void before(){
        busStop = new BusStop("High Street");
        person = new Person();
        person1 = new Person();
    }


    @Test
    public void hasName(){
        assertEquals("High Street", busStop.getName());
    }

    @Test
    public void startsWithEmptyQueue(){
        assertEquals(0, busStop.peopleInQueue());
    }

    @Test
    public void canAddPersonToQueue(){
        busStop.addPersonToQueue(person);
        assertEquals(1, busStop.peopleInQueue());
    }

    @Test
    public void canRemovePersonFromQueue(){
        busStop.addPersonToQueue(person);
        busStop.removePersonFromQueue(person);
        assertEquals(0, busStop.peopleInQueue());
    }

    @Test
    public void canEmptyQueue(){
        busStop.addPersonToQueue(person);
        busStop.addPersonToQueue(person1);
        busStop.clearQueue();
        assertEquals(0, busStop.peopleInQueue());
    }

}
