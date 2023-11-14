/**
 * Model a passenger wishing to get from one
 * location to another.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class Passenger
{
    private String name;
    private Location pickup;
    private Location destination;
    private String taxiName;
    protected int arrivalTime;
    protected int creditCard;
    private Reliable reliable;
    //incluir campo para el nombre del taxi que lo ha transportado

    /**
     * Constructor for objects of class Passenger
     * @param pickup The pickup location, must not be null.
     * @param destination The destination location, must not be null.
     * @param name The passenger's name
     * @throws NullPointerException If either location is null.
     */
    public Passenger(Location pickup, Location destination, String name, String taxiName, int arrivalTime, int creditCard /*, Reliable reliable*/)
    {
        //TODO modificar el constructor o crear otro constructor si necesario
        if(pickup == null) {
            throw new NullPointerException("Pickup location");
        }
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }
        this.pickup = pickup;
        this.destination = destination;
        this.name = name;
        this.taxiName = taxiName;
        this.arrivalTime = arrivalTime;
        this.creditCard = creditCard;
        //setReliable(reliable);
        
        //incluir inicialización del campo para el nombre del taxi que lo ha transportado
    }

    /**
     * @return The name of the passenger.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The destination location.
     */
    public Location getDestination()
    {
        return destination;
    }

    /**
     * Return details of the passenger, such as where it is.
     * @return A string representation of the passenger.
     */
    public String toString()
    {
        return "Passenger "+getName()+" travelling from " +
        pickup + " to " + destination;
    }

    //TODO Debe poder devolver la posición donde hay que recoger al Passenger.
    /**
     * @return the location where the passenger has to be picked up.
     */
    public Location getPickup()
    {
        return pickup;
    }

    //TODO Debe poder devolver la localización donde hay que llevar al Passenger.

    //TODO Debe poder modificarse el nombre del taxi usado.
    /**
     * Set the name of the taxi assigned with the passenger.
     */
    public void setNombreTaxi(String nombreTaxi)
    {
        taxiName = nombreTaxi;
    }    

    //TODO Debe poder devolver el nombre del taxi usado..
    /**
     * @return the name of the taxi the passenger is assigned with.
     */
    public String getNombreTaxi()
    {
        return taxiName;
    }    

    /**
     * Show the final information about the passenger, including the name of the taxi that used.
     */
    public String showFinalInfo()
    {
        // TO DO
        return "Passenger "+ getName()+" in location " +
        getDestination().getX() + "," + getDestination().getY() + " transported by: " + getNombreTaxi();
    }
    
    public int getArrivalTime(){
        return this.arrivalTime;
    }
    
    public int getCreditCard(){
        return this.creditCard;
    }
    
    void act(){
        //pay();
        //calculateEvaluationValue();
    }

}
