package racingcar.model.dto;

public class CarMovementDto {
    private String name;
    private int movement;

    public CarMovementDto(String name, int movement) {
        this.name = name;
        this.movement = movement;
    }

    public String getName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

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
