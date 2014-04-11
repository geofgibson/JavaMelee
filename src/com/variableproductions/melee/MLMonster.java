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
//This class is generic for monsters and NPCs
public class MLMonster {
    int index, strength, dexterity, movementAllowance, adjDX;
    String name;
    MLArmourModifiers armour;
    MLWeaponSpecs normalCombat, hthCombat;
    
    /**
     *
     */
    public MLMonster() {
        index = strength = dexterity = movementAllowance  = adjDX = 0;
        armour = new MLArmourModifiers();
        normalCombat = new MLWeaponSpecs();
        hthCombat = new MLWeaponSpecs();
    }
    
}
