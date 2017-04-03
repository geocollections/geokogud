package ee.ttu.geocollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
@Component
class AuditInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(AuditInterceptor.class);
    private static final String AUDIT_KEY = "audit";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        StringBuilder sb = new StringBuilder(" user: ");
        if (auth != null && auth.getPrincipal() instanceof UserDetails) {
            UserDetails user = (UserDetails) auth.getPrincipal();
            sb.append(user.getUsername());
        } else {
            sb.append("anonymous");
        }

        sb.append(", client IP: ").append(request.getRemoteAddr());
        MDC.put(AUDIT_KEY, sb.toString());

        logger.info("URI: " + request.getRequestURI());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //logger.info("POST HANDLE");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove(AUDIT_KEY);
    }
}
