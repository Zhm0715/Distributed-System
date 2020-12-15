package zhm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManagerServer8002Main {

    public static void main(String[] args) {
        SpringApplication.run(ManagerServer8002Main.class, args);
    }

}
