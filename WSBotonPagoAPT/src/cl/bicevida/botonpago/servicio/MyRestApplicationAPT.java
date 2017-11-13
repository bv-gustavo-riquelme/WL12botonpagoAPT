package cl.bicevida.botonpago.servicio;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class MyRestApplicationAPT extends Application {
    public MyRestApplicationAPT() {
        super();
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(ServicioAPT.class);
        return classes;
    }
}
