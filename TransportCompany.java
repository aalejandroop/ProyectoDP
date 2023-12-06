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
    private Map<Taxi, TreeSet<Passenger>> assignments;
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
        
        return vehicles;
    }

    /**
     * @return The list of passengers.
     */
    public List<Passenger> getPassengers()
    {
        

        return passengers;
    }

    /**
     * @param Add the new Vehicle.
     */
    public void addVehicle(Taxi vehicle)
    {
       
        vehicles.add(vehicle);
    }

    /**
     * Add a new passenger in the company.
     * @param passenger The new passenger.
     */
    public void addPassenger(Passenger passenger)
    {
      
        passengers.add(passenger);

    }

    /**
     * Find a the most closed free vehicle to a location, if any.
     * @param passenger who needs a taxi
     * @return A free vehicle, or null if there is none.
     */
    
    public Taxi scheduleVehicle(Passenger passenger){
        Taxi t = null;
        boolean enc = false;
        List<Taxi> listaVehiculosDisponibles = new ArrayList<Taxi>();
        
        for(int i = 0; i<vehicles.size(); i++){
            if (assignments.containsKey(vehicles.get(i))){
                if(assignments.get(vehicles.get(i)).size() < vehicles.get(i).getOccupation()){
                    vehicles.get(i).setTargetLocation(passenger.getPickup());
                    listaVehiculosDisponibles.add(vehicles.get(i));
                }
            }
            else{
                vehicles.get(i).setTargetLocation(passenger.getPickup());
                listaVehiculosDisponibles.add(vehicles.get(i));
            }
        }
        Collections.sort(listaVehiculosDisponibles,new ComparadorTaxi());
        
        for(int i = 0; i < listaVehiculosDisponibles.size(); i++){
            if(!enc){
                if(passenger.getCreditCard() > 20000 && listaVehiculosDisponibles.get(i).getOccupation() == 1){
                    enc = true;
                    t = listaVehiculosDisponibles.get(i);
                }
                else{
                    if (assignments.containsKey(listaVehiculosDisponibles.get(i))){        
                        if(assignments.get(listaVehiculosDisponibles.get(i)).size() < listaVehiculosDisponibles.get(i).getOccupation() && listaVehiculosDisponibles.get(i).getOccupation() > 1 && passenger.getCreditCard() <= 20000){
                            enc = true;
                            t = listaVehiculosDisponibles.get(i);
                        }
                    }
                    else{
                        if(listaVehiculosDisponibles.get(i).getOccupation() > 1){
                        enc = true;
                        t = listaVehiculosDisponibles.get(i);
                        }
                    }
                }
                }
            else{
                if (assignments.containsKey(listaVehiculosDisponibles.get(i))){
                    listaVehiculosDisponibles.get(i).setTargetLocation(assignments.get(listaVehiculosDisponibles.get(i)).first().getPickup());    
                }
                else{
                    listaVehiculosDisponibles.get(i).clearTargetLocation();
                }
            }
        }
        for(int i = 0; i < vehicles.size(); i++){
            if(assignments.containsKey(vehicles.get(i))){
                vehicles.get(i).setTargetLocation(assignments.get(vehicles.get(i)).first().getPickup());
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
        Taxi t = null;
        t = scheduleVehicle(passenger);
        TreeSet<Passenger> pasajeros = new TreeSet<Passenger>(new ComparadorPasHoraLlegada());

        if(t == null){
            return false;
        }
        else{
            if(assignments.containsKey(t)){
                pasajeros = assignments.get(t);
                assignments.remove(t);
                pasajeros.add(passenger);
                assignments.put(t, pasajeros);
                t.setTargetLocation(assignments.get(t).first().getPickup());
            }
            else{
                pasajeros.add(passenger);
                assignments.put(t, pasajeros);
                t.setTargetLocation(assignments.get(t).first().getPickup());
            }
            System.out.println("<<<< " + t + " go to pick up passenger " + passenger.getName() + " at " + passenger.getPickup());
            return true;
            
        }
            
    }   

    /**
     * A vehicle has arrived at a pickup point.
     * @param vehicle The vehicle at the pickup point.
     */
    public void arrivedAtPickup(Taxi taxi)
    {
            TreeSet<Passenger> pasajeros = new TreeSet<Passenger>(new ComparadorPasHoraLlegada());
            if (taxi.getLocation().equals((assignments.get(taxi).first().getPickup()))){
                taxi.pickup(assignments.get(taxi).first());
                System.out.println("<<<< "+taxi + " picks up " + (assignments.get(taxi).first().getName()));
            }
        }

    /**
     * When arrived at destination, offloads the current passenger and unasigns them.
     */
    public void arrivedAtDestination(Taxi taxi)
    {
        TreeSet<Passenger> pasajeros = new TreeSet<Passenger>(new ComparadorPasHoraLlegada());
        if(taxi.getLocation().equals(taxi.getPasajero().getDestination())){
            System.out.println(">>>> "+ taxi + " offloads " + taxi.getPasajero().toString());
            taxi.getPasajero().act();
            if (assignments.get(taxi).size() > 1){
                    pasajeros = assignments.get(taxi);
                    pasajeros.remove(pasajeros.first());
                    assignments.remove(taxi);
                    assignments.put(taxi, pasajeros);
                    if(assignments.get(taxi).size() > 0){
                        taxi.setTargetLocation(assignments.get(taxi).first().getPickup());
                    }
                }
                else{
                    assignments.remove(taxi);
                    taxi.clearTargetLocation();
                }
        }

    }
    
    
    /**
     * Show the final information of the TransportCompany
     */
    public void showFinalInfo(){
         Taxi t;
        t= vehicles.get(0);
        for(int i =0; i< vehicles.size(); i++){
            if(vehicles.get(i).getIdleCount() < t.getIdleCount()){
                t=vehicles.get(i);
            }
        }
        System.out.println("-->> Taxi(s) with less time not active <<--");
        System.out.println(t.showFinalInfo());
        
        System.out.println("-->> Taxi(s) with highest evaluation <<--");
        for(int i =0; i< vehicles.size(); i++){
            if(vehicles.get(i).getValuation() > t.getValuation()){
                t=vehicles.get(i);
            }
        }
        System.out.println(t.showFinalInfo());
        System.out.println("");
    }
}