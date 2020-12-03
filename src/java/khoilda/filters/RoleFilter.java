/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class RoleFilter implements Filter {

    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    private final List<String> guest;
    private final List<String> admin;
    private final List<String> actor;
    private final List<String> director;

    public RoleFilter() {
        guest = new ArrayList<>();
        guest.add("index.jsp");
        guest.add("error.jsp");
        guest.add("LoginAction");
        guest.add("LoginAction.action");
        guest.add("notFoundPage.jsp");

        admin = new ArrayList<>();
        admin.add("insertscene.jsp");
        admin.add("inserttool.jsp");
        admin.add("insertuser.jsp");
        admin.add("managescene.jsp");
        admin.add("managetool.jsp");
        admin.add("manageuser.jsp");
        admin.add("updatescene.jsp");
        admin.add("updatetool.jsp");
        admin.add("updateuser.jsp");
        admin.add("DeleteSceneAction");
        admin.add("DeleteToolAction");
        admin.add("DeleteUserAction");
        admin.add("DeleteSceneAction.action");
        admin.add("DeleteToolAction.action");
        admin.add("DeleteUserAction.action");
        admin.add("EditSceneAction");
        admin.add("EditToolAction");
        admin.add("EditUserAction");
        admin.add("EditSceneAction.action");
        admin.add("EditToolAction.action");
        admin.add("EditUserAction.action");
        admin.add("InsertSceneAction");
        admin.add("InsertToolAction");
        admin.add("InsertUserAction");
        admin.add("InsertSceneAction.action");
        admin.add("InsertToolAction.action");
        admin.add("InsertUserAction.action");
        admin.add("SearchSceneAction");
        admin.add("SearchToolAction");
        admin.add("SearchUserAction");
        admin.add("SearchSceneAction.action");
        admin.add("SearchToolAction.action");
        admin.add("SearchUserAction.action");
        admin.add("UpdateSceneAction");
        admin.add("UpdateToolAction");
        admin.add("UpdateUserAction");
        admin.add("UpdateSceneAction.action");
        admin.add("UpdateToolAction.action");
        admin.add("UpdateUserAction.action");
        admin.add("MoveToAccountAction.action");
        admin.add("MoveToSceneAction.action");
        admin.add("MoveToToolAction.action");
        admin.add("MoveToAcountAcction");
        admin.add("MoveToSceneAction");
        admin.add("MoveToToolAction");
        admin.add("struts-dojo-tags");
        admin.add("index.jsp");
        admin.add("error.jsp");
        admin.add("LoginAction");
        admin.add("LoginAction.action");
        admin.add("notFoundPage.jsp");
        admin.add("LogoutAction");
        admin.add("LogoutAction.action");
        admin.add("admin.jsp");

        actor = new ArrayList<>();
        actor.add("actor.jsp");
        actor.add("index.jsp");
        actor.add("error.jsp");
        actor.add("LoginAction");
        actor.add("LoginAction.action");
        actor.add("notFoundPage.jsp");
        actor.add("LogoutAction");
        actor.add("LogoutAction.action");

        director = new ArrayList<>();
        director.add("director.jsp");
        director.add("index.jsp");
        director.add("error.jsp");
        director.add("LoginAction");
        director.add("LoginAction.action");
        director.add("notFoundPage.jsp");
        director.add("LogoutAction");
        director.add("LogoutAction.action");
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RoleFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RoleFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("ROLE");
        System.out.println(role);
        String uri = req.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String resource = uri.substring(lastIndex + 1);
        if (role == null) {
            if (guest.contains(resource) || resource.endsWith("js") || resource.endsWith("css") || resource.endsWith("woff2") || resource.endsWith("woff") || resource.endsWith("ttf") || resource.endsWith("jpg") || resource.endsWith("png") || resource.endsWith("jpeg")) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect("index.jsp");
            }
        } else {
            if (role.equals("actor")) {
                if (actor.contains(resource) || resource.endsWith("js") || resource.endsWith("css") || resource.endsWith("woff2") || resource.endsWith("woff") || resource.endsWith("ttf") || resource.endsWith("jpg") || resource.endsWith("png") || resource.endsWith("jpeg")) {
                    chain.doFilter(request, response);
                } else {
                    res.sendRedirect("actor.jsp");
                }
            } else if (role.equals("director")) {
                if (director.contains(resource) || resource.endsWith("js") || resource.endsWith("css") || resource.endsWith("woff2") || resource.endsWith("woff") || resource.endsWith("ttf") || resource.endsWith("jpg") || resource.endsWith("png") || resource.endsWith("jpeg")) {
                    chain.doFilter(request, response);
                } else {
                    res.sendRedirect("director.jsp");
                }
            } else if (role.equals("admin")) {
                System.out.println(resource);
                if (admin.contains(resource) || resource.endsWith("js") || resource.endsWith("css") || resource.endsWith("woff2") || resource.endsWith("woff") || resource.endsWith("ttf") || resource.endsWith("jpg") || resource.endsWith("png") || resource.endsWith("jpeg")) {
                    chain.doFilter(request, response);
                } else {
                    res.sendRedirect("admin.jsp");
                }
            } else {
                res.sendRedirect("notFoundPage.jsp");
            }
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("RoleFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("RoleFilter()");
        }
        StringBuffer sb = new StringBuffer("RoleFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
