/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.variableproductions.melee;

/**
 *
 * @author geofgibson
 */
public class ArmourDatabase {
    
    MLArmourModifiers[] armour;
    
    /**
     *
     */
    public ArmourDatabase() {
        MLArmourModifiers none = new MLArmourModifiers();
        none.hits = 0;
        none.armourMovement = 10;
        none.dxAdj = 0;
        none.name = "None";
	MLArmourModifiers leather = new MLArmourModifiers();
        leather.hits = 2;
        leather.armourMovement = 8;
        leather.dxAdj = -2;
        leather.name = "Leather, -2 hits";
	MLArmourModifiers chainmail = new MLArmourModifiers();
        chainmail.hits = 3;
        chainmail.armourMovement = 6;
        chainmail.dxAdj = -3;
        chainmail.name = "Chainmail, -3 hits";
	MLArmourModifiers plate = new MLArmourModifiers();
        plate.hits = 5;
        plate.armourMovement = 6;
        plate.dxAdj = -4;
        plate.name = "Plate, -5 hits";
	
        armour = new MLArmourModifiers[] {none, leather, chainmail, plate};
    }
    
}
