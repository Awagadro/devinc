package devinc.pre.mod08;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(value = ElementType.FIELD)
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME) // аннотация будет записана в class-файл и доступна во время выполнения
											// через reflection
public @interface MyAnnotation {
	String type() default "string";
}
