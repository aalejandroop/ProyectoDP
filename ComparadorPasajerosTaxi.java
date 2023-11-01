import java.util.*; 

/**
 * Write a description of class ComparadorPasajerosTaxi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorPasajerosTaxi implements Comparator<Taxi>
{
    /**
     * Compares the total of transported passengers for taxis, if equal compares by name in ascending order
     * @return a value lesser than 0 if t2's total transported passengers is higher than t1's or if it comes first in the sorting order.
     * @return 0 if t1 and t2 are equal in terms of the sorting order.
     * @return a value higher than 0 if t1's total transported passengers is higher than t2's or if it comes first in the sorting order.
     */
    public int compare(Taxi t1, Taxi t2){  
    
        if (t1.passengersTransported() == t2.passengersTransported()){
            return (t1.getName().compareTo(t2.getName()));
        }
        else{
            if(t1.passengersTransported() > t2.passengersTransported()){
                return 1;
            }
            else{
                return -1;
            }
        } 
    }
}