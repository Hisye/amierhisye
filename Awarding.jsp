<%-- 
    Document   : Awarding
    Created on : Jun 7, 2023, 9:46:50 PM
    Author     : User
--%>

<%@page import="java.util.List"%>
<%@page import="HandlingStatus.StudentApplicationDao"%>
<%@page import="HandlingStatus.StudentApplication"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="java.sql.Date"%>
<%@page import="HandlingStatus.ViewStudentStatus"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Admin Page</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

        <style>
            * {
                padding: 0;
                margin: 0;
            }

            .navbar {
                display: flex;
                justify-content: space-between;
                align-items: center;
                background: #B3B6B7;
            }

            .navbar-nav.ml-auto {
                margin-left: auto;
            }


            .nav-link,
            .navbar-brand {
                color: #fff;
                cursor: pointer;
                background-color: #ECF0F1;
                padding: 5px;
                border-radius: 5px;
                border: #222;
                margin-left: 10px;
            }

            .nav-link {
                margin-right: 1em !important;
            }

            .nav-link:hover {
                color: #000;
            }

            .navbar-collapse {
                justify-content: flex-end;
            }

            .logout-button {
                color: #fff;
                background-color: rgb(235, 106, 106);
                padding: 5px;
                border-radius: 5px;
                border: none;
                margin-left: 10px;
            }

            .container {
                display: flex;
                justify-content: left;
                margin: 0 auto;
                background-color: white;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
                margin-top: 20px;
            }

            .form-container {
                width: 50%;
                margin-right: 20px;
            }

            .output-container {
                width: 50%;
            }
            .financial-aid-table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            .financial-aid-table th,
            .financial-aid-table td {
                padding: 8px 50px 8px 50px;
                text-align: left;
                border-bottom: 1px solid #ddd;

            }

            .financial-aid-table th {
                background-color: #f2f2f2;
            }
        </style>
        <!-- Bootstrap CSS v5.2.1 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous" />
    </head>

    <body style="background-color: #FBFCFC">
        <header>
            <nav class="navbar navbar-expand-md">
                <a class="navbar-brand" href="index.html">UMTStudentFinancialAid</a>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="financialAidRegistration.jsp">Financial Aid</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link logout-button" href="logout.html">Logout</a>
                    </li>
                </ul>
            </nav>
        </header>
        <main>
            <h1 style="padding: 20px; align-content: center;
                justify-content: center; background-color: wheat;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); margin-bottom: 20px;">Student Application List</h1>
            <div class="container">
                <div class="output-container">
                    <h3 id="formTitle" style="margin-bottom: 20px;">List of Application</h3>
                    <jsp:include page="/ViewStudentStatus"/>
                </div>
            </div>


        </main>
    </body>
</html>
