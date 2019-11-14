package com.ing.tech.logger;

import com.ing.tech.configuration.DoSomething;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoggerInterfaceError implements LoggerInterface {

    private DoSomething doSomething;

    public LoggerInterfaceError(DoSomething doSomething) {
        this.doSomething = doSomething;
    }

    @Override
    public void log(String message) {
        log.error(message);
        doSomething.log();
    }
}
