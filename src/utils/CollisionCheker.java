package utils;

import entity.Entity;
import main.GamePanel;

public class CollisionCheker {

	GamePanel gp;
	
	public CollisionCheker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		int entityleftWorldX = (entity.worldX + entity.solidArea.x);
		int entityrihtWorldX = (entity.worldX + entity.solidArea.x + entity.solidArea.width);
		int entitytopWorldY = (entity.worldY + entity.solidArea.y);
		int entityBottomWorldY = (entity.worldY + entity.solidArea.y + entity.solidArea.height);
		int entityleftCol = entityleftWorldX/gp.tileSize;
		int entityrightCol = entityrihtWorldX/gp.tileSize;
		int entitytopRow = entitytopWorldY/gp.tileSize;
		int entitybottomRow = entityBottomWorldY/gp.tileSize;
		int tileNum1, tileNum2;
		switch(entity.direction) {
		case "up":

			entitytopRow = (entitytopWorldY - entity.speed)/gp.tileSize;
			if(entitybottomRow > 0) {
				tileNum1 = gp.getTileM().getMapData().get(entityleftCol).get(entitytopRow);
				tileNum2 = gp.getTileM().getMapData().get(entityrightCol).get(entitytopRow);
				
				if(gp.getTileM().getTiles().get(tileNum1).isCollision() == true || 
						gp.getTileM().getTiles().get(tileNum2).isCollision() == true) {
					entity.setCollisionOn(true);
				}	
			} else {
				entity.setCollisionOn(true);
			}
			break;
		case "down":
			entitybottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
			if(entitybottomRow < gp.getTileM().getMapData().get(0).size()) {			
				tileNum1 = gp.getTileM().getMapData().get(entityleftCol).get(entitybottomRow);
				tileNum2 = gp.getTileM().getMapData().get(entityrightCol).get(entitybottomRow);
				if(gp.getTileM().getTiles().get(tileNum1).isCollision() == true || 
						gp.getTileM().getTiles().get(tileNum2).isCollision() == true) {
					entity.collisionOn = true;
				}
			} else {
				entity.setCollisionOn(true);
			}
			break;
		case "left":
			entityleftCol = (entityleftWorldX - entity.speed)/gp.tileSize;
			if(entityrightCol > 0){
				tileNum1 = gp.getTileM().getMapData().get(entityleftCol).get(entitytopRow);
				tileNum2 = gp.getTileM().getMapData().get(entityleftCol).get(entitybottomRow);
				if(gp.getTileM().getTiles().get(tileNum1).isCollision() == true || 
						gp.getTileM().getTiles().get(tileNum2).isCollision() == true) {
					entity.collisionOn = true;
				}
			}else {
				entity.setCollisionOn(true);
			}
			break;
		case "right" :	
				
			entityrightCol = (entityrihtWorldX + entity.speed)/gp.tileSize;
			if(entityrightCol < gp.getTileM().getMapData().size()) {	
				tileNum1 = gp.getTileM().getMapData().get(entityrightCol).get(entitytopRow);
				tileNum2 = gp.getTileM().getMapData().get(entityrightCol).get(entitybottomRow);
				if(gp.getTileM().getTiles().get(tileNum1).isCollision() == true || 
						gp.getTileM().getTiles().get(tileNum2).isCollision() == true) {
					entity.collisionOn = true;
				}
			}else {
				entity.collisionOn = true;
			}
			break;
		}
	} 
	
	/*
	public int checkObject(Entity entity, boolean player) {
		int index = -1;
		for(int i = 0; i < gp.obj.length;i++) {
			if(gp.obj[i] != null) {
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
				
				switch(entity.direction) {
				case "up" : 
					entity.solidArea.y -= entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if(gp.obj[i].collision == true) {
								entity.collisionOn = true;
							}
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "left": 
					entity.solidArea.x -= entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if(gp.obj[i].collision == true) {
								entity.collisionOn = true;
							}
							if(player == true) {
								index = i;
							}
						}	
					}
					break;
				case "right": 
					entity.solidArea.x += entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if(gp.obj[i].collision == true) {
								entity.collisionOn = true;
							}
							if(player == true) {
								index = i;
							}
						}	
					}
					break;
				}
			
			entity.solidArea.x = entity.solidAreaDefaultX;
			entity.solidArea.y = entity.solidAreaDefaultY;
			gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
			gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
			}
		}
		
		return index;
		
	}
	*/

}
