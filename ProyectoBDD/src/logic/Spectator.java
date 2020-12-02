package logic;

public class Spectator {
	
	private int TicketNo;
	private float BetAmount; 
	private int AccountNo;
	
public Spectator(int ticketNo, float betAmount, int accountNo) {
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
	public float getBetAmount() {
		return BetAmount;
	}
	public void setBetAmount(float betAmount) {
		BetAmount = betAmount;
	}
	public int getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	} 

}

