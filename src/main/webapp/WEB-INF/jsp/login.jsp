<!DOCTYPE html>
<html lang="vi">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Toeic practice</title>

  <link rel="stylesheet" href="./../../../../../node_modules/bootstrap/dist/css/bootstrap.css">
  <link rel="stylesheet" href="./../css/index.css">
</head>

<body>
  <!-- inject:components/header.html -->
  <!-- endinject -->

  <main class="page-main">
    <div class="main">
      <div class="container-fluid">
        <div class="row login__container">
          <div class="login col-lg-4">
            <div class="login__header">
              <strong class="login__header-text">TOEIC Practice</strong>
            </div>
            <div class="login__body">
              <form action="">
                <div class="form-group">
                  <label for="username" class="login__text">Username:</label>
                  <input type="text" name="" id="username" class="form-control">
                </div>
                <div class="form-group">
                  <label for="password" class="login__text">Password:</label>
                  <input type="password" name="" id="password" class="form-control">
                </div>
                <div class="flex flex--center-h m--bottom-10">
                  <input type="checkbox" class="checkbox m--right-5" name="" id="rememberMe" class="form-check-input">
                  <label for="rememberMe" class="login__text form-check-label">Remember me</label>
                </div>
                <button type="submit" class="btn btn-lg btn__default">Login</button>
              </form>
            </div>

            <div class="login__footer">
              <div class="login__footer-option">
                <a href="register.html" class="login__link">Register</a>
                <span class="dash">|</span>
                <a href="#" class="login__link">Forget password ?</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>

  <!-- inject:components/symbol-defs.svg -->
  <!-- endinject -->

  <!-- inject:components/footer.html -->
  <!-- endinject -->

  <footer class="page-footer">
  </footer>
  <!-- End Page Footer -->

  <script src="./../../../../../node_modules/bootstrap/dist/js/bootstrap.js"></script>
  <script src="./../js/index.js"></script>

</body>

</html>