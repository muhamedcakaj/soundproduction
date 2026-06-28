package Sound.Production.Sound.Production;

import Sound.Production.Sound.Production.DTO.LoginRequestDTO;
import Sound.Production.Sound.Production.DTO.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository userRepository,JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }
    public Map<String, Object> login(LoginRequestDTO request) {

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
        String token = jwtUtil.generateToken(user);

        return Map.of("token", token);
    }
}