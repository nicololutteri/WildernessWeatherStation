package base;

/**
 * Coordinate geografiche relativa alla posizione di una stazione sul suolo terrestre
 */
public class Position {

    private float X;
    private float Y;
    private float Z;

    public Position(float x, float y, float z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public float getX() {
        return X;
    }

    public void setX(float x) {
        X = x;
    }

    public float getY() {
        return Y;
    }

    public void setY(float y) {
        Y = y;
    }

    public float getZ() {
        return Z;
    }

    public void setZ(float z) {
        if (z < Constant.MaxDepth)
        {
            throw new IllegalArgumentException();
        }

        Z = z;
    }

    @Override
    public String toString() {
        return  "X=" + X +
                ", Y=" + Y +
                ", Z=" + Z;
    }

}
