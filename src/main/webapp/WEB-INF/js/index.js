$(document).ready(function() {

  var un = $('#username').val();
  var pw = $('#password').val();


  $('#btn-login').on('click', function() {
    $.ajax({
      type: 'GET',
      url: 'http://www.json-generator.com/api/json/get/cfOBqynbTm?indent=2',
      dataType: 'json',
      success: function(data) {
        $('.textA').append(data[0].username);
        $('.textB').append(data[0].password);
      }
    })
  });

});