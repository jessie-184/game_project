package app.games.commonobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.gameobjects.StaticGameObject;
import app.gameengine.model.physics.Vector2D;

/**
 * A wall object the player can collide with, serves as a building block
 * for your levels.
 */
public class Wall extends StaticGameObject {

    public Wall(int x, int y) {
        super(x, y);
        this.spriteSheetFilename = "Ground/Cliff.png";
        this.defaultSpriteLocation = new SpriteLocation(3, 0);
    }

    @Override
    public void collideWithDynamicObject(DynamicGameObject obj) {
        Vector2D objLoc = obj.getLocation();
        double objX = objLoc.getX();
        double objY = objLoc.getY();
        double wallX = this.getLocation().getX();
        double wallY = this.getLocation().getY();
        double objDX = objLoc.getX();
        double objDY = objLoc.getY();
        double wallDX = this.getDimensions().getX();
        double wallDY = this.getDimensions().getY();
        double moveLeft = objX + objDX - wallX;
        double moveRight = wallX + wallDX - objX;
        double moveUp = objY + objDY - wallY;
        double moveDown = wallY + wallDY - objY;
        double objOX = obj.getOrientation().getX();
        double objOY = obj.getOrientation().getY();
        System.out.println("left: " + moveLeft + ", right: " + moveRight + ", up: " + moveUp + ", down: " + moveDown);
        System.out.println("location before: " + objX + ", " + objY);
        if (objOX == 1.0) objLoc.setX(moveLeft);
        else if (objOX == -1.0) objLoc.setX(moveRight);
        else if (objOY == 1.0) objLoc.setY(moveUp);
        else if (objOY == -1.0) objLoc.setY(moveDown);
        System.out.println("location after: " + objX + ", " + objY);
    }
}
