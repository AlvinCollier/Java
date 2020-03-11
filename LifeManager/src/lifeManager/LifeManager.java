package lifeManager;

import java.util.Scanner;

public class LifeManager {

	public static void main(String[] args) {
		
		int sleep = 32;
		int travel = 1;
		
		Scanner sc = new Scanner(System.in);
		
		Week week = new Week();
		week.printWeek();
		
		for(int i = 0; i < week.getDay().length; i++) {
			System.out.print("Do you work on " + week.getDayAtIndex(i).getName() + "?");
			String response = sc.nextLine();
			if(response.toLowerCase().contains("y")) {
				int startTime, endTime, wakeUp;
				System.out.print("What time do you start work on " + week.getDayAtIndex(i).getName() + "?");
				startTime = sc.nextInt();
				System.out.print("What time do you end work on " + week.getDayAtIndex(i).getName() + "?");
				endTime = sc.nextInt();
				startTime *=4;
				endTime *=4;
				insertTag(week, i, startTime, endTime, "Work");
				insertTag(week, i, startTime-travel, startTime-1, "To Work" );
				insertTag(week, i, endTime+1, endTime+travel, "Go Home" );
				wakeUp = (startTime)-8-travel;
				insertTag(week, i, startTime-travel-4,startTime-travel-1, "GetRdy");
				insertTag(week, i, wakeUp, wakeUp, "Wake Up");
				insertTag(week, i, wakeUp+1,wakeUp+1, "Brekfst");
				insertTag(week, i, wakeUp-sleep-1, wakeUp-1, "Sleep");
				insertTag(week, i, wakeUp-sleep-4, wakeUp-sleep-1, "Rdy4Bed");
				response = sc.nextLine();
			}
			else {
				
			}
			
			
			System.out.println("");
		}
		int averageWakeTime = 0;
		int averageDays = 0;
		for(int i = 0; i < week.getDay().length; i++) {
			if(week.getDayAtIndex(i).findStartTimeSlotByTag("Wake Up") > -1) {
				averageWakeTime += week.getDayAtIndex(i).findStartTimeSlotByTag("Wake Up");
				averageDays ++;
			}
		}
		averageWakeTime = averageWakeTime/averageDays;
		for(int i = 0; i < week.getDay().length; i++) {
			if(week.getDayAtIndex(i).findStartTimeSlotByTag("Wake Up") == -1) {
				insertTag(week, i, averageWakeTime, averageWakeTime, "Wake Up");
				insertTag(week, i, averageWakeTime+1,averageWakeTime+1, "Brekfst");
				insertTag(week, i, averageWakeTime-sleep-1, averageWakeTime-1, "Sleep");
				insertTag(week, i, averageWakeTime-sleep-4, averageWakeTime-sleep-1, "Rdy4Bed");
			}
		}
		week.printWeek();
		sc.close();
	}
	
	public static void insertWorkTime(Week week, int i, int startTime, int endTime) {
		for(int t = startTime*4; t <= endTime*4; t++) {
			week.getDayAtIndex(i).getTimeSlotAtIndex(t).setTag("Work");
		}
	}
	
	public static void insertTag(Week week, int day, int startTime, int endTime, String tag) {
		
		int oldDay = day;
		
		for(int i = startTime; i <= endTime; i++) {
			if(i < 0) {
				day -=1;
				i +=96;
				if(day < 0) {
					day = 6;
				}
			}
			
			week.getDayAtIndex(day).getTimeSlotAtIndex(i).setTag(tag);
			if(day < oldDay) {
				i -=96;
				day +=1;
			}
			else if(day > oldDay) {
				i -=96;
				day +=1;
				if(day > 6) {
					day = 0;
				}
			}
		}
		
	}
	

}

class Week{
	
	private Day[] day;
	
	Week(){
		
		day = new Day[7];
		for(int i = 0; i < day.length; i++) {
			day[i] = new Day();
		}
		day[0].setName("Sunday");
		day[1].setName("Monday");
		day[2].setName("Tuesday");
		day[3].setName("Wednesd");
		day[4].setName("Thursda");
		day[5].setName("Friday");
		day[6].setName("Saturday");
	}
	
	public void printWeek() {
		
		for(int i = 0; i < day.length; i++) {
			System.out.print(day[i].getName() + "\t\t");
		}
		System.out.println("");
		for(int i = 0; i < day[0].getTimeSlot().length; i++) {
			for(int d = 0; d < day.length; d++) {
				System.out.print(day[d].getTimeSlotAtIndex(i).getHour() + ":" + day[d].getTimeSlotAtIndex(i).getMinutes() + "\t" + day[d].getTimeSlotAtIndex(i).getTag()  + "\t");
			}
			System.out.println("");
		}
		
	}
	
	public Day[] getDay() {
		return day;
	}
	
	public Day getDayAtIndex(int i) {
		return day[i];
	}
	
	
	
}

class Day{
	
	private String name;
	private TimeSlot[] timeSlot;
	
	Day() {
		//time slots are every 15 minutes so that's 
		//four an hour, times 24 hours in a day.
		timeSlot = new TimeSlot[96];
		for(int i = 0; i < timeSlot.length; i++) {
			timeSlot[i] = new TimeSlot();
			timeSlot[i].setHour(i/4);
			timeSlot[i].setMinutes((i%4)*15);
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public TimeSlot[] getTimeSlot() {
		return timeSlot;
	}
	
	public TimeSlot getTimeSlotAtIndex(int i) {
		return timeSlot[i];
	}
	
	public int findStartTimeSlotByTag(String s) {

		for(int i = 0; i < timeSlot.length; i++) {
			if(timeSlot[i].getTag() ==s ) {
				return i;
			}
		}
		return -1; //should throw an error about slot not found
	}
	
}

class TimeSlot{
	
	private int hour;
	private int minutes;
	private String tag;
	
	TimeSlot(){
		
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getTag() {
		if(this.tag != null)
			return tag;
		
		return "";
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
