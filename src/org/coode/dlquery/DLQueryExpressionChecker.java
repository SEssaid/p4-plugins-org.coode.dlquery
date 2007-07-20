package org.coode.dlquery;

import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.description.OWLDescriptionNode;
import org.protege.editor.owl.model.description.OWLDescriptionNodeParser;
import org.protege.editor.owl.model.description.OWLDescriptionParser;
import org.protege.editor.owl.model.description.OWLExpressionParserException;
import org.protege.editor.owl.ui.clsdescriptioneditor.OWLExpressionChecker;
import org.semanticweb.owl.model.OWLException;
/*
 * Copyright (C) 2007, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */


/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: 11-Oct-2006<br><br>
 * <p/>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br><br>
 */
public class DLQueryExpressionChecker implements OWLExpressionChecker<OWLDescriptionNode> {

    private OWLEditorKit owlEditorKit;


    public DLQueryExpressionChecker(OWLEditorKit owlEditorKit) {
        this.owlEditorKit = owlEditorKit;
    }


    public OWLDescriptionNode createObject(String text) throws OWLExpressionParserException, OWLException {
        return ((OWLDescriptionNodeParser) owlEditorKit.getOWLModelManager().getOWLDescriptionParser()).createOWLDescriptionNode(
                text);
    }


    public void check(String text) throws OWLExpressionParserException, OWLException {
        OWLDescriptionParser parser = owlEditorKit.getOWLModelManager().getOWLDescriptionParser();
        if (parser instanceof OWLDescriptionNodeParser) {
            ((OWLDescriptionNodeParser) parser).isWellFormedNode(text);
        }
        else {
            parser.isWellFormed(text);
        }
    }
}