<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Add a Cat - Cat Shop</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .add-cat-container {
            margin-top: 50px;
            max-width: 500px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        header, footer {
            background-color: #343a40;
            color: white;
            padding: 15px;
            text-align: center;
        }
        footer {
            margin-top: 50px;
        }
    </style>
</head>
<body>

<header>
    <h1>Add a New Cat</h1>
</header>

<div class="container d-flex justify-content-center">
    <div class="add-cat-container">
        <form th:action="@{/add-cat}" method="post">
            <div class="form-group">
                <label for="name">Cat Name:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="breed">Breed:</label>
                <input type="text" class="form-control" id="breed" name="breed" required>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" class="form-control" id="price" name="price" step="0.01" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Add Cat</button>
        </form>
    </div>
</div>

<footer>
    <p>&copy; 2024 Cat Shop</p>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
