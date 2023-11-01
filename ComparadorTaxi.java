import java.util.*; 
/**
 * Write a description of class ComparadorTaxi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorTaxi implements Comparator<Taxi>
{
    /**
     * Compares the disance to both taxis target location, if equal compares by name in ascending order
     * @return a value lesser than 0 if t1's distance is lower to the target than t2's or if it comes first in the sorting order.
     * @return 0 if t1 and t2 are equal in terms of the sorting order.
     * @return a value lesser than 0 if t2's distance is lower to the target than t1's or if it comes first in the sorting order.
     */
    public int compare(Taxi t1, Taxi t2){  

        if (t1.distanceToTheTargetLocation() ==t2.distanceToTheTargetLocation()){
            return (t1.getName().compareTo(t2.getName()));
        }
        else{
            if(t1.distanceToTheTargetLocation() > t2.distanceToTheTargetLocation()){
                return 1;
            }
            else{
                return -1;
            }
        } 
    }
}