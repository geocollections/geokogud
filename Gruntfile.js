module.exports = function(grunt) {

    grunt.initConfig({

        i18nextract: {
            default_options: {
                src: [ 'src/main/app/**/*.js', 'src/**/*.html' ],
                prefix : 'translations_',
                lang: ['et', 'en'],
                namespace: true,
                safeMode: true,
                dest: 'src//main/webapp/app/i18n'
            }
        }
    });

    grunt.loadNpmTasks('grunt-angular-translate');
    grunt.registerTask('default', ['i18nextract']);
};
