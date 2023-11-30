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
    
    public String getGasto(){
        return this.gasto;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    /*public void setValor(int valor){
        this.valor = valor;
    }*/
    
    @Override
    public String toString(){
        return " <fuel consumption: " + gasto + " (value: " + valor + ")>";
    }
    
}