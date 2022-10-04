import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

public class Arena {
    private int width;
    private int height;

    private Hero hero = new Hero(10, 10);

    public Arena (int width, int height) {
        this.width = width;
        this.height = height;
    }
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
    public void draw(Screen screen) {
        screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X') [0]);
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
