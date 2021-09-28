package org.example;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {

    private static final String FIRST_NAME_PARAM = "txt_first_name";

    private static final String LAST_NAME_PARAM = "txt_last_name";

    private static final String FIRST_NAME_DEFAULT = "NoName";

    private static final String LAST_NAME_DEFAULT = "NoName";


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter(FIRST_NAME_PARAM);
        if (StringUtils.isBlank(firstName)) {
            firstName = FIRST_NAME_DEFAULT;
        }
        firstName = StringUtils.capitalize(firstName);

        String lastName = request.getParameter(LAST_NAME_PARAM);
        if (StringUtils.isBlank(lastName)) {
            lastName = LAST_NAME_DEFAULT;
        }
        lastName = StringUtils.capitalize(lastName);

        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.getRequestDispatcher("result.jsp").forward(request, response);

    }
}
