/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging;

import java.util.logging.Logger;

/**
 *
 * @author Serhiy
 */
public class TestLogger {
    private static final Logger logger = Logger.getLogger(TestLogger.class.getName());
    
    TestLogger(){
        logger.info(TestLogger.class.getName());
    }
    public void procces(int x){
        //logger.info("process()");
        try{
            if(x % 10 == 0){
                throw new Exception();
            }
        }
        catch(Exception e){
            logger.warning("warning "+x+" % 10 != 0");
        }
    }
}
