package com.info.teknik.converter;

import com.info.teknik.dto.MachineBrandDto;
import com.info.teknik.entity.MachineBrand;
import org.springframework.stereotype.Component;

@Component
public class MachineBrandConverter {
    public MachineBrand machineBrandConvertToMachineBrandDto(MachineBrandDto machineBrandDto){
            MachineBrand machineBrand = new MachineBrand();
            machineBrand.setName(machineBrandDto.getName());
            return machineBrand;
    }
    public MachineBrandDto machineBrandDtoConvertToMachineBrand(MachineBrand machineBrand) {
        MachineBrandDto machineBrandDto = new MachineBrandDto();
        machineBrandDto.setName(machineBrand.getName());
        return machineBrandDto;
    }
}
