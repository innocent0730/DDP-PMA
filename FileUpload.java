@WebServlet("/FileUpload")
@MultipartConfig
public class FileUpload extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request,  HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        final Part filePart = request.getPart("file");
        String id = request.getParameter("id");
 
        InputStream FileBytes = null;
        final PrintWriter writer = response.getWriter();
 
        try {
 
         String filename = filePart.getSubmittedFileName();
        	FileBytes = filePart.getInputStream();  // to get the body of the request as binary data
 
            final byte[] bytes = new byte[FileBytes.available()];
             FileBytes.read(bytes);  //Storing the binary data in bytes array.
 
            Connection  con=null;
             Statement stmt=null;
 
               try {
                     Class.forName("com.mysql.cj.jdbc.Driver");
                     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC","root","root");
                  } catch (Exception e) {
                        System.out.println(e);
                        System.exit(0);
                              }
                int success=0;
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO upload VALUES(?,?,?)");
                pstmt.setString(1, id);
                pstmt.setBytes(2,bytes);    //Storing binary data in blob field.
                pstmt.setString(3,filename);    //Storing binary data in blob field.
                success = pstmt.executeUpdate();
                if(success>=1)  System.out.println("Data Stored");
                 con.close(); 
 
                 writer.println("<br/> Book Successfully Stored");
 
        } catch (FileNotFoundException fnf) {
            writer.println("You  did not specify a file to upload");
            writer.println("<br/> ERROR: " + fnf.getMessage());
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
 
            if (FileBytes != null) {
                FileBytes.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
 
    }
 
}
