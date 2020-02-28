package com.dev.republica.service;

import java.util.List;
import java.util.Optional;

import com.dev.republica.dto.UserDto;
import com.dev.republica.error.UserAlreadyExistException;
import com.dev.republica.model.PasswordResetToken;
import com.dev.republica.model.Usuario;
import com.dev.republica.model.VerificationToken;

public interface IUserService {
	
	Usuario registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;

	Usuario getUser(String verificationToken);

    void saveRegisteredUser(Usuario user);

    void deleteUser(Usuario user);

    void createVerificationTokenForUser(Usuario user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(Usuario user, String token);

    Usuario findUserByUsername(String username);

    PasswordResetToken getPasswordResetToken(String token);

    Usuario getUserByPasswordResetToken(String token);

    Optional<Usuario> getUserByID(long id);

    void changeUserPassword(Usuario user, String password);

    boolean checkIfValidOldPassword(Usuario user, String password);

    String validateVerificationToken(String token);

    List<String> getUsersFromSessionRegistry();
	
}
