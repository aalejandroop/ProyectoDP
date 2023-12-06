import java.util.*;
/**
 * Model the common elements of taxis and shuttles.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public abstract class Taxi implements Actor
{
// The Taxi Company of this Taxi.
    private TransportCompany company;   
    private Location location;     
    private  Location targetLocation;   
    private int idleCount;      
    private String name;
    protected TreeSet<Passenger> passengers;
    private int passengersTransported;
    protected FuelConsumption fuelConsumption;
    protected int valuation;
    protected int occupation;//min 1 max 4
    private Location initialLocation;
    
    /**
     * Constructor of class Vehicle
     * @param company The taxi company. Must not be null.
     * @param location The vehicle's starting point. Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    public Taxi(TransportCompany company, Location location, String name, FuelConsumption fuelConsumption)
    {
        if(company == null) {
            throw new NullPointerException("company");
        }
        if(location == null) {
            throw new NullPointerException("location");
        }
        this.name = name;
        this.company = company;
        this.location = location;
        this.targetLocation = null;
        this.initialLocation = location;
        idleCount = 0;
        this.passengers = new TreeSet<Passenger>(new ComparadorPasHoraLlegada());
        passengersTransported = 0;
        this.occupation = 1;
        this.fuelConsumption = fuelConsumption;
        }

        
    /**
     * @return the name of the taxi
     */
    public String getName()
    {
        return name;
    }

    public int getValuation(){
        return this.valuation;
    }
    /**
     * Get the location.
     * @return Where this taxi is currently located.
     */
    public Location getLocation()
    {
        return location;
    }
    /**
     * Get the initial location of the taxi.
     * @return Where this taxi is initaly located.
     */
    public Location getInitialLocation(){
        return this.initialLocation;
    }

    /**
     * Get the passenger.
     * @return the current passenger who is the first passenger of the TreeSet.
     */
    public Passenger getPasajero(){
        return this.passengers.first();
    }
    /**
     * Get the TreeSet of passengers.
     * @return TreeSet of passengers.
     */
    public TreeSet<Passenger> getPasajeros(){
        return passengers;
    }

    /**
     * Set the current location.
     * @param location Where it is. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setLocation(Location location)
    {
        if(location != null) {
            this.location = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Get the target location.
     * @return Where this vehicle is currently headed, or null
     *         if it is idle.
     */
    public Location getTargetLocation()
    {
        return targetLocation;
    }

    /**
     * Set the required target location.
     * @param location Where to go. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setTargetLocation(Location location)
    {
        if(location != null) {
            targetLocation = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Receive a pickup location. This becomes the
     * target location.
     * @param location The pickup location.
     */
    public void setPickupLocation(Location location)
    {
        setTargetLocation(location);
    }

    /**
     * Has the vehicle a target Location?
     * @return Whether or not this vehicle has a target Location.
     */
    public boolean hasTargetLocation(){
        return getTargetLocation() != null;
    }

    /**
     * Clear the target location.
     */
    public void clearTargetLocation()
    {
        targetLocation = null;
    }

    /**
     * @return on how many steps this vehicle has been idle.
     */
    public int getIdleCount()
    {
        return idleCount;
    }

    /**
     * Increment the number of steps on which this vehicle
     * has been idle.
     */
    public void incrementIdleCount()
    {
        idleCount++;
    }

    /**
     * Return details of the taxi, such as where it is, occupation, name and the type of taxi.
     * @return A string representation of the taxi.
     */
    public String toString()
    {
        return getClass().getName() + " " +getName()+" at " + getLocation() + " occupation " + occupation;
    }

    /**
     * Is the taxi free?
     * @return Whether or not this taxi is free.
     */
    public boolean isFree()
    {
      
        if (passengers.size() < occupation){
            return true;
        }
        else
            return false;
    }

    /**
     * Notify the company of our arrival at a pickup location.
     */
    public void notifyPickupArrival()
    {
      
        company.arrivedAtPickup(this);

    }

    /**
     * Notify the company of our arrival at a passenger's destination.
     */
    public void notifyPassengerArrival(Passenger passenger)
    {
      
        if(this.location.equals(passenger.getDestination())){
            company.arrivedAtDestination(this);

        }
    }

    /**
     * Receive a passenger.
     * Set passenger's destination as its target location.
     * @param passenger The passenger.
     */
    public void pickup(Passenger passenger)
    {
       
        passenger.setNombreTaxi(this.getName());
        this.passengers.add(passenger);
        this.targetLocation = passenger.getDestination();
        

    }

    /**
     * Offload the first passenger of the TreeSet.
     */
    public void offloadPassenger()
    {
       
        this.passengers.remove(this.passengers.first());
      
    }

    /**
     * @return how many passengers this vehicle has transported.
     */
    public int passengersTransported()
    {
       
        return this.passengersTransported;
    }

    /**
     * Increment the number of passengers this vehicle has transported.
     */
    protected void incrementPassengersTransported()
    {
        
        this.passengersTransported++;
    }

    /**
     * Get the distance to the target location from the current location.
     * @return distance to target location.
     */
    public int distanceToTheTargetLocation()
    {
        
        return this.location.distance(this.targetLocation);
    }

    /**
     * Carry out a taxi's actions.
     */

    public abstract void act();

    /**
     * Return details of the taxi, such as where it is.
     * @return A string representation of the taxi.
     */
    
    public abstract int obtainComsumption();
    
    
    /**
     * Get the occupation that is the amount of people that can enter in the taxi.
     * @return a int tha is the occupation.
     */
    public int getOccupation(){
        return this.occupation;
    }
    
    
    /**
     * Get the fuelconsumption.
     * @return FuelConsumption of the taxi.
     */
    public FuelConsumption getFuelConsumption(){
        return fuelConsumption;
    }
    
    /**
     * Get the actual amount of passengers that a taxi have.
     * @return int that refers passengers size.
     */
    public int getPassengerSize(){
        return passengers.size();
    }
    
    /**
     * @return final information of the taxi.
     */
    public abstract String showFinalInfo(); 
    
    
   
}