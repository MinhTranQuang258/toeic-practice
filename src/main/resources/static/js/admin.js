$(document).ready(function () {

  $('.js-question-type').on('change', function () {
    current = $(this).val();
    $('.admin__question').removeClass('d-none');
    $('.js-question-num-answers').closest('.form-group').removeClass('d-none');
    
    switch (current) {
      case 'grammar':
        $('.js-question-num-answers').closest('.form-group').removeClass('d-none');
        $('.js-question-addon').closest('.form-group').addClass('d-none');
        $('.js-question-soundtrack').closest('.form-group').addClass('d-none');
        $('.js-question-image').closest('.form-group').addClass('d-none');
        $('.question__media').addClass('d-none')
        break;
      case 'listening':
        $('.js-question-num-answers').closest('.form-group').removeClass('d-none');
        $('.js-question-addon').closest('.form-group').removeClass('d-none');
        $('.js-question-soundtrack').closest('.form-group').removeClass('d-none');
        $('.js-question-image').closest('.form-group').addClass('d-none');
        $('.question__media').removeClass('d-none')
        break;
      case 'reading':
        $('.js-question-num-answers').closest('.form-group').removeClass('d-none');
        $('.js-question-addon').closest('.form-group').addClass('d-none');
        $('.js-question-soundtrack').closest('.form-group').addClass('d-none');
        $('.js-question-image').closest('.form-group').addClass('d-none');
        $('.question__media').addClass('d-none')
        break;
    }
  });

  $('.js-question-num-answers').on('change', function () {
    current = $(this).val();
    ansList = $('.js-new-answers-list');

    switch (current) {
      case '3':
        ansList.empty();
        ansList.append('<div class="form-inline mb-4"><input type="email" class="form-control w-75 mr-5" id="answerA" placeholder="Đáp án A" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label" >Đáp án đúng</label></div>');
        ansList.append('<div class="form-inline mb-4"><input type="email" class="form-control w-75 mr-5" id="answerB" placeholder="Đáp án B" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label" >Đáp án đúng</label></div>');
        ansList.append('<div class="form-inline mb-4"><input type="email" class="form-control w-75 mr-5" id="answerC" placeholder="Đáp án C" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label" >Đáp án đúng</label></div>');
        break;
      case '4':
        ansList.empty();
        ansList.append('<div class="form-inline mb-4"><input type="email" class="form-control w-75 mr-5" id="answerA" placeholder="Đáp án A" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label" >Đáp án đúng</label></div>');
        ansList.append('<div class="form-inline mb-4"><input type="email" class="form-control w-75 mr-5" id="answerB" placeholder="Đáp án B" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label" >Đáp án đúng</label></div>');
        ansList.append('<div class="form-inline mb-4"><input type="email" class="form-control w-75 mr-5" id="answerC" placeholder="Đáp án C" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label" >Đáp án đúng</label></div>');
        ansList.append('<div class="form-inline mb-4"><input type="email" class="form-control w-75 mr-5" id="answerD" placeholder="Đáp án D" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label" >Đáp án đúng</label></div>');
        break;
    }
  });

  $('.js-question-addon').on('change', function () {
    current = $(this).val();

    switch (current) {
      case '1':
        $('.js-question-soundtrack').closest('.form-group').removeClass('d-none');
        $('.js-question-image').closest('.form-group').addClass('d-none');
        $('.question__media').removeClass('d-none')
        break;
      case '2':
        $('.js-question-soundtrack').closest('.form-group').removeClass('d-none');
        $('.js-question-image').closest('.form-group').removeClass('d-none');
        $('.question__media').removeClass('d-none')
        break;
    }
  });
});