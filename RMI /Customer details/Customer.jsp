<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customers</title>
</head>
<body>
    <h1>Customer Information</h1>
    <!-- Link to add a new customer -->
    <a href="NewCustomer.jsp">Add New Customer</a><br><br>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Database connection parameters
                String url = "jdbc:mysql://localhost:3306/store";
                String user = "root";
                String password = "";
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                try {
                    // Load the JDBC driver
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    // Establish the connection
                    conn = DriverManager.getConnection(url, user, password);
                    // Create a SQL query
                    String sql = "SELECT id, name, email FROM customer";
                    pstmt = conn.prepareStatement(sql);
                    // Execute the query
                    rs = pstmt.executeQuery();
                    // Process the result set
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String email = rs.getString("email");
            %>
            <tr>
                <td><%= id %></td>
                <td><%= name %></td>
                <td><%= email %></td>
                <td>
                    <a href="EditCustomer.jsp?id=<%= id %>">Edit</a> |
                    <a href="DeleteCustomer.jsp?id=<%= id %>">Delete</a>
                </td>
            </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
            %>
            <tr>
                <td colspan="4">Error retrieving data</td>
            </tr>
            <%
                } finally {
                    // Close resources
                    try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
                    try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
                    try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
                }
            %>
        </tbody>
    </table>
    <br> <a href="Index.jsp">Back to Index</a><br><br>
</body>
</html>
