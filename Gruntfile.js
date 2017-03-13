module.exports = function(grunt) {

    grunt.initConfig({

        i18nextract: {
            default_options: {
                src: [ 'src/**/*.js', 'src/**/*.html' ],
                prefix : 'translations_',
                lang: ['et', 'en'],
                namespace: true,
                safeMode: true,
                dest: 'src/**/i18n'
            }
        }
    });

    grunt.loadNpmTasks('grunt-angular-translate');
    grunt.registerTask('default', ['i18nextract']);
};
