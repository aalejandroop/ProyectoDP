
/**
 * Write a description of class PassengerVip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PassengerVip extends Passenger
{
    public PassengerVip(Location pickup, Location destination, String name, String taxiName, int arrivalTime, int creditCard, Reliable reliable)
    {
        super(pickup,destination,name,taxiName, arrivalTime, creditCard, reliable);
    }
    
    public void pay(){
        this.creditCard = this.creditCard - 610;
    }
    
    @Override
    public int calculateEvaluationValue(){
        return super.calculateEvaluationValue() + 15;
    }
}
