/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.variableproductions.melee;

import java.beans.*;
import static java.lang.Boolean.*;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;





/**
 *
 * @author geofgibson
 */
public final class MLMeleeController {
     
    boolean stFixed, dxFixed;
    MLMonster[] monsterDatabase;
    
    /**
     *
     */
    public MLMeleeController() {    
       stFixed = dxFixed = FALSE;
       monsterDatabase = new MLMonster[12];
       buildMonsterDatabase();
    }
 
    /**
     *
     */
    public void createCharacter() {
        //randomize ST & DX
	int stDxRatio;
        Random rand = new Random();
        stDxRatio = rand.nextInt(8) + 1;
        //check for fixed value
        if (!stFixed) {
            try {
                Melee.mLCharacter.setStrength (8 + stDxRatio);
            }
            catch (PropertyVetoException e) {
                //this exception is handled by the setter
            }
	}
	if (!dxFixed) {
            try {
                Melee.mLCharacter.setDexterity (16 - stDxRatio);
            } catch (PropertyVetoException ex) {
                //this exception is handled by the setter
            }
            Melee.mLCharacter.setAdjustedDX(Melee.mLCharacter.dexterity + Melee.mLCharacter.currentArmour.dxAdj);	
	}
        //Clear possessions
        Melee.mLCharacter.currentArmour = Melee.mLCharacter.armour[0];
        Melee.mLCharacter.currentArmour.name = "None";
        Melee.mLCharacter.weaponOne = Melee.mLCharacter.weapons[0];
        Melee.mLCharacter.weaponOne.name = "None";
        Melee.mLCharacter.weaponOne.dice = "";
        Melee.mLCharacter.weaponTwo = Melee.mLCharacter.weapons[0];
        Melee.mLCharacter.weaponTwo.name = "None";
        Melee.mLCharacter.weaponTwo.dice = "";
        Melee.mLCharacter.currentDagger = Melee.mLCharacter.daggers[0];
        Melee.mLCharacter.currentDagger.name = "None";
        Melee.mLCharacter.currentDagger.dice = "";
        this.buildPossessions();
    }
    void toggleStFixed() {
        if (stFixed) {
            stFixed = false;
	}
	else {//toggle must not be set then
            stFixed = true;
	}
    }
    void toggleDxFixed() {
	if (dxFixed) {
            dxFixed = false;
	}
	else {//toggle must not be set then
            dxFixed = true;
	}
    }
    
    void selectArmour(int sender) {
	Melee.mLCharacter.currentArmour = Melee.mLCharacter.armour[sender];
	Melee.mLCharacter.setMovementAllowance (Melee.mLCharacter.currentArmour.armourMovement);
	Melee.mLCharacter.adjustedDX = Melee.mLCharacter.dexterity+Melee.mLCharacter.currentArmour.dxAdj;
        buildPossessions();
    }
    
    
    void selectWeapon1(int sentIndex) {
	//validate weapon selection
	MLWeaponSpecs selectedWeapon = Melee.mLCharacter.weapons[sentIndex];
	int minimumStrength = selectedWeapon.stMinimum;
	if (Melee.mLCharacter.strength >= minimumStrength) {
            Melee.mLCharacter.weaponOne = Melee.mLCharacter.weapons[sentIndex];
	}
	else {
            //display sheet not enough strength
            JOptionPane.showMessageDialog(null, "You cannot use a "+selectedWeapon.name+" without a strength of at least "+selectedWeapon.stMinimum,"Not so fast ...",JOptionPane.WARNING_MESSAGE);
            Melee.mLCharacter.weaponOne = Melee.mLCharacter.weapons[0];
            
	}
        buildPossessions();
    }

    void selectWeapon2(int sentIndex) {
	//validate weapon selection
	MLWeaponSpecs selectedWeapon = Melee.mLCharacter.weapons[sentIndex];
	int minimumStrength = selectedWeapon.stMinimum;
	if (Melee.mLCharacter.strength >= minimumStrength) {
            Melee.mLCharacter.weaponTwo = Melee.mLCharacter.weapons[sentIndex];
	}
	else {
            //display sheet not enough strength
            JOptionPane.showMessageDialog(null, "You cannot use a "+selectedWeapon.name+" without a strength of at least "+selectedWeapon.stMinimum,"Not so fast ...",JOptionPane.WARNING_MESSAGE);
            Melee.mLCharacter.weaponTwo = Melee.mLCharacter.weapons[0];   
	}
        buildPossessions();
    }
    
    void selectDagger(int sentIndex) {
	Melee.mLCharacter.currentDagger = Melee.mLCharacter.daggers[sentIndex];
        buildPossessions();
    }
    
    void buildPossessions() {
        //Rebuild possessions string currentArmour, weaponOne, weaponTwo, currentDagger
        String possessionsString = Melee.mLCharacter.currentArmour.name;
        possessionsString = possessionsString.concat("\n");
        possessionsString = possessionsString.concat(Melee.mLCharacter.weaponOne.name);
        possessionsString = possessionsString.concat(Melee.mLCharacter.weaponOne.dice);
        possessionsString = possessionsString.concat("\n");
        possessionsString = possessionsString.concat(Melee.mLCharacter.weaponTwo.name);
        possessionsString = possessionsString.concat(Melee.mLCharacter.weaponTwo.dice);
        possessionsString = possessionsString.concat("\n");
        possessionsString = possessionsString.concat(Melee.mLCharacter.currentDagger.name);
        possessionsString = possessionsString.concat(Melee.mLCharacter.currentDagger.dice);
        //MUST use synthesized setter to trigger KVC bindings updates!
        Melee.mLCharacter.setPossessions(possessionsString);        
    }
    
    void buildMonsterDatabase() {
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
        buildMonster.normalCombat.dice = "2d6+2";
        buildMonster.hthCombat.dice = "3d6";
        monsterDatabase[0] = buildMonster;
        buildMonster = new MLMonster();
        buildMonster.index = 0;
        buildMonster.name = "Wolf";
        buildMonster.strength = 10;
        buildMonster.dexterity = 14;
        buildMonster.movementAllowance = 12;
        buildMonster.armour.name = "Fur";
        buildMonster.armour.hits = 2;
        buildMonster.armour.dxAdj = 0;
        buildMonster.armour.armourMovement = 12;
        buildMonster.normalCombat.dice = "1d6+1";
        buildMonster.hthCombat.dice = "1d6+1";
        monsterDatabase[1] = buildMonster;
        
    }
}
