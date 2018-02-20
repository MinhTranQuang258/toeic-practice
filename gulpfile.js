const gulp = require('gulp');
const sass = require('gulp-sass');
const inject = require('gulp-inject');
const browserSync = require('browser-sync').create();

// const {paths} = JSON.parse(fs.readFileSync('path.json', 'utf8'));

gulp.task('browserSync', function(){
  browserSync.init({
    server: {
      baseDir: 'src/main/resources/public'
    }
  })
});

gulp.task('library', function() {
  // var target = gulp.src('src/main/resources/public/layout/components/*.html');
  // var sources = gulp.src(['./src/main/resources/public/**/*.js', './src/main/resources/public/**/*.css'], {read: false});

  // return target.pipe(inject(sources), {ignorePath: 'dist'});
  // return gulp.src('src/main/resources/public/index.html')
  //   .pipe(inject(gulp.src('src/main/resources/public/layout/components/*.*'), {
  //     starttag: '<!-- inject:{{path}} -->',
  //     relative: true
  //   }))
});

gulp.task('sass', function() {
  return gulp.src('src/main/resources/public/scss/index.scss')
    .pipe(sass())
    .pipe(gulp.dest('src/main/resources/public/css'))
    .pipe(browserSync.reload({
      stream: true
    }))
});

gulp.task('watch', ['browserSync', 'sass', 'library'], function() {
  gulp.watch('src/main/resources/public/scss/**/*.scss', ['sass']);
});