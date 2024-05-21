package com.info.teknik.util;

import com.info.teknik.entity.CustomerMachine;
import com.info.teknik.entity.Part;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ServiceLifeCalculatorUtil {

    public static Long nextServiceLife(CustomerMachine customerMachine, Part part){
        return customerMachine.getCounter() + part.getServiceLife();
    }
}
