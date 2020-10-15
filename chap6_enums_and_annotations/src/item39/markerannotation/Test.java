package item39.markerannotation;

// Marker annotation type declaration

import java.lang.annotation.*;

/**
 * Indicates that the annotated method is a test method.
 * Use only on parameterless static methods.
 */
// annotations on annotation type declarations are known as meta-annotations
@Retention(RetentionPolicy.RUNTIME) // retained at runtime
@Target(ElementType.METHOD) // legal only on method declarations
public @interface Test {
}
