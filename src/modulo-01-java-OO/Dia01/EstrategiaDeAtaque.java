import java.util.*;

/**
 * Write a description of interface EstrategiaDeAtaque here.
 * 
 * @author Rodrigo Molina
 * @version 16/04/2015
 */
public interface EstrategiaDeAtaque
{
    void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs);   
    ArrayList<Elfo> getOrdemDoUltimoAtaque();
}