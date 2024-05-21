package com.info.teknik.converter;

import com.info.teknik.entity.CustomerMachine;
import com.info.teknik.entity.CustomerMachinePart;
import com.info.teknik.entity.Part;
import com.info.teknik.util.ServiceLifeCalculatorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerMachinePartConverter {

    public List<CustomerMachinePart> createConverter(CustomerMachine customerMachine, List<Part> parts){
        List<CustomerMachinePart> customerMachineParts = new ArrayList<>();

        parts.forEach(part -> {
            Long nextServiceLife = ServiceLifeCalculatorUtil.nextServiceLife(customerMachine, part);

            CustomerMachinePart customerMachinePart = new CustomerMachinePart();
            customerMachinePart.setCustomerMachine(customerMachine);
            customerMachinePart.setPart(part);
            customerMachinePart.setNextServiceLife(nextServiceLife);

            customerMachineParts.add(customerMachinePart);
        });

        return customerMachineParts;
    }
}
