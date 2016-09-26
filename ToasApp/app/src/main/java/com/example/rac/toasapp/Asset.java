package com.example.rac.toasapp;

/**
 * Created by Rac on 9/26/2016.
 *
 * This class represents an asset, what it has and what i can do.
 */

public class Asset {

    private String assetName, assetDesc;
    private double expectedLife, cost, age;
    private AssetFlowChart flowchart;

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetDesc() {
        return assetDesc;
    }

    public void setAssetDesc(String assetDesc) {
        this.assetDesc = assetDesc;
    }

    public double getExpectedLife() {
        return expectedLife;
    }

    public void setExpectedLife(double expectedLife) {
        this.expectedLife = expectedLife;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public AssetFlowChart getFlowchart() {
        return flowchart;
    }

    public void setFlowchart(AssetFlowChart flowchart) {
        this.flowchart = flowchart;
    }

}
