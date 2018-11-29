package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;


@WebServlet("/waitingAction")
public class WaitingAction extends HttpServlet {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    String card = null;

    public WaitingAction() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Start]WaitingAction");

        String str;
        Socket s;
        String card;

        if(request.getSession()==null){
            //TODO: lidar com o problema de nao encontrar a sessao. Voltar ao index
        }


        try {
            s = new Socket("localhost", 7781);

            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeBytes("card|" + request.getSession().getAttribute("username"));

            DataInputStream in = new DataInputStream(s.getInputStream());

            byte[] buffer = new byte[1024];
            int len = in.read(buffer, 0, 1024);
            String data = new String(buffer, 0, len);


            if(data.equals("no")){
                s.close();
                request.getRequestDispatcher("wait.jsp").forward(request, response);
            }
            else if(data.equals("Bruxa")){
                request.getSession().setAttribute("card", "Bruxa");
                System.out.println(request.getSession().getAttribute("card"));
                s.close();
                request.getRequestDispatcher("CardCharacter.jsp").forward(request, response);
            }
            else if(data.equals("Lobo")){
                request.getSession().setAttribute("card", "Lobo");
                s.close();
                request.getRequestDispatcher("CardCharacter.jsp").forward(request, response);
            }
            else if(data.equals("Anjo")){
                request.getSession().setAttribute("card", "Anjo");
                s.close();
                request.getRequestDispatcher("CardCharacter.jsp").forward(request, response);
            }
            else if(data.equals("AldeaoF")){
                request.getSession().setAttribute("card", "AldeaoF");
                s.close();
                request.getRequestDispatcher("CardCharacter.jsp").forward(request, response);
            }
            else if(data.equals("AldeaoM")){
                request.getSession().setAttribute("card", "AldeaoM");
                s.close();
                request.getRequestDispatcher("CardCharacter.jsp").forward(request, response);
            }
            else if(data.equals("Bebado")){
                request.getSession().setAttribute("card", "Bebado");
                s.close();
                request.getRequestDispatcher("CardCharacter.jsp").forward(request, response);
            }
            else if(data.equals("Cupido")){
                request.getSession().setAttribute("card", "Cupido");
                s.close();
                request.getRequestDispatcher("CardCharacter.jsp").forward(request, response);
            }
            else if(data.equals("Prostituta")){
                request.getSession().setAttribute("card", "Prostituta");
                s.close();
                request.getRequestDispatcher("CardCharacter.jsp").forward(request, response);
            }
            else if(data.equals("Urso")){
                request.getSession().setAttribute("card", "Urso");
                s.close();
                request.getRequestDispatcher("CardCharacter.jsp").forward(request, response);
            }
            else{
                s.close();
                request.getRequestDispatcher("wait.jsp").forward(request, response);
            }

            //s.setSoTimeout(5000);

            System.out.println("data: '" + data + "'");


        }catch (Exception e){
            System.out.println("Caught exception: " + e.toString());
        }

        System.out.println("[End]WaitingAction");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }



}
