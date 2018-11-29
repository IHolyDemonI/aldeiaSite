package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Map;


@WebServlet("/createProfileUsername")
public class CreateProfileUsername extends HttpServlet {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String username = null;

    public CreateProfileUsername() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Start]createProfileUsername");

        Socket s;

        if(request.getSession()==null){
            //TODO: lidar com o problema de nao encontrar a sessao. Voltar ao index
        }
        else{
            username = request.getParameter("username");

            try {
                s = new Socket("localhost", 7781);

                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeBytes("username|" + username);

                DataInputStream in = new DataInputStream(s.getInputStream());

                byte[] buffer = new byte[1024];
                int len = in.read(buffer, 0, 1024);

                String data = new String(buffer, 0, len);
                //s.setSoTimeout(5000);

                System.out.println("data: '" + data + "'");
                s.close();

                if(data.equals("true")){
                    request.getSession().setAttribute("username", username);
                    request.getRequestDispatcher("ProfileAvatar.jsp").forward(request, response);
                }
                else{
                    request.getRequestDispatcher("UsernameError.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("[End]createProfileUsername");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }


}