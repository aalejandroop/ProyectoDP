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
    private List<Passenger> assignments;
    /**
     * Constructor for objects of class TransportCompany
     */
    public TransportCompany(String name)
    {
        this.name = name;
        //TODO implementar el resto del constructor 
        this.vehicles = new ArrayList<Taxi>();
        this.passengers = new ArrayList<Passenger>();
        this.assignments = new ArrayList<Passenger>();

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
    public void arrivedAtDestination(Taxi vehicle,
    Passenger passenger)
    {
        System.out.println(vehicle + " offloads " + passenger);
    }

    /**
     * @return The list of vehicles.
     */
    public List<Taxi> getVehicles()
    {       
        //TODO implementar el método 

        return this.vehicles;
    }

    /**
     * @return The list of passengers.
     */
    public List<Passenger> getPassengers()
    {
        //TODO implementar el método 

        return this.passengers;
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
    private Taxi scheduleVehicle(Location location)
    {
        //TODO implementar el método
        boolean enc = false;
        Taxi t = null;
        for(int i = 0; i<vehicles.size() && vehicles.get(i).isFree(); i++){
            vehicles.get(i).setTargetLocation(location);
            }
        Collections.sort(vehicles,new ComparadorTaxi());
        for(int i = 0; i<vehicles.size(); i++){
            if(vehicles.get(i).isFree()&& !enc){
                t = vehicles.get(i);
                enc = true;
            }
            else{
                if(vehicles.get(i).isFree()){
                    vehicles.get(i).clearTargetLocation();
                }
            }
        }
        return t;
    }

    /**
     * Request a pickup for the given passenger.
     * @param passenger The passenger requesting a pickup.
     * @return Whether a free vehicle is available.
     */
    public boolean requestPickup(Passenger passenger)
    {
        //TODO implementar el método
        Taxi t = null;
        t.setPickupLocation(passenger.getPickup());
        t = scheduleVehicle(t.getLocation());
        if(t == null){
            return false;
        }
            else{
                assignments.add(passenger);
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
        for(int i = 0; i < passengers.size() && !enc; i++){
            if (taxi.getLocation() == passengers.get(i).getPickup()){
                enc = true;
                taxi.pickup(passengers.get(i));
                assignments.add(passengers.get(i));
                System.out.println("<<<< "+taxi + " picks up " + passengers.get(i).getName());
            }
        }
        //System.out.println("<<<< "+taxi + " picks up " + passenger.getName());
        //TODO el pasajero debe guardar el nombre del taxi que le ha recogido
        //TODO el taxi debe recoger al pasajero
    }
    
    
    
    public void arrivedAtDestination(Taxi taxi)
    {
        //TODO Obtener el pasajero asignado al taxi y eliminar la asignación correspondiente taxi/pasajero
        boolean enc = false;
        for(int i = 0; i < assignments.size() && !enc; i++){
            if(taxi.getTargetLocation() == taxi.getLocation() && taxi.getTargetLocation() == assignments.get(i).getDestination()){
                enc = true;
                assignments.remove(i);
                System.out.println("<<<< "+taxi + " picks up " + passengers.get(i).getName());
            }
        }
    }
}
