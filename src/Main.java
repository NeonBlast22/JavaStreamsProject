import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
import java.util.Optional;

public class Main {
    public static double gravity = 9.81;

    public static void main(String[] args) {
        List<ArtilleryGun> artillery = List.of(
                new ArtilleryGun(new Vector2D(100, 12), 500),
                new ArtilleryGun(new Vector2D(-900, 121), 400),
                new ArtilleryGun(new Vector2D(1200, 152), 700),
                new ArtilleryGun(new Vector2D(5100, 1300), 900),
                new ArtilleryGun(new Vector2D(-2600, -5020), 300),
                new ArtilleryGun(new Vector2D(-4600, -5300), 600),
                new ArtilleryGun(new Vector2D(-9000, -31000), 300)
        );

        Vector2D target = new Vector2D(255, 330);

        artillery.forEach(a -> a.target = target);

        HashSet<ArtilleryGun> in_range = new HashSet<ArtilleryGun>();
        artillery.parallelStream()
                .distinct()
                .filter(a -> a.InRangeOfTarget())
                .peek(a -> in_range.add(a))
                .forEach(ArtilleryGun::aimAtTarget);

        in_range.forEach(a -> System.out.println(a.toString()));
    }
}