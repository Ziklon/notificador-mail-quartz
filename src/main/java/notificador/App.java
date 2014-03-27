package notificador;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("spring-quartz.xml");
    }

}
