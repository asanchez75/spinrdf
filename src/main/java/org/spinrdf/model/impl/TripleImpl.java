/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  See the NOTICE file distributed with this work for additional
 *  information regarding copyright ownership.
 */

package org.spinrdf.model.impl;

import org.apache.jena.enhanced.EnhGraph;
import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.Resource;
import org.spinrdf.model.Triple;
import org.spinrdf.model.print.PrintContext;
import org.spinrdf.vocabulary.SP;


public abstract class TripleImpl extends TupleImpl implements Triple {

	public TripleImpl(Node node, EnhGraph graph) {
		super(node, graph);
	}


	public Resource getPredicate() {
		return (Resource) getRDFNodeOrVariable(SP.predicate);
	}
	
	
	public void print(PrintContext p) {
		print(getSubject(), p);
		p.print(" ");
		print(getPredicate(), p, true);
		p.print(" ");
		print(getObject(), p);
	}
}
