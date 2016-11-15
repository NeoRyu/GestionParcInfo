package application.tools;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Boris on 10/11/2016.
 */
public class Verif {

    public static <T> boolean verifier(T objet) {

        Validator validator;
        Set<ConstraintViolation<T>> constraintViolations = new Set<ConstraintViolation<T>>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<ConstraintViolation<T>> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(ConstraintViolation<T> tConstraintViolation) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends ConstraintViolation<T>> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        constraintViolations = validator.validate(objet);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<T> contraintes : constraintViolations) {
                System.out.println(contraintes.getMessage());
            }
            return false;
        } else {
            return true;
        }
    }

}
