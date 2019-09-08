//needed for exception handling examples
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

//this class has package visibility
class Box {
	//all state variables MUST be private, period
	private int width = 20;
	private int height = 10;
	private String hLineSymbol = "-";
	private String vLineSymbol = "|";

	//special method - constructor, must be public and returns nothing
	public Box() { //this is default, does nothing

	}

	//you can have as many constructors
	//this one requires you to provide different parameters
	public Box(int w, int h, String hLine, String vLine) {
		width = w;
		height = h;
		hLineSymbol = hLine;
		vLineSymbol = vLine;
	}

	//Accessory methods exposed to uses with public keyword
	//does not alter the internal state of objects
	public int findHeight() {
		return height;
	}

	public int findWidth() {
		return width;
	}

	public String findVLSymbol() {
		return vLineSymbol;
	}

	public String findHLSymbol() {
		return hLineSymbol;
	}

	//mutator methods, changes the state of objects
	public void changeHLineSymbol(String hLine) {
		hLineSymbol = hLine;
	}

	public void changeVLineSymbol(String vLine) {
		vLineSymbol = vLine;
	}

	public void changeWidth(int newWidth) {
		width = newWidth;
	}

	public void changeHeight(int newHeight) {
		height = newHeight;
	}

	////Important note:  check how I transformed this code, why?  Which one is better?
	/*
	 public void drawHorizontalLine() {
		int count = 0;
		while (count++ < width)
			System.out.printf(hLineSymbol);
		System.out.printf("\n");
	}

	void drawVerticalLines() {
		int count = 0, count2 = 0;
		while (count++ < height) {
			System.out.printf(vLineSymbol);
			count2 = 0;
			while (count2++ < width - 2)
				System.out.printf(" ");
			System.out.printf(vLineSymbol + "\n");
		}
	}

	public void drawBox() {
		drawHorizontalLine();
		drawVerticalLines();
		drawHorizontalLine();
	}
	*/
	
	//internal behaviors, changes here can be done anytime
	private void drawHorizontalLine(String tempHChar, int tempHSize) {
		int count = 0;
		while (count++ < tempHSize)
			System.out.printf(tempHChar);
	}

	private void drawVerticalLines() {
		int count = 0, count2 = 0;
		while (count++ < findHeight() - 2) {
			System.out.printf(findVLSymbol());
			count2 = 0;
			drawHorizontalLine(" ", findWidth() - 2);
			System.out.printf(findVLSymbol() + "\n");
		}
	}

	//public interface, interface can't be changed, otherwise caller needs to be changed
	//however, the internal code can be changed anytime
	public void drawBox() {
		drawHorizontalLine(findHLSymbol(), findWidth());
		System.out.printf("\n");
		drawVerticalLines();
		drawHorizontalLine(findHLSymbol(), findWidth());
		System.out.printf("\n");
	}
}//Box

//FancyBox is a Box, which also can selectively have provide ability to fill the box with a character
//now the Box class needs to change a bit.  However, we can do this without breaking others who were
//still using Box class as is.
class FancyBox extends Box {
	//has all the internal state of Box and also has
	private String fillSymbol;

	//default constructor
	public FancyBox() {
		super();
		fillSymbol = " "; //must initialize it
	}

	public FancyBox(String fillSymbol, int w, int h, String hLine, String vLine) {
		super(w,h, hLine, vLine); //first the parent is build
		this.fillSymbol = fillSymbol;
	}
	
	//these codes are generated by eclipse -- using Source menue and Generate option
	public FancyBox(String fillSymbol) {
		super();
		this.fillSymbol = fillSymbol;
	}

	/**
	 * @return the fillSymbol
	 */
	public String getFillSymbol() {
		return fillSymbol;
	}

	/**
	 * @param fillSymbol the fillSymbol to set
	 */
	public void setFillSymbol(String fillSymbol) {
		this.fillSymbol = fillSymbol;
	}
	
	////Note: We don't want to break the old code, so, for now, we will rewrite code
	private void drawHorizontalLine(String tempHChar, int tempHSize) {
		int count = 0;
		while (count++ < tempHSize)
			System.out.printf(tempHChar);
	}

	private void drawVerticalLines(String fillChar) {
		int count = 0;
		while (count++ < findHeight() - 2) {
			System.out.printf(findVLSymbol());
			drawHorizontalLine(fillChar, findWidth() - 2);
			System.out.printf(findVLSymbol() + "\n");
		}
	}

	//public interface, interface can't be changed, otherwise caller needs to be changed
	//however, the internal code can be changed anytime
	public void drawBox() {
		drawHorizontalLine(findHLSymbol(), findWidth());
		System.out.printf("\n");
		drawVerticalLines(getFillSymbol());
		drawHorizontalLine(findHLSymbol(), findWidth());
		System.out.printf("\n");
	}
}
public class Demo_UnitIV_ClassObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
 		//this is user of my box class. My .drawBox completely got revamped internally,
		// but the user of my class had no impact.
		Box bBox = new Box();
		System.out.println(bBox.findHeight());
		System.out.println(bBox.findWidth());
		System.out.println(bBox.findVLSymbol());
		System.out.println(bBox.findHLSymbol());
		bBox.drawBox();

		bBox.changeHeight(8);
		bBox.changeWidth(8);
		bBox.changeHLineSymbol("*");
		bBox.changeVLineSymbol("*");
		System.out.println(bBox.findHeight());
		System.out.println(bBox.findWidth());
		System.out.println(bBox.findVLSymbol());
		System.out.println(bBox.findHLSymbol());
		bBox.drawBox();
		
		//Inheritance.  Let us user our Fancy Box
		FancyBox defaultFancyBox = new FancyBox();
		defaultFancyBox.drawBox();
		
		//box filled with future stars like you
		FancyBox starFancyBox = new FancyBox("*");
		starFancyBox.drawBox();
		
		//that was not much of fun, how about box filled with dollars, that is more like it
		FancyBox dollarFancyBox = new FancyBox("$");
		dollarFancyBox.drawBox();
	}
}
