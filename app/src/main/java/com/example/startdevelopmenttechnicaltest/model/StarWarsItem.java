package com.example.startdevelopmenttechnicaltest.model;

public class StarWarsItem {
    private String mPlanetName;
    private String mPopulation;
    private String mDiameter;
    private String mClimate;
    private String mRotation;
    private String mOrbital;
    private String mGravity;
    private String mTerrain;
    private String mSurface;


    public StarWarsItem(String mPlanetName, String mPopulation, String mDiameter, String mClimate, String mRotation, String mOrbital, String mGravity, String mTerrain, String mSurface) {
        this.mPlanetName = mPlanetName;
        this.mPopulation = mPopulation;
        this.mDiameter = mDiameter;
        this.mClimate = mClimate;
        this.mRotation = mRotation;
        this.mOrbital = mOrbital;
        this.mGravity = mGravity;
        this.mTerrain = mTerrain;
        this.mSurface = mSurface;
    }

    public String getmPlanetName() {
        return mPlanetName;
    }

    public String getmPopulation() {
        return mPopulation;
    }

    public String getmDiameter() {
        return mDiameter;
    }

    public String getmClimate() {
        return mClimate;
    }

    public String getmRotation() {
        return mRotation;
    }

    public String getmOrbital() {
        return mOrbital;
    }

    public String getmGravity() {
        return mGravity;
    }

    public String getmTerrain() {
        return mTerrain;
    }

    public String getmSurface() {
        return mSurface;
    }
}

