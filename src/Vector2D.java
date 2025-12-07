public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D()
    {
        x = 0;
        y = 0;
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(this.x + other.x, this.y + other.y);
    }

    public Vector2D subtract(Vector2D other) {
        return new Vector2D(this.x - other.x, this.y - other.y);
    }

    public Vector2D multiply(double scalar) {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

    public double dotProduct(Vector2D other) {
        return (this.x * other.x) + (this.y * other.y);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public double distanceTo(Vector2D vector)
    {
        return subtract(vector).magnitude();
    }

    public Vector2D normalize() {
        double mag = magnitude();
        if (mag == 0) {
            return new Vector2D(0, 0); // Handle zero vector
        }
        return new Vector2D(x / mag, y / mag);
    }

    public Radian getAngle()
    {
        return new Radian(Math.atan2(x, y));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}