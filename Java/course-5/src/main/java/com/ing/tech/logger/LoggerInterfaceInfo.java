package com.ing.tech.logger;

import com.ing.tech.configuration.DoSomething;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoggerInterfaceInfo implements LoggerInterface {


    private DoSomething doSomething;

    public LoggerInterfaceInfo(DoSomething doSomething) {
        this.doSomething = doSomething;
    }

    public void log(String message) {
      log.info(message);
      doSomething.log();
    }
}
