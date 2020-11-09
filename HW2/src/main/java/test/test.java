package test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test {
    @Autowired
    private testEle testele;

    @Test
    public void run(){
        System.out.println(this.testele);
    }

}
