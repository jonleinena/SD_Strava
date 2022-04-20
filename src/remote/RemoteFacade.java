package remote;

import data.domain.Challenge;
import data.domain.User;
import data.dto.ChallengeAssembler;
import data.dto.ChallengeDTO;
import services.ChallengeAppService;
import services.LoginAppService;
import services.RegisterAppService;
import services.WorkoutAppService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {


    private static final long serialVersionUID = 1L;

    //Data structure for manage Server State
    public Map<Long, User> serverState = new HashMap<>();

    public RemoteFacade() throws RemoteException {
        super();
    }

    @Override
    public boolean registerEmail(String email, String password, String name, LocalDate birthDate) throws RemoteException {
        if(RegisterAppService.getInstance().registerEmail(email, password, name, birthDate)){
            emailLogin(email, password);
            return true;
        } else {
            throw new RemoteException("User could not be correctly registered");
        }

    }

    @Override
    public User externalRegister(String redirect) throws RemoteException { //should make use of a gateway for the register
        System.out.println("Redirecting to "+redirect);
        User u = RegisterAppService.getInstance().externalRegister(redirect);
        if(u != null){
            if(!this.serverState.containsValue(u)){
                Long token = Calendar.getInstance().getTimeInMillis();
                this.serverState.put(token, u);
                return u;
            } else  {
                throw new RemoteException("User is already logged in");
            }
        } else {
            throw new RemoteException("An error occurred while registering the user");
        }

    }

    @Override
    public long emailLogin(String email, String password) throws RemoteException {
        System.out.println(" * RemoteFacade login: " + email + " / " + password);

        //Perform login() using LoginAppService
        User user = LoginAppService.getInstance().emailLogin(email, password);

        //If login() success user is stored in the Server State
        if (user != null) {
            //If user is not logged in
            if (!this.serverState.containsValue(user)) {
                Long token = Calendar.getInstance().getTimeInMillis();
                this.serverState.put(token, user);
                return(token);
            } else {
                throw new RemoteException("User is already logged in!");
            }
        } else {
            throw new RemoteException("Login fails!");
        }
    }

    @Override
    public long externalLogin(String redirect) throws RemoteException { //should make use of a gateway for the login
        System.out.println("Redirecting to "+redirect);
        User user = LoginAppService.getInstance().externalLogin(redirect);
        if(user != null){
            if(!this.serverState.containsValue(user)){
                Long token = Calendar.getInstance().getTimeInMillis();
                this.serverState.put(token, user);
                return token;
            }else throw new RemoteException("User is already logged in!");
        } else throw new RemoteException("Login went wrong");

    }

    @Override
    public void logout(long token) throws RemoteException {
        System.out.println(" * RemoteFacade logout: " + token);

        if (this.serverState.containsKey(token)) {
            //Logout means remove the User from Server State
            this.serverState.remove(token);
        } else {
            throw new RemoteException("User is not not logged in!");
        }
    }

    @Override
    public boolean createWorkout(long token, String title, String sport, float distance, LocalDate startDate, LocalTime startHour, float duration) throws RemoteException {
        if(this.serverState.containsKey(token)){
            return WorkoutAppService.getInstance().createWorkout(this.serverState.get(token), title,sport,distance,startDate, startHour, duration);
        } else return false;

    }

    @Override
    public boolean createChallenge(long token,String title, LocalDate startDate, LocalDate endDate, float distanceGoal, float timeGoal, String[] sport) {
        if(this.serverState.containsKey(token)){
            return ChallengeAppService.getInstance().createChallenge(this.serverState.get(token), title, startDate, endDate, distanceGoal, timeGoal, sport);
        } else return false;

    }

    @Override
    public List<ChallengeDTO> getChallenges(long token,LocalDate endDate) throws RemoteException {
        if(this.serverState.containsKey(token)){
            List<ChallengeDTO> dto = ChallengeAssembler.getInstance().challengeToDTOs(ChallengeAppService.getInstance().getChallenges(serverState.get(token), endDate));
            return dto;
        } else throw  new RemoteException("The user is not logged in");

    }

    @Override
    public boolean acceptChallenge(long token,Challenge challenge) throws RemoteException {
        if(this.serverState.containsKey(token)){
            return ChallengeAppService.getInstance().acceptChallenge(this.serverState.get(token), challenge);
        } else throw new RemoteException("User is not logged in");

    }
}
