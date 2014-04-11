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
public class MonsterDatabase {
    
    MLMonster[] monster = new MLMonster[13];
    
    /**
     *
     */
    public MonsterDatabase() {
        //armour.dxAdj used for ataacks AGINST monster
        MLMonster buildMonster = new MLMonster();
        buildMonster.index = 0;
        buildMonster.name = "Bear";
        buildMonster.strength = 30;
        buildMonster.dexterity = 11;
        buildMonster.movementAllowance = 8;
        buildMonster.armour.name = "Fur";
        buildMonster.armour.hits = 2;
        buildMonster.armour.dxAdj = 0;
        buildMonster.armour.armourMovement = 8;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        buildMonster.normalCombat.name = "Claw";
        buildMonster.normalCombat.dice = "2d6+2";
        buildMonster.hthCombat.dice = "3d6";
        monster[0] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 1;
        buildMonster.name = "Wolf";
        buildMonster.strength = 10;
        buildMonster.dexterity = 14;
        buildMonster.movementAllowance = 12;
        buildMonster.armour.name = "Fur";
        buildMonster.armour.hits = 2;
        buildMonster.armour.dxAdj = 0;
        buildMonster.armour.armourMovement = 12;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        buildMonster.normalCombat.name = "Claw";
        buildMonster.normalCombat.dice = "1d6+1";
        buildMonster.hthCombat.dice = "1d6+1";
        monster[1] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 2;
        buildMonster.name = "Dire Wolf";
        buildMonster.strength = 14;
        buildMonster.dexterity = 14;
        buildMonster.movementAllowance = 14;
        buildMonster.armour.name = "Fur";
        buildMonster.armour.hits = 2;
        buildMonster.armour.dxAdj = 0;
        buildMonster.armour.armourMovement = 14;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        buildMonster.normalCombat.name = "Claw";
        buildMonster.normalCombat.dice = "1d6+2";
        buildMonster.hthCombat.dice = "2d6";
        monster[2] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 3;
        buildMonster.name = "Giant Snake";
        buildMonster.strength = 12;
        buildMonster.dexterity = 12;
        buildMonster.movementAllowance = 6;
        buildMonster.armour.name = "None";
        buildMonster.armour.hits = 0;
        buildMonster.armour.dxAdj = -3;
        buildMonster.armour.armourMovement = 6;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        buildMonster.normalCombat.name = "Tooth";
        buildMonster.normalCombat.dice = "1d6+1";
        buildMonster.hthCombat.dice = "2d6-1";
        monster[3] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 4;
        buildMonster.name = "Giant";
        //define strength on creating instance
        //buildMonster.strength = rand.nextInt(25) + 25;
        buildMonster.strength = 25;
        buildMonster.dexterity = 9;
        buildMonster.movementAllowance = 10;
        buildMonster.armour.name = "None";
        buildMonster.armour.hits = 0;
        buildMonster.armour.dxAdj = 0;
        buildMonster.armour.armourMovement = 10;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        //probably have to select weapon upon creating actual monster instance
        //Select one weapon from available database
        //int weaponIndex = rand.nextInt(Melee.mLCharacter.weapons.length) + 1;
        //buildMonster.normalCombat = Melee.mLCharacter.weapons[weaponIndex];
        buildMonster.hthCombat.dice = "2d6-1";
        monster[4] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 5;
        buildMonster.name = "Gargoyle";
        buildMonster.strength = 20;
        buildMonster.dexterity = 11;
        buildMonster.movementAllowance = 10;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        buildMonster.armour.name = "Stone";
        buildMonster.armour.hits = 3;
        buildMonster.armour.dxAdj = 0;
        //using armourMovement for flying MA
        buildMonster.armour.armourMovement = 16;
        buildMonster.normalCombat.name = "Claw";
        buildMonster.normalCombat.dice = "2d6";
        buildMonster.hthCombat.dice = "2d6";
        monster[5] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 6;
        buildMonster.name = "Orc";
        //set minimum ST and DX and finalize on instantiating
        buildMonster.strength = 8;
        buildMonster.dexterity = 8;
        buildMonster.movementAllowance = 10;
        buildMonster.armour.name = "None";
        buildMonster.armour.hits = 0;
        buildMonster.armour.dxAdj = 0;
        buildMonster.armour.armourMovement = 10;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        buildMonster.normalCombat.dice = "new";
        buildMonster.hthCombat.dice = "1-(size 4-2)";
        monster[6] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 7;
        buildMonster.name = "Hobgoblin";
        //set minimum ST and DX and finalize on instantiating
        buildMonster.strength = 6;
        buildMonster.dexterity = 6;
        buildMonster.movementAllowance = 10;
        buildMonster.armour.name = "None";
        buildMonster.armour.hits = 0;
        buildMonster.armour.dxAdj = 0;
        buildMonster.armour.armourMovement = 10;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        buildMonster.normalCombat.dice = "new";
        buildMonster.hthCombat.dice = "1-(size 4-2)";
        monster[7] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 8;
        buildMonster.name = "Goblin";
        //set minimum ST and DX and finalize on instantiating
        buildMonster.strength = 4;
        buildMonster.dexterity = 4;
        buildMonster.movementAllowance = 10;
        buildMonster.armour.name = "None";
        buildMonster.armour.hits = 0;
        buildMonster.armour.dxAdj = 0;
        buildMonster.armour.armourMovement = 10;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        buildMonster.normalCombat.dice = "new";
        buildMonster.hthCombat.dice = "1-(size 4-2)";
        monster[8] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 9;
        buildMonster.name = "Elf";
        //set minimum ST and DX and finalize on instantiating
        buildMonster.strength = 6;
        buildMonster.dexterity = 10;
        buildMonster.movementAllowance = 12;
        buildMonster.armour.name = "None";
        buildMonster.armour.hits = 0;
        buildMonster.armour.dxAdj = 0;
        buildMonster.armour.armourMovement = 12;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        buildMonster.normalCombat.dice = "new";
        buildMonster.hthCombat.dice = "1-(size 4-2)";
        monster[9] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 10;
        buildMonster.name = "Dwarf";
        //set minimum ST and DX and finalize on instantiating
        buildMonster.strength = 10;
        buildMonster.dexterity = 6;
        buildMonster.movementAllowance = 12;
        buildMonster.armour.name = "None";
        buildMonster.armour.hits = 0;
        buildMonster.armour.dxAdj = 0;
        buildMonster.armour.armourMovement = 12;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        buildMonster.normalCombat.dice = "new";
        buildMonster.hthCombat.dice = "1-(size 4-2)";
        monster[10] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 11;
        buildMonster.name = "Hobbit";
        //set minimum ST and DX and finalize on instantiating
        buildMonster.strength = 4;
        buildMonster.dexterity = 12;
        buildMonster.movementAllowance = 10;
        buildMonster.armour.name = "None";
        buildMonster.armour.hits = 0;
        buildMonster.armour.dxAdj = 0;
        buildMonster.armour.armourMovement = 10;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        buildMonster.normalCombat.dice = "new";
        buildMonster.hthCombat.dice = "1-(size 4-2)";
        monster[11] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 12;
        buildMonster.name = "Human";
        //set minimum ST and DX and finalize on instantiating
        buildMonster.strength = 8;
        buildMonster.dexterity = 8;
        buildMonster.movementAllowance = 10;
        buildMonster.armour.name = "None";
        buildMonster.armour.hits = 0;
        buildMonster.armour.dxAdj = 0;
        buildMonster.armour.armourMovement = 10;
        buildMonster.adjDX = buildMonster.dexterity + buildMonster.armour.dxAdj;
        buildMonster.normalCombat.dice = "new";
        buildMonster.hthCombat.dice = "1-(size 4-2)";
        monster[12] = buildMonster;
    }
}
