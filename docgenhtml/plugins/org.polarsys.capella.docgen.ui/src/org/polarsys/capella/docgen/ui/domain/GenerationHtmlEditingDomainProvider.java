/*******************************************************************************
 * Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales - initial API and implementation
 ******************************************************************************/

package org.polarsys.capella.docgen.ui.domain;

import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.polarsys.capella.common.platform.sirius.ted.SemanticEditingDomainFactory;

/**
 * An editing domain provider specific to the migration, that allows the use of
 * {@link CapellaDeleteCommand}.
 */
public class GenerationHtmlEditingDomainProvider implements IEditingDomainProvider {
	/**
	 * @see org.polarsys.capella.common.tig.ef.IEditingDomainProvider#getEditingDomain()
	 */
	public TransactionalEditingDomain getEditingDomain() {
		SemanticEditingDomainFactory factory = new SemanticEditingDomainFactory();
		return factory.createEditingDomain();
	}
}
