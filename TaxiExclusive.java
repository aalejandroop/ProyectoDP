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
    public TaxiExclusive(TransportCompany company, Location location, String name, FuelConsumption fuelConsumption, int weight)
    {
        //TODO resto de inicializaciones pendientes
        super(company, location, name, fuelConsumption);
        this.weight = weight;
    }

    @Override
    public int obtainComsumption(){
        int distancia = getLocation().distance(getInitialLocation());
        int consumo;
        consumo = this.weight * super.fuelConsumption.getValor() * distancia;
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
                    serPopularEnRedes();//aumenta/disminuye popularidad (Taxi Exclusive)
                    notifyPassengerArrival(this.passengers.first());
                    offloadPassenger();
                    incrementPassengersTransported();
                }
            }

        }

    }

    private void serPopularEnRedes(){
        if(super.getPasajero().getCreditCard()>20000){
            this.popularidad=this.popularidad +4;
        }
        else{
            this.popularidad=this.popularidad-1;
        }
    }
}