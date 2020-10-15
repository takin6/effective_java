package item39.repeatableannotation;

import java.lang.annotation.*;

//Container annotation for the repeatable ExceptionTest annotation (Page 186)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTestContainer {
    ExceptionTest[] value();
}
