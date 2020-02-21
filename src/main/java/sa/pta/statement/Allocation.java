package sa.pta.statement;

import sa.pta.element.Type;
import sa.pta.element.Variable;

/**
 * Represents a new statement: var = new T;
 */
public class Allocation implements Statement {

    private final Variable var;

    private final Object allocationSite;

    private final Type type;

    public Allocation(Variable var, Object allocationSite, Type type) {
        this.var = var;
        this.allocationSite = allocationSite;
        this.type = type;
    }

    public Variable getVar() {
        return var;
    }

    public Object getAllocationSite() {
        return allocationSite;
    }

    public Type getType() {
        return type;
    }

    @Override
    public Kind getKind() {
        return Kind.ALLOCATION;
    }
}
