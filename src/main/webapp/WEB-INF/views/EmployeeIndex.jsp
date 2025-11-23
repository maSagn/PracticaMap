<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
    </head>
    <body>
        <div class="container">
            <a class="btn btn-success">Add employee</a>
            <center><h1>Employees</h1></center>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Position</th>
                        <th scope="col">Salary</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${employees}">
                    <tr>
                        <th scope="row">
                            <a class="btn btn-warning"><i class="bi bi-pencil-fill"></i></a>
                            <a class="btn btn-danger"><i class="bi bi-trash-fill"></i></a>
                        </th>
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.position}</td>
                        <td>${employee.salary}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
