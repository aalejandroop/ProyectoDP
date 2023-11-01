
import java.util.*; 

/**
 * Compare taxis by name in ascending order.
 * 
 * @author DP Clasess
 * @version 2023
 */
public class ComparadorNombreTaxi implements Comparator<Taxi>
{
    /**
     * Compares p1 and p2 in lexicographic order.
     * @return a value lesser than 0 if p1 comes before p2 in ascending order.
     * @return 0 if p1 and p2 are equal in terms of the sorting order.
     * @return a value higher than 0 if p1 comes after p2 in the sorting order.
     */
    public int compare(Taxi p1, Taxi p2){  
        return (p1.getName().compareTo(p2.getName()));
    } 
}

