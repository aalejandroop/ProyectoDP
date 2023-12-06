/**
 * Write a description of class TaxiExclusive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TaxiExclusive extends Taxi
{
    private int weight;
    private int popularidad=6;
    /**
     * Constructor for objects of class TaxiExclusive
     */
    public TaxiExclusive(TransportCompany company, Location location, String name, FuelConsumption fuelConsumption, int weight)
    {
        
        super(company, location, name, fuelConsumption);
        this.weight = weight;
    }

    @Override
    public int obtainComsumption(){
        int distancia = getLocation().distance(getInitialLocation());
        int consumo;
        consumo = (this.weight/2) * fuelConsumption.getValor() * distancia;
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
                    
                    serPopularEnRedes();//aumenta/disminuye popularidad (Taxi Exclusive)
                    notifyPassengerArrival(this.passengers.first());
                    valuation = valuation + this.passengers.first().calculateEvaluationValue();
                    offloadPassenger();
                    incrementPassengersTransported();
                }
            }

        }

    }

   /**
     * Increment or decrement the taxi's popularity depending of the money that the passenger have in his credit card.
     */ 
    private void serPopularEnRedes(){
        if(this.getPasajero().getCreditCard()>20000){
            this.popularidad=this.popularidad +4;
        }
        else{
            this.popularidad=this.popularidad-1;
        }
    }
     public String showFinalInfo()
    {
        return toString()+" - passengers transported: "+ passengersTransported() + " - non active for: "+ getIdleCount() + " times - valuation: "+ valuation + " - consumption: " + obtainComsumption()+ " - popularity: " + popularidad;
    }
}