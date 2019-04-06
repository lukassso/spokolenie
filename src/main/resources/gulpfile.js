const gulp = require('gulp');
const browserSync = require('browser-sync').create();
const sass = require('gulp-sass');
const runSequence = require('run-sequence');
const imagemin = require('gulp-imagemin');
const cache = require('gulp-cache');
// const useref = require('gulp-useref');
// const gulpIf = require('gulp-if');
// const cssnano = require('gulp-cssnano');
const gutil = require('gulp-util');
const concat = require('gulp-concat');
const babili = require("gulp-babili");
const sourcemaps = require('gulp-sourcemaps');
const autoprefixer = require('gulp-autoprefixer');

// gulp.task('default', defaultTask);
// function defaultTask(done) {
//   // place code for your default task here
//   done();
// }

//test

gulp.task('default', (callback) => {
  runSequence(['watch', 'sass', 'browserSync'],
  callback)
})

gulp.task('browserSync', () => {
    browserSync.init( {
        server: {
            baseDir: './'
        },
    })
})

gulp.task('sass', () => {
    return gulp.src('src/scss/**/*.+(css|scss)')
    .pipe(sourcemaps.init())
    .pipe(sass({outputStyle: 'compressed'}))
    
    .pipe(autoprefixer ({
      browsers: ['last 2 versions'],
      cascade: false
    }))
    .pipe(sourcemaps.write())
    .pipe(gulp.dest('css'))
    .pipe(browserSync.reload({
        stream: true
    }))
})

gulp.task('watch', () => {
    gulp.watch('src/scss/**/*.+(css|scss)',['sass']);
    gulp.watch('*.html', browserSync.reload);
    gulp.watch('src/js/**/*.js', browserSync.reload);
})

gulp.task('images', function () {
  return gulp.src('src/img/**/*.+(png|jpg|jpeg|gif|svg)')
  .pipe(cache(imagemin({
    interlaced: true
   })))
  .pipe(gulp.dest('img'))
})

// gulp.task('useref', () => {
//   return gulp.src('dist/css/*.css')
//   .pipe(gulpIf('*.css', cssnano()))
//   .pipe(gulp.dest('dist/css'))
// })

gulp.task('scripts', function () {
  return gulp.src(['src/js/*.js'])
  .pipe(concat('main.min.js'))
  .pipe(babili({
    mangle: {
      keepClassNames: true
    }
  }))
  .on('error', function (err) {
    gutil.log(gutil.colors.red('[Error]'), err.toString());
  })
  .pipe(gulp.dest('js'));
})