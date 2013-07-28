package at.Owens79.ItemSlots;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;


public class SignControl {

	private ItemSlots plugin;
	
	
	private Display display;

	private final int MARKER_LINE = 0;
	private final int ODDS_LINE = 1;
	private final int PAY_LINE = 2;

	private Sign sign;
	private Block block;

	private String marker;
	private String printMarker;

	private int maxOdds;
	private int baseOdds;
	private int printOdds;

	private int maxPay;
	private int basePay;
	private int printPay;


	public SignControl(ItemSlots plugin) {

		this.plugin = plugin;
		this.display = new Display();

	}

	public void setBlock(Block block){

		this.block = block;
	}

	public void printSign(){

		sign.update();
	}

	/****************************
	 * setSign()
	 * 
	 * @param Block
	 ****************************/
	public void setSign() {

		Sign sign = null;
		
		if(this.isWallSign(block)){

			try {

				sign = (Sign) block.getState();
			}

			catch (Exception e) {

				e.printStackTrace();
			}

			this.sign = sign;

		}
	}

	/****************************
	 * setSign(Block block)
	 * 
	 * @param Block
	 ****************************/
	public void setSign(Block block) {
		
		this.setBlock(block);
		
		this.setSign();
	}
	
	
	/************************************
	 * isWallSign()
	 * 
	 * @param Block
	 * @return is checked block a wall sign
	 ************************************/
	public boolean isWallSign(Block block) {
		
		return block.getType().equals(Material.WALL_SIGN);

	}
	

	public void setMarker(){

		marker = plugin.getConfig().getString(PathNames.MARK_LINE);
	}

	public void setPrintMarker(){

		printMarker = sign.getLine(this.MARKER_LINE);
	}

	public void setMaxOdds() {

		maxOdds = 0;

		maxOdds =  plugin.getConfig().getInt(PathNames.MAX_ODDS);

	}

	public void setMaxPay() {

		maxPay = 0;

		maxPay = plugin.getConfig().getInt(PathNames.MAX_PAY_OUT);
	}

	public void setBaseOdds() {

		baseOdds = 0;

		baseOdds = plugin.getConfig().getInt(PathNames.BASE_ODDS);
		
		//display.toCon("Base Odds is " + this.baseOdds);
	}

	public void setBasePay() {

		basePay = 0;

		basePay = plugin.getConfig().getInt(PathNames.BASE_PAY_OUT);
		
		//display.toCon("Base Pay is " + this.basePay);

	}

	public int lineConvert(String line){

		// display.toCon("Entered lineConvert");
		
		int num = 0;

		if(line.isEmpty()){

			num = 0;
		}

		else {

			num = Integer.parseInt(line) ;
		}

		return num;

	}//lineConvert

	public void setPrintedOdds() {

		String lineOdds = null;

		printOdds = 0;

		lineOdds = sign.getLine(ODDS_LINE);

		printOdds = lineConvert(lineOdds);
		
		//display.toCon("Printed pay is " + this.printPay);

	}//setPrintedOdds

	public void setPrintedPay() {

		String linePay = null;

		printPay = 0;

		linePay = sign.getLine(PAY_LINE);
		
		printPay = lineConvert(linePay);

	}



	public void setLines() {

		this.setMarker();
		this.setPrintMarker();

		this.setBaseOdds();
		this.setMaxOdds();
		this.setPrintedOdds();

		this.setBasePay();
		this.setMaxPay();
		this.setPrintedPay();

	}//setLines



	public boolean isGreater(int a, int b) {

		return a > b;

	}//isGreater(int, int)

	public boolean isLesser(int a, int b) {

		return a < b;

	}//isLesser(int, int)

	public boolean isEqual(int a, int b) {

		return a == b;

	}//isEqual(int, int)

	public boolean isEqual(String a, String b) {

		return a.equalsIgnoreCase(b);

	}//isEqual(String, String)

	public boolean oddsIsLessThanMax() {

		return isLesser(printOdds, maxOdds);

	}//OddsLessMax

	public boolean oddsIsHigherThanMax(){

		return isGreater(printOdds, maxOdds);

	}//OddsHigherMax

	public boolean oddsIsLessThanZero(){

		return isLesser(printOdds, 0);

	}//OddsLessZero

	public boolean oddsHigherIsThanZero() {

		return isGreater(printOdds, 0);

	}//OddsHigherZero
	

	public boolean payIsLessThanMax() {

		return isLesser(printPay, maxPay);

	}//PayLessMax

	public boolean payIsHigherThanMax(){

		return isGreater(printPay, maxPay);

	}//PayHigherMax

	public boolean payIsLessThanZero(){

		return isLesser(printPay, 0);

	}//PayLessZero

	public boolean payIsHigherThanZero() {

		return isGreater(printPay, 0);

	}//PayHigherZero

	public boolean isMarkerValid() {

		return isEqual(marker, printMarker);

	}//isMarkerValid
	

	public void print(int a, int line) {
		
		String arg = Integer.toString(a);
		
		sign.setLine(line, arg);
		
		sign.update();
	}
	
	public void print(String arg, int line) {
		
		sign.setLine(line, arg);
		
		sign.update();
	}
	
	public void printMarker() {
			
			this.print(marker, MARKER_LINE);
	}
	
	public void checkOddsHigh() {
		
		if(oddsIsHigherThanMax()) {
			
			print(this.maxOdds, this.ODDS_LINE);
		}
	}
	
	public void checkOddsLow() {
		
		if(!this.oddsHigherIsThanZero()){
			
			print(this.baseOdds, this.ODDS_LINE);
		}
	}
	
	public void checkPayHigh() {
		
		if(this.payIsHigherThanMax()){
			
			print(this.maxPay, this.PAY_LINE);
		}
	}
	
	public void checkPayLow() {
		
		if(!this.payIsHigherThanZero()) {
			
			print(this.basePay, this.PAY_LINE);
		}
	}
	
	public int getMaxOdds() {
		
		return this.maxOdds;
	}
	
	public int getBaseOdds() {
		
		return this.baseOdds;
	}

	public int getPrintedOdds() {
		
		return this.printOdds;
	}
	
	public int getMaxPay() {
		
		return this.maxPay;
	}
	
	public int getBasePay() {
		
		return this.basePay;
	}
	
	public int getPrintedPay() {
		
		return this.printPay;
	}
	
	public Sign getSign(){
		
		return this.sign;
	}
	
	public void showLines() {
		
		display.toCon(printMarker);
		display.toCon(printOdds);
		display.toCon(printPay);	
	}
	
}//SignControl
