import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TaxiTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class TaxiTest
{
    private Taxi taxi;
    private Passenger passenger;
    private Taxi taxi2;
    private Passenger passenger2;
    //TODO
    //crear más campos (si es necesario) 
    /**
     * Default constructor for test class TaxiTest
     */
    public TaxiTest()
    {
    }

    /**
     * Create a taxi.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        TransportCompany company = new TransportCompany("Compañía Taxis Cáceres");
        // Starting position for the taxi.
        Location taxiLocation = new Location(0, 0);
        Location taxiLocation2 = new Location(2, 2);
        // Locations for the passenger.
        Location pickup = new Location(3, 3);
        Location destination = new Location(0, 0);
        Location pickup2 = new Location(6, 6);
        Location destination2 = new Location(1, 1);

        passenger = new PassengerVip(pickup, destination,"Kevin", 30, 30000, Reliable.HIGH);
        taxi = new TaxiExclusive(company, taxiLocation,"T1", FuelConsumption.MEDIUM, 7000);
        passenger2 = new PassengerNoVip(pickup2, destination2,"Fernando",20, 3000, Reliable.LOW);
        taxi2 = new TaxiShuttle(company, taxiLocation2,"T2", FuelConsumption.HIGH,9000);
        //TODO
        //Completar (si es necesario) este método
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test creation and the initial state of a taxi.
     */
    @Test
    public void testCreation()
    {
        assertEquals(true, taxi.isFree());
    }

    /**
     * Test that a taxi is no longer free after it has
     * picked up a passenger.
     */
    @Test
    public void testPickup()
    {
        //TODO implementar este método
        assertEquals(true, taxi.isFree());
        taxi.pickup(passenger);
        assertEquals(false, taxi.isFree());

        assertEquals(true, taxi2.isFree());
        taxi2.pickup(passenger2);
        assertEquals(false, taxi2.isFree());
    }

    /**
     * Test that a taxi becomes free again after offloading
     * a passenger.
     */
    @Test
    public void testOffload()
    {
        //TODO implementar este método
        taxi.pickup(passenger);
        assertEquals(false, taxi.isFree());
        taxi.offloadPassenger();
        assertEquals(true, taxi.isFree());

        taxi2.pickup(passenger2);
        assertEquals(false, taxi2.isFree());
        taxi2.offloadPassenger();
        assertEquals(true, taxi2.isFree());
    }

    /**
     * Test that a taxi picks up and delivers a passenger within
     * a reasonable number of steps.
     */
    
    /*
    @Test
    public void testDelivery()
    {        
        //TODO implementar este método
        int cont = 0;
        taxi.setTargetLocation(passenger.getPickup());
        int distancia = taxi.distanceToTheTargetLocation();
        for (int i = 0; i < distancia; i++){
            taxi.act();
            cont++;
        }
        assertEquals(3, cont);
        taxi.pickup(passenger);
        taxi.setTargetLocation(passenger.getDestination());
        distancia = taxi.distanceToTheTargetLocation();
        cont = 0;
        for (int i = 0; i < distancia; i++){
            taxi.act();
            cont++;
        }
        assertEquals(3, cont);

        cont = 0;

        taxi2.setTargetLocation(passenger2.getPickup());
        int distancia2 = taxi2.distanceToTheTargetLocation();
        for (int i = 0; i < distancia2; i++){
            taxi2.act();
            cont++;
        }
        assertEquals(4, cont);
        taxi2.pickup(passenger2);
        taxi2.setTargetLocation(passenger2.getDestination());
        distancia2 = taxi2.distanceToTheTargetLocation();
        cont = 0;
        for (int i = 0; i < distancia2; i++){
            taxi2.act();
            cont++;
        }
        assertEquals(5, cont);
    }*/
}

