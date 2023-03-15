package cl.danonunez.springbootbciassessment.service;

import cl.danonunez.springbootbciassessment.dto.CreateUserDTO;
import cl.danonunez.springbootbciassessment.dto.CreatedUserDTO;
import cl.danonunez.springbootbciassessment.dto.UpdateUserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    CreatedUserDTO createUser(CreateUserDTO user) throws Exception;

    CreatedUserDTO getUserById(UUID userId) throws Exception;

    List<CreatedUserDTO> getAllUsers() throws Exception;

    CreatedUserDTO updateUser(UpdateUserDTO user) throws Exception;

    void deleteUser(UUID userId) throws Exception;
}
