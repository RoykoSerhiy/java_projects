
package springioc;

import Units.Knight;
import Units.Unit;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class SpringIoC {

    
    public static void main(String[] args) {
        iocStart();
    }
    public static void iocStart(){
        String[] ids = {"mainUnit" , "supportUnit" , "magUnit"};
        AbstractApplicationContext aac;
        
        Path conf = Paths.get("simple.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext(conf.toAbsolutePath().toString());
        for(String id : ids){
            Unit u = (Unit)context.getBean(id);
            u.doMission();
        }
      }
}
   
    

