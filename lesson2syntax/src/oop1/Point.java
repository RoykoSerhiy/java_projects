
package oop1;


public class Point {
  private double x;
  private double y;
  
  public Point(double x , double y){
      this.x = x;
      this.y = y;
  }
   public static Point create(double x , double y){ 
        return new Point(x , y);
    }
  public void add(Point p){
      x += p.x;
      y += p.y;
  }
  
  @Override
  public String toString(){
      return x + " " + y;
  }
}
