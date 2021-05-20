/*
 * Tai-e: A Static Analysis Framework for Java
 *
 * Copyright (C) 2020-- Tian Tan <tiantan@nju.edu.cn>
 * Copyright (C) 2020-- Yue Li <yueli@nju.edu.cn>
 * All rights reserved.
 *
 * Tai-e is only for educational and academic purposes,
 * and any form of commercial use is disallowed.
 * Distribution of Tai-e is disallowed without the approval.
 */

package pascal.taie.analysis.pta.plugin;

import pascal.taie.analysis.graph.callgraph.Edge;
import pascal.taie.analysis.pta.core.cs.context.Context;
import pascal.taie.analysis.pta.core.cs.element.CSCallSite;
import pascal.taie.analysis.pta.core.cs.element.CSMethod;
import pascal.taie.analysis.pta.core.cs.element.CSObj;
import pascal.taie.analysis.pta.core.cs.element.CSVar;
import pascal.taie.analysis.pta.core.solver.Solver;
import pascal.taie.analysis.pta.pts.PointsToSet;
import pascal.taie.ir.stmt.Invoke;
import pascal.taie.language.classes.JMethod;

/**
 * Analysis plugin interface.
 * This interface contains callbacks for pointer analysis events.
 * It is suppose to provide a mechanism for extending functionalities
 * of the analysis, so its implementations would have side effects
 * on pointer analysis and should be thread-safe.
 */
public interface Plugin {

    /**
     * Sets pointer analysis solver which will be used later by the plugin.
     */
    default void setSolver(Solver solver) {
    }

    /**
     * Invoked when pointer analysis starts.
     * Thread-safe.
     */
    default void onStart() {
    }

    /**
     * Invoked when pointer analysis finishes.
     * Pointer analysis is supposed to have been finished at this stage,
     * thus this call back should NOT modify pointer analysis results.
     * Thread-safe.
     */
    default void onFinish() {
    }

    /**
     * Invoked when set of new objects flow to a context-sensitive variable.
     * Not thread-safe, but single-thread on csVar.
     * @param csVar variable whose points-to set changes
     * @param pts set of new objects
     */
    default void onNewPointsToSet(CSVar csVar, PointsToSet pts) {
    }

    /**
     * Invoked when a new call graph edge is discovered.
     * Not thread-safe, but single-thread on edge.
     * @param edge new call graph edge
     */
    default void onNewCallEdge(Edge<CSCallSite, CSMethod> edge) {
    }

    /**
     * Invoked when a new reachable method is discovered.
     * Not thread-safe, but single-thread on method.
     * @param method new reachable method
     */
    default void onNewMethod(JMethod method) {
    }

    /**
     * Invoked when a new reachable context-sensitive method is discovered.
     * Not thread-safe, but single-thread on csMethod.
     * @param csMethod new reachable context-sensitive method
     */
    default void onNewCSMethod(CSMethod csMethod) {
    }

    /**
     * Invoked when pointer analysis failed to resolve callee (i.e., resolve
     * to null) on a receiver object. Some plugins take over such cases to
     * do their analysis.
     * @param recv the receiver object
     * @param context the context of the invocation
     * @param invoke the invocation site
     */
    default void onUnresolvedCall(CSObj recv, Context context, Invoke invoke) {
    }
}
