package com.etiya.darwinproject1.core.utilities.mappers.mapstruct;

import com.etiya.darwinproject1.business.dtos.requests.user.CreateUserRequest;
import com.etiya.darwinproject1.business.dtos.response.user.CreateUserResponse;
import com.etiya.darwinproject1.entities.concretes.user.UserSpec;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    CreateUserRequest modelToRequest(UserSpec userSpec);
    UserSpec requestToModel(CreateUserRequest createUserRequest);
    @Mapping(source = "userSpec.id", target = "userId")
    CreateUserResponse modelToResponse(UserSpec userSpec);
    @InheritInverseConfiguration
    UserSpec responseToModel(CreateUserResponse createUserResponse);


}
