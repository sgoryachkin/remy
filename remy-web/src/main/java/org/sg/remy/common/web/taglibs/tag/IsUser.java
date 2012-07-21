package org.sg.remy.common.web.taglibs.tag;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

import org.sg.remy.common.web.taglibs.func.ELSecurity;

public class IsUser extends ConditionalTagSupport{
	private static final long serialVersionUID = -5534576041012633413L;

	@Override
	protected boolean condition() throws JspTagException {
		return  ELSecurity.isUser();
	}
	
}
