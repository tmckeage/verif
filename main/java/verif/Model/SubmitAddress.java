package verif;

import java.io.Serializable;
 
public class SubmitAddress implements Serializable {

  private String addressee;
  private String street;
  private String street2;
  private String city;
  private String state;
  private String zipcode;
  private int candidates;

  public String getAddressee() {
    return this.addressee;
  }
  public void setAddressee(String addressee){
    this.addressee = addressee;
  }

  public String getStreet() {
    return this.street;
  }
  public void setStreet(String street){
    this.street = street;
  }

  public String getStreet2() {
    return this.street2;
  }
  public void setStreet2(String street2){
    this.street2 = street2;
  }

  public String getCity() {
    return this.city;
  }
  public void setCity(String city){
    this.city = city;
  }

  public String getState() {
    return this.state;
  }
  public void setState(String state){
    this.state = state;
  }

  public String getZipcode() {
    return this.zipcode;
  }
  public void setZipcode(String zipcode){
    this.zipcode = zipcode;
  }

  public int getCandidates() {
    return this.candidates;
  }
  public void setCandidates(int candidates){
    this.candidates = candidates;
  }
}