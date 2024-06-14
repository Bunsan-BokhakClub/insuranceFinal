package contract;

import compensation.CompensationClaim;
import compensation.CompensationClaimList;
import compensation.CompensationClaimListImpl;
import customer.Customer;
import insurance.Insurance;
import payment.PaymentListImpl;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Contract {

// 중복된 명사 지우기

	private String contractID;
	private String concludeDate;
	private String endDate;
	private PaymentListImpl paymentList;
	private Customer customer;
	private Insurance insurance;


	public CompensationClaimListImpl compensationClaimList;

	public Contract(Customer customer, Insurance insurance, String date) {

		this.customer = customer;
		this.insurance = insurance;

		this.compensationClaimList = new CompensationClaimListImpl();
		this.concludeDate = date;
		this.contractID = customer.getCustomerID() + insurance.getInsuranceID();
		this.endDate = addYearsToDate();
		this.paymentList = new PaymentListImpl();
	}

	@Override
	public String toString() {
		return  "고객 ID = " + customer.getCustomerID() + '\n' +
				", 이름='" + customer.getName() + '\n' +
				", 성별='" + customer.getGender() + '\n' +
				", 생년월일='" + customer.getBirth() + '\n' +
				", 전화번호='" + customer.getPhoneNumber() + '\n' +
				", 주소='" + customer.getAddress() + '\n' +
				", 보험 ID='" + insurance.getInsuranceID() + '\n' +
				", 보험 이름='" + insurance.getInsuranceName() + '\n' +
				", 보험료=" + insurance.getPaymentAmount() + '\n' +
				", 보상금=" + insurance.getCompensationAmount() + "\n" +
				", 갱신 상태='" + insurance.getCycleType() + '\n' +
				", 갱신 주기='" + insurance.getPaymentCycle() + '\n' +
				", 보험 기간='" + insurance.getInsurancePeriod() + '\n' +
				'}' + '\n' + "\n";
	}

	private String addYearsToDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(this.concludeDate, formatter);
		LocalDateTime newDateTime = dateTime.plusYears(Integer.parseInt(insurance.getInsurancePeriod()));
		return newDateTime.format(formatter);
	}

	public double calculateCancelMoney(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime endDateTime = LocalDateTime.parse(this.endDate, formatter);

		Period endPeriod = Period.between(now.toLocalDate(), endDateTime.toLocalDate());
		int endTotalMonths = endPeriod.getYears() * 12 + endPeriod.getMonths();
		if (endTotalMonths > 12) {
			return insurance.getPaymentAmount() * 0.6;
		} else if (endTotalMonths > 0) {
			return insurance.getPaymentAmount() * 0.4;
		} else {
			return 0; // 만기일이 지났거나 오늘인 경우 환급금 없음
		}
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public PaymentListImpl getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(PaymentListImpl paymentList) {
		this.paymentList = paymentList;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getConcludeDate() {
		return concludeDate;
	}

	public void setConcludeDate(String concludeDate) {
		this.concludeDate = concludeDate;
	}

	public String getContractID() {
		return contractID;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
	}
}
