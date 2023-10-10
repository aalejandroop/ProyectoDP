/**
 * Model a location in a city.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class Location
{
    private int x;  //TODO cambiar a private
    private int y;  //TODO cambiar a private

    /**
     * Model a location in the city.
     * @param x The x coordinate. Must be positive.
     * @param y The y coordinate. Must be positive.
     * @throws IllegalArgumentException If a coordinate is negative.
     */
    public Location(int x, int y)
    {
        if(x < 0) {
            throw new IllegalArgumentException(
                "Negative x-coordinate: " + x);
        }
        if(y < 0) {
            throw new IllegalArgumentException(
                "Negative y-coordinate: " + y);
        }        
        this.x = x;
        this.y = y;
    }

    /**
     * @return The x coordinate.
     */
    public int getX()
    {
        return x;
    }

    /**
     * @return The y coordinate.
     */
    public int getY()
    {    
        return y;
    }
    
    public void setLocation(int fila, int columna){
        x = fila;
        y = columna;
    }

    /**
     * Generate the next location to visit in order to
     * reach the destination.
     * @param destination Where we want to get to.
     * @return A location in a direct line from this to
     *         destination.
     */
    public Location nextLocation(Location destination)
    {
        //TODO ahora mismo este método devuelve directamente el destino final
        //PERO DEBERIA ir calculando y devolviendo la siguiente posición por la que 
        // va pasando el taxi hasta llegar al destino
        Location siguiente;
        int filaActual, columnaActual;
        filaActual = this.getX();
        columnaActual = this.getY();
        siguiente = new Location(filaActual, columnaActual);
        
        if(filaActual != destination.getX() && columnaActual != destination.getY()){
            if(filaActual < destination.getX()){
                filaActual++;
            }
            else{
                filaActual--;
            }
            if(columnaActual < destination.getY()){
                columnaActual++;
            }
            else{
                columnaActual--;
            }
        }
        else{
            if(filaActual != destination.getX() && columnaActual == destination.getY()){
                if(filaActual < destination.getX()){
                    filaActual++;
                }
                else{
                    filaActual--;
                }
            }
            else{
                if(filaActual == destination.getX() && columnaActual != destination.getY()){
                    if(columnaActual < destination.getY()){
                        columnaActual++;
                    }
                    else{
                        columnaActual--;
                    }
                }
            }
        }
        siguiente.setLocation(filaActual, columnaActual);
        return siguiente;
    }

    /**
     * Determine the number of movements required to get
     * from here to the destination.
     * @param destination The required destination.
     * @return the number of movement steps.
     */
    public int distance(Location destination)
    {   
        Location l;
        //TODO implementar este método que devuelve el número total de pasos para alcanzar el destino
        int i = destination.getX() - this.getX();
        if (i < 0){
            i = i * -1;
        }
        int j = destination.getY() - this.getY();
        if (j < 0){
            j = j * -1;
        }
        if (i > j){
            return i;
        }
        else{
            return j;   
        }
    }

    /**
     * Implement content equality for locations.
     * @return true if this location matches the other, false otherwise.
     */
    public boolean equals(Object other)
    {
        if(other instanceof Location) {
            Location otherLocation = (Location) other;
            return x == otherLocation.getX() &&
            y == otherLocation.getY();
        }
        else {
            return false;
        }
    }

    /**
     * @return A representation of the location.
     */
    public String toString()
    {
        return "location " + x + "," + y;
    }

    /**
     * Use the top 16 bits for the y value and the bottom for the x.
     * Except for very big grids, this should give a unique hash code
     * for each (x, y) pair.
     * @return A hashcode for the location.
     */
    public int hashCode()
    {
        return (y << 16) + x;
    }
}
