/**
 * Write a description of class TaxiShuttle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TaxiShuttle extends Taxi
{
   
    /**
     * Constructor for objects of class TaxiShuttle
     */
    public TaxiShuttle(TransportCompany company, Location location, String name, FuelConsumption fuelComsumption, int ocupation)
    {
       
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
        consumo =fuelConsumption.getValor() * distancia;
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
                        valuation = valuation + this.passengers.first().calculateEvaluationValue();
                        offloadPassenger();
                        incrementPassengersTransported();
                    }
                    
                }

            }

        }
    }
    
    public String showFinalInfo()
    {
        return toString()+" - passengers transported: "+ passengersTransported() + " - non active for: "+ getIdleCount() + " times - valuation: "+ valuation + " - consumption: " + obtainComsumption();
    }
}