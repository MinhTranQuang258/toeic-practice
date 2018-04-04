$(document).ready(function () {

  var qContainer = $('.admin__question');

  $('.js-question-type').on('change', function () {
    current = $(this).val();
    $('.admin__question').removeClass('d-none');
    $('.js-question-num-answers').closest('.form-group').removeClass('d-none');
    
    switch (current) {
      case 'grammar':
        // $('.js-question-num-answers').closest('.form-group').removeClass('d-none');
        // $('.js-question-addon').closest('.form-group').addClass('d-none');
        // $('.js-question-soundtrack').closest('.form-group').addClass('d-none');
        // $('.js-question-image').closest('.form-group').addClass('d-none');
        // qMedia.addClass('d-none')
        newGrammar(qContainer);
        break;
      case 'listening':
        // $('.js-question-num-answers').closest('.form-group').removeClass('d-none');
        $('.js-question-addon').closest('.form-group').removeClass('d-none');
        // $('.js-question-soundtrack').closest('.form-group').removeClass('d-none');
        // $('.js-question-image').closest('.form-group').addClass('d-none');
        // qMedia.removeClass('d-none')
        newListening(qContainer);
        break;
      case 'reading':
        // $('.js-question-num-answers').closest('.form-group').removeClass('d-none');
        $('.js-question-addon').closest('.form-group').addClass('d-none');
        // $('.js-question-soundtrack').closest('.form-group').addClass('d-none');
        // $('.js-question-image').closest('.form-group').addClass('d-none');
        // qMedia.addClass('d-none')
        newReading(qContainer);
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
    qMedia = $('.question__media');
    switch (current) {
      case '1':
        qMedia.empty();
        qMedia.append('<div class="form-group w-50 mb-4 px-1 float-left"><label>File âm thanh</label><input type="file" class="form-control js-question-soundtrack" /></div>');
        break;
      case '2':
        qMedia.empty();
        qMedia.append('<div class="form-group w-50 mb-4 px-1 float-left"><label>File âm thanh</label><input type="file" class="form-control js-question-soundtrack" /></div>');
        qMedia.append('<div class="form-group w-50 mb-4 px-1 float-left"><label>File hình ảnh</label><input type="file" class="form-control js-question-image" /></div>');
        break;
    }
  });
});

function newGrammar($container) {
  $container.empty();
  $container.append('<div class="admin__section"><div class="form-group"><textarea class="form-control" rows="3" placeholder="Điền câu hỏi mới ..." th:text="${detailQuestion}"></textarea></div></div>');
  $container.append('<div class="admin__section"><div class="admin__answers-list js-new-answers-list">');
  $container.find('.admin__answers-list').append('<div class="form-inline mb-4"><input type="text" class="form-control w-75 mr-5" id="answerA" placeholder="Đáp án A" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label">Đáp án đúng</label></div>');
  $container.find('.admin__answers-list').append('<div class="form-inline mb-4"><input type="text" class="form-control w-75 mr-5" id="answerB" placeholder="Đáp án B" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label">Đáp án đúng</label></div>');
  $container.find('.admin__answers-list').append('<div class="form-inline mb-4"><input type="text" class="form-control w-75 mr-5" id="answerC" placeholder="Đáp án C" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label">Đáp án đúng</label></div>');
  $container.append('</div></div>');
  $container.append('<div class="float-right mt-5"><button type="reset" class="btn btn-lg btn__default">Nhập lại</button>&nbsp;&nbsp;<button type="submit" class="btn btn-lg btn__default">Thêm</button></div>');
}

function newListening($container) {
  $container.empty();
  $container.append('<div class="admin__section"><div class="form-group"><textarea class="form-control" rows="3" placeholder="Điền câu hỏi mới ..." th:text="${detailQuestion}"></textarea></div></div>');
  $container.append('<div class="admin__section row mx-0 question__media">');
  $container.find('.question__media').append('<div class="form-group w-50 mb-4 px-1 float-left"><label>File âm thanh</label><input type="file" class="form-control js-question-soundtrack" /></div>');
  // $container.find('.question__media').append('<div class="form-group w-50 mb-4 px-1 float-left"><label>File hình ảnh</label><input type="file" class="form-control js-question-image" /></div>');
  $container.append('</div>');
  $container.append('<div class="admin__section"><div class="admin__answers-list js-new-answers-list">');
  $container.find('.admin__answers-list').append('<div class="form-inline mb-4"><input type="text" class="form-control w-75 mr-5" id="answerA" placeholder="Đáp án A" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label">Đáp án đúng</label></div>');
  $container.find('.admin__answers-list').append('<div class="form-inline mb-4"><input type="text" class="form-control w-75 mr-5" id="answerB" placeholder="Đáp án B" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label">Đáp án đúng</label></div>');
  $container.find('.admin__answers-list').append('<div class="form-inline mb-4"><input type="text" class="form-control w-75 mr-5" id="answerC" placeholder="Đáp án C" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label">Đáp án đúng</label></div>');
  $container.append('</div></div>');
  $container.append('<div class="float-right mt-5"><button type="reset" class="btn btn-lg btn__default">Nhập lại</button>&nbsp;&nbsp;<button type="submit" class="btn btn-lg btn__default">Thêm</button></div>');
}

function newReading($container) {
  $container.empty();
  $container.append('<div class="admin__section"><div class="form-group"><textarea class="form-control" rows="3" placeholder="Điền câu hỏi mới ..." th:text="${detailQuestion}"></textarea></div></div>');
  $container.append('<div class="admin__section"><div class="admin__answers-list js-new-answers-list">');
  $container.find('.admin__answers-list').append('<div class="form-inline mb-4"><input type="text" class="form-control w-75 mr-5" id="answerA" placeholder="Đáp án A" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label">Đáp án đúng</label></div>');
  $container.find('.admin__answers-list').append('<div class="form-inline mb-4"><input type="text" class="form-control w-75 mr-5" id="answerB" placeholder="Đáp án B" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label">Đáp án đúng</label></div>');
  $container.find('.admin__answers-list').append('<div class="form-inline mb-4"><input type="text" class="form-control w-75 mr-5" id="answerC" placeholder="Đáp án C" /><input class="form-check-input" type="radio" name="rightAnswer" /><label class="form-check-label">Đáp án đúng</label></div>');
  $container.append('</div></div>');
  $container.append('<div class="float-right mt-5"><button type="reset" class="btn btn-lg btn__default">Nhập lại</button>&nbsp;&nbsp;<button type="submit" class="btn btn-lg btn__default">Thêm</button></div>');
}

// function newAddOn($container) {
//   $.container.
// }