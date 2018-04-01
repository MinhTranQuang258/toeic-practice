
window.$ = $;

// If you want to pick and choose which modules to include, comment out the above and uncomment
// the line below
//import './lib/foundation-explicit-pieces';

$(document).ready(function() {

  $('.js-sidebar-item').on('click', function(e) {
    e.preventDefault;
    $(this).siblings('ul').slideToggle('fast');

    $(this).parent('.sidebar__item').siblings().find('ul').slideUp();
  });


  $('#loginForm').submit(function (e) {
    e.preventDefault();
    login();
  });


  $('.sidebar--sub__link').on('click', function(e) {
    e.preventDefault();
    $('.question').removeClass('d-none');
  });

});

// Function

function login() {
  var user = {
    username: $('#username').val(),
    password: $('#passowrd').val()
  }
  $.ajax({
    // type 
    type: 'POST',
    // edit API url below
    url: 'http://www.json-generator.com/api/json/get/cpyfNgFoKq?indent=2',
    data: JSON.stringify(FormData),
    dataType: 'json',
    success: function(result) {

      // Do something if success

    },
    error: function(e) {
      alert('Error!');
      console.log('ERROR: ', e);
    }
  });
  resetData();
}

