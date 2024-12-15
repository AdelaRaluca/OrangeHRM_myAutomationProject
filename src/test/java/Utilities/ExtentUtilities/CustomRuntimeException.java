package Utilities.ExtentUtilities;

import Utilities.LoggerUtility;

public class CustomRuntimeException extends RuntimeException{
    public CustomRuntimeException(String message) {
        super(message);
LoggerUtility.errorLog(message);
    }
}
