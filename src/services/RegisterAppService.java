package services;

import data.domain.User;

import java.time.LocalDate;

public class RegisterAppService {

    private static RegisterAppService instance;

    private RegisterAppService() {}

    public static RegisterAppService getInstance(){
        if(instance == null) instance = new RegisterAppService();
        return instance;
    }

    public boolean registerEmail(String email, String password, String name, LocalDate birthDate){
        System.out.println("Registering user in the database");

        User u = new User();
        u.setEmail(email);
        u.setPassword(org.apache.commons.codec.digest.DigestUtils.sha1Hex(password));
        u.setName(name);
        u.setBirthDate(birthDate);

        return u.getEmail().equals(email) && u.checkPassword(org.apache.commons.codec.digest.DigestUtils.sha1Hex(password));
    }

    public User externalRegister(String redirect) {
        System.out.println("Registering with "+redirect);
        User user = new User();
        user.setEmail("jon.leinena@opendeusto.es");
        user.setName("jon");
        user.setBirthDate(LocalDate.parse("13/12/2000"));
        String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
        user.setPassword(sha1);

        return user;
    }




}
