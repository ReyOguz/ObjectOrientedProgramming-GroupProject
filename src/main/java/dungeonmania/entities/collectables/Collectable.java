package dungeonmania.entities.collectables;

import dungeonmania.entities.Entity;
import dungeonmania.entities.Player;
import dungeonmania.entities.inventory.InventoryItem;
import dungeonmania.map.GameMap;
import dungeonmania.util.Position;

public abstract class Collectable extends Entity implements InventoryItem {
    public Collectable(Position position) {
        super(position);
    }

    @Override
    public boolean canMoveOnto(GameMap map, Entity entity) {
        return true;
    }

    @Override
    public void onOverlap(GameMap map, Entity entity) {
        if (entity instanceof Player) {
            pickUpCollectable(this, (Player) entity, map);
        }
    }

    public void pickUpCollectable(Entity entity, Player player, GameMap map) {
        player.pickUp(entity);
        map.destroyEntity(entity);
    }

    public boolean isTreasure() {
        return false;
    }
}
