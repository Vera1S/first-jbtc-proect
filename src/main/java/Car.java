import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
    public class Car {

        private int id;

        private String name;

        private String country;

        public Car(int id, String name, String country) {
        }
    }

