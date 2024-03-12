package retoclase6;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.codere.bo.Names;
import com.codere.vo.People;


public class ListNamesTest {

	private static Scanner data;
	private static List<People> sortedPeople; //New sorted list by user selection

	public static void main(String[] args) {

		//Import the business object
		Names listNames = new Names();

		//Make a list from business object
		List<People> list = listNames.getListOfNames();

		//Instance of scanner for user interaction
		data = new Scanner(System.in);

		//show options menu
		System.out.print("Sleccione el orden de la lista: \n");
		System.out.print("Nombre [1] \n");
		System.out.print("Apellido [2] \n");
		System.out.print("Cumpleaños [3] \n");
		System.out.print("Edad [4] \n");
		System.out.print("Estado civil[5] \n");
		int order = data.nextInt();

		// Return new list sorted by user selection
		switch (order) {
		case 1: {
			sortedPeople = list.stream().sorted(Comparator.comparing(People::getName)).collect(Collectors.toList());
			break;
		}
		case 2: {
			sortedPeople = list.stream().sorted(Comparator.comparing(People::getLastName)).collect(Collectors.toList());
			break;
		}
		case 3: {
			sortedPeople = list.stream().sorted(Comparator.comparing(People::getBirthDay)).collect(Collectors.toList());
			break;
		}
		case 4: {
			sortedPeople = list.stream().sorted(Comparator.comparing(People::getAge)).collect(Collectors.toList());
			break;
		}
		case 5: {
			sortedPeople = list.stream().sorted(Comparator.comparing(People::isMarried)).collect(Collectors.toList());
			break;
		}
		default:
			throw new IllegalArgumentException("Valor no listado: " + order);
		}
		
		System.out.print("------------------------------------------------------------------------------------------\n");
		System.out.print("Mostrar listado en modo inverso? \n");
		System.out.print("SI [1] \n");
		System.out.print("NO [2] \n");
		int isInverse = data.nextInt();
		
		if(isInverse == 1) {
			Collections.reverse(sortedPeople);
		}
		
		
		String out = "\n";

		//each final result and print on screen
		for (People people : sortedPeople) {
			// System.out.println(people);

			String married = people.isMarried() ? "casado" : "soltero";

			out += "Nombre:" + people.getName();
			out += ", Apellido: " + people.getLastName();
			out += ", Genero: " + people.getGender();
			out += ", Cumpleaños: " + people.getMxDate();
			out += ", Edad: " + people.getAge();
			out += ", Estado civil: " + married;
			out += "\n------------------------------------------------------------------------------------------------ \n";
		}

		System.out.println(out);

	}

}
