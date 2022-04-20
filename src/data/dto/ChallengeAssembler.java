package data.dto;

import data.domain.Challenge;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ChallengeAssembler {
    private static ChallengeAssembler instance;

    private ChallengeAssembler(){ }

    public static ChallengeAssembler getInstance(){
        if (instance == null) {
            instance = new ChallengeAssembler();
        }

        return instance;

    }

    public ChallengeDTO challengeToDTO(Challenge c){
        ChallengeDTO dto = new ChallengeDTO();

        dto.setTitle(c.getTitle());
        dto.setStartDate(c.getStartDate());
        dto.setEndDate(c.getEndDate());
        dto.setDistanceGoal(c.getDistanceGoal());
        dto.setTimeGoal(c.getTimeGoal());
        dto.setSport(c.getSport()); //we're making a shallow copy


        return dto;
    }

    public List<ChallengeDTO> challengeToDTOs(List<Challenge> challenges){
        List<ChallengeDTO> dtos = new ArrayList<ChallengeDTO>();
        for (Challenge challenge: challenges) {
            dtos.add(this.challengeToDTO(challenge));
        }

        return dtos;
    }

}
