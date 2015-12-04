
package Repositorios;

import java.util.ArrayList;
import java.util.List;
import Model.Time;

/**
 *
 * @author 631420343
 */
public class RepositorioTime {
    private List<Time> times;
    
    private RepositorioTime() {
        times = new ArrayList<Time>();
    }
    
    public boolean addTimes(Time time){
        return (times.add(time));
    }
    
    public List<Time> getListaJogadores() {
        return times;
    }
    
    public boolean timeExiste(String nome) {
        for (Time time : times) {
            if (time.getNome().equalsIgnoreCase(nome)) {
            } else {
                return true;
            }
        }
        return false;
    }
    
    public Time buscarTime(String nome) {
        for (Time time : times) {
            if (time.getNome().equalsIgnoreCase(nome)) {
                return time;
            }
        }
        return null;
    }
    
    public void deletarJogador(String nome) {
        
    };    
}
