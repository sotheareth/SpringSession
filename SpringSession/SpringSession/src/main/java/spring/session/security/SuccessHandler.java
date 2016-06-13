package spring.session.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class SuccessHandler implements AuthenticationSuccessHandler {
	
	private String redirectUrl;

    public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}


	@Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, 
            HttpServletResponse httpServletResponse, 
            Authentication authentication) throws IOException, ServletException {

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        String sessionId = httpServletResponse.getHeader("JSESSIONID");
        HttpSession session = httpServletRequest.getSession();
        if(sessionId != null && authentication.getDetails() instanceof WebAuthenticationDetails){
        	WebAuthenticationDetails details = (WebAuthenticationDetails)authentication.getDetails();
        	sessionId = details.getSessionId();
        }
        httpServletResponse.setHeader("Set-Cookie", "JSESSIONID=" + sessionId + ";domain=localhost;path=/;httponly");
        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, 
        		redirectUrl);
    }
}