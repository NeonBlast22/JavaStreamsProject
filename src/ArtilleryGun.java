public class ArtilleryGun
{
    public Vector2D position;
    public Vector2D target;

    public Radian gun_azimuth;
    public Radian gun_elevation;

    public double muzzle_velocity;

    public ArtilleryGun(Vector2D position, double muzzel_velocity)
    {
        this.position = position;
        this.muzzle_velocity = muzzel_velocity;
    }

    public ArtilleryGun()
    {
        position = new Vector2D();
        target = new Vector2D();
        muzzle_velocity = 500;
    }

    public boolean InRangeOfTarget()
    {
        double distance_to_target = position.distanceTo(target);
        return calculateMaximumRange() >= distance_to_target;
    }

    public double calculateMaximumRange()
    {
        double projectile_initial_vertical_velocity = Math.sin(Math.PI / 4f) * muzzle_velocity;
        double flightTime = (projectile_initial_vertical_velocity / Main.gravity) * 2; //Time to maximum height * 2

        double projectile_horizontal_velocity = Math.cos(Math.PI / 4f) * muzzle_velocity;
        double horizontal_distance = projectile_horizontal_velocity * flightTime;

        return horizontal_distance;
    }

    public Radian calculateElevationToHitDistance(double distance)
    {
        //angle = 1/2 * asin ( (distance * gravity) / muzzel_velocity ^ 2 )
        return new Radian(Math.asin((distance * Main.gravity) / Math.pow(muzzle_velocity, 2)) / 2);
    }

    public Radian calculateAzimuthToPosition(Vector2D target_position)
    {
        return target_position.subtract(position).getAngle();
    }

    public void aimAtTarget()
    {
        double distanceToTarget = position.distanceTo(target);
        gun_elevation = calculateElevationToHitDistance(distanceToTarget);
        gun_azimuth = calculateAzimuthToPosition(target);
    }

    @Override
    public String toString() {
        return "Artillery: \n" +
                "Pos: " + position.toString() + "\n" +
                "Muzzle Velocity: " + muzzle_velocity + "\n" +
                "Target: " + target.toString() + "\n" +
                "Azimuth: " + gun_azimuth + " Elevation: " + gun_elevation;
    }
}
