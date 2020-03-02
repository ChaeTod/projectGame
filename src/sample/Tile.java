package sample;

public class Tile {
    private boolean value;

    public Tile(){
        value = false;  // from the beginning we suppose to set all field by zeros. After we will shake the field places and randomly setup zeros and X.
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public void toggle(){
        value = !value;
    }
}
