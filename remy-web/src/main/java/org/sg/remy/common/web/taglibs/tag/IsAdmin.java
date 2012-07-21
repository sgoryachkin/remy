package org.sg.remy.common.web.taglibs.tag;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

import org.sg.remy.common.web.taglibs.func.ELSecurity;

public class IsAdmin extends ConditionalTagSupport{
	private static final long serialVersionUID = 8278302403649254339L;
	
	@Override
	protected boolean condition() throws JspTagException {
		return ELSecurity.isAdmin();
	}
	
}
