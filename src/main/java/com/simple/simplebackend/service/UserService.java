package com.simple.simplebackend.service;

import com.simple.simplebackend.dao.UserDAO;
import com.simple.simplebackend.dto.UserDTO;
import com.simple.simplebackend.enumtype.OperationTypeEnum;
import com.simple.simplebackend.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDAO userDAO;

    /**
     * Register user string.
     *
     * @param userDTO the user dto
     */
    public String registerUser(UserDTO userDTO) {
        User savedUser = handleSaveUser(OperationTypeEnum.CREATE, userDTO);
        return "User saved with id " + savedUser.getId();
    }

    /**
     * Update user string.
     *
     * @param userDTO the user dto
     */
    public String updateUser(UserDTO userDTO) {
        User savedUser = handleSaveUser(OperationTypeEnum.UPDATE, userDTO);
        return "User updated, id: " + savedUser.getId();
    }

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public Iterable<User> getAllUsers() {
        return userDAO.findAll();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public User getById(int id) {
        return userDAO.findById(id);
    }

    private User handleSaveUser(OperationTypeEnum operationType, UserDTO userDTO) {
        //business logic here
        return userDAO.saveUser(operationType, userDTO);
    }

}
