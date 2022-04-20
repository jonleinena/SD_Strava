package test;



import data.domain.Workout;
import data.dto.ChallengeDTO;
import remote.RemoteFacade;
import services.ChallengeAppService;
import services.LoginAppService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LocalTest {

	public static void main(String[] args) {		
		RemoteFacade facade = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		long token = 0l;

		try{
			//register
			facade = new RemoteFacade();
			if (facade.registerEmail("jon@mail.com", org.apache.commons.codec.digest.DigestUtils.sha1Hex("jon"),"Jon", LocalDate.parse("13-12-2000", formatter) )){
				System.out.println("Registered successfully");
			}


		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());
		}

		try {
			//Login
			String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
			token = facade.emailLogin("thomas.e2001@gmail.com", sha1);
			//create workouts
			facade.createWorkout(token, "test", "Running", 12.0f, LocalDate.now(), LocalTime.now(), 60.0f);
			facade.createWorkout(token, "test1", "Cycling", 85.0f, LocalDate.now(), LocalTime.now(), 90.0f);
			facade.createWorkout(token, "test2", "Running", 12.0f, LocalDate.now(), LocalTime.now(), 60.0f);

			List<Workout> workouts = facade.serverState.get(token).getWorkouts();
			for (Workout w:
				 workouts) {
				System.out.println(w);
			}

			//accept challenges
			facade.acceptChallenge(token, ChallengeAppService.getInstance().getChallengesMap().get("Reto1"));
			facade.acceptChallenge(token, ChallengeAppService.getInstance().getChallengesMap().get("Reto2"));
			facade.acceptChallenge(token, ChallengeAppService.getInstance().getChallengesMap().get("Reto3"));
			facade.acceptChallenge(token, ChallengeAppService.getInstance().getChallengesMap().get("Reto4"));

			List<ChallengeDTO> challenges = facade.getChallenges(token, LocalDate.now());
			for (ChallengeDTO c:
				 challenges) {
				System.out.println(c);
			}

			//create a new challenge
			facade.createChallenge(token, "challEngE", LocalDate.parse("19-04-2022", formatter), LocalDate.parse("29-04-2022", formatter), 120f, 45f, new String[]{"Running"});

			challenges = facade.getChallenges(token, LocalDate.now());
			for (ChallengeDTO c:
					challenges) {
				System.out.println(c);
			}

			//Logout
			facade.logout(token);


		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}

		//Force exit to stop RMI Server
		System.exit(0);
	}
}