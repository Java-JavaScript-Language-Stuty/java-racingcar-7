package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;
import racingcar.model.dto.CarMovementDto;

public class ModelTest {
    private MockRandomProvider mockRandomProvider;

    @BeforeEach
    void setUp() {
        mockRandomProvider = new MockRandomProvider(
                true, false, true,
                true, true, true,
                true, true, true,
                true, true, true,
                true, true, true
        );
    }

    @Nested
    @DisplayName("경주 테스트")
    class RaceTest {
        @Test
        @DisplayName("초기화 테스트")
        public void initialTest() {
            Race race = Race.init(List.of("pobi", "woni", "jun"));
            assertEquals(0, race.getTurn());
            assertEquals(
                    List.of(
                            new CarMovementDto("pobi", 0),
                            new CarMovementDto("woni", 0),
                            new CarMovementDto("jun", 0)
                    ),
                    race.getResult()
            );
        }

        @Test
        @DisplayName("이동 테스트")
        public void movementTest() {
            Race race = Race.init(List.of("pobi", "woni", "jun"));
            IntStream.range(0, 5).forEach(i -> race.advance(mockRandomProvider::mockingRandom));
            assertEquals(5, race.getTurn());
            assertEquals(
                    List.of(
                            new CarMovementDto("pobi", 5),
                            new CarMovementDto("woni", 4),
                            new CarMovementDto("jun", 5)
                    ),
                    race.getResult()
            );
            assertEquals(List.of("pobi", "jun"), race.getWinner());
        }
    }
}
