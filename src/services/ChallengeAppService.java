package services;

import data.domain.Challenge;
import data.domain.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChallengeAppService {

    private static ChallengeAppService instance;
    private HashMap<String, Challenge> challengesMap = new HashMap<>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private ChallengeAppService(){this.initializeData();}

    public static ChallengeAppService getInstance(){

        if(instance == null){

            instance = new ChallengeAppService();

        }

        return instance;

    }

    public HashMap<String, Challenge> getChallengesMap() {
        return this.challengesMap;
    }
    
    private void initializeData(){
        User user0 = new User();
        user0.setEmail("jon@mail.com");
        user0.setPassword(org.apache.commons.codec.digest.DigestUtils.sha1Hex("jonle"));
        user0.setBirthDate(LocalDate.parse("13-12-2000", formatter));
        user0.setName("Jon");
        User user1 = new User();
        user1.setEmail("goka@mail.com");
        user1.setPassword(org.apache.commons.codec.digest.DigestUtils.sha1Hex("gorkita"));
        user1.setBirthDate(LocalDate.parse("04-04-2000", formatter));
        user1.setName("Gorka");
        User user2 = new User();
        user2.setEmail("anton@mail.com");
        user2.setPassword(org.apache.commons.codec.digest.DigestUtils.sha1Hex("anton"));
        user2.setBirthDate(LocalDate.parse("01-01-1998", formatter));
        user2.setName("Anton");

        Challenge challenge0 = new Challenge();
        challenge0.setTitle("Reto0");
        challenge0.setStartDate(LocalDate.now());
        challenge0.setEndDate(LocalDate.parse("27-04-2022", formatter));
        challenge0.setSport(new String[]{"Runnning"});
        challenge0.setDistanceGoal(12.0f);
        challenge0.setTimeGoal(0.0f);
        challengesMap.put(challenge0.getTitle(), challenge0);


        Challenge challenge1 = new Challenge();
        challenge1.setTitle("Reto1");
        challenge1.setStartDate(LocalDate.parse("17-04-2022", formatter));
        challenge1.setEndDate(LocalDate.parse("29-04-2022", formatter));
        challenge1.setSport(new String[]{"Runnning", "Cycling"});
        challenge1.setDistanceGoal(122.0f);
        challenge1.setTimeGoal(240.00f);
       challengesMap.put(challenge1.getTitle(), challenge1);

        Challenge challenge2 = new Challenge();
        challenge2.setTitle("Reto2");
        challenge2.setStartDate(LocalDate.now());
        challenge2.setEndDate(LocalDate.parse("02-05-2022", formatter));
        challenge2.setSport(new String[]{"Cycling"});
        challenge2.setDistanceGoal(60f);
        challenge2.setTimeGoal(120.0f);
        challengesMap.put(challenge2.getTitle(), challenge2);


        Challenge challenge3 = new Challenge();
        challenge3.setTitle("Reto3");
        challenge3.setStartDate(LocalDate.parse("03-02-2022", formatter));
        challenge3.setEndDate(LocalDate.parse("03-04-2022", formatter));
        challenge3.setSport(new String[]{"Runnning"});
        challenge3.setDistanceGoal(12.0f);
        challenge3.setTimeGoal(45.0f);
        challengesMap.put(challenge3.getTitle(), challenge3);


        Challenge challenge4 = new Challenge();
        challenge4.setTitle("Reto4");
        challenge4.setStartDate(LocalDate.parse("03-02-2022", formatter));
        challenge4.setEndDate(LocalDate.parse("07-04-2022", formatter));
        challenge4.setSport(new String[]{"Cycling"});
        challenge4.setDistanceGoal(12.0f);
        challenge4.setTimeGoal(0.0f);
        challengesMap.put(challenge4.getTitle(), challenge4);


        Challenge challenge5 = new Challenge();
        challenge5.setTitle("Reto5");
        challenge5.setStartDate(LocalDate.now());
        challenge5.setEndDate(LocalDate.parse("27-04-2022", formatter));
        challenge5.setSport(new String[]{"Runnning"});
        challenge5.setDistanceGoal(120.0f);
        challenge5.setTimeGoal(240.0f);
        challengesMap.put(challenge5.getTitle(), challenge5);


        Challenge challenge6 = new Challenge();
        challenge6.setTitle("Reto6");
        challenge6.setStartDate(LocalDate.parse("02-04-2022", formatter));
        challenge6.setEndDate(LocalDate.parse("17-04-2022", formatter));
        challenge6.setSport(new String[]{"Runnning"});
        challenge6.setDistanceGoal(12.0f);
        challenge6.setTimeGoal(0.0f);
        challengesMap.put(challenge6.getTitle(), challenge6);


        Challenge challenge7 = new Challenge();
        challenge7.setTitle("Reto7");
        challenge7.setStartDate(LocalDate.now());
        challenge7.setEndDate(LocalDate.parse("27-04-2022", formatter));
        challenge7.setSport(new String[]{"Runnning"});
        challenge7.setDistanceGoal(12.0f);
        challenge7.setTimeGoal(0.0f);
        challengesMap.put(challenge7.getTitle(), challenge7);


        user0.addChallenge(challenge0);
        user0.addChallenge(challenge1);
        user1.addChallenge(challenge2);
        user1.addChallenge(challenge5);
        user1.addChallenge(challenge1);
        user2.addChallenge(challenge3);
        user2.addChallenge(challenge6);
        user2.addChallenge(challenge4);


    }


    public boolean createChallenge(User user,String title, LocalDate startDate, LocalDate endDate, float distanceGoal, float timeGoal, String[] sport){
        if(user != null){
            Challenge challenge = new Challenge();
            challenge.setTitle(title);
            challenge.setStartDate(startDate);
            challenge.setEndDate(endDate);
            challenge.setSport(sport);
            challenge.setDistanceGoal(distanceGoal);
            challenge.setTimeGoal(timeGoal);


            user.addChallenge(challenge);
            return true;
        } else return false;
    }

    public List<Challenge> getChallenges(User user, LocalDate endDate){
        List<Challenge> challenges = new ArrayList<>();
        if(user != null){
            for (Challenge challenge: user.getChallenges()) {
                if(challenge.getEndDate().isAfter(endDate)){
                    challenges.add(challenge);
                }
            }
            return challenges;
        } else return null;
    }

    public boolean acceptChallenge(User user, Challenge c){
        if(user!= null && c.getEndDate().isAfter(LocalDate.now())){
            user.addChallenge(c);
            return true;
        } else return false;
    }

}
