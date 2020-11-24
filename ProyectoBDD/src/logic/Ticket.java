package logic;

public class Ticket {
	private int code;
	private String paymentMode;
	private float price;
	private Horse BetHorse;
	private String DateRace;
	private String TimeRace;
	private String DatePurchase;
	private String TimePurchase;
	
	public Ticket(int code, String paymentMode, float price, Horse betHorse, String dateRace, String timeRace,
			String datePurchase, String timePurchase) {
		super();
		this.code = code;
		this.paymentMode = paymentMode;
		this.price = price;
		BetHorse = betHorse;
		DateRace = dateRace;
		TimeRace = timeRace;
		DatePurchase = datePurchase;
		TimePurchase = timePurchase;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Horse getBetHorse() {
		return BetHorse;
	}

	public void setBetHorse(Horse betHorse) {
		BetHorse = betHorse;
	}

	public String getDateRace() {
		return DateRace;
	}

	public void setDateRace(String dateRace) {
		DateRace = dateRace;
	}

	public String getTimeRace() {
		return TimeRace;
	}

	public void setTimeRace(String timeRace) {
		TimeRace = timeRace;
	}

	public String getDatePurchase() {
		return DatePurchase;
	}

	public void setDatePurchase(String datePurchase) {
		DatePurchase = datePurchase;
	}

	public String getTimePurchase() {
		return TimePurchase;
	}

	public void setTimePurchase(String timePurchase) {
		TimePurchase = timePurchase;
	}
	
	
}
