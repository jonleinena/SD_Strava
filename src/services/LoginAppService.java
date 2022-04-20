package services;

import data.domain.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class LoginAppService {

    private static LoginAppService instance;

    private LoginAppService(){}

    public static LoginAppService getInstance() {
        if(instance == null){
            instance =  new LoginAppService();
        }
        return instance;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public User emailLogin(String email, String password){
        User user = new User();
        user.setEmail(email);
        //Generate the hash of the password
        String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(password);
        user.setPassword(sha1);

        if (user.getEmail().equals(email) && user.checkPassword(org.apache.commons.codec.digest.DigestUtils.sha1Hex(password))) {
            return user;
        } else {
            return null;
        }
    }

    public User externalLogin(String redirect){
        System.out.println("logging in with "+redirect);
        User user = new User();
        user.setName("Gorka");
        user.setEmail("estebanareizaga@opendeusto.es");
        String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
        user.setPassword(sha1);
        user.setBirthDate(LocalDate.parse("04-04-2000", formatter));
        return user;
    }

}
