/*
 * Tai-e: A Program Analysis Framework for Java
 *
 * Copyright (C) 2020 Tian Tan <tiantan@nju.edu.cn>
 * Copyright (C) 2020 Yue Li <yueli@nju.edu.cn>
 * All rights reserved.
 *
 * This software is designed for the "Static Program Analysis" course at
 * Nanjing University, and it supports a subset of Java features.
 * Tai-e is only for educational and academic purposes, and any form of
 * commercial use is disallowed.
 */

package pascal.taie.ir;

import pascal.taie.ir.exp.Var;
import pascal.taie.ir.stmt.Stmt;
import pascal.taie.java.classes.JMethod;

import java.util.List;

public class DefaultNewIR implements NewIR {

    private final JMethod method;

    private final Var thisVar;

    private final List<Var> params;

    private final List<Var> vars;

    private final List<Stmt> stmts;

    private final List<TryCatchBlock> tryCatchBlocks;

    public DefaultNewIR(
            JMethod method, Var thisVar, List<Var> params, List<Var> vars,
            List<Stmt> stmts, List<TryCatchBlock> tryCatchBlocks) {
        this.method = method;
        this.thisVar = thisVar;
        this.params = params;
        this.vars = vars;
        this.stmts = stmts;
        this.tryCatchBlocks = tryCatchBlocks;
    }

    @Override
    public JMethod getMethod() {
        return method;
    }

    public Var getThis() {
        return thisVar;
    }

    @Override
    public List<Var> getParams() {
        return params;
    }

    @Override
    public Var getParam(int i) {
        return params.get(i);
    }

    @Override
    public List<Var> getVars() {
        return vars;
    }

    @Override
    public List<Stmt> getStmts() {
        return stmts;
    }

    @Override
    public List<TryCatchBlock> getTryCatchBlocks() {
        return tryCatchBlocks;
    }
}
