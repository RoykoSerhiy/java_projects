
package annotations;

@AnnotationGameUnit
@Weigth(1)
public class Rabbit extends Unit {
    @InitMethod
    public void initRabbit(){
        System.out.println("Init this white rabbit");
    }
}
