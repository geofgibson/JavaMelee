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
public class WeaponDatabase {
    
    MLWeaponSpecs[] weapons, daggers;
    
    /**
     *
     */
    public WeaponDatabase() {
        
        //set up weapon data
	MLWeaponSpecs noWeapon = new MLWeaponSpecs();
        noWeapon.stMinimum = 0;
        noWeapon.dxAdj = 0;
        noWeapon.name = "None";
        noWeapon.dice = "";
	MLWeaponSpecs rapier = new MLWeaponSpecs();
	rapier.stMinimum = 9;
	rapier.dxAdj = 0;
	rapier.name = "Rapier";
	rapier.dice = " 1d6";
	MLWeaponSpecs club = new MLWeaponSpecs();
	club.stMinimum = 9;
	club.dxAdj = 0;
	club.name = "Club";
	club.dice = " 1d6";
	MLWeaponSpecs hammer = new MLWeaponSpecs();
	hammer.stMinimum = 10;
	hammer.dxAdj = 0;
	hammer.name = "Hammer";
	hammer.dice = " 1d6+1";
	MLWeaponSpecs cutlass = new MLWeaponSpecs();
	cutlass.stMinimum = 10;
	cutlass.dxAdj = 0;
	cutlass.name = "Cutlass";
	cutlass.dice = " 2d6-2";
	MLWeaponSpecs shortSword = new MLWeaponSpecs();
	shortSword.stMinimum = 11;
	shortSword.dxAdj = 0;
	shortSword.name = "Shortsword";
	shortSword.dice = " 2d6-1";
	MLWeaponSpecs mace = new MLWeaponSpecs();
	mace.stMinimum = 11;
	mace.dxAdj = 0;
	mace.name = "Mace";
	mace.dice = " 2d6-1";
	MLWeaponSpecs smallAxe = new MLWeaponSpecs();
	smallAxe.stMinimum = 11;
	smallAxe.dxAdj = 0;
	smallAxe.name = "Small axe";
	smallAxe.dice = " 1d6+2";
	MLWeaponSpecs broadsword = new MLWeaponSpecs();
	broadsword.stMinimum = 12;
	broadsword.dxAdj = 0;
	broadsword.name = "Broadsword";
	broadsword.dice = " 2d6";
	MLWeaponSpecs mornigstar = new MLWeaponSpecs();
	mornigstar.stMinimum = 13;
	mornigstar.dxAdj = 0;
	mornigstar.name = "Morningstar";
	mornigstar.dice = " 2d6+1";
	MLWeaponSpecs twoHandedSword = new MLWeaponSpecs();
	twoHandedSword.stMinimum = 14;
	twoHandedSword.dxAdj = 0;
	twoHandedSword.name = "2-handed sword";
	twoHandedSword.dice = " 3d6-1";
	MLWeaponSpecs battleAxe = new MLWeaponSpecs();
	battleAxe.stMinimum = 15;
	battleAxe.dxAdj = 0;
	battleAxe.name = "Battleaxe";
	battleAxe.dice = " 3d6";
	MLWeaponSpecs javelin = new MLWeaponSpecs();
	javelin.stMinimum = 9;
	javelin.dxAdj = 0;
	javelin.name = "Javelin";
	javelin.dice = " 1d6-1";
	MLWeaponSpecs spear = new MLWeaponSpecs();
	spear.stMinimum = 11;
	spear.dxAdj = 0;
	spear.name = "Spear";
	spear.dice = " 1d6+1";
	MLWeaponSpecs halberd = new MLWeaponSpecs();
	halberd.stMinimum = 13;
	halberd.dxAdj = 0;
	halberd.name = "Halberd";
	halberd.dice = " 2d6-1";
	MLWeaponSpecs pikeAxe = new MLWeaponSpecs();
	pikeAxe.stMinimum = 15;
	pikeAxe.dxAdj = 0;
	pikeAxe.name = "Pike axe";
	pikeAxe.dice = " 2d6+2";
	MLWeaponSpecs thrownRock = new MLWeaponSpecs();
	thrownRock.stMinimum = 0;
	thrownRock.dxAdj = 0;
	thrownRock.name = "Thrown rock";
	thrownRock.dice = " 1d6-4";
	MLWeaponSpecs sling = new MLWeaponSpecs();
	sling.stMinimum = 0;
	sling.dxAdj = 0;
	sling.name = "Sling";
	sling.dice = " 1d6-2";
	MLWeaponSpecs smallBow = new MLWeaponSpecs();
	smallBow.stMinimum = 9;
	smallBow.dxAdj = 0;
	smallBow.name = "Small bow";
	smallBow.dice = " 1d6-1";
	MLWeaponSpecs horseBow = new MLWeaponSpecs();
	horseBow.stMinimum = 10;
	horseBow.dxAdj = 0;
	horseBow.name = "Horse bow";
	horseBow.dice = " 1d6";
	MLWeaponSpecs longBow = new MLWeaponSpecs();
	longBow.stMinimum = 11;
	longBow.dxAdj = 0;
	longBow.name = "Long bow";
	longBow.dice = " 1d6+2";
	MLWeaponSpecs lightCrossbow = new MLWeaponSpecs();
	lightCrossbow.stMinimum = 12;
	lightCrossbow.dxAdj = 0;
	lightCrossbow.name = "Light crossbow";
	lightCrossbow.dice = " 2d6";
	MLWeaponSpecs heavyCrossbow = new MLWeaponSpecs();
	heavyCrossbow.stMinimum = 15;
	heavyCrossbow.dxAdj = 0;
	heavyCrossbow.name = "Heavy crossbow";
	heavyCrossbow.dice = " 3d6";
	MLWeaponSpecs smallShield = new MLWeaponSpecs();
	smallShield.stMinimum = 0;
	smallShield.dxAdj = 0;
	smallShield.name = "Small shield";
	smallShield.dice = ", -1 hit";
	MLWeaponSpecs largeShield = new MLWeaponSpecs();
	largeShield.stMinimum = 0;
	largeShield.dxAdj = 1;
	largeShield.name = "Large shield";
	largeShield.dice = ", -2 hits (-1 DX when ready)";
        
        weapons = new MLWeaponSpecs[] {noWeapon, rapier, club, hammer, cutlass, shortSword, mace, smallAxe, broadsword, mornigstar, twoHandedSword, battleAxe, javelin, spear, halberd, pikeAxe, thrownRock, sling, smallBow, horseBow, longBow, lightCrossbow, heavyCrossbow, smallShield, largeShield};
        
        //initialize daggers
	MLWeaponSpecs dagger = new MLWeaponSpecs();
	dagger.stMinimum = 0;
	dagger.dxAdj = 0;
	dagger.name = "Dagger";
	dagger.dice = " 1d6-1";
	MLWeaponSpecs mainGauche = new MLWeaponSpecs();
	mainGauche.stMinimum = 0;
	mainGauche.dxAdj = 0;
	mainGauche.name = "Main-Gauche";
	mainGauche.dice = " 1d6-1";
	
	daggers = new MLWeaponSpecs[] {noWeapon, dagger, mainGauche};
       
    }
}
