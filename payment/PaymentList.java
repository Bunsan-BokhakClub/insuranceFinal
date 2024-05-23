package payment;

import java.util.List;

public interface PaymentList {

	void add(Payment payment);

	void delete();

	List<Payment> getPaymentListByCustomerID(String customerID);

	void update();

}