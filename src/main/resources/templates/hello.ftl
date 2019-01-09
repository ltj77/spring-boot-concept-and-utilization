<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>CORS Test</h1>
<script src="/webjars/jquery/dist/jquery.min.js"></script>
<script>
  $(function() {
    $.ajax("http://localhost:8080/hello")
        .done(function(msg) {
          alert(msg);
        })
        .fail(function() {
          alert("fail");
        });
  });
</script>
</body>
</html>