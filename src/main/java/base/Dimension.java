package base;

/**
 * Grandezza di una stazione
 */
public class Dimension {

    private float Width;
    private float Length;
    private float Depth;

    public Dimension(float width, float length, float depth) {
        setWidth(width);
        setLength(length);
        setDepth(depth);
    }

    @Override
    public String toString() {
        return "Width=" + Width +
                ", Length=" + Length +
                ", Depth=" + Depth;
    }

    public float getWidth() {
        return Width;
    }

    public void setWidth(float width) {
        if (width < 1)
        {
            throw new IllegalArgumentException();
        }

        Width = width;
    }

    public float getLength() {
        return Length;
    }

    public void setLength(float length) {
        if (length < 1)
        {
            throw new IllegalArgumentException();
        }

        Length = length;
    }

    public float getDepth() {
        return Depth;
    }

    public void setDepth(float depth) {
        if (depth < 1)
        {
            throw new IllegalArgumentException();
        }

        Depth = depth;
    }

}
