
/**
 * Write a description of class TaxiShuttle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TaxiShuttle extends Taxi
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class TaxiShuttle
     */
    public TaxiShuttle(TransportCompany company, Location location, String name, FuelConsumption fuelComsumption, int ocupation)
    {
        //TODO resto de inicializaciones pendientes
        super(company, location, name, fuelComsumption);
        if (ocupation<1){
            ocupation = 1;
        }
        else{
            if (ocupation > 4){
                ocupation = 4;
            }
            else{
                this.occupation = ocupation;
            }
        }

    }
    
    @Override
    public int obtainComsumption(){
        int distancia = getLocation().distance(getInitialLocation());
        int consumo;
        consumo = super.fuelConsumption.getValor() * distancia;
        return consumo;
    }
    
    @Override
    public void act(){
        if(!hasTargetLocation()){
            incrementIdleCount();
        }
        else{
            setLocation(getLocation().nextLocation(getTargetLocation()));
            System.out.println("@@@ Taxi: " + getName() + " moving to " + getLocation());
            if(getLocation().equals(getTargetLocation())){
                if(this.passengers.size() == 0){
                    notifyPickupArrival();
                }
                else{
                    if(getLocation().equals(this.passengers.first().getDestination())){
                        notifyPassengerArrival(this.passengers.first());
                        offloadPassenger();
                        incrementPassengersTransported();
                    }
                    /*else{
                        if(this.passengers.size() < ocupation){
                            notifyPickupArrival();
                        }
                    }*/
                }

            }

        }
    }
}
