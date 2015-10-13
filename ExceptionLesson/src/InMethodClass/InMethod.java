
package InMethodClass;


public class InMethod {
    public static void test(){
        String name = "Vasya";
        
        class UserInfo{
            String info(){
                return "user:" + name;
            }
        }
        
        UserInfo ui = new UserInfo();
        System.out.println(ui.info());
    }
}
