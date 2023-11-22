
/**
 * Write a description of class TaxiExclusive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TaxiExclusive extends Taxi
{
    private int weight;
    /**
     * Constructor for objects of class TaxiExclusive
     */
    public TaxiExclusive(TransportCompany company, Location location, String name, int weight)
    {
        //TODO resto de inicializaciones pendientes
        super(company, location, name);
        this.weight = weight;
    }
    
    @Override
    public int obtainComsumption(){
        int distancia = super.getLocation().;
        
    }
}
