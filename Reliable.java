
/**
 * Enumeration class Reliable - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Reliable
{
    LOW ("Low", 5),
    HIGH ("High", 10);
    
    private final String fiabilidad;
    private final int valor;
    
    Reliable(String fiabilidad, int valor){
        this.fiabilidad = fiabilidad;
        this.valor = valor;
    }
    
    /**
     * Get the type fiability of the passenger.
     * @return a string that is the fiability of the passenger.
     */
    public String getFiabilidad(){
        return this.fiabilidad;
    }
    
    /**
     * Get the value of the fiability.
     * @return int that is the value of the fiability.
     */
    public int getValor(){
        return this.valor;
    }
    
    /**
     * @return a string with the final information.
     */
    @Override
    public String toString(){
        return "<reliable: " + fiabilidad + " (value: " + valor + ")>";
    }
    
}
