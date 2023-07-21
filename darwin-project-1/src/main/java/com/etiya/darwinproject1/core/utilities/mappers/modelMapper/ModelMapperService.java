package com.etiya.darwinproject1.core.utilities.mappers.modelMapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forResponse();

    ModelMapper forRequest();
}
