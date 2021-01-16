import com.validation.*;
import com.validation.annotations.NotEmpty;
import com.validation.exceptions.ResponseException;
import com.validation.exceptions.ValidatorException;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Validation validation = Validation.getValidationInstance();
        validation.setValidationStrategy(new AnnotationValidation());
        Test test = new Test();
        Test2 test2 = new Test2();
        Test3 test3 = new Test3();
        ResponseException err = validation.validate(test);

        System.out.println("Test1 has error : " + err.hasError());

        System.out.println("Test1 all error :");
        Map<String, List<ValidatorException>> errors = err.getAllErrors();

        for (String key : errors.keySet())
        {
            System.out.println("Field Name : " + key);
            for (ValidatorException ve : errors.get(key)) {
                System.out.println("Error : " + ve.getMessage());
            }
        }


        List<String> errorOfRegex = err.getErrorInString("regex");

        System.out.println("Error of regex");
        for (String str : errorOfRegex) {
            System.out.println("Error : " + str);
        }




    }
}
