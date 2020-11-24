package logic;

public class Spectator {
	
	private int TicketNo;
	private float BetAmount; 
	private int AccontNo;
	
public Spectator(int ticketNo, float betAmount, int accontNo) {
		super();
		TicketNo = ticketNo;
		BetAmount = betAmount;
		AccontNo = accontNo;
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
	public int getAccontNo() {
		return AccontNo;
	}
	public void setAccontNo(int accontNo) {
		AccontNo = accontNo;
	} 

}

