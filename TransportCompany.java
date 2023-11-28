import java.util.*;

/**
 * Model the operation of a taxi company, operating different
 * types of vehicle. This version operates a single taxi.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TransportCompany  
{
    // TODO definir todos sus campos
    private String name;  //nombre de la compañía
    private List<Taxi> vehicles;
    private List<Passenger> passengers;
    //private List<Assignment> assignments;
    private Map<Taxi, Passenger> assignments;
    /**
     * Constructor for objects of class TransportCompany
     */
    public TransportCompany(String name)
    {
        this.name = name;
        //TODO implementar el resto del constructor 
        this.vehicles = new ArrayList<Taxi>();
        this.passengers = new ArrayList<Passenger>();
        //this.assignments = new ArrayList<Assignment>();
        this.assignments = new HashMap<>();

    }

    /**
     * @return The name of the company.
     */
    public String getName()
    {
        return name;
    }

    /**
     * A vehicle has arrived at a passenger's destination.
     * @param vehicle The vehicle at the destination.
     * @param passenger The passenger being dropped off.
     */
    public void arrivedAtDestination(Taxi vehicle,Passenger passenger)
    {
        System.out.println(vehicle + " offloads " + passenger);
    }

    /**
     * @return The list of vehicles.
     */
    public List<Taxi> getVehicles()
    {       
        //TODO implementar el método 

        return vehicles;
    }

    /**
     * @return The list of passengers.
     */
    public List<Passenger> getPassengers()
    {
        //TODO implementar el método 

        return passengers;
    }

    /**
     * @param Add the new Vehicle.
     */
    public void addVehicle(Taxi vehicle)
    {
        //TODO implementar el método
        vehicles.add(vehicle);
    }

    /**
     * Add a new passenger in the company.
     * @param passenger The new passenger.
     */
    public void addPassenger(Passenger passenger)
    {
        //TODO implementar el método
        passengers.add(passenger);

    }

    /**
     * Find a the most closed free vehicle to a location, if any.
     * @param location location to go
     * @return A free vehicle, or null if there is none.
     */
    /*private Taxi scheduleVehicle(Location location)
    {
        //TODO implementar el método
        boolean enc = false;
        Taxi t = null;
        for(int i = 0; i<vehicles.size(); i++){
            if(vehicles.get(i).getTargetLocation()==null&& vehicles.get(i).isFree()&&!assignments.contains(vehicles.get(i))){
                vehicles.get(i).setTargetLocation(location);
            }
        }
        Collections.sort(vehicles,new ComparadorTaxi());

        for(int i = 0; i<vehicles.size(); i++){

            if( vehicles.get(i).isFree()&& vehicles.get(i).getTargetLocation().equals(location) && !enc){
                enc =true;
                t=vehicles.get(i);

            }else{
                if(vehicles.get(i).isFree()&&vehicles.get(i).getTargetLocation()!=null&& vehicles.get(i).getTargetLocation().equals(location)){
                    vehicles.get(i).clearTargetLocation();
                }
            }
        }
        return t;
    }
    */

    /**
     * Request a pickup for the given passenger.
     * @param passenger The passenger requesting a pickup.
     * @return Whether a free vehicle is available.
     */
    public boolean requestPickup(Passenger passenger)
    {
        //TODO implementar el método
        Taxi t = null;
        t = scheduleVehicle(passenger.getPickup());

        if(t == null){
            return false;
        }
        else{
            t.setTargetLocation(passenger.getPickup());
            assignments.add(new Assignment(t, passenger));
            System.out.println("<<<< Taxi " + t.getName() + " at " + t.getLocation() + " go to pickup passenger " + passenger.getName() +
                " at " + passenger.getPickup());

            return true;
        }
    }   

    /**
     * A vehicle has arrived at a pickup point.
     * @param vehicle The vehicle at the pickup point.
     */
    public void arrivedAtPickup(Taxi taxi)
    {
        boolean enc = false;

        for(int i = 0; i < assignments.size() && !enc; i++){
            if (taxi.getLocation().equals( assignments.get(i).getPassenger().getPickup())){
                enc = true;
                taxi.pickup(assignments.get(i).getPassenger());
                System.out.println("<<<< "+taxi + " picks up " + assignments.get(i).getPassenger().getName());
                assignments.remove(i);
            }
        }
        //TODO el pasajero debe guardar el nombre del taxi que le ha recogido
        //TODO el taxi debe recoger al pasajero
    }

    /**
     * When arrived at destination, offloads the current passenger and unasigns them.
     */
    /*public void arrivedAtDestination(Taxi taxi)
    {
        if(taxi.getLocation().equals(taxi.getPasajero().getDestination())){
            System.out.println(">>>> "+ taxi + " offloads " + taxi.getPasajero().getName() + " travelling from " 
                + taxi.getPasajero().getPickup() + " to " + taxi.getPasajero().getDestination());
            taxi.offloadPassenger();                        
        }

    }
    */
}