package remote;

import data.domain.Challenge;
import data.domain.User;
import data.dto.ChallengeDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IRemoteFacade extends Remote {

    public boolean registerEmail(String email, String password, String name, LocalDate birthDate) throws RemoteException;
    public User externalRegister(String redirect) throws RemoteException;
    public long emailLogin(String email, String password) throws RemoteException;
    public long externalLogin(String redirect) throws RemoteException;
    public void logout(long token) throws RemoteException;
    public boolean createWorkout(long token, String title, String sport, float distance, LocalDate startDate, LocalTime startHour, float duration) throws RemoteException;
    public boolean createChallenge(long token, String title, LocalDate startDate, LocalDate endDate, float distanceGoal, float timeGoal, String[] sport) throws RemoteException;
    public List<ChallengeDTO> getChallenges(long token, LocalDate endDate) throws RemoteException;
    public boolean acceptChallenge(long token, Challenge challenge) throws RemoteException;

}
