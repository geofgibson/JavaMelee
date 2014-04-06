/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.variableproductions.melee;

import java.beans.*;

/**
 *
 * @author geofgibson
 */
public class MLCharacter {
    
    int strength, dexterity, movementAllowance, experiencePoints, adjustedDX;
    MLWeaponSpecs[] weapons, daggers;
    MLArmourModifiers[] armour;
    MLArmourModifiers currentArmour;
    MLWeaponSpecs weaponOne, weaponTwo, currentDagger;
    String possessions;
    /**
     *
     */
    public PropertyChangeSupport mPcs = new PropertyChangeSupport(this);
    private final VetoableChangeSupport mVcs = new VetoableChangeSupport(this);
    
    /**
     *
     */
    public MLCharacter() {
	strength = dexterity = 8;
	movementAllowance = 10;
	adjustedDX = dexterity;
        possessions = null;
	
	// FUTURE MOD load data from a file
	//setup armour modifier data
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
        currentArmour = armour[0];

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
	smallShield.dice = " 1d6";
	MLWeaponSpecs largeShield = new MLWeaponSpecs();
	largeShield.stMinimum = 0;
	largeShield.dxAdj = 1;
	largeShield.name = "Large shield";
	largeShield.dice = " 2d6";
	
	weapons = new MLWeaponSpecs[] {noWeapon, rapier, club, hammer, cutlass, shortSword, mace, smallAxe, broadsword, mornigstar, twoHandedSword, battleAxe, javelin, spear, halberd, pikeAxe, thrownRock, sling, smallBow, horseBow, longBow, lightCrossbow, heavyCrossbow, smallShield, largeShield};
	weaponOne = weapons[0];
	weaponTwo = weapons[0];

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
	currentDagger = daggers[0];
       
        this.addListeners();
       
    }
    
    private void addListeners() {
        MyPropertyChangeListener aChangeListener;
        aChangeListener = new MyPropertyChangeListener();
        this.addPropertyChangeListener(aChangeListener);
        this.addVetoableChangeListener(aChangeListener);
    }
    
    /**
     *
     * @param lProperty
     * @param listener
     */
    public void addPropertyChangeListener(String lProperty, PropertyChangeListener listener) {
        mPcs.addPropertyChangeListener(lProperty, listener);
    }
    
    /**
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        mPcs.addPropertyChangeListener(listener);
    }
    
    /**
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        mPcs.removePropertyChangeListener(listener);
    }
    
    /**
     *
     * @param listener
     */
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        mVcs.addVetoableChangeListener(listener);
    }
    
    /**
     *
     * @param listener
     */
    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        mVcs.removeVetoableChangeListener(listener);
    }
    
    /**
     *
     * @return dexterity
     */
    public int getDexterity() {
        return dexterity;
    }
    
    /**
     *
     * @param newDexterity
     * @throws PropertyVetoException
     */
    public void setDexterity(int newDexterity) throws PropertyVetoException {
        int oldDexterity = dexterity;
        try {
            mVcs.fireVetoableChange("dexterity", oldDexterity, newDexterity);
        }
        catch (PropertyVetoException e) {
           oldDexterity = (int) e.getPropertyChangeEvent().getNewValue();
           newDexterity = 24 - strength; 
        }
        dexterity = newDexterity;
        setAdjustedDX(dexterity);
        mPcs.firePropertyChange("dexterity", oldDexterity, newDexterity);
        
    }
    
    /**
     *
     * @return strength
     */
    public int getStrength() {
        return strength;
    }
    
    /**
     *
     * @param newStrength
     * @throws PropertyVetoException
     */
    public void setStrength(int newStrength) throws PropertyVetoException {
        int oldStrength = strength;
        try {
           mVcs.fireVetoableChange("strength", oldStrength, newStrength);
        }
        catch (PropertyVetoException e) {
           oldStrength = (int) e.getPropertyChangeEvent().getNewValue();
           newStrength = 24 - dexterity;
        }
        strength = newStrength;
        mPcs.firePropertyChange("strength", oldStrength, newStrength);
    }
    
    /**
     *
     * @return adjustedDX
     */
    public int getAdjustedDX() {
        return adjustedDX;
    }
    
    /**
     *
     * @param newAdjustedDX
     */
    public void setAdjustedDX(int newAdjustedDX) {
        int oldAdjustedDX = adjustedDX;
        adjustedDX = newAdjustedDX = currentArmour.dxAdj+dexterity;
        mPcs.firePropertyChange("adjustedDX", oldAdjustedDX, newAdjustedDX);
    }
       
    /**
     *
     * @return possessions
     */
    public String getPossessions() {
        return possessions;
    }
    
    /**
     *
     * @param newPossessions
     */
    public void setPossessions(String newPossessions) {
        String oldPossessions = possessions;
        possessions = newPossessions;
        mPcs.firePropertyChange("possessions", oldPossessions, newPossessions);
    }
    
    /**
     *
     * @return movementAllowance
     */
    public int getMovementAllowance() {
        return movementAllowance;
    }
    
    /**
     *
     * @param newMA
     */
    public void setMovementAllowance(int newMA) {
        int oldMA = movementAllowance;
        movementAllowance = newMA;
        mPcs.firePropertyChange("movementAllowance", oldMA, newMA);
    }
    
    /**
     *
     */
    public class MyPropertyChangeListener implements PropertyChangeListener, VetoableChangeListener {
	    // This method is called every time the property value is changed
            @Override
	    public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().isEmpty()) {
                    return;
                }
            }
            @Override
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                if (evt.getPropertyName().isEmpty()) {
                    return;
                }
                switch (evt.getPropertyName()) {
                    case "strength":
                        //Testing that ST+DX<25
                        if ( ((dexterity+(int)evt.getNewValue())>24) || ((int)evt.getNewValue()<1) ) {       
                            throw new PropertyVetoException("This is the strength veto exception", evt);
                        }
                        break;
                    case "dexterity":
                        //Testing that ST+DX<25
                        if ( ((strength+(int)evt.getNewValue())>24) || ((int)evt.getNewValue()<1) ) {                
                            throw new PropertyVetoException("This is the dexterity veto exception", evt);	
                        }
                        break;
                }
            }   
    }
 
}
