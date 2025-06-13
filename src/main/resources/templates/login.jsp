<%-- 
    Document   : login
    Created on : May 27, 2025, 8:33:58 PM
    Author     : Ilham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link rel="stylesheet" href="./css/login.css">
    </head>
    <body style="background-color: #0a1a2a;">
        <nav>
            
        </nav>
        <div class="container">
            <section class="description">
                <img src="./img/logo.png">
                <p>Selamat datang di <b>CINEMATE!</b> Temukan jadwal film terbaru, pilih kursi favoritmu, dan pesan tiket dengan mudah. Masuk sekarang untuk mulai petualangan menontonmu.</p>
            </section>
            <section class="login-container" style=" padding: 0 50px; padding-top: 33px;" >
                <div class="judul" style="display: flex; justify-content: start; align-items: start; width: 100%; gap: 80px;">
                    <h1 style="font-size: 42px; font-weight: bold; margin: 0;">Log In</h1>
                </div>
                <div class="logo" style="display: flex; justify-content: center; align-items: start; width: 100%; gap: 80px;">
                    <img src="./img/logoPure.png">
                </div>
                <div style="display: flex; flex-direction: column; justify-content: center; align-items: center; width: 100%;">
                    <h3 style="margin: 0; margin-bottom: 7px; font-size: 29px;">Welcome Back to CINEMATE</h3>
                    <h3 style="color: #8C97A8; margin: 0; margin-bottom: 8px; font-weight: lighter;">Enter your email and password to continue</h3>
                </div>
                <form method="get" action="">
                    <div class="input-container">
                        <label for="email" class="form-label">Email</label>
                        <input style="border: 1px solid #045595; border-radius: 13px;" class="form-control" type="email" id="email" name="email" placeholder="Enter your Email" required>
                    </div>
                    <div class="input-container">
                        <label class="form-label" for="password">Password</label>
                        <input style="border: 1px solid #045595; border-radius: 13px" class="form-control" type="password" id="password" name="password" placeholder="Enter your Password" required>
                    </div>
                    <p>Forgot Password? <a href="" style="text-decoration: none; color: black;"><b>Reset Password</b></a></p>
                    <p>By continuing, you agree to Cinemate’s <a href="#" ><b>Terms of Service</b></a> and acknowledge you've read our <a href="#"><b>Privacy Policy</b></a>.</p>
                    <button type="submit" class="submit">Log In</button>
                    <div>
                        <h1 class="or">OR</h1>
                    </div>
                    <button type="button" class="google-login">Log In with Google</button>
                    <p style="text-align: center; margin: 10px 0;">Don't have an account? <a href="./masuk/register.jsp" style="text-decoration: none; color: black;"><b>Register</b></a></p>
                </form>
            </section>
        </div>
    </body>
</html>
