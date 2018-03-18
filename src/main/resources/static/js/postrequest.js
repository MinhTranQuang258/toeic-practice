$(document).ready(function () {

  /**
   * Login submit event
   */
  $('#loginForm').submit(function (e) {
    e.preventDefault();
  });
  
  function click(){
	  
  }$.ajax({
	  type: 'POST',
      url: 'http://localhost:8080/click'
  });


  function login() {
    var user = {
      username: $('#username').val(),
      password: $('#passowrd').val()
    }
    $.ajax({
      type: 'POST',
      url: 'http://localhost:8080/click',
      data: JSON.stringify(FormData),
      dataType: 'json',
      success: function(result) {
        if(result.status == "Done") {
          $('.main-page').empty();

          $('.main-page').html('<p>You are now logged with <strong>'+ result.data.username+'</strong> </p>')
        } else {
          $('.main-page').html('<h1>Wrong username or password!</h1>');
        }
        console.log(result.length);
      },
      error: function(e) {
        alert('Error!');
        console.log('ERROR: ', e);
      }
    });
    resetData();
  }

  function resetData() {
    $('#username').val('');
    $('#passowrd').val('');
  }
});