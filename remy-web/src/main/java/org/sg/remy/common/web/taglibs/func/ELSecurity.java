package org.sg.remy.common.web.taglibs.func;

import javax.servlet.http.HttpServletRequest;

import org.sg.remy.common.web.utils.RequestUtils;

/**
 * @author Semyon Goryachkin
 */
public class ELSecurity {

	public static final String GOOGLE_ADMIN_ROLE = "admin";

	public static boolean hasRole(String role) {
		return RequestUtils.getHttpServletRequest().isUserInRole(role);
	}

	public static boolean isAdmin() {
		return RequestUtils.getHttpServletRequest().isUserInRole(GOOGLE_ADMIN_ROLE);
	}

	public static boolean isUser() {
		HttpServletRequest request = RequestUtils.getHttpServletRequest();
		return !request.isUserInRole(GOOGLE_ADMIN_ROLE)
				&& request.getUserPrincipal() != null;
	}

	public static String userName() {
		return RequestUtils.getHttpServletRequest().getRemoteUser();
	}

}
