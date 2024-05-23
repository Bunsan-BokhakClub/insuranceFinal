package payment;

import java.time.LocalDateTime;

public class Payment {

	private String customerID;
	private String insuranceID;
	private int paymentAmount;
	private String paymentDate;
	private String bank;
	private String accountNumber;
	private String accountHolder;
	private boolean whetherPayment;

	public Payment(String customerID, String insuranceID, int paymentAmount,
				   String bank, String accountNumber, String accountHolder) {
		this.accountHolder = accountHolder;
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.customerID = customerID;
		this.insuranceID = insuranceID;
		this.paymentAmount = paymentAmount;
		this.paymentDate = LocalDateTime.now().toString();
		this.whetherPayment = true;
	}

	public String  getCustomerID() {
		return customerID;
	}
}