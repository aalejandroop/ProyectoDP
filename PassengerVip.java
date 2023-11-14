
/**
 * Write a description of class PassengerVip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PassengerVip extends Passenger
{
    public PassengerVip(Location pickup, Location destination, String name, String taxiName, int arrivalTime, int creditCard /*, Reliable reliable*/)
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
        this.creditCard = this.creditCard - 610;
    }
    
    public int calculateEvaluationValue(){
        return 0; //this.reliable = 2 * this.reliable + 15;
    }
}
