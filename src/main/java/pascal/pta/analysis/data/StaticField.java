package pascal.pta.analysis.data;

import pascal.pta.element.Field;

public class StaticField extends AbstractPointer {

    private final Field field;

    StaticField(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    @Override
    public String toString() {
        return field.toString();
    }
}