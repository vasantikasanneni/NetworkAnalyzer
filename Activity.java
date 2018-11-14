package com.pathlist;


public class Activity {
    private String actName;
    private String actDependencies;
    private int actDuration;

    public Activity()
    {
        
    }
    public Activity(String actName, String actDependencies, int actDuration) {
        this.actName = actName;
        this.actDependencies = actDependencies;
        this.actDuration = actDuration;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getActDependencies() {
        return actDependencies;
    }

    public void setActDependencies(String actDependencies) {
        this.actDependencies = actDependencies;
    }

    public int getActDuration() {
        return actDuration;
    }

    public void setActDuration(int actDuration) {
        this.actDuration = actDuration;
    }

    @Override
    public String toString() {
        return "Activity{" + "actName=" + actName + ", actDependencies=" + actDependencies + ", actDuration=" + actDuration + '}';
    }
    
    
    
}