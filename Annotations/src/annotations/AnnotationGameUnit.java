
package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationGameUnit {
    
}
@Retention(RetentionPolicy.RUNTIME)
@interface Weigth{
    int value();
}
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface InitMethod{
    
}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ModuleUnits{
    Class<? extends Unit>[] units();
}
