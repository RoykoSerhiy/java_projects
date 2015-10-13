
package extendedoop;


public class ExtendedOOP {

    
    public static void main(String[] args) {
        TestClass tc = new TestClass();
        tc.method(new User(){public String getName(){return "name";}});
        testEnum();
    }
    public static void testEnum(){
        
        System.out.println(Month.January+" "+Month.April+" "+Month.February);
    }
}
enum Month{
    
    January("01"),
    February("02"),
    March("03"),
    April("04");
    
    private String value;
    Month(String val){
        value = val;
    }
    @Override
    public String toString(){
        return value;
    }
}
