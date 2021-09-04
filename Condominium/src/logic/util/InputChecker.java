package logic.util;

import logic.controller.exception.InvalidInputException;

public class InputChecker {

	private static String emailPattern = "^([a-zA-Z0-9\\.\\_\\-]+)@([a-zA-Z0-9\\.\\_\\-]+)\\.([a-zA-Z0-9\\.\\_\\-]{2,5})$";
	//password must be at least 6 char long and contain at least a symbol
	private static String passwordPattern = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$";
	//generic String must not be empty
	private static String genericPattern = "^(?!\\s*$).+$";
	
	private InputChecker() {
		//must remain empty
	}

	public static void checkEmail(String email) throws InvalidInputException{
		try {
			if(!email.matches(InputChecker.emailPattern)) {
				throw new InvalidInputException("Given email does not match " + InputChecker.emailPattern);
			}
		} catch (NullPointerException e) {
			throw new InvalidInputException("Given email must not be null"); 
		}
	}
	
	public static void checkPassword(String password) throws InvalidInputException{
		try {
			if(!password.matches(InputChecker.passwordPattern)) {
				throw new InvalidInputException("Given password does not match " + InputChecker.passwordPattern);
			}
		} catch (NullPointerException e) {
			throw new InvalidInputException("Given password must not be null"); 
		}
	}
	
	public static void checkGenericString(String generic) throws InvalidInputException{
		try {
			if(!generic.matches(InputChecker.genericPattern)) {
				throw new InvalidInputException("Given generic string is empty");
			}
		} catch (NullPointerException e) {
			throw new InvalidInputException("Given generic must not be null"); 
		}
	}
	
	public static void checkNotNull(Object object, String name) throws InvalidInputException{
		if(object == null)
			throw new InvalidInputException(String.format("%s must not be null.", name));
	}
	
	public static void checkIntegerMoreThan(String name, Integer value, Integer lowerBound) throws InvalidInputException {
		InputChecker.checkNotNull(value, name);
		InputChecker.checkNotNull(lowerBound, "Inserted lowerBound for " + name + ".");
		if(value <= lowerBound)
			throw new InvalidInputException(String.format("%s: %d must be more than %d.", name, value, lowerBound));
	}
	
}
