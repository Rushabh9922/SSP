<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Customer</title>
</head>
<body>
    <h1>Edit Customer</h1>
    <%
        String url = "jdbc:mysql://localhost:3306/store";
        String user = "root";
        String password = "";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String id = request.getParameter("id");
        String         name = "";
        String email = "";
        if (id != null && !id.isEmpty()) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Establish the connection
                conn = DriverManager.getConnection(url, user, password);
                // Create a SQL query to find the customer
                String sql = "SELECT name, email FROM customer WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(id));
                // Execute the query
                rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    name = rs.getString("name");
                    email = rs.getString("email");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close resources
                try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
                try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
                try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
            }
        }
    %>
    <form action="UpdateCustomerServlet" method="post">
        <input type="hidden" name="id" value="<%= id %>">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%= name %>" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%= email %>" required><br><br>
        <input type="submit" value="Update Customer">
    </form>
    <a href="Customer.jsp">Back to Customer List</a><br><br>
</body>


</html>
