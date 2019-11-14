package com.ing.tech;

import com.ing.tech.configuration.DoSomething;
import com.ing.tech.logger.LoggerInterface;
import com.ing.tech.logger.LoggerInterfaceError;
import com.ing.tech.logger.LoggerInterfaceInfo;
import com.ing.tech.profile.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringMainApplication implements CommandLineRunner {

    @Autowired
    private DoSomething doSomething;

//    @Autowired
//    private ConfigProperties configProperties;
//
//    @Value("3")
//    private String numberOfThreads;

//    @Autowired
//    private List<Example> examples;

    List <LoggerInterface> logs;

    public SpringMainApplication(List <LoggerInterface> logs) {
        this.logs = logs;
    }

    @Override
    public void run(String... args) throws Exception {
//        log.info(String.valueOf(examples.size()));
           doSomething.log();
//        log.info(numberOfThreads);
//        log.info(configProperties.getApi());
//        log.info(configProperties.getKey());
          logs.forEach(x -> x.log("mesaj"));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMainApplication.class, args);
    }
}
