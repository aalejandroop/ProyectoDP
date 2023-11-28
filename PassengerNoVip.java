
/**
 * Write a description of class PassengerNoVip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PassengerNoVip extends Passenger
{
    public PassengerNoVip(Location pickup, Location destination, String name, String taxiName, int arrivalTime, int creditCard, Reliable reliable)
    {
        super(pickup,destination,name,taxiName, arrivalTime, creditCard, reliable);
    }
    public void pay(){
        this.creditCard = this.creditCard - 30;
    }
    
    @Override
    public int calculateEvaluationValue(){
        return super.calculateEvaluationValue();
    }
}

