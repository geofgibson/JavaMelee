/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.variableproductions.melee;

import java.beans.*;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author geofgibson
 */
public final class MLMeleeController {
     
    boolean stFixed, dxFixed;
    MonsterDatabase monsterDatabase;
    Random rand;
    ArmourDatabase armourDatabase;
    WeaponDatabase weaponDatabase;
    MLMonster myMonster;
    
    /**
     *
     */
    public MLMeleeController() {  
       rand = new Random();
       stFixed = dxFixed = false;
       monsterDatabase = new MonsterDatabase();
       armourDatabase = new ArmourDatabase();
       weaponDatabase = new WeaponDatabase();
    }
 
    /**
     *
     */
    public void createNPC() {
        //pull NPC from database and show card
        int newMonster = rand.nextInt(monsterDatabase.monster.length);
        myMonster = new MLMonster();
        myMonster = monsterDatabase.monster[newMonster];
        //test for conditional NPC values and fill
        switch (newMonster) {
            case 4: //Giant
                System.out.println("giant");
                myMonster.strength = rand.nextInt(25) + 25;
                myMonster.armour = JavaMelee.myController.armourDatabase.armour[rand.nextInt(4)];
                myMonster.adjDX = myMonster.armour.dxAdj + myMonster.dexterity;
                myMonster.normalCombat.dice = (myMonster.strength / 10) + "d6+1";
                break;
            case 6: // Orc
                System.out.println("orc");
                int stDxRatio = rand.nextInt(9);
                myMonster.strength = 8 + stDxRatio;
                myMonster.dexterity = 16 - stDxRatio;
                myMonster.armour = JavaMelee.myController.armourDatabase.armour[rand.nextInt(4)];
                myMonster.adjDX = myMonster.armour.dxAdj + myMonster.dexterity;
                myMonster.normalCombat = JavaMelee.myController.weaponDatabase.weapons[rand.nextInt(25)];
                break;
            case 7: // Hobgoblin
                System.out.println("hobgoblin");
                stDxRatio = rand.nextInt(9);
                myMonster.strength = 6 + stDxRatio;
                myMonster.dexterity = 14 - stDxRatio;
                myMonster.armour = JavaMelee.myController.armourDatabase.armour[rand.nextInt(4)];
                myMonster.adjDX = myMonster.armour.dxAdj + myMonster.dexterity;
                myMonster.normalCombat = JavaMelee.myController.weaponDatabase.weapons[rand.nextInt(25)];
                break;
            case 8: //Goblin
                stDxRatio = rand.nextInt(11);
                myMonster.strength = 4 + stDxRatio;
                myMonster.dexterity = 14 - stDxRatio;
                myMonster.armour = JavaMelee.myController.armourDatabase.armour[rand.nextInt(4)];
                myMonster.adjDX = myMonster.armour.dxAdj + myMonster.dexterity;
                myMonster.normalCombat = JavaMelee.myController.weaponDatabase.weapons[rand.nextInt(25)];
                break;
            case 9: // Elf
                stDxRatio = rand.nextInt(9);
                myMonster.strength = 6 + stDxRatio;
                myMonster.dexterity = 18 - stDxRatio;
                myMonster.armour = JavaMelee.myController.armourDatabase.armour[rand.nextInt(4)];
                myMonster.adjDX = myMonster.armour.dxAdj + myMonster.dexterity;
                System.out.println("elf armour: "+myMonster.armour.name);
                System.out.println("substring: " + myMonster.armour.name.substring(0, 4));
                if (myMonster.armour.name.substring(0, 4).equals("Leat")) {
                    myMonster.armour.armourMovement = 10;
                }
                myMonster.normalCombat = JavaMelee.myController.weaponDatabase.weapons[rand.nextInt(25)];
                break;
            case 10: //Dwarf
                stDxRatio = rand.nextInt(9);
                myMonster.strength = 10 + stDxRatio;
                myMonster.dexterity = 14 - stDxRatio;
                myMonster.armour = JavaMelee.myController.armourDatabase.armour[rand.nextInt(4)];
                myMonster.adjDX = myMonster.armour.dxAdj + myMonster.dexterity;
                myMonster.normalCombat = JavaMelee.myController.weaponDatabase.weapons[rand.nextInt(25)];
                // +1 bonus for hammers and axes
                if (myMonster.normalCombat.name.contains("axe")) {
                    myMonster.normalCombat.dice = myMonster.normalCombat.dice + "+1";
                }
                if (myMonster.normalCombat.name.toLowerCase().contains("hammer")) {
                    myMonster.normalCombat.dice = myMonster.normalCombat.dice + "+1";
                }
                break;
            case 11: // Hobbit
                stDxRatio = rand.nextInt(5);
                myMonster.strength = 4 + stDxRatio;
                myMonster.dexterity = 16 - stDxRatio;
                myMonster.armour = JavaMelee.myController.armourDatabase.armour[rand.nextInt(4)];
                myMonster.adjDX = myMonster.armour.dxAdj + myMonster.dexterity;
                myMonster.normalCombat = JavaMelee.myController.weaponDatabase.weapons[rand.nextInt(25)];
                // +3 for missle or thrown
                myMonster.normalCombat.dice = myMonster.normalCombat.dice + " +3DX +1hit  missle or thrown";
                break;
            case 12: // Human
                stDxRatio = rand.nextInt(9);
                myMonster.strength = 8 + stDxRatio;
                myMonster.dexterity = 16 - stDxRatio;
                myMonster.armour = JavaMelee.myController.armourDatabase.armour[rand.nextInt(4)];
                myMonster.adjDX = myMonster.armour.dxAdj + myMonster.dexterity;
                myMonster.normalCombat = JavaMelee.myController.weaponDatabase.weapons[rand.nextInt(25)];
                break;
        }
        new NPCCard().setVisible(true);
    }
    
    /**
     *
     */
    public void newCharacter() {
        //show new character card
        new Melee().setVisible(true);
    }
    /**
     *
     */
    public void createCharacter() {
        //randomize ST & DX
	int stDxRatio;
        stDxRatio = rand.nextInt(9);
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
        Melee.mLCharacter.currentArmour = JavaMelee.myController.armourDatabase.armour[0];
        Melee.mLCharacter.currentArmour.name = "None";
        Melee.mLCharacter.weaponOne = JavaMelee.myController.weaponDatabase.weapons[0];
        Melee.mLCharacter.weaponOne.name = "None";
        Melee.mLCharacter.weaponOne.dice = "";
        Melee.mLCharacter.weaponTwo = JavaMelee.myController.weaponDatabase.weapons[0];
        Melee.mLCharacter.weaponTwo.name = "None";
        Melee.mLCharacter.weaponTwo.dice = "";
        Melee.mLCharacter.currentDagger = JavaMelee.myController.weaponDatabase.daggers[0];
        Melee.mLCharacter.currentDagger.name = "None";
        Melee.mLCharacter.currentDagger.dice = "";
        this.buildPossessions();
    }
    
    void toggleStFixed() {
        stFixed = stFixed ? false : true;
    }
    
    void toggleDxFixed() {
	dxFixed = dxFixed ? false : true;
    }
    
    void selectArmour(int sender) {
	Melee.mLCharacter.currentArmour = JavaMelee.myController.armourDatabase.armour[sender];
	Melee.mLCharacter.setMovementAllowance (Melee.mLCharacter.currentArmour.armourMovement);
        Melee.mLCharacter.setAdjustedDX(Melee.mLCharacter.dexterity + Melee.mLCharacter.currentArmour.dxAdj);
        buildPossessions();
    }
    
    
    void selectWeapon1(int sentIndex) {
	//validate weapon selection
	MLWeaponSpecs selectedWeapon = JavaMelee.myController.weaponDatabase.weapons[sentIndex];
	int minimumStrength = selectedWeapon.stMinimum;
	if (Melee.mLCharacter.strength >= minimumStrength) {
            Melee.mLCharacter.weaponOne = JavaMelee.myController.weaponDatabase.weapons[sentIndex];
	}
	else {
            //display sheet not enough strength
            JOptionPane.showMessageDialog(null, "You cannot use a "+selectedWeapon.name+" without a strength of at least "+selectedWeapon.stMinimum,"Not so fast ...",JOptionPane.WARNING_MESSAGE);
            Melee.mLCharacter.weaponOne = JavaMelee.myController.weaponDatabase.weapons[0];
            
	}
        buildPossessions();
    }

    void selectWeapon2(int sentIndex) {
	//validate weapon selection
	MLWeaponSpecs selectedWeapon = JavaMelee.myController.weaponDatabase.weapons[sentIndex];
	int minimumStrength = selectedWeapon.stMinimum;
	if (Melee.mLCharacter.strength >= minimumStrength) {
            Melee.mLCharacter.weaponTwo = JavaMelee.myController.weaponDatabase.weapons[sentIndex];
	}
	else {
            //display sheet not enough strength
            JOptionPane.showMessageDialog(null, "You cannot use a "+selectedWeapon.name+" without a strength of at least "+selectedWeapon.stMinimum,"Not so fast ...",JOptionPane.WARNING_MESSAGE);
            Melee.mLCharacter.weaponTwo = JavaMelee.myController.weaponDatabase.weapons[0];   
	}
        buildPossessions();
    }
    
    void selectDagger(int sentIndex) {
	Melee.mLCharacter.currentDagger = JavaMelee.myController.weaponDatabase.daggers[sentIndex];
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
   
}
