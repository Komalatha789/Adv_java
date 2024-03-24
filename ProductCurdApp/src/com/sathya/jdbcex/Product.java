package com.sathya.jdbcex;

public class Product {

int ProId;
 String ProName;
 double Proprice;

public Product(int proId, String proName, double proprice) {

	super();
	this.ProId = proId;
	this.ProName = proName;
	this.Proprice = proprice;
	
}
public int getProId() {
	return ProId;
}
public void setProId(int proId) {
	this.ProId = proId;
}
public String getProName() {
	return ProName;
}
public void setProName(String proName) {
	this.ProName = proName;
}
public double getProprice() {
	return Proprice;
}
public void setProprice(double proprice) {
	this.Proprice = proprice;
}
@Override
public String toString() {
	return "Product [ProId=" + ProId + ", ProName=" + ProName + ", Proprice=" + Proprice + "]";
}
public Product()
{
}
}
 
