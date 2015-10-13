/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Annotations {

    
    public static void main(String[] args) {
        runModule();
    }
    public static void runModule(){
        try {
            Class<GameModule> moduleClass = (Class<GameModule>) Class.forName("annotations.GameModule");
            GameModule module = moduleClass.newInstance();
            Annotation[] anno = moduleClass.getAnnotations();
            if(!moduleClass.isAnnotationPresent(ModuleUnits.class))
            {
                throw new Exception("No module");
            }
            
            Class<Unit>[] units = (Class<Unit>[])moduleClass.getAnnotation(ModuleUnits.class).units();
            
            for(Class<Unit> unitClass:units){
               Method[] methods = unitClass.getMethods(); 
            
               Unit unit = unitClass.newInstance();
            
            
            for(Method method : methods){
                    if(method.isAnnotationPresent(InitMethod.class)){
                        method.invoke(unit);
                    }
                }
            }
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Annotations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Annotations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Annotations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Annotations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
}
