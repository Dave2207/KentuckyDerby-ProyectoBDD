package logic;

public class Account {
	private int accountNo;
	private boolean hasMembership;
	
	public Account(int accountNo, boolean hasMembership) {
		super();
		this.accountNo = accountNo;
		this.hasMembership = hasMembership;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public boolean isHasMembership() {
		return hasMembership;
	}

	public void setHasMembership(boolean hasMembership) {
		this.hasMembership = hasMembership;
	}
	
	
}
