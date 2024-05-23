package compensation;

import partner.Partner;

public class Servey {

	private String claimantName;
	private String bank;
	private String accountNumber;
	private String accountHolder;
	private int serveyAmount;
	public Partner partner;

	public Servey(String claimantName, String bank,
				  String accountNumber, String accountHolder, int serveyAmount, Partner partner) {

		this.claimantName = claimantName;
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.serveyAmount = serveyAmount;
		this.partner = partner;
	}

}