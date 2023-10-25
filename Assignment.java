
/**
 * Write a description of class Assignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Assignment
{
    // instance variables - replace the example below with your own
    private Taxi taxi;
    private Passenger passenger;

    /**
     * Constructor for objects of class Assignment
     */
    public Assignment(Taxi t, Passenger p)
    {
        this.taxi = t;
        this.passenger = p;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public Taxi getTaxi()
    {
        return this.taxi;
    }
    
    public Passenger getPassenger()
    {
        return this.passenger;
    }
}
