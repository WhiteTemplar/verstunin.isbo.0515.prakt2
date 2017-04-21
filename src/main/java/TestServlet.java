import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class TestServlet extends HttpServlet {
    ToDoArray list = new ToDoArray();
    {list.add("Example task");}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder buf = new StringBuilder();
        List<ToDoList> tasks=list.view();
        for (ToDoList task : tasks) {
            buf.append("<li>"+ task.todo+"</li>\n");
        }
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Список дел</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"post\" action=\"add\">\n" +
                "    Задача:<input name=\"task\">\n" +
                "    <input type=\"submit\" value=\"add\">\n" +
                "</form>\n" +
                "<ol>\n" +
                    buf+
                "</ol>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String what=req.getParameter("task");
        list.add(what);
        resp.sendRedirect("/");
    }
}