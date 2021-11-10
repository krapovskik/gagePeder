package mk.ukim.finki.lab1.lab1.web.servlet;

import mk.ukim.finki.lab1.lab1.model.Order;
import mk.ukim.finki.lab1.lab1.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.lab1.lab1.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "confirmation", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        try{
            this.orderService.placeOrder(req.getSession().getAttribute("color").toString(),clientName,clientAddress);
        }
        catch (InvalidArgumentsException e){
            WebContext context = new WebContext(req,resp, req.getServletContext());
            context.setVariable("hasError", true);
            context.setVariable("errorMessage", e.getMessage());
            this.springTemplateEngine.process("deliveryInfo.html",context,resp.getWriter());
        }
        Order order = this.orderService.findOrderByClientAndAddressAndSetSize(clientName,clientAddress,req.getSession().getAttribute("size").toString());
        WebContext context = new WebContext(req,resp, req.getServletContext());
        context.setVariable("order",order);
        context.setVariable("userIP", req.getRemoteAddr());
        context.setVariable("userBrowser", req.getHeader("User-Agent").split("/")[0]);
        this.springTemplateEngine.process("confirmationInfo.html",context,resp.getWriter());


    }
}
