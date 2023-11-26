
/**
 * Write a description of class TaxiExclusive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TaxiExclusive extends Taxi
{
    private int weight;
    private int popularidad;
    /**
     * Constructor for objects of class TaxiExclusive
     */
    public TaxiExclusive(TransportCompany company, Location location, String name, int ocupation, int weight)
    {
        //TODO resto de inicializaciones pendientes
        super(company, location, name, ocupation);
        this.weight = weight;
    }
    
    @Override
    public int obtainComsumption(){
        int distancia = getLocation().distance(getInitialLocation());
        int consumo;
        consumo = this.weight * super.fuelComsumption.getValor() * distancia;
        return consumo;
    }
    
    @Override
    public void act(){
        if(!hasTargetLocation()){
            incrementIdleCount();
        }
        else{
            setLocation(super.getLocation().nextLocation(getTargetLocation()));
            System.out.println("@@@ Taxi: " + getName() + " moving to: " + getLocation().getX() + " - " + getLocation().getY());
            if(super.getLocation().equals(getTargetLocation())){
                if(this.passengers.size() == 0){
                    notifyPickupArrival();
                }
                else{
                    if(super.getLocation().equals(this.passengers.first().getDestination())){
                        serPopularEnRedes();//aumenta/disminuye popularidad (Taxi Exclusive)
                        notifyPassengerArrival(this.passengers.first());
                        offloadPassenger();
                        incrementPassengersTransported();
                    }
                    else{
                        if(this.passengers.size() < ocupation){
                            notifyPickupArrival();
                        }
                    }
                }

            }

        }
    }
    public void serPopularEnRedes(){
        if(super.getPasajero().getCreditCard()>2000){
            this.popularidad=this.popularidad +4;
        }
        else{
            this.popularidad=this.popularidad-1;
        }
    }
}
