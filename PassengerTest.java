import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PassengerTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class PassengerTest
{
    Location startLocation;
    Location destination;
    Passenger pasajero;
    /**
     * Default constructor for test class PassengerTest
     */
    public PassengerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {   
        startLocation = new Location(1, 2);
        destination = new Location(2, 2);
        pasajero = new PassengerVip(startLocation, destination, "Pedro", 30, 30000, Reliable.HIGH);
        pasajero.setNombreTaxi("Taxi Emilio");
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
     * Test basic creation of a passenger.
     * Ensure that the pickup and destination locations
     * have been set.
     */
    @Test
    public void testCreation()
    {
        //TODO implementar este método
        // Testear la creación correcta de objetos de tipo Passenger comprobando 
        // que la inicialización de campos como dirección de recogida y destino es correcta.
        assertEquals(pasajero.getPickup().getX(),1);
        assertEquals(pasajero.getPickup().getY(),2);
        
        assertEquals(pasajero.getDestination().getX(),2);
        assertEquals(pasajero.getDestination().getY(),2);
    }

    /**
     * Test of the getTaxiName method.
     * Ensure that this method gets and returns the name of the taxi correctly.
     */
    @Test
    public void testGetTaxiName()
    {
        //TODO implementar este método
        // Testear el método que devuelve el nombre del taxi que ha transportado
        //al pasajero/a
        assertEquals(pasajero.getNombreTaxi(), "Taxi Emilio");
        
    }

    /**
     * Test of the getPickupLocation method.
     * Ensure that this method gets and returns the pickup location correctly.
     */
    @Test
    public void testGetPickupLocation ()
    {
        //TODO implementar este método
        // Testear el método que devuelve la dirección de recogida del objeto.
        assertEquals(pasajero.getPickup().getX(),1);
        assertEquals(pasajero.getPickup().getY(),2);
    }
}