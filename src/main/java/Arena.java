import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.Terminal;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);
    }
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    private boolean canHeroMove(Position position) {
        if (position.getX() > width - 1) return false;
        if (position.getY() > height - 1) return false;
        if (position.getX() < 0) return false;
        if (position.getY() < 0) return false;
        return true;
    }
    private void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
    }
    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp: moveHero(hero.moveUp()); break;
            case ArrowRight: moveHero(hero.moveRight()); break;
            case ArrowDown: moveHero(hero.moveDown()); break;
            case ArrowLeft: moveHero(hero.moveLeft()); break;
        }
    }
}
