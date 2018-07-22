package com.example.demo.handlers;

import com.example.demo.drivers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HandlerResolver {
    private ApplicationContext applicationContext;
    private Resolver<PSP, Operation> pspOperationResolver;
    private EnumMap<PSP, Class<?>> pspEnumMap;

    @Autowired
    public HandlerResolver(ApplicationContext applicationContext, Resolver<PSP, Operation> pspOperationResolver) {
        this.applicationContext = applicationContext;
        this.pspOperationResolver = pspOperationResolver;
        pspEnumMap = new EnumMap<>(PSP.class);
        pspEnumMap.put(PSP.ADYEN, AdyenDriver.class);
        pspEnumMap.put(PSP.SAP, SAPDriver.class);
    }

    public <HT> HT resolve(Operation operation, Class<HT> klass) {
        Collection<HT> handlers = applicationContext.getBeansOfType(klass).values();
        Class<?> matchedClass = pspEnumMap.get(pspOperationResolver.resolve(operation));
        return handlers.stream()
                .filter(ht -> ht.getClass().equals(matchedClass))
                .findFirst()
                .orElse(null);
    }
}
