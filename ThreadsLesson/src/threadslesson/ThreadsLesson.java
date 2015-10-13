
package threadslesson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadsLesson {

   static File file = new File("E:\\\\iotest.txt");
    public static void main(String[] args) {
       
      input();   
    }
    public static void input(){
        FileWriter writer = null;
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in));){
            boolean exit = false;
            writer = new FileWriter(file);
            while(!exit)
            {
                String str = input.readLine();
                if(str.equals("exit"))
                {
                    break;
                }
                if(str.equals("show")){
                    writer.flush();
                    showContent();
                    continue;
                }
                long time = System.currentTimeMillis();
                String finalLine = String.format("%TD : %s\n", time , str);
                //System.out.println(finalLine);
                
                writer.append(finalLine);
                
            }
            writer.flush();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            try
            {
                if(writer != null)
                {
                    writer.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ThreadsLesson.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void showContent() throws FileNotFoundException, IOException{
        FileReader reader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(reader);
        String line;
        int num = 0;
        while((line = bufReader.readLine()) != null ){
            System.out.println(num + " " + line); 
            num++;
        }
    }
}
