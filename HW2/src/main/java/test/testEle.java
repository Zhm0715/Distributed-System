package test;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Configurable
public class testEle {
    @Bean
    public testEle getNew(){
        return new testEle();
    }
}
