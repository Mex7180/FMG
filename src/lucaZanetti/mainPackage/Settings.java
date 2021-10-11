package lucaZanetti.mainPackage;

import java.awt.Point;
import java.io.File;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.util.ArrayList;

public class Settings {
	/* Class where all settings are saved
	 * To all variables there are getters
	 * and setters
	 */
	static int AmountOfPoints = 150;
	static int FactorPointToWindowHeight = 5;
	static int FactorPointToWindowWidth = 5;
	static int RandomIntervall = 50;
	static String mainPath = Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent().toString();
	public static String SettingsPath = mainPath+"/res/FMGSettings.txt";
	public static String imagePath = mainPath+"/res/";

	static boolean CreateFileOf = true;
	public static int IterationAmount = 300;
	public static int IterationAmountSD = 10;
	public static int amountRandValues = 3;
	public static int IterationAmountPolyLine2 = 6;
	

	public static int Case = 10;

	public static int WindowXPosition = 400;
	public static int WindowYPosition = 200;
	public static String title = "WINDOW";
	public static int WindowLengh = (Settings.AmountOfPoints)*(Settings.FactorPointToWindowHeight);
	public static int WindowHeight = (Settings.AmountOfPoints)*(Settings.FactorPointToWindowWidth);
	public static Point JMCCornerPoint1 = new Point(0,0);
	public static Point JMCornerPoint2 = new Point(WindowLengh,WindowHeight);
	public static double differenceX = Math.abs(JMCornerPoint2.x-JMCCornerPoint1.x);
	public static double differenceY = Math.abs(JMCornerPoint2.y-JMCCornerPoint1.y);
	
	public static double JMCRadius = 3.0;
	public static double JMCBasicFactor = 3.0/WindowLengh;
	public static ComplexNumber C = new ComplexNumber(-0.6, -0.6);
	public static ComplexNumber Z = new ComplexNumber(0, 0);
	public static double JMCdifference = Math.max(differenceX, differenceY)*JMCBasicFactor;
	public static double JMCVariableFactor = JMCdifference/WindowLengh;
	
	public static int factorYValue = 6;
	public static int amountOfFrequencies = 300;
	
	public static ArrayList<Point> pointsTSPS = new ArrayList<>();
	public static boolean canPlacePoints = true;
	
	public static int amountIterationsMPD = 8;
	public static Point AMPD = new Point(100, 400);
	public static Point BMPD = new Point(500, 400);
	public static int factorGaussianRand = 6;
	
	//getters and setters for all variables
	private static void refreshPaths() {
		setSettingsPath(Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent().toString()+"/res/FMGSettings.txt");
		setImagePath(Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent().toString()+"/res/");
	}
	
	public static String getImagePath() {
		refreshPaths();
		return imagePath;
	}

	public static void setImagePath(String imagePath) {
		Settings.imagePath = imagePath;
	}
	public static int getAmountIterationsMPD() {
		return amountIterationsMPD;
	}

	public static void setAmountIterationsMPD(int amountIterations) {
		amountIterationsMPD = amountIterations;
	}

	public static Point getAMPD() {
		return AMPD;
	}

	public static void setAMPD(Point aMPD) {
		Settings.AMPD = aMPD;
	}

	public static Point getBMPD() {
		return BMPD;
	}

	public static void setBMPD(Point bMPD) {
		BMPD = bMPD;
	}

	public static int getFactorGaussianRand() {
		return factorGaussianRand;
	}

	public static void setFactorGaussianRand(int factorGaussianRand) {
		Settings.factorGaussianRand = factorGaussianRand;
	}


	public static int getAmountRandValues() {
		return amountRandValues;
	}

	public static void setAmountRandValues(int amountRandValues) {
		Settings.amountRandValues = amountRandValues;
	}
	
	public static boolean getCanPlacePoints() {
		return canPlacePoints;
	}



	public static void setCanPlacePoints(boolean canPlacePoints) {
		Settings.canPlacePoints = canPlacePoints;
	}



	public static ArrayList<Point> getPointsTSPS() {
		return pointsTSPS;
	}



	public static void setPointsTSPS(ArrayList<Point> pointsTSPS) {
		Settings.pointsTSPS = pointsTSPS;
	}
	
	public static void addPointTSPS(Point p) {
		pointsTSPS.add(p);
	}

	public static void clearPointsTSPS() {
		pointsTSPS.clear();
	}

	public static int getAmountOfFrequencies() {
		return amountOfFrequencies;
	}



	public static void setAmountOfFrequencies(int amountOfFrequencies) {
		Settings.amountOfFrequencies = amountOfFrequencies;
	}



	public static int getFactorYValue() {
		return factorYValue;
	}



	public static void setFactorYValue(int factorYValue) {
		Settings.factorYValue = factorYValue;
	}

	
	public static double getJMCVariableFactor() {
		return JMCVariableFactor;
	}



	public static void setJMCVariableFactor(double jMCVariablerFaktor) {
		JMCVariableFactor = jMCVariablerFaktor;
	}

	private static Point StartPointSnowFlake = new Point(100, 300);
	private static Point EndPointSnowFlake = new Point(600, 300);
	
	
	
	public ComplexNumber getC(){
		return C;
	}
	
	
	
	public ComplexNumber getZ(){
		return Z;
	}
	
	public void setWindowHeight(int hight){
		WindowHeight = hight;
	}
	
	public void setWindowLengh(int lengh){
		WindowHeight = lengh;
	}
	
	public static Point getStartPunktSF() {
		return StartPointSnowFlake;
	}
	
	public static Point getEndPunktSF() {
		return EndPointSnowFlake;
	}
	
	public void setStartPunktSF(Point p) {
		StartPointSnowFlake.setLocation(p);
	}
	
	public void setStartPunktSF(int x, int y) {
		StartPointSnowFlake.setLocation(x,y);
	}
	
	public void setEndPunktSF(Point p) {
		EndPointSnowFlake.setLocation(p);
	}
	
	public void setEndPunktSF(int x, int y) {
		EndPointSnowFlake.setLocation(x,y);
	}
	
	public static void setCase(int c) {
		Case = c;
	}
	
	public void setAnzahlPunkte(int anzahl){
		AmountOfPoints = anzahl;
	}

	public static void setAmountOfPoints(int aNZAHLPUNKTE) {
		AmountOfPoints = aNZAHLPUNKTE;
	}

	public static void setFactorPointToWindowHeight(int fAKTORPUNKTEZUFENSTERLAENGE) {
		FactorPointToWindowHeight = fAKTORPUNKTEZUFENSTERLAENGE;
	}

	public static void setFactorPointToWindowWidth(int fAKTORPUNKTEZUFENSTERBREITE) {
		FactorPointToWindowWidth = fAKTORPUNKTEZUFENSTERBREITE;
	}

	public static void setRandomIntervall(int randomIntervall) {
		RandomIntervall = randomIntervall;
	}

	public static void setMainpath(String mAINPATH) {
		mainPath = mAINPATH;
	}

	public static void setCreateFileOf(boolean createFileOf) {
		CreateFileOf = createFileOf;
	}

	public static void setIterationAmount(int iTERATIONENANZAHL) {
		IterationAmount = iTERATIONENANZAHL;
	}

	public static void setWindowXPosition(int windowXPosition) {
		WindowXPosition = windowXPosition;
	}

	public static void setWindowYPosition(int windowYPosition) {
		WindowYPosition = windowYPosition;
	}

	public static void setTitle(String title) {
		Settings.title = title;
	}

	public static void setC(ComplexNumber c) {
		C = c;
	}

	public static void setZ(ComplexNumber z) {
		Z = z;
	}

	public static void setStartPointSnowFlake(Point startPunktSchneeFlocke) {
		StartPointSnowFlake = startPunktSchneeFlocke;
	}

	public static void setEndPointSnowFlake(Point endPunktSchneeFlocke) {
		EndPointSnowFlake = endPunktSchneeFlocke;
	}

	public static int getAmountOfPoints() {
		return AmountOfPoints;
	}

	public static int getFactorPointToWindowHeight() {
		return FactorPointToWindowHeight;
	}

	public static int getFactorPointToWindowWidth() {
		return FactorPointToWindowWidth;
	}

	public static int getRandomIntervall() {
		return RandomIntervall;
	}


	public static String getMainpath() {
		refreshPaths();
		return mainPath;
	}

	public static boolean isCreateFileOf() {
		return CreateFileOf;
	}

	public static int getIterationAmount() {
		return IterationAmount;
	}

	public static int getCase() {
		return Case;
	}

	public static int getWindowXPosition() {
		return WindowXPosition;
	}

	public static int getWindowYPosition() {
		return WindowYPosition;
	}

	public static String getTitle() {
		return title;
	}

	public static int getWindowLengh() {
		return WindowLengh;
	}

	public static int getWindowHeight() {
		return WindowHeight;
	}

	public static Point getStartPointSnowFlake() {
		return StartPointSnowFlake;
	}

	public static Point getEndPointSnowFlake() {
		return EndPointSnowFlake;
	}



	public static double getJMCBasicFactor() {
		return JMCBasicFactor;
	}



	public void setJMCBasicFactor(double jMCFaktor) {
		JMCBasicFactor = jMCFaktor;
	}

	public static Point getJMCCornerPoint1() {
		return JMCCornerPoint1;
	}

	public static void setJMCCornerPoint1(Point jMCEckPunkt1) {
		JMCCornerPoint1 = jMCEckPunkt1;
	}

	public static Point getJMCornerPoint2() {
		return JMCornerPoint2;
	}

	public static void setJMCornerPoint2(Point jMCEckPunkt2) {
		JMCornerPoint2 = jMCEckPunkt2;
	}

	public static double getDifferenceX() {
		return differenceX;
	}

	public static void setDifferenceX(double differenzX) {
		Settings.differenceX = differenzX;
	}

	public static double getDifferenceY() {
		return differenceY;
	}

	public static void setDifferenceY(double differenzY) {
		Settings.differenceY = differenzY;
	}

	public static double getJMCdifference() {
		return JMCdifference;
	}

	public static void setJMCdifference(double jMCdifferenz) {
		JMCdifference = jMCdifferenz;
	}

	public static double getJMCRadius() {
		return JMCRadius;
	}

	public static void setJMCRadius(double jMCRadius) {
		JMCRadius = jMCRadius;
	}



	public static int getIterationAmountSD() {
		return IterationAmountSD;
	}



	public static void setIterationAmountSD(int iterationenSD) {
		IterationAmountSD = iterationenSD;
	}



	public static String getSettingsPath() {
		refreshPaths();
		return SettingsPath;
	}



	public static void setSettingsPath(String settingsPath) {
		SettingsPath = settingsPath;
	}

	public static int getIterationAmountPolyLine2() {
		return IterationAmountPolyLine2;
	}

	public static void setIterationAmountPolyLine2(int iterationAmountPolyLine2) {
		IterationAmountPolyLine2 = iterationAmountPolyLine2;
	}

	

}
