import java.util.Objects;

public class laptop {
  
  private String brand;
  
  private int HDD;
  
  private int RAM;
  
  private String OS;

  public laptop(String OS, int RAM, int HDD, String brand) {
    this.OS = OS;
    this.RAM = RAM;
    this.HDD = HDD;
    this.brand = brand;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public int getHDD() {
    return HDD;
  }

  public void setHDD(int HDD) {
    this.HDD = HDD;
  }

  public int getRAM() {
    return RAM;
  }

  public void setRAM(int RAM) {
    this.RAM = RAM;
  }

  public String getOS() {
    return OS;
  }

  public void setOS(String OS) {
    this.OS = OS;
  }

  @Override
  public String toString() {
    return "laptop{" +
           "brand='" + brand + '\'' +
           ", HDD=" + HDD +
           ", RAM=" + RAM +
           ", OS='" + OS + '\'' +
           '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    laptop laptop = (laptop) obj;
    return brand.equals(laptop.brand) && HDD == laptop.HDD && RAM == laptop.RAM && OS.equals(laptop.OS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(brand, HDD, RAM, OS);
  }

}

