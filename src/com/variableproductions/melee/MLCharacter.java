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
        currentArmour = JavaMelee.myController.armourDatabase.armour[0];
	weaponOne = JavaMelee.myController.weaponDatabase.weapons[0];
	weaponTwo = JavaMelee.myController.weaponDatabase.weapons[0];
	currentDagger = JavaMelee.myController.weaponDatabase.daggers[0];
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
