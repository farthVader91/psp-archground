package com.example.demo;

import com.example.demo.drivers.Operation;
import com.example.demo.drivers.Route;
import com.example.demo.handlers.ChargeHandler;
import com.example.demo.handlers.HandlerResolver;
import com.example.demo.handlers.TransferHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

	    SpringApplication.run(DemoApplication.class, args);
	}

	private HandlerResolver handlerResolver;

	@Autowired
    public DemoApplication(HandlerResolver chargeHandlerHandlerResolver) {
        this.handlerResolver = chargeHandlerHandlerResolver;
    }

    @Bean
    public CommandLineRunner runner() {
	    return args -> {
            Route r = new Route("sap", "a", "b");
            Operation op = new Operation(r);
            System.out.println(handlerResolver.resolve(op, TransferHandler.class));

        };
    }
}
