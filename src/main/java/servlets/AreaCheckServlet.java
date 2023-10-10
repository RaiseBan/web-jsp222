package servlets;

import models.Point;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/areaCheck")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            double x = Double.parseDouble(request.getParameter("x"));
            double y = Double.parseDouble(request.getParameter("y"));
            double r = Double.parseDouble(request.getParameter("r"));
            Point point = new Point(x, y, r);
            String result;

            if (point.isinArea()){
                result = "In";
            }else{
                result = "Out";
            }

            HttpSession session = request.getSession();
            @SuppressWarnings("unchecked")
            List<Point> pointsList = (List<Point>)session.getAttribute("result");
            if (pointsList == null){
                pointsList = new ArrayList<>();
                session.setAttribute("result", pointsList);
            }
            pointsList.add(point);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"result\":\"" + result + "\"}");

        }catch (Exception e){
            e.printStackTrace();
            request.getRequestDispatcher("./index.jsp").forward(request, response);
        }
    }

}
