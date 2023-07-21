package com.etiya.darwinproject1.core.utilities.mappers.modelMapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {
    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse() {//id, name, x, y, z,response nesnemde olan alanları maple buna loose(gevşek) denir
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)//belirsizlik olduğu durumda onu ignore ediyim mi
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {//herşeyi maplemek için standard kullanılıyo
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}