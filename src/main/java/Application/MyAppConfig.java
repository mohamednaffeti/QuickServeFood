package Application;

import Quick.Serve.Food.Controllers.EntrepriseController;



import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/")
public class MyAppConfig extends Application {

    /**
     * We add all controllers here
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(EntrepriseController.class);
        return classes;
    }
}