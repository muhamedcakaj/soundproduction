package Sound.Production.Sound.Production;

import Sound.Production.Sound.Production.DTO.LoginRequestDTO;
import Sound.Production.Sound.Production.DTO.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public LoginResponseDTO login(LoginRequestDTO request) {

        UserEntity user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.UNAUTHORIZED,
                                "Invalid username or password"
                        ));

        if (!request.getPassword().equals(user.getPassword())) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid username or password"
            );
        }
        return new LoginResponseDTO(user);
    }
}