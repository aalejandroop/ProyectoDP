
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
    
    public String getFiabilidad(){
        return this.fiabilidad;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    /*public void setValor(int valor){
        this.valor = valor;
    }*/
    
    @Override
    public String toString(){
        return "<reliable: " + fiabilidad + " (value: " + valor + ")>";
    }
    
}
