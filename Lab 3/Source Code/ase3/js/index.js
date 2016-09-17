
    $("#login").click(function() {
        localStorage.setItem("UserName", document.getElementById('username').value);
        localStorage.setItem("password", document.getElementById('password').value);
        var a = document.getElementById('username').value;
        if(a == "admin")
        {
            window.open('admin.html');}
        else
        window.open('home.html');
    });

