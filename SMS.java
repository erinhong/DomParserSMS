package main.java;

public class SMS {
    private String id;
    private String text;
    private String country; // from source 
    private String srcID;
    private String collector;// from collection Method 
    private String year; //from collection Method 


    public SMS(){} 

    public SMS(String id, String text, String country, String srcID, String collector, String year) {
        this.id = id; 
        this.text= text; 
        this.country= country; 
        this.srcID=srcID; 
        this.collector= collector; 
        this.year=year; 
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCountry(String country){
        this.country = country; 
    }
    
    public void setSourceID(String srcID){
        this.srcID = srcID;
    }
    
    public void setCollector(String collector){
        this.collector = collector; 
    }
    
    public void setYear(String year){
        this.year = year; 
    }
    

    @Override
    public String toString() {
            return "<" + id + ", " + text + ", " + country + ", " + srcID + ", " + collector + ", "+ year+ ">";
    }
}
