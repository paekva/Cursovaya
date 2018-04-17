function Login() {
  var msg = $('#login-form').serialize();
  $.ajax({
    type: 'POST',
    url: 'http://localhost:8080/kursovaya_war_exploded/rest/auth/auth',
    data: msg,
    success: function (data) {
      if (data === "false") {
        $('#results').html('Неверные данные пользователя');
      } else {
        window.localStorage.setItem('user', document.getElementById('inputLogin').value);
        window.location.pathname = '/';
      }
    }
  });
}
