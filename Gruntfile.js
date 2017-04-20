module.exports = function(grunt) {

    grunt.initConfig({

        i18nextract: {
            default_options: {
                src: [ 'src/main/app/**/*.js', 'src/**/*.html' ],
                prefix : 'translations_',
                lang: ['et', 'en'],
                customRegex: [ 'data-title="{{\s\'((?:\\\\.|[^\'\\\\])*)\'\\|\stranslate\s}}"' ],
                namespace: true,
                safeMode: false,
                dest: 'src/main/webapp/app/i18n'
            }
        }
    });

    grunt.loadNpmTasks('grunt-angular-translate');
    grunt.registerTask('default', ['i18nextract']);
};
