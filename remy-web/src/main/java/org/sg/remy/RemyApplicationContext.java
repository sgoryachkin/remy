package org.sg.remy;

import org.sg.remy.business.BusinessContext;
import org.sg.remy.common.CommonContext;
import org.sg.remy.dev.DevContext;
import org.sg.remy.security.SecurityContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ BusinessContext.class, CommonContext.class, DevContext.class, SecurityContext.class })
public class RemyApplicationContext {
	

}
