package item33;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

// Use of asSubclass to safely cast to a bounded type token
public class PrintAnnotation {

    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null; // Unbounded type token
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch(Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        // asSubclass: casts the Class object on which it is called to represent a subclass of the class represented by its argument
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: java PrintAnnotation <class> <annotation>");
            System.exit(1);
        }
        String className = args[0];
        String annotationTypeName = args[1];
        Class<?> klass = Class.forName(className);
        System.out.println(getAnnotation(klass, annotationTypeName));
    }
}
