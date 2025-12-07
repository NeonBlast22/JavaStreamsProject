public class Radian {
    public double angle;

    public Radian()
    {
        angle = 0;
    }

    public Radian(double initalAngle)
    {
        angle = initalAngle;
    }

    public double toDegrees()
    {
        return angle * (180 / Math.PI);
    }

    @Override
    public String toString() {
        return angle + " rad";
    }
}
