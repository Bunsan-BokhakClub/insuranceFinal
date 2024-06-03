package payment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentListImpl implements PaymentList {

	private ArrayList<Payment> paymentList;

	public PaymentListImpl() {
		this.paymentList = new ArrayList<Payment>();
	}

	@Override
	public void add(Payment payment){
		paymentList.add(payment);
	}

	@Override
	public void delete(){

	}

	@Override
	public List<Payment> getPaymentListByCustomerID(String customerID) {
		return paymentList.stream()
				.filter(payment -> payment.getCustomerID().equals(customerID))
				.collect(Collectors.toList());
	}

	@Override
	public void update(){

	}

}