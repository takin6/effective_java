package item39.annotationwithparameter;

import java.lang.annotation.*;

/**
 * Indicates that the annotated method is a test method that
 * must throw the designated exception to succeed.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
// Annotation type with a parameter (Page 183)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}
