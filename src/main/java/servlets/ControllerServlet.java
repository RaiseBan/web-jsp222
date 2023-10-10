package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Console;
import java.io.IOException;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("clearSession".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        } else {
            processRequest(request, response);
        }

    }

    private boolean checkIn(double[] arr, double value) {
        for (double arrValue : arr) {
            if (arrValue == value) {
                return false;
            }
        }
        return true;
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // add catch
        double[] rangeR = new double[]{1, 1.5, 2, 2.5, 3};
        System.out.println("1");
        String xValue = request.getParameter("x");
        String yValue = request.getParameter("y");
        String rValue = request.getParameter("r");
        System.out.println("2");
        if (xValue == null || yValue == null || rValue == null) {
            System.out.println(xValue + " " + yValue + " " + rValue);
            System.out.println("err1");
            throw new IOException();
        }

        if (xValue.isEmpty() || yValue.isEmpty() || rValue.isEmpty()) {
            System.out.println("err2");
            throw new IOException();
        }

        if (Double.parseDouble(xValue) < -3 || Double.parseDouble(xValue) > 3 || Double.parseDouble(yValue) < -5 || Double.parseDouble(yValue) > 5 ||
                checkIn(rangeR, Double.parseDouble(rValue))
        ) {
            System.out.println(Double.parseDouble(xValue) + " " + Double.parseDouble(yValue) + " " + Double.parseDouble(yValue) + " " + rValue);
            System.out.println("err3");
            throw new IOException();
        }
        request.getRequestDispatcher("/areaCheck").forward(request, response);


    }
}
