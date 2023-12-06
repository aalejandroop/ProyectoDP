import java.util.*;

public class ComparadorPasHoraLlegada implements Comparator<Passenger>
{
    /**
     * Compares p1 and p2 by the arrival time order, if this is equal, its compare by the name of the passenger in alphabetic order.
     * @return a value lesser than 0 if p1's arrival time is lower  than p2's or if it comes first in the sorting order.
     * @return 0 if p1's and p2's are equal in terms of the sorting order.
     * @return a value lesser than 0 if p2's arrival time is lower than p1's or if it comes first in the sorting order.
     */
    public int compare(Passenger p1, Passenger p2){  
        if (p1.getArrivalTime() == p2.getArrivalTime()){
            return (p1.getName().compareTo(p2.getName()));
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