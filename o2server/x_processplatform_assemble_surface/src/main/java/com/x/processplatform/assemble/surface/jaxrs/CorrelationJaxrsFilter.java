package com.x.processplatform.assemble.surface.jaxrs;

import javax.servlet.annotation.WebFilter;

import com.x.base.core.project.jaxrs.CipherManagerUserJaxrsFilter;

@WebFilter(urlPatterns = "/jaxrs/correlation/*", asyncSupported = true)
public class CorrelationJaxrsFilter extends CipherManagerUserJaxrsFilter {

}
