import java.util.*;
/**
 * Write a description of class ComparadorTaxiPassengerArrivalTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorTaxiPassengerArrivalTime implements Comparator<Passenger>
{
    /**
     * Compares p1 and p2 in lexicographic order.
     * @return a value lesser than 0 if p1 comes before p2 in ascending order.
     * @return 0 if p1 and p2 are equal in terms of the sorting order.
     * @return a value higher than 0 if p1 comes after p2 in the sorting order.
     */
    public int compare(Passenger p1, Passenger p2){  
        if (p1.getArrivalTime() == p2.getArrivalTime()){
            return 0;
        }
        else{
            if(p1.getArrivalTime() > p2.getArrivalTime()){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}