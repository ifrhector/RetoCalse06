package com.codere.bo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import com.codere.vo.People;

/**
 * Business Object, simulate negotiate data from DataBase
 * @author HFR
 *
 */
public class Names {

	//Make list to return final object list
	private List<String> names;
	private List<String> lastname;
	
	//Counter for control shuffle list
	private int currentIndex;
	
	//Final control for each on arrays
	private final int QUANTITY = 6;

	/**
	 * Constructor from class
	 */
	public Names() {
		super();

		//Make list from names
		names = new ArrayList<>();
		names.add("Héctor");
		names.add("Sara");
		names.add("Angel");
		names.add("Diego");
		names.add("Mengano");
		names.add("Sutana");

		//Make list from last names
		lastname = new ArrayList<>();
		lastname.add("Flores");
		lastname.add("Ramírez");
		lastname.add("Cuevas");
		lastname.add("Nieves");
		lastname.add("Martínez");
		lastname.add("Serrano");

		//Set counter index in 0
		currentIndex = 0;

		//When load application shuffle for set new names with new last names
		Collections.shuffle(names);
		Collections.shuffle(lastname);
	}

	/**
	 * Return a list from People object, always shuffle names and last names.
	 * @return list from <People> object 
	 */
	public List<People> getListOfNames() {

		//Final People list to return
		List<People> peopleList = new ArrayList<People>();

		//This each obtains name, last name, birth, age, gender and married fields from some validations
		for (int i = 0; i < QUANTITY; i++) {
			
			//Create a simple People object
			People newPeople = new People();

			//Get array with two elements, birth and age, from getRandomBirthday() method
			String[] dateAge = getRandomBirthday();
			
			//get array with two elements, name and last name, from getName() method
			String[] name = getName();
			
			//Convert a string date to readable date, use in order correctly
			LocalDate d = LocalDate.parse(dateAge[2]);

			//Set values for simple people object
			newPeople.setName(name[0]);
			newPeople.setLastName(name[1]);
			newPeople.setBirthDay(d);
			newPeople.setMxDate(dateAge[0]);
			newPeople.setAge(dateAge[1]);
			
			//Some rules for set married or gender
			newPeople.setGender((name[0] == "Sara" || name[0] == "Sutana") ? "F" : "M");
			newPeople.setMarried(Integer.parseInt(dateAge[1]) >= 30 ? true : false);

			//At the end of each cycle, add this object on father list <peopleList>
			peopleList.add(newPeople);
		}

		//At complete each, return the final list
		return peopleList;
	}

	/**
	 * 
	 * @return an array with name and last name
	 */
	private String[] getName() {

		//After shuffle on constructor, get elements by variable "currentIndex"
		String nextName = names.get(currentIndex);
		String nextLastName = lastname.get(currentIndex);
		
		//Increase the value index for next data extraction
		currentIndex++;

		//Assemble the array with values from names and last names based on currentIndex
		String[] response = { nextName, nextLastName };

		//Return the final array
		return response;
	}

	/**
	 * 
	 * @return an array with birthday and age
	 */
	private String[] getRandomBirthday() {

		//Instance of GregorianCalendar, to set the shuffle values
		GregorianCalendar gc = new GregorianCalendar();

		//Get random year from randBetween() method
		int year = randBetween(1990, 2010);

		//Set the year
		gc.set(Calendar.YEAR, year);

		//Field number for get and set indicating the day number within the current year.
		int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

		//Set a day for complete the date
		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		
		//Library Calendar use array to return month and days, we need set "0" when element from array is minor or equals to nine
		String completeMonth = (gc.get(Calendar.MONTH) + 1) <= 9 ? "0" + (gc.get(Calendar.MONTH) + 1) : (gc.get(Calendar.MONTH) + 1) + "";
		String completeDay = (gc.get(Calendar.DAY_OF_MONTH) <= 9 ? "0" + gc.get(Calendar.DAY_OF_MONTH) : gc.get(Calendar.DAY_OF_MONTH)) + "";
		
		//Make final string with random date
		String randomDateString = gc.get(Calendar.YEAR) + "-" + completeMonth + "-" + completeDay;
		
		//Convert to readable Date from string
		LocalDate randomDate = LocalDate.parse(randomDateString);
		//Get actual date
		LocalDate curDate = LocalDate.now();
		
		//With the random date and actual date, calculate individual years old
		int yearsOld = Period.between(randomDate, curDate).getYears();

		//assemble the final array with three elements, MX  date (dd/mm/YYYY), individual age,
		//and random date in English format, the latter to be able to reorder the list by date
		String[] response = {
				completeDay + "/" + completeMonth + "/" + gc.get(Calendar.YEAR),
				yearsOld + "",
				randomDateString
		};

		return response;
	}

	/**
	 * Return a random year from two years range
	 * @param start
	 * @param end
	 * @return integer year
	 */
	private int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

}
