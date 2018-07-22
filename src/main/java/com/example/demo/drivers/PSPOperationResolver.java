package com.example.demo.drivers;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PSPOperationResolver implements Resolver<PSP, Operation> {
    private Map<String, PSP> stringPSPMap;

    public PSPOperationResolver() {
        stringPSPMap = new HashMap<>();
        stringPSPMap.put("adyen", PSP.ADYEN);
        stringPSPMap.put("sap", PSP.SAP);
    }

    @Override
    public PSP resolve(Operation payload) {
        return stringPSPMap.get(payload.getRoute().getPsp());
    }
}
