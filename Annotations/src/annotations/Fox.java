
package annotations;
@AnnotationGameUnit
@Weigth(1)
public class Fox extends Unit {


    @InitMethod
    public void initFox(){
        System.out.println("Fox init...");
    
    }

}
