import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
	private String name;
	private int [] score;
	private double finalScore;
	private byte grade;
	public Student(String [] line){
		// use one line data to extract student data
		this.name = line[0].trim();
		this.score = new int[line.length - 1];	// initial score array base on test numbers
		for(int i=0; i< this.score.length; i++){
			this.score[i] = Integer.parseInt(line[i+1].trim());
		}
	}
	public void calGrade() {
		// calculate student's final score and grade
		this.finalScore = (this.score[0] + this.score[1] + this.score[2] + this.score[3]) * 0.1 +
				this.score[4]*0.2 + this.score[5]*0.15 + this.score[6]*0.25;
		if(this.finalScore >= 90)
			this.grade = 'A';
		else if(this.finalScore >=80)
			this.grade = 'B';
		else if(this.finalScore >=70)
			this.grade = 'C';
		else if(this.finalScore >=60)
			this.grade = 'D';
		else
			this.grade = 'F';
	}
	public String getName(){
		return this.name;
	}
	public int getScore(int testNum){
		return this.score[testNum];
	}
	public char getGrade(){ 
		return (char)this.grade;
	}
	@Override
	public int compareTo(Student s) {
		// compare student object based on their names
		return this.getName().compareTo(s.getName());
	}
}

public class LetterGrader implements IGrader{
	private String inputFile;
	private String outputFile;
	private int studentNum;	// number of students
	private int testNum; // number of tests
	BufferedReader br = null;
	BufferedWriter bw = null;
	PrintWriter pw =null;
	private ArrayList<Student> studentArray = new ArrayList<Student>();
	public LetterGrader(String inp, String outp){
		// constructor method
		this.inputFile = inp;
		this.outputFile = outp;
	}
	public void readScore(){
		// reads score and stores the data in member variables
		String line;
		String [] splitedLine;
		try { 
			// create stream buffer
			this.br = new BufferedReader(new FileReader(this.inputFile));
			while ((line=br.readLine()) != null) {
				splitedLine = line.split(",");
				testNum = splitedLine.length - 1;
				this.studentArray.add(new Student(splitedLine));
			}
			this.studentNum = this.studentArray.size();
		}
		catch (Exception e) {
			System.out.printf("The file %s is not available in default folder\n", this.inputFile);
			System.exit(0);
		}
	}
	public void calcLetterGrade(){
		//determines letter grade and stores information
		for(Student stu: this.studentArray)
			stu.calGrade();
	}
	public void printGrade(){
		//writes the grade in output file
		try{
			this.bw = new BufferedWriter(new FileWriter(this.outputFile));
			this.pw = new PrintWriter(bw);
			Collections.sort(this.studentArray);
			for(Student stu: this.studentArray){
				pw.printf("%-24s%-24s\n", stu.getName(), stu.getGrade());
			}
		}
		catch(Exception e) {
			System.out.printf("Ouput Error\n");
			System.exit(0);
		}
	}
	public void displayAverages(){
		//displays the averages in console
		System.out.println();
		System.out.printf("Letter grade has been calculated for students listed in input file %s and written to output file %s \n", 
				this.inputFile, this.outputFile);
		System.out.println("\nHere is the class averages:");
		System.out.println("\t\tQ1\tQ2\tQ3\tQ4\tMidI\tMidII\tFinal");
		System.out.print("Average:\t");
		for(int i=0; i<this.testNum; i++)
			System.out.printf("%.2f\t", this.testAvgScore(i));
		System.out.print("\nMinimum:\t");
		for(int i=0; i<this.testNum; i++)
			System.out.printf("%d\t", this.testMinScore(i));
		System.out.print("\nMaximum:\t");
		for(int i=0; i<this.testNum; i++)
			System.out.printf("%d\t", this.testMaxScore(i));	
	}
	private double testAvgScore(int testNum){
		// return average score in a certain test
		double totalScore = 0;
		for(Student stu: this.studentArray)
			totalScore += stu.getScore(testNum);
		return totalScore / this.studentNum;
	}
	private int testMaxScore(int testNum){
		// return the max score in a certain test
		int maxScore = 0;
		for(Student stu: this.studentArray)
			maxScore = stu.getScore(testNum)>maxScore ? stu.getScore(testNum):maxScore;
		return maxScore;
	}
	private int testMinScore(int testNum){
		// return the min score in a certain test
		int minScore = 100;
		for(Student stu: this.studentArray)
			minScore = stu.getScore(testNum)<minScore ? stu.getScore(testNum):minScore;
		return minScore;
	}
	public void doCleanup(){
		//use it to close files and other resources
		try{
			System.out.println("\n\nPress ENTER to continue ...");
			Scanner readInput = new Scanner(System.in);
			while(true){
				if(System.in.read() == '\n')
					break;
			}
			this.br.close();
			this.pw.close();
			this.bw.close();
		}
		catch(Exception e){}
	}
}
