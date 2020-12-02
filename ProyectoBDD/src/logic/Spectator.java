package logic;

public class Spectator {
	
	private int TicketNo;
	private int BetAmount; 
	private int AccountNo;
	
public Spectator(int ticketNo, int betAmount, int accountNo) {
		super();
		TicketNo = ticketNo;
		BetAmount = betAmount;
		AccountNo = accountNo;
	}
	//	*** Getters & Setters****
	public int getTicketNo() {
		return TicketNo;
	}
	public void setTicketNo(int ticketNo) {
		TicketNo = ticketNo;
	}
	public int getBetAmount() {
		return BetAmount;
	}
	public void setBetAmount(int betAmount) {
		BetAmount = betAmount;
	}
	public int getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	} 

}

