/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8lessson;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *
 * @author Serhiy
 */
public class testClass {
    
    List<String> strings = Arrays.asList("a" , "aaa" , "jjjjr" , "fffff" ,"drrrr");
    
    public void listTest(){
      String str = strings.stream().filter(s -> (s.length() > 3 && s.length() < 8))
                .map(s -> ("[" + s + "]"))
                .reduce("strings:" , (previous , s) -> previous + " " + s);
        System.out.println(str);
    }
    public Double testMethod1(Function<Number , Double> fun, Number x){
        return fun.apply(x);
    }
    public void mathFunc(){
        System.out.println(testMethod1(this::square , 10));
        System.out.println(testMethod1(this::sum , 10));
    }
    public Double square(Number x){
        return x.doubleValue() * x.doubleValue();
    }
    public Double sum(Number x){
        return x.doubleValue() + x.doubleValue();
    }
    public void testEvalConstructor(){
		runConstructor(MyClass::new, "Class" , 1);
	}
    public <A,B,C> void runConstructor(BiFunction<A,B,C> fun , A a , B b){
        
        C obj = fun.apply(a, b);
        System.out.println(obj.toString());
    }
    public void testLambda(){
        System.out.println(operation(x -> x * x , 10));
        System.out.println(operation(x -> x * x * x , 12));
        System.out.println(operation(x -> x / x + 20 , 25));
    }
    public void testBiOperation(){
        System.out.println(BiOperation((x , y) -> {return x.doubleValue() / y.doubleValue();}, 20, 3));
    }
    
    public int operation(Function<Integer , Integer> fun, int x){
       return fun.apply(x);
    }
    public Double BiOperation(BiFunction<Integer , Integer , Double> fun , int x , int y){
        return fun.apply(x, y);
    }
}
class MyClass{
    String s;
    int i;
    public MyClass(String  s, int i){
        this.s = s;
        this.i = i;
    }
    public String getVal(){
        return s + " my " + i +" class";
    }
    @Override
    public String toString(){
        return s + " my " + i +" class";
    }
    
}