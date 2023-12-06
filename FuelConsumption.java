/**
 * Enumeration class fuelConsumption - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum FuelConsumption
{
    HIGH ("High", 8),
    MEDIUM( "Medium", 6),
    LOW ("Low", 4);
    
    
    private final String gasto;
    private final int valor;
    
    FuelConsumption(String gasto, int valor){
        this.gasto = gasto;
        this.valor = valor;
    }
    
    /**
     * Get the spend type of the taxi
     * @return string that refers the spend of the taxi.
     */
    public String getGasto(){
        return this.gasto;
    }
    
    /**
     * Get the value of the spend type of the taxi.
     * @return int that refers the spend type.
     */
    public int getValor(){
        return this.valor;
    }
    
    /**
     * Show the final info of FuelConsumption
     */
    @Override
    public String toString(){
        return " <fuel consumption: " + gasto + " (value: " + valor + ")>";
    }
    
}