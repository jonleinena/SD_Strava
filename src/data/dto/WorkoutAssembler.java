package data.dto;

import data.domain.Workout;

public class WorkoutAssembler {

    private WorkoutAssembler instance;

    private WorkoutAssembler(){}

    private WorkoutAssembler getInstance(){
        if (instance == null) {
            instance = new WorkoutAssembler();
        }

        return instance;
    }

    public WorkoutDTO workoutToDTO(Workout w){
        WorkoutDTO dto = new WorkoutDTO();

        dto.setTitle(w.getTitle());
        dto.setStartDate(w.getStartDate());
        dto.setStartHour(w.getStartHour());
        dto.setDistance(w.getDistance());
        dto.setDuration(w.getDuration());
        dto.setSport(w.getSport());

        return dto;
    }


}
