package data.dto;

import data.domain.User;

public class UserAssembler {

    private static UserAssembler instance;

    private UserAssembler(){

    }

    private UserAssembler getInstance(){
        if (instance == null) {
            instance = new UserAssembler();
        }

        return instance;
    }

    public UserDTO userToDTO(User u){

        UserDTO dto = new UserDTO();

        dto.setEmail(u.getEmail());
        dto.setName(u.getName());
        dto.setBirthDate(u.getBirthDate());
        dto.setHeight(u.getHeight());
        dto.setWeight(u.getWeight());
        dto.setMaxPPM(u.getMaxPPM());
        dto.setRestPPM(u.getRestPPM());

        return dto;
    }

}
