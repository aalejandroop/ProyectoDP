
/**
 * Write a description of class PassengerNoVip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PassengerNoVip extends Passenger
{
    public PassengerNoVip(Location pickup, Location destination, String name, String taxiName, int arrivalTime, int creditCard /*, Reliable reliable*/)
    {
        //TODO modificar el constructor o crear otro constructor si necesario
      /*  if(pickup == null) {
            throw new NullPointerException("Pickup location");
        }
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }
        */
        super(pickup,destination,name,taxiName, arrivalTime, creditCard);
    }
    
    public void pay(){
        this.creditCard = this.creditCard - 30;
    }
    
    public int calculateEvaluationValue(){
        return 2 * this.reliable.getValor();
    }
}

