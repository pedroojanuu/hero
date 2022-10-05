import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public abstract class Element {
    protected Position position;
    public Element(int x, int y) {
        position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public int getX() {return position.getX();}

    public int getY() {return position.getY();}

    public void setX(int x) {position.setX(x);}

    public void setY(int y) {position.setY(y);}

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void draw(TextGraphics graphics) throws IOException;
}
