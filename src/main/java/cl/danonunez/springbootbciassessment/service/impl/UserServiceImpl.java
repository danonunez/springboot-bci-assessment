package cl.danonunez.springbootbciassessment.service.impl;

import cl.danonunez.springbootbciassessment.dto.CreateUserDTO;
import cl.danonunez.springbootbciassessment.dto.CreatedUserDTO;
import cl.danonunez.springbootbciassessment.dto.UpdateUserDTO;
import cl.danonunez.springbootbciassessment.entity.Phone;
import cl.danonunez.springbootbciassessment.entity.User;
import cl.danonunez.springbootbciassessment.exception.EmailAlreadyExistException;
import cl.danonunez.springbootbciassessment.exception.UserNotFoundException;
import cl.danonunez.springbootbciassessment.repository.UserRepository;
import cl.danonunez.springbootbciassessment.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public CreatedUserDTO createUser(CreateUserDTO userDto) {
        if(userRepository.existsByEmail(userDto.getEmail())) {
            throw new EmailAlreadyExistException("El correo ya fue registrado");
        }
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, CreatedUserDTO.class);
    }

    @Override
    public CreatedUserDTO getUserById(UUID userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Usuario no encontrado");
        }
        User existingUser = optionalUser.get();
        return modelMapper.map(existingUser, CreatedUserDTO.class);
    }

    @Override
    public List<CreatedUserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> modelMapper.map(user, CreatedUserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CreatedUserDTO updateUser(UpdateUserDTO updateUserDTO) {
        Optional<User> optionalUser = userRepository.findById(updateUserDTO.getId());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Usuario no encontrado");
        }

        User existingUser = optionalUser.get();
        existingUser.setName(updateUserDTO.getName());
        existingUser.setEmail(updateUserDTO.getEmail());
        existingUser.setPassword(updateUserDTO.getPassword());
        Set<Phone> phones = updateUserDTO.getPhones().stream().map(
                (phoneDTO) -> modelMapper.map(phoneDTO, Phone.class))
                .collect(Collectors.toSet());
        phones.forEach((phone) -> {
            phone.setUserId(existingUser.getId());
        });
        existingUser.getPhones().clear();
        existingUser.getPhones().addAll(phones);

        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, CreatedUserDTO.class);
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }
}
