<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista Customers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div id="wrapper" class="container">
        <header id="header" class="header-panel">
            <h2>Rental Car</h2>
        </header>
    </div>

    <div id="container" class="container">
        <div id="content" class="content">

            <h3>Lista Customers</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Cognome</th>
                        <th>Data di nascita</th>
                        <th>Ruolo</th>
                        <th>Azioni</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="tempCustomer" items="${LISTA_CUSTOMERS}">

                        <!-- link per UPDATE -->
                        <c:url var="tempLink" value="RentalCarControllerServlet">
                            <c:param name="command" value="LOAD"/>
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>

                        <!-- link per DELETE -->
                        <c:url var="deleteLink" value="RentalCarControllerServlet">
                            <c:param name="command" value="DELETE"/>
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>

                        <tr>
                            <td>${tempCustomer.nome}</td>
                            <td>${tempCustomer.cognome}</td>
                            <td>${tempCustomer.datadinascita}</td>
                            <td>${tempCustomer.ruolo}</td>
                            <td>
                                <a href="${tempLink}">Aggiorna</a>
                                |
                                <a href="${deleteLink}"
                                   onclick="if (!(confirm('Vuoi eliminare questo venditore?'))) return false">
                                    Elimina
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>


            </table>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>