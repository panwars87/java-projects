/**
 * 
 */
package com.exp.learning.adapter;

import com.exp.learning.annotations.ClassDefine;

@ClassDefine(
		author = "Shashant P", 
		className = "RunAdapterExample.class", 
		currentVersion = 1, 
		date = "10/26/2016", 
		description = "A class to run adapter design pattern example.", 
		reviews = { "Shashant" }
)
public class RunAdapterExample {

	public static void main(String[] args) {
		
		// Object for Xpay
		Xpay xpay = new XpayImpl();
		xpay.setCreditCardNo("4789565874102365");
		xpay.setCustomerName("Max Warner");
		xpay.setCardExpMonth("09");
		xpay.setCardExpYear("25");
		xpay.setCardCVVNo((short)235);
		xpay.setAmount(2565.23);
		
		PayD payD = new XpayToPayDAdapter(xpay);
		testPayD(payD);
	}
	
	private static void testPayD(PayD payD){
		
		System.out.println(payD.getCardOwnerName());
		System.out.println(payD.getCustCardNo());
		System.out.println(payD.getCardExpMonthDate());
		System.out.println(payD.getCVVNo());
		System.out.println(payD.getTotalAmount());
	}
}
