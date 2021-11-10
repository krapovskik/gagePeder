package mk.ukim.finki.lab1.lab1.web.servlet;

import mk.ukim.finki.lab1.lab1.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BalloonListSevrlet", urlPatterns = "")
public class BalloonListSevrlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final BalloonService balloonService;

    public BalloonListSevrlet(SpringTemplateEngine springTemplateEngine, BalloonService balloonService) {
        this.springTemplateEngine = springTemplateEngine;
        this.balloonService = balloonService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext context = new WebContext(request,response, request.getServletContext());
        context.setVariable("listBalloons",this.balloonService.listAll());
        this.springTemplateEngine.process("listBalloons.html",context,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");
        req.getSession().setAttribute("color",color);
        resp.sendRedirect("/selectBalloon");
    }
}
