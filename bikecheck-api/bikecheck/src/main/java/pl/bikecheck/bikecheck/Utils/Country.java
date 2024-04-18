package pl.bikecheck.bikecheck.Utils;

public enum Country {
    POLAND("PL"),
    SWEDEN("SW"),
    UNITED_STATES("US");
    private String code;
    Country(String code){
        this.code=code;
    }
    public String getCode(){
        return code;
    }


}
