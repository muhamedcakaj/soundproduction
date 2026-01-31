package Sound.Production.Sound.Production.DTO;

import Sound.Production.Sound.Production.UserEntity;

public class LoginResponseDTO {
    private int id;
    private String username;
    private String role;

    public LoginResponseDTO(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
