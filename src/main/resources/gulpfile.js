const gulp = require('gulp');
var sass = require('gulp-sass');
var browserSync = require('browser-sync').create();
var del = require('del');
var runSequence = require('run-sequence');

gulp.task('browserSync', () => {
  browserSync.init( {
      server: {
          baseDir: './static/'
      },
  })
})
gulp.task('sass', () => {
  return gulp.src('app/sass/**/*.scss')
    .pipe(sass()) // Converts Sass to CSS with gulp-sass
    .pipe(gulp.dest('app/css'))
    .pipe(browserSync.reload({
      stream: true
    }))
});
gulp.task('watch', ['browserSync', 'sass'], () => {
  gulp.watch('app/sass/**/*.scss', ['sass']);
  gulp.watch('**/*.html', browserSync.reload);
  gulp.watch('app/js/**/*.js', browserSync.reload);
});
gulp.task('clean:dist', () => {
  return del.sync('dist');
})
gulp.task('default', function (callback) {
  runSequence(['watch', 'sass', 'browserSync'],
    callback
  )
})