package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@WebServlet("/createProfileAvatar")
public class CreateProfileAvatar extends HttpServlet {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String avatar= null;

    public CreateProfileAvatar() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Start]createProfileAvatar");
        Socket s;

        if(request.getSession()==null){
            //TODO: lidar com o problema de nao encontrar a sessao. Voltar ao index
        }
        else{
            avatar = request.getParameter("avatar");

            System.out.println("AVATAR: " + avatar + " ====================================");

            try {
                s = new Socket("localhost", 7781);

                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeBytes("avatar|" + avatar);

                DataInputStream in = new DataInputStream(s.getInputStream());

                byte[] buffer = new byte[1024];
                int len = in.read(buffer, 0, 1024);

                String data = new String(buffer, 0, len);
                //s.setSoTimeout(5000);

                System.out.println("data: '" + data + "'");
                s.close();

                if(data.equals("true")){
                    request.getRequestDispatcher("wait.jsp").forward(request, response);
                }
                else{
                    request.getRequestDispatcher("avatarError.jsp").forward(request, response);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("[End]createProfileAvatar");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }



}
