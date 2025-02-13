package racingcar.model.dto;

public record CarMovementDto(String name, int movement) {
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarMovementDto that = (CarMovementDto) o;
        return movement == that.movement && name.equals(that.name);
    }
}
